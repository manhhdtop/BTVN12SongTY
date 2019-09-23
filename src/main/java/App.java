import vn.topica.itlab4.bean.Person;
import vn.topica.itlab4.utils.DbUtils;
import vn.topica.itlab4.utils.FileUtils;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

/*
 * This class contain main method to run application
 * Variable personList is list of person get from csv file
 * Variable fileName is name of csv file
 * Variable url is path of csv file in resources folder
 */
public class App
{
	public static void main(String[] args)
	{
		List<Person> personList = null;
		String fileName = "person.csv";
		URL url;
		try
		{
			url = App.class.getClassLoader().getResource(fileName);
			if (url == null)
			{
				System.err.println("Oop!!! File not found. Cannot get list person");
			}
			else
			{
				/*
				 * If url not null get list person from csv insert into
				 * variable personList
				 */
				String path = Objects.requireNonNull(url).getFile();
				personList = FileUtils.read(path);
				
				// Print personList
				if (personList.size() == 0)
				{
					System.out.println("No person found in file " + fileName);
				}
				else
				{
					System.out.println("Person list:");
					personList.forEach(System.out::println);
				}
			}
		}
		catch (FileNotFoundException | NullPointerException e)
		{
			/*
			 * Catch exception
			 */
			System.err.println("Oop!!! File not found. Cannot get list person");
		}
		/*
		 * If personList not null and not empty, insert them into database
		 */
		if (personList != null && personList.size() > 0)
		{
			System.out.println("\nInsert " + personList.size() + "  persons " +
					"to database...");
			DbUtils.insertPersons(personList);
		}
		
		/**
		 * Get list person from database
		 */
		personList = DbUtils.getPersons();
		// Print personList
		if (personList == null || personList.size() == 0)
		{
			System.out.println("No person found in database ");
		}
		else
		{
			System.out.println("Person list:");
			personList.forEach(System.out::println);
		}
	}
}
