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
