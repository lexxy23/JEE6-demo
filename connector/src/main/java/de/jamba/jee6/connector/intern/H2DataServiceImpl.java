/**
 *
 */
package de.jamba.jee6.connector.intern;

import javax.inject.Singleton;

import de.jamba.jee6.connector.H2DatabaseConfigService;

/**
 * @author dstrauss
 *
 */
@Singleton
public class H2DataServiceImpl implements H2DatabaseConfigService {

	private String jndi = "/jee6/jdbc/jee6Ds";
	private String jdbcUrl = "jdbc:h2:~/test";
	private String username = "sa";
	private String password = "sa";

	/**
	 *
	 */
	public H2DataServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.jamba.jee6.connector.H2DatabaseConfigService#getJndi()
	 */
	@Override
	public String getJndi() {
		return jndi;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.jamba.jee6.connector.H2DatabaseConfigService#getJdbcUrl()
	 */
	@Override
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.jamba.jee6.connector.H2DatabaseConfigService#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.jamba.jee6.connector.H2DatabaseConfigService#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.jamba.jee6.connector.H2DatabaseConfigService#setJndi(java.lang.String)
	 */
	@Override
	public void setJndi(String s) {
		jndi = s;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.jamba.jee6.connector.H2DatabaseConfigService#setJdbcUrl(java.lang.
	 * String)
	 */
	@Override
	public void setJdbcUrl(String s) {
		jdbcUrl = s;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.jamba.jee6.connector.H2DatabaseConfigService#setUsername(java.lang
	 * .String)
	 */
	@Override
	public void setUsername(String u) {
		username = u;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.jamba.jee6.connector.H2DatabaseConfigService#setPassword(java.lang
	 * .String)
	 */
	@Override
	public void setPassword(String p) {
		password = p;
	}

}
