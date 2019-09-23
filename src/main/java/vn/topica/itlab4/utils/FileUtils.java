package vn.topica.itlab4.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.topica.itlab4.bean.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 * This class read csv file and convert it to List<Person>
 */
public class FileUtils
{
	/**
	 * ApplicationContext is a class to get Spring bean
	 */
	private static ApplicationContext context =
			new ClassPathXmlApplicationContext("bean.xml");
	
	/**
	 * Read file csv from path and convert to person by function
	 * stringToObject()
	 *
	 * @param path is path of file to read
	 * @return list of person get from csv file
	 * @throws FileNotFoundException when file not exist in path variable
	 */
	public static List<Person> read(String path) throws FileNotFoundException
	{
		if (path != null && !path.isEmpty())
		{
			File file = new File(path);
			if (file.exists())
			{
				return read(file);
			}
			else
			{
				throw new FileNotFoundException();
			}
		}
		return null;
	}
	
	
	/**
	 * Read file csv from a file and convert to person by function
	 * stringToObject()
	 *
	 * @param file is  file to read
	 * @return list of person get from csv file
	 * @throws FileNotFoundException when file not exist in path variable
	 */
	public static List<Person> read(File file) throws FileNotFoundException
	{
		/*
		 * Get bean "personList"
		 */
		List<Person> persons = (List<Person>) context.getBean("personList");
		if (file != null && file.exists() && file.canRead())
		{
			try
			{
				Scanner scanner = new Scanner(file);
				while (scanner.hasNext())
				{
					Person p = stringToObject(scanner.nextLine());
					if (p != null)
					{
						persons.add(p);
					}
				}
				scanner.close();
				
				return persons;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			throw new FileNotFoundException();
		}
		return null;
	}
	
	/**
	 * Convert a string to Person object
	 *
	 * @param line is string to convert
	 * @return a Person
	 */
	private static Person stringToObject(String line)
	{
		String[] fields = line.split("\\s*,\\s*");
		if (!fields[0].trim().equalsIgnoreCase("ID"))
		{
			Person p = (Person) context.getBean("person");
			try
			{
				p.setId(Integer.parseInt(fields[0]));
			}
			catch (NumberFormatException e)
			{
				System.err.println(fields[0]);
				throw new NumberFormatException();
			}
			p.setName(fields[1]);
			try
			{
				p.setBirthOfDate(Utils.parseDate(fields[2]));
			}
			catch (ParseException e)
			{
				System.err.println("Unknown date format.");
			}
			switch (fields[3].toLowerCase().trim())
			{
				case "male":
					p.setGender(1);
					break;
				case "female":
					p.setGender(0);
					break;
				case "other":
					p.setGender(2);
					break;
				default:
					System.err.println("Unknown gender.");
					p.setGender(2);
					break;
			}
			return p;
		}
		return null;
	}
}
