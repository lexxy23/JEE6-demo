/**
 *
 */
package de.jamba.jee6.connector.work;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.resource.spi.work.Work;

import de.jamba.jee6.connector.H2DatabaseConfigService;

/**
 * @author dstrauss
 *
 */
public class StartServerWork implements Work {
	/**
	 * A logger.
	 */
	private static final Logger LOG = Logger.getLogger(StartServerWork.class
			.getName());
	/**
	 * The base configuration.
	 */
	private H2DatabaseConfigService svc;

	public StartServerWork(H2DatabaseConfigService c) {
		svc=c;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		LOG.info("Initialising Driver...");
		try {
			Class.forName("org.h2.Driver");
			DriverManager.getConnection(svc.getJdbcUrl(), svc.getUsername(),
					svc.getPassword());
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, "error on starting db connection", e);
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "error on starting db connection", e);
		}
		LOG.info("done");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.resource.spi.work.Work#release()
	 */
	@Override
	public void release() {
		LOG.info("Release??");
	}

}
