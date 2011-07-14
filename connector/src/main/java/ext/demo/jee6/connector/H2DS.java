/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ext.demo.jee6.connector;

import javax.annotation.sql.DataSourceDefinition;
import org.h2.jdbcx.JdbcDataSource;

/**
 *
 * @author foxmobile
 */
@DataSourceDefinition(name = "java:global/jee6Jdbc", className = "org.h2.jdbcx.JdbcDataSource", databaseName = "testdb", password = "sa", user = "sa", url = "jdbc:h2:~/testdb")
public class H2DS extends JdbcDataSource {

	/**
	 * The svuid.
	 */
	private static final long serialVersionUID = -7935584611038675989L;

}
