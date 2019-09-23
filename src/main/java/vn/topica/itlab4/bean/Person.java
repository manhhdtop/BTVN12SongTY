package vn.topica.itlab4.bean;

import vn.topica.itlab4.utils.Utils;

import java.util.Date;

/**
 * POJO class to save information of human
 */
public class Person
{
	private int id;
	private String name;
	private Date birthOfDate;
	private int gender;
	
	public Person()
	{
		id = -1;
		name = "";
		birthOfDate = null;
		gender = 1;
	}
	
	public Person(int id, String name, Date birthOfDate, int gender)
	{
		this.id = id;
		this.name = name;
		this.birthOfDate = birthOfDate;
		this.gender = gender;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Date getBirthOfDate()
	{
		return birthOfDate;
	}
	
	public void setBirthOfDate(Date birthOfDate)
	{
		this.birthOfDate = birthOfDate;
	}
	
	public int getGender()
	{
		return gender;
	}
	
	public void setGender(int gender)
	{
		this.gender = gender;
	}
	
	@Override
	public String toString()
	{
		return "Person [ID: " + id + "; Name: " + name + "; BirthOfDate: "
				+ Utils.formatDate(birthOfDate) + "; Gender: " + (gender == 0 ?
				"Female" : (gender == 1 ? "Male" : "Other")) +
				"]";
	}
}
