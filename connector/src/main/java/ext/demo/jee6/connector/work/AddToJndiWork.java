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
package ext.demo.jee6.connector.work;


import org.h2.jdbcx.JdbcDataSource;

import ext.demo.jee6.connector.H2DatabaseConfigService;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;

import javax.resource.spi.work.Work;

/**
 * @author dstrauss
 */
public class AddToJndiWork implements Work {

	/**
	 * A logger.
	 */
	private static final Logger LOG = Logger.getLogger(AddToJndiWork.class
			.getName());

	/**
	 * The data config.
	 */
	private H2DatabaseConfigService svc;

	/**
	 * The print writer to log messages.
	 */
	private PrintWriter pw;

	/**
	 * @param c
	 *            the data config
	 */
	public AddToJndiWork(H2DatabaseConfigService c) {
		svc = c;
		pw = new PrintWriter(System.out);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		LOG.info("Preparing datasource factory");
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL(svc.getJdbcUrl());
		ds.setUser(svc.getUsername());
		ds.setPassword(svc.getPassword());
		ds.setDescription("The in-memory db");
		ds.setLogWriter(pw);
		ds.getReference();
		Context ctx;
		try {
			ctx = new InitialContext();
			ctx.bind(svc.getJndi(), ds);
			LOG.info("bound to " + svc.getJndi());
		} catch (NamingException e) {
			LOG.log(Level.SEVERE,
					"Error on setting the datasource into the jndi!", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.resource.spi.work.Work#release()
	 */
	@Override
	public void release() {
		LOG.info("Release?????");
	}
}
