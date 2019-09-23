package vn.topica.itlab4.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.topica.itlab4.bean.Person;

import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * This class has some method to process data in database
 */
public class DbUtils
{
	/**
	 * ApplicationContext is a class to get Spring bean
	 */
	private static ApplicationContext context =
			new ClassPathXmlApplicationContext("bean.xml");
	
	private static String sql;
	
	/**
	 * Insert list person to database
	 *
	 * @param personList is list of person to insert
	 */
	public static void insertPersons(List<Person> personList)
	{
		try
		{
			Connection c = ConnectionUtil.getConnection();
			personList.forEach(p -> insert(c, p));
		}
		catch (SQLException e)
		{
			System.err.println("Connection closed or do not open!");
		}
	}
	
	/**
	 * Insert a person to database
	 *
	 * @param p is person to insert
	 */
	public static void insertPerson(Person p)
	{
		try
		{
			Connection c = ConnectionUtil.getConnection();
			insert(c, p);
		}
		catch (SQLException e)
		{
			System.err.println("Connection closed or do not open!");
		}
	}
	
	/**
	 * Get list person from database
	 *
	 * @return list person
	 */
	public static List<Person> getPersons()
	{
		List<Person> personList = null;
		try
		{
			Connection c = ConnectionUtil.getConnection();
			personList = select(c);
		}
		catch (SQLException e)
		{
			System.err.println("Connection closed or do not open!");
		}
		return personList;
	}
	
	/**
	 * Process insert a person to database
	 *
	 * @param c is connection to database
	 * @param p is person to insert
	 */
	private static void insert(Connection c, Person p)
	{
		sql = JdbcConstant.INSERT_PERSON;
		try
		{
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, p.getId());
			pstm.setString(2, p.getName());
			pstm.setLong(3, p.getBirthOfDate().getTime());
			pstm.setInt(4, p.getGender());
			pstm.executeUpdate();
		}
		catch (SQLException e)
		{
			switch (e.getSQLState())
			{
				case "23000":
					System.err.println("ID " + p.getId() + " exist the in " +
							"database. Insert failed.");
					break;
				default:
					System.err.println("Unknown error!");
			}
		}
	}
	
	/**
	 * Get list person from database
	 *
	 * @param c is connection to data base
	 * @return list person
	 * @throws SQLException handle exception
	 */
	private static List<Person> select(Connection c) throws SQLException
	{
		List<Person> personList = null;
		sql = JdbcConstant.SELECT_PERSON;
		Statement sm = c.createStatement();
		ResultSet rs = sm.executeQuery(sql);
		if (rs.next())
		{
			personList = (List<Person>) context.getBean("personList");
			do
			{
				Person p = (Person) context.getBean("person");
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setBirthOfDate(new Date(rs.getLong("birth_of_date")));
				p.setGender(rs.getInt("gender"));
				personList.add(p);
			} while (rs.next());
		}
		return personList;
	}
}
