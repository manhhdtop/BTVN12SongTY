package vn.topica.itlab4.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class has some method for application
 * Variable dateFormat is format of date to parse and show date
 */
public class Utils
{
	private static String dateFormat = "dd/MM/yyyy";
	private static SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	
	public static Date parseDate(String date) throws ParseException
	{
		return sdf.parse(date);
	}
	
	public static String formatDate(Date date)
	{
		return sdf.format(date);
	}
	
}
