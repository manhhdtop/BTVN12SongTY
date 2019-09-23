package vn.topica.itlab4.utils;

/**
 * This class init some const for connect and process database
 */
public class JdbcConstant
{
	public static final String DB_NAME = "itlab4";
	public static final String HOST = "localhost";
	public static final int PORT = 3306;
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	
	public static final String SELECT_PERSON = "SELECT * FROM person";
	public static final String INSERT_PERSON = "INSERT INTO person VALUES (?, ?, ?, ?)";
}
