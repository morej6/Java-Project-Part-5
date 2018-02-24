package Moreno.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Used to process a product description and price.
 * @author Juan Moreno
 * @version 1.3
 * @since 11]2/08/16
 */
public class Product {
	
	//***********************************************************
	// Class member variable declared to private.
	//**********************************************************
	private String m_description;
	private double m_price;

	/**
	 * Default constructor set values of each member variable to a default value
	 */
	public Product()
	{
		m_description = "one";
		m_price = 0;
	}
	
	/**
	 * Constructor
	 * Sets the value of each member variable to the corresponding parameter
	 * @param description contains a products description data
	 * @param price contains a products price data
	 */
	public Product (String description, double price)
	{
		m_description = description;
		m_price = price;
	}
	
	/**
	 * GetDescription returns m_description value
	 * @return m_description variable data
	 */
	public String GetDescription()
	{
		return m_description;
	}
	
	/**
	 * Getprice returns m_price value
	 * @return m_price variable data
	 */
	public double GetPrice()
	{
		return m_price;
	}
	

	/**
	 * This method sets product description 
	 * @param description sets description value to m_description
	 */
	public void SetDescription(String description)
	{
		m_description = description;
	}

	/**
	 *  This method sets product price
	 * @param price sets price value to m_price, and check if value is greater than zero
	 */
	public void SetPrice(double price)
	{
		if (price >=0)
		{
			m_price = price;
		}
	}
	
	/**
	 * The method write is used to print to a file
	 * @param ps Uses PrintStream to print member variable data
	 */
	public void Write(PrintStream ps)
	{
		ps.printf("%s\n", m_description);
		ps.printf("%.2f\n",m_price);
	}
	
	/**
	 * This method is used to read in data
	 * @param s Takes in a Scanner variable to read data from a file
	 */
	public void Read(Scanner s)
	{
		
		m_description = s.nextLine();
		m_price = s.nextDouble();	
		
		
	}
	
	/**
	 * This method prints read data in JSON format
	 * @return s Return a string in JSON format
	 */
	public String GetJSON()
	{
		String s;
		s = "\"" +  "Description" + "\"" + " : " + "\"" + m_description + "\"" +"," + " " + "\"" + "Price\"" + " : " + m_price;
		
		return s;
	}
	
	/**
	 * ToString override toStirng class and return a formatted string
	 */
	@Override
	public String toString()
	{
		String s ="";
		s += m_description;
		s += ", ";
		s+= "$"; //This was added 12/08/16
		s += m_price;
		return s;
	}
}
