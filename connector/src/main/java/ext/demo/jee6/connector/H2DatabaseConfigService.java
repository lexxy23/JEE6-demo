/**
 *
 */
package ext.demo.jee6.connector;

/**
 * @author dstrauss
 *
 */
public interface H2DatabaseConfigService {
	String getJndi();

	String getJdbcUrl();

	String getUsername();

	String getPassword();

	void setJndi(String s);

	void setJdbcUrl(String s);

	void setUsername(String u);

	void setPassword(String p);
}
