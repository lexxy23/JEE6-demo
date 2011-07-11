/**
 *
 */
package de.jamba.jee6.connector;

import java.io.PrintWriter;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

/**
 * @author dstrauss
 *
 */
public class H2ManagedConnection implements ManagedConnection {

	/**
	 *
	 */
	public H2ManagedConnection() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addConnectionEventListener(ConnectionEventListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void associateConnection(Object arg0) throws ResourceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void cleanup() throws ResourceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() throws ResourceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getConnection(Subject arg0, ConnectionRequestInfo arg1)
			throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XAResource getXAResource() throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeConnectionEventListener(ConnectionEventListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws ResourceException {
		// TODO Auto-generated method stub

	}

}
