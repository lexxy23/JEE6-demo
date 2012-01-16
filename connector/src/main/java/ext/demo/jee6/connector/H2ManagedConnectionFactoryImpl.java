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
package ext.demo.jee6.connector;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.security.auth.Subject;
import javax.sql.XADataSource;

import org.h2.jdbcx.JdbcDataSource;

/**
 * @author dstrauss
 *
 */
@ConnectionDefinition(connectionImpl = JdbcDataSource.class, connectionFactoryImpl = H2ManagedConnectionFactoryImpl.class, connection = XADataSource.class, connectionFactory = ManagedConnectionFactory.class)
public class H2ManagedConnectionFactoryImpl implements ManagedConnectionFactory {
	/**
	 * The svuid.
	 */
	private static final long serialVersionUID = 8086214300115438193L;
	/**
	 * The log writer.
	 */
	private transient PrintWriter pw;

	/**
	 *
	 */
	public H2ManagedConnectionFactoryImpl() {
		pw = new PrintWriter(System.out);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#createConnectionFactory()
	 */
	@Override
	public Object createConnectionFactory() throws ResourceException {
		return new H2ManagedConnectionFactoryImpl();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#createConnectionFactory(javax
	 * .resource.spi.ConnectionManager)
	 */
	@Override
	public Object createConnectionFactory(ConnectionManager arg0)
			throws ResourceException {
		return new H2ManagedConnectionFactoryImpl();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#createManagedConnection(javax
	 * .security.auth.Subject, javax.resource.spi.ConnectionRequestInfo)
	 */
	@Override
	public ManagedConnection createManagedConnection(Subject arg0,
			ConnectionRequestInfo arg1) throws ResourceException {
		return new H2ManagedConnection();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.resource.spi.ManagedConnectionFactory#getLogWriter()
	 */
	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		return pw;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#matchManagedConnections(java
	 * .util.Set, javax.security.auth.Subject,
	 * javax.resource.spi.ConnectionRequestInfo)
	 */
	@Override
	public ManagedConnection matchManagedConnections(Set arg0, Subject arg1,
			ConnectionRequestInfo arg2) throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.resource.spi.ManagedConnectionFactory#setLogWriter(java.io.PrintWriter
	 * )
	 */
	@Override
	public void setLogWriter(PrintWriter arg0) throws ResourceException {
		pw = arg0;
	}

}
