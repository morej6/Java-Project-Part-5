package Moreno.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;


/**
 * Used to process a single person purchase 
 * @author Juan Moreno
 * @version 1.2
 * @since 10/23/16
 */
public class Purchase  {
	

	//***********************************************************
	// Class member variable declared to private.
	//**********************************************************
	private Product Product;
	private int m_quantity;

	/**
	 * Default constructor set values of each member variable to a default value
	 */
	public Purchase()
	{
		Product = new Product();
		m_quantity = 0;
	}
	
	/**
	 * Constructor
	 * Sets the value of each member variable to the corresponding parameter
	 * @param quantity contains the number of item data
	 */
	public Purchase(int quantity)
	{
		m_quantity = quantity;
	}

	/**
	 * Getquantity returns m_quantity value
	 * @return m_quantity variable data
	 */
	public int Getquantity()
	{
		return m_quantity;
	}
	
	/**
	 *  This method sets product quantity
	 * @param quantity sets quantity value to m_quantity
	 */
	public void Setquantity(int quantity)
	{
		m_quantity = quantity;
	}
	
	/**
	 * This method is used to read in data
	 * @param s Takes in a Scanner variable to read data from a file
	 */
	public void Read(Scanner s)
	{
		
			Product.Read(s);
			m_quantity = s.nextInt();
			s.nextLine();
	}
	
	/**
	 * The method write is used to print to a file
	 * @param ps Uses PrintStream to print member variable data
	 */
	public void Write(PrintStream ps)
	{
		Product.Write(ps);
		ps.printf("%d\n",m_quantity);
	}
	

	/**
	 * This method prints data in JSON format
	 * @return s Return a string in JSON format
	 */
	public String GetJSON()
	{
		String s;
		s = "{" + "\n" + "\"" +  "Product\""  + " : " + "\n"  + "{"+ Product.GetJSON() +  "}" +"," +"\n"+"\""  + "Quantity\"" + " : " + m_quantity + "\n"+ "}" ; 
		return s;
	}
	

	
	/**
	 * ToString override toStirng class and return a formatted string
	 */
	@Override
	public String toString()
	{
		String s ="";
		s += m_quantity;
		s += ", ";
		s += Product.toString();
		s += "\n";
		return s;
	}

	/**
	 * GetProduct returns a product price and description
	 * @return a product collection
	 */
	public Product GetProduct()
	{
		return Product;
	}
	
	
	
}
