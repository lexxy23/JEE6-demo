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
