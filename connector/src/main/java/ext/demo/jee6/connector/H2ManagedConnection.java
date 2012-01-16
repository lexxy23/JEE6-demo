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
