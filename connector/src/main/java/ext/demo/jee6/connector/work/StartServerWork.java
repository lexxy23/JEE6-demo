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

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.resource.spi.work.Work;

import ext.demo.jee6.connector.H2DatabaseConfigService;

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
