/**
 *
 */
package ext.demo.jee6.connector.intern;

import javax.inject.Singleton;

import ext.demo.jee6.connector.H2DatabaseConfigService;

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
    
    @Override
    public String getJndi() {
        return jndi;
    }
    
    @Override
    public String getJdbcUrl() {
        return jdbcUrl;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public void setJndi(String s) {
        jndi = s;
    }
    
    @Override
    public void setJdbcUrl(String s) {
        jdbcUrl = s;
    }
    
    @Override
    public void setUsername(String u) {
        username = u;
    }
    
    @Override
    public void setPassword(String p) {
        password = p;
    }
    
}
