package Moreno.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;


/**
 * Used to process a single person data.
 * @author Juan Moreno
 * @version 1.2
 * @since 11/15/16
 */
public class Customer {
	
	//***********************************************************
	// Class member variable declared to private.
	//**********************************************************
	private String m_firstName;
	private String m_lastName;
	private Address Address;
	
	/**
	 * Default constructor set values of each member variable to a default value
	 */
	public Customer()
	{
		m_firstName = "0";
		m_lastName = "0";
		Address = new Address();
	}
	
	/**
	 * Constructor
	 * Sets the value of each member variable to the corresponding parameter
	 * @param firstName contains a person first name data
	 * @param lastName contains a person last name data
	 */
	public Customer(String firstName, String lastName)
	{
		m_firstName = firstName;
		m_lastName = lastName;
	}
	
	/**
	 * GetfirstName returns m_firstName value
	 * @return m_firstName variable data
	 */
	public  String GetfirstName()
	{
		return m_firstName;
	}
	
	/**
	 * GetlastName returns m_lastName value
	 * @return m_lastName variable data
	 */
	public String GetlastName()
	{
		return m_lastName;
	}
	
	/**
	 *  This method sets product price
	 * @param firstName sets firstName value to m_firstName
	 */
	public void SetfirstName(String firstName)
	{
		m_firstName = firstName;
	}
	
	/**
	 *  This method sets product price
	 * @param lastName sets lastName value to m_lastName.
	 */
	public void SetlastName(String lastName)
	{
		m_lastName = lastName;
	}
	
	/**
	 * This method is used to read in data
	 * @param s Takes in a Scanner variable to read data from a file
	 */
	public void Read(Scanner s)
	{
			m_firstName = s.nextLine();
			m_lastName = s.nextLine();
			Address.Read(s);	
	}
	
	/**
	 * The method write is used to print to a file
	 * @param ps Uses PrintStream to print member variable data
	 */
	public void write(PrintStream ps)
	{
		ps.printf("%s\n",m_firstName);
		ps.printf("%s\n",m_lastName);
		Address.write(ps);
	}

	/**
	 * This method prints read data in JSON format
	 * @return s Return a string in JSON format
	 */
	public String GetJSON()
	{
		String s;
		s = "{" + "\n" +"\"" +  "First Name" + "\"" + " : " + "\"" + m_firstName + "\"" +"," + " " + "\"" + "Last Name\""  + " : " + "\"" + m_lastName  + "\""+ "," + " \n" +"\""+ "Address\"" + " :" + "\n" + Address.GetJSON() +"\n" +"}" +","+ "\n";
		return s;
	}

	/**
	 * ToString override toStirng class and return a formatted string
	 */
	@Override
	public String toString()
	{
		String s ="";
		s += m_firstName;
		s += ", ";
		s += m_lastName;
		s += ", ";
		s += Address.toString();
		s += "\n";
		return s;
	}

	/**
	 * GetAddress returns an Address value
	 * @return GetAddress variable data
	 */
	public Address GetAddress()
	{
		return Address;
	}
}
