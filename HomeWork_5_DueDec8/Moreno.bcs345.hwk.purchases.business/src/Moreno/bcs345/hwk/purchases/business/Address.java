package Moreno.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;
/**
 *  Used to process the address of a single person.
 * @author Juan Moreno
 * @version 1.2
 * @since 11/15/16
 */
public class Address {
	
	//***********************************************************
	// Class member variable declared to private.
	//**********************************************************
	private String m_number;
	private String m_street;
	private String m_city;
	private String m_state;
	private String m_zip;
	
	/**
	 * Default constructor set values of each member variable to a default value
	 */
	public Address()
	{
		m_number = "Null";
		m_street = "Null";
		m_city = "Null";
		m_state = "Null";
		m_zip = "Null";
	}
	
	
	/**
	 *Constructor
	 *Sets the value of each member variable to the corresponding parameter
	 * @param number contains the address number data
	 * @param street contains the address street data
	 * @param city contains the address city data
	 * @param state contains the address state data
	 * @param zip contains the address zip data
	 */
	public Address(String number, String street, String city, String state, String zip)
	{
		m_number = number;
		m_street = street;
		m_city = city;
		m_state = state;
		m_zip = zip;
	}
	
	/**
	 * Getnumber returns m_number value
	 * @return m_number 
	 */
	public String Getnumber()
	{
		return m_number;
	}
	
	/**
	 * Getstreet returns m_street value
	 * @return m_street 
	 */
	public String Getstreet()
	{
		return m_street;
	}

	/**
	 * Getcity return m_city value
	 * @return m_city value
	 */
	public String Getcity()
	{
		return m_city;
	}

	/**
	 * Getstate return m_state value
	 * @return m_state 
	 */
	public String Getstate()
	{
		return m_state;
	}

	/**
	 * Getzip returns m_zip value
	 * @return m_zip value
	 */
	public String Getzip()
	{
		return m_zip;
	}

	/**
	 * This method sets address number
	 * @param number Sets number value to m_number
	 */
	public void Setnumber(String number)
	{
		m_number = number;
	}
	
	/**
	 * This method sets address street
	 * @param street Sets street value to m_street
	 */
	public void Setstreet(String street)
	{
		m_street = street;
	}
	
	/**
	 * This method sets address city 
	 * @param city Sets city value to m_city
	 */
	public void Setcity(String city)
	{
		m_city = city;
	}

	
	/**
	 * This method sets address state
	 * @param state Sets state value to m_state
	 */
	public void Setstate(String state)
	{
		m_state = state;
	}

	
	/**
	 * This method sets address zip
	 * @param zip Sets zip value to m_zip
	 */
	public void Setzip(String zip)
	{
		m_zip = zip;
	}
	
	/**
	 * The method write is used to print to a file
	 * @param ps Uses PrintStream to print member variable data
	 */
	public void write(PrintStream ps)
	{
		ps.printf("%s\n", m_number);
		ps.printf("%s\n",m_street);
		ps.printf("%s\n", m_city);
		ps.printf("%s\n", m_state);
		ps.printf("%s\n", m_zip);
		
	}
	
	/**
	 * This method is used to read in data
	 * @param s Takes in a Scanner variable to read data from a file
	 */
	public void Read(Scanner s)
	{
			m_number = s.nextLine();
			m_street = s.nextLine();
			m_city = s.nextLine();
			m_state = s.nextLine();
			m_zip = s.nextLine();
	}
	
	/**
	 * This method prints read data in JSON format
	 * @return s Return a string in JSON format
	 */
	public String GetJSON()
	{
		String s;
		s = "{" + "\"" +  "Number" + "\"" + " : " + "\"" + m_number + "\"" +"," + " " + "\"" + "Street\"" + " : "+ 
		"\"" + m_street + "\""+ "," + " "+ "\""+ "City" + "\"" + " : "+"\"" + m_city + "\"" + "," + " " + "\""+ "State"
		+ "\"" + " : " + "\"" + m_state + "\"" + "," + "\"" + "Zip" + "\"" + " : "+ "\"" + m_zip + "\"" + "}";
		
		return s;
	}
	
	
	/**
	 * ToString override toStirng class and return a formatted string
	 */
	@Override
	public String toString()
	{
		String s ="";
		s += m_number;
		s += " ";
		s += m_street;
		s += ", ";
		s += m_city;
		s += ", ";
		s += m_state;
		s += " ";
		s += m_zip;
		return s;
	}

}
