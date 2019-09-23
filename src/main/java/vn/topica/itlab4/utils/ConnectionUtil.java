package vn.topica.itlab4.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class ConnectionUtil create connection pool to manage connection to database
 */
class ConnectionUtil
{
	private static BasicDataSource ds = new BasicDataSource();
	
	/**
	 * Init connection pool by BasicDataSource library from apache
	 * Min connection accept is 1
	 * Max connection accept is 5
	 */
	static
	{
		String hostName = JdbcConstant.HOST;
		String dbName = JdbcConstant.DB_NAME;
		int port = JdbcConstant.PORT;
		String option = "?characterEncoding=UTF-8&serverTimezone=Europe/Paris";
		String connectionURL = "jdbc:mysql://" + hostName + ":" + port + "/" + dbName + option;
		
		ds.setUrl(connectionURL);
		ds.setUsername(JdbcConstant.USERNAME);
		ds.setPassword(JdbcConstant.PASSWORD);
		ds.setMinIdle(1);
		ds.setMaxIdle(5);
	}
	
	private ConnectionUtil()
	{
	}
	
	/**
	 * This method get connection from connection pool and return
	 *
	 * @return connection to database
	 * @throws SQLException when exception handle
	 */
	public static Connection getConnection() throws SQLException
	{
		return ds.getConnection();
	}
	
}
