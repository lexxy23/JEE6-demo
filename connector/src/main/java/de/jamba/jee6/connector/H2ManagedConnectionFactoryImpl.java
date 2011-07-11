/**
 *
 */
package de.jamba.jee6.connector;

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
