# JEE6 Demo

A simple project to demonstrate the capabilities of JEE6, using Glassfish and JBoss AS 7.

## How to build

On builds, you have to use

    mvn clean install -Pno-repo-man

This will setup a runtime to include some external repositories to download artifacts from.

## Deploy on the glassfish

We use the H2 database to test the environment. Copy the h2*.jar to glassfish's lib directory (glassfish/lib).

Then start your domain and execute this command to add the H2 database to glassfish:

  ./asadmin create-jdbc-connection-pool --datasourceclassname org.h2.jdbcx.JdbcDataSource --restype javax.sql.XADataSource "--property=User=sa:Password=sa:DatabaseName=jee6Db:URL=jdbc\:h2\:~/jee6TestDb" myTestPool

Then, add this connection pool to the jndi:
  ./asadmin create-jdbc-resource --connectionpoolid myTestPool jboss/datasources/j66DemoDS

* org.h2.jdbcx.JdbcConnectionPool
* org.h2.jdbcx.JdbcDataSource
* org.h2.Driver