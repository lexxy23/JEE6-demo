/**
 *
 */
package ext.demo.jee6.connector;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
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
import javax.resource.spi.work.WorkException;
import javax.resource.spi.work.WorkManager;
import javax.sql.DataSource;
import javax.transaction.xa.XAResource;

import org.h2.jdbcx.JdbcXAConnection;

import ext.demo.jee6.connector.intern.H2DataServiceImpl;
import ext.demo.jee6.connector.work.AddToJndiWork;
import ext.demo.jee6.connector.work.StartServerWork;

/**
 * A sample connector to use the H2 in-memory database.
 *
 * @author dstrauss
 */
@Connector(displayName = "H2 Connector 2", eisType = "jeeDb", description = "The h2 database as in-memory version", version = "1.0", transactionSupport = TransactionSupportLevel.XATransaction, vendorName = "H2")
public class H2Connector2 implements ResourceAdapter, Serializable {

	/**
	 * The svuid.
	 */
	private static final long serialVersionUID = -6582010013509315991L;
	/**
	 * A logger.
	 */
	private static final Logger LOG = Logger.getLogger(H2Connector2.class
			.getName());
	/**
	 * The environment.
	 */
	@ConfigProperty(defaultValue = "test", description = { "The environment to use" }, confidential = false)
	private String env;
	/**
	 * The internal connection to the database.
	 */
	private Connection conn;
	/**
	 * A work manager.
	 */
	private WorkManager workManager;
	/**
	 * A simple data collection service.
	 */
	@Inject
	private H2DatabaseConfigService svc;

	/**
	 * Inits the connector.
	 */
	public H2Connector2() {
		// nothing special
	}

	/**
	 * @return the env
	 */
	public synchronized String getEnv() {
		return env;
	}

	/**
	 * @param env
	 *            the env to set
	 */
	public synchronized void setEnv(String env) {
		this.env = env;
	}

	/**
	 * @return the username
	 */
	public synchronized String getUsername() {
		return svc.getUsername();
	}

	/**
	 * @param username
	 *            the username to set
	 */
	@ConfigProperty
	public synchronized void setUsername(String username) {
		svc.setUsername(username);
	}

	/**
	 * @return the password
	 */
	public synchronized String getPassword() {
		return svc.getPassword();
	}

	/**
	 * @param password
	 *            the password to set
	 */
	@ConfigProperty(confidential = true)
	public synchronized void setPassword(String password) {
		svc.setPassword(password);
	}

	/**
	 * @return the jdbcUrl
	 */
	public synchronized String getJdbcUrl() {
		return svc.getJdbcUrl();
	}

	/**
	 * @param jdbcUrl
	 *            the jdbcUrl to set
	 */
	@ConfigProperty
	public synchronized void setJdbcUrl(String jdbcUrl) {
		svc.setJdbcUrl(jdbcUrl);
	}

	/**
	 * @return the targetJndi
	 */
	public synchronized String getTargetJndi() {
		return svc.getJndi();
	}

	/**
	 * @param targetJndi
	 *            the targetJndi to set
	 */
	@ConfigProperty
	public synchronized void setTargetJndi(String targetJndi) {
		svc.setJndi(targetJndi);
	}

	@Override
	public void endpointActivation(MessageEndpointFactory arg0,
			ActivationSpec arg1) throws ResourceException {
		LOG.info("Endpoints activate");
	}

	@Override
	public void endpointDeactivation(MessageEndpointFactory arg0,
			ActivationSpec arg1) {
		LOG.info("Endpoints deactivate");
	}

	@Override
	public XAResource[] getXAResources(ActivationSpec[] arg0)
			throws ResourceException {
		LOG.info("XA Resources being requested");
		if (arg0 != null) {
			for (ActivationSpec as : arg0) {
				LOG.log(Level.INFO, "aspec: {0}", as);
			}
		}
		Context ctx = null;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(svc.getJndi());
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
	public void start(BootstrapContext arg0)
			throws ResourceAdapterInternalException {
		LOG.info("Starting H2Connector :) env=" + env);
		workManager = arg0.getWorkManager();
		if (svc == null) {
			svc = new H2DataServiceImpl();
		}
		try {
			workManager.doWork(new StartServerWork(svc));
			workManager.doWork(new AddToJndiWork(svc));
		} catch (WorkException e) {
			throw new ResourceAdapterInternalException(e);
		}
	}

	@Override
	public void stop() {
		LOG.info("Stopping H2Connector :(");
		try {
			if ((conn != null) && !conn.isClosed()) {
				conn.createStatement().execute("SHUTDOWN");
			}
                        LOG.info("Database is shutting down...");
		} catch (SQLException e) {
			LOG.log(Level.INFO, "error when shutting down the server!", e);
		}
		try {
			Context ctx = new InitialContext();
			ctx.unbind(svc.getJndi());
                        LOG.info("Unbind successful");
		} catch (NamingException e) {
			LOG.log(Level.INFO,
					"error when shutting down the jndi for this jdbc!", e);
		}
	}
}
