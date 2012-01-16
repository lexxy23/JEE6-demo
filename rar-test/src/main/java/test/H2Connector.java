/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */
/**
 *
 */
package test;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.jdbcx.JdbcXAConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ConfigProperty;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.TransactionSupport.TransactionSupportLevel;
import javax.resource.spi.endpoint.MessageEndpointFactory;

import javax.sql.DataSource;

import javax.transaction.xa.XAResource;

/**
 * A sample connector to use the H2 in-memory database.
 *
 * @author  dstrauss
 */
@Connector(
    displayName = "H2 Connector 2",
    eisType = "jdbc",
    description = "The h2 database as in-memory version",
    version = "1.0",
    transactionSupport = TransactionSupportLevel.XATransaction,
    vendorName = "H2"
)
public class H2Connector implements ResourceAdapter {

    /**
     * A logger.
     */
    private static final Logger LOG = Logger.getLogger(H2Connector.class.getName());

    /**
     * The environment.
     */
    @ConfigProperty(
        defaultValue = "test",
        description = { "The environment to use" },
        confidential = false
    )
    private String env;

    /**
     * The username.
     */
    @ConfigProperty(
        defaultValue = "sa",
        description = { "The username" },
        confidential = false
    )
    private String username = "sa";

    /**
     * The password.
     */
    @ConfigProperty(
        defaultValue = "sa",
        description = { "The password" },
        confidential = true
    )
    private String password = "sa";

    /**
     * The database jdbc url.
     */
    @ConfigProperty(
        defaultValue = "jdbc:h2:~/test",
        description = { "The default jdbc url" },
        confidential = false
    )
    private String jdbcUrl = "jdbc:h2:~/test";

    /**
     * The target jndi to mount the datasource to.
     */
    @ConfigProperty(
        defaultValue = "jdbc/jee6Test",
        description = "The place to mount the datasource"
    )
    private String targetJndi = "jdbc/jee6Test";

    /**
     * The internal connection to the database.
     */
    private Connection conn;

    /**
     */
    public H2Connector() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return  the env
     */
    public synchronized String getEnv() {
        return env;
    }

    /**
     * @param  env  the env to set
     */
    public synchronized void setEnv(String env) {
        this.env = env;
    }

    /**
     * @return  the username
     */
    public synchronized String getUsername() {
        return username;
    }

    /**
     * @param  username  the username to set
     */
    public synchronized void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return  the password
     */
    public synchronized String getPassword() {
        return password;
    }

    /**
     * @param  password  the password to set
     */
    public synchronized void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return  the jdbcUrl
     */
    public synchronized String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     * @param  jdbcUrl  the jdbcUrl to set
     */
    public synchronized void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * @return  the targetJndi
     */
    public synchronized String getTargetJndi() {
        return targetJndi;
    }

    /**
     * @param  targetJndi  the targetJndi to set
     */
    public synchronized void setTargetJndi(String targetJndi) {
        this.targetJndi = targetJndi;
    }

    @Override
    public void endpointActivation(MessageEndpointFactory arg0, ActivationSpec arg1) throws ResourceException {
        LOG.info("Endpoints activate");
    }

    @Override
    public void endpointDeactivation(MessageEndpointFactory arg0, ActivationSpec arg1) {
        LOG.info("Endpoints deactivate");
    }

    @Override
    public XAResource[] getXAResources(ActivationSpec[] arg0) throws ResourceException {
        LOG.info("XA Resources:");
        if (arg0 != null) {
            for (ActivationSpec as : arg0) {
                LOG.info("aspec: " + as);
            }
        }
        Context ctx = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(targetJndi);
            JdbcXAConnection rc = (JdbcXAConnection) ds.getConnection();
            List<XAResource> l = new ArrayList<XAResource>();
            l.add(rc);
            return l.toArray(new XAResource[1]);
        } catch (NamingException e) {
            throw new ResourceException(e);
        } catch (SQLException e) {
            throw new ResourceException(e);
        }
    }

    @Override
    public void start(BootstrapContext arg0) throws ResourceAdapterInternalException {
        LOG.info("Starting H2Connector :) env=" + env);
        try {
            setupServer();
            setupDatasources();
        } catch (NamingException e) {
            throw new ResourceAdapterInternalException("Error when setting up the datasources!", e);
        } catch (SQLException e) {
            throw new ResourceAdapterInternalException("Error when setting up the datasources!", e);
        } catch (ClassNotFoundException e) {
            throw new ResourceAdapterInternalException("Error when setting up the datasources!", e);
        }
    }

    @Override
    public void stop() {
        LOG.info("Stopping H2Connector :(");
        try {
            if ((conn != null) && !conn.isClosed()) {
                conn.createStatement().execute("SHUTDOWN");
            }
        } catch (SQLException e) {
            LOG.log(Level.INFO, "error when shutting down the server!", e);
        }
    }

    /**
     * Starts the in-memory server.
     *
     * @throws  SQLException
     * @throws  ClassNotFoundException
     */
    private void setupServer() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection(jdbcUrl, username, password);
    }

    /**
     * Setup the datasource.
     *
     * @throws  NamingException  if an error occurred.
     * @throws  SQLException
     */
    private void setupDatasources() throws NamingException, SQLException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(jdbcUrl);
        ds.setUser(username);
        ds.setPassword(password);
        Context ctx;
        try {
            ctx = new InitialContext();
            ctx.bind(targetJndi, ds);
        } catch (NamingException e) {
            throw e;
        }
    }
}
