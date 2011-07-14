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
