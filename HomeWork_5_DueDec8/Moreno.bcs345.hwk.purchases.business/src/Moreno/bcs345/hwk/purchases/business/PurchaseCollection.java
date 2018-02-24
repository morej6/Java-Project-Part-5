package Moreno.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Calls a instance of CustomerPurchaseConsoleUI and PurchaseCollectionConsoleUI to show menu
 * 
 * @author Juan Moreno
 * @version 1.2
 * @since 11/15/16
 */
public class PurchaseCollection  {
	
	//***********************************************************
	// Class member variable declared to private.
	//**********************************************************
	private Customer Customer;
	private int size;
	private Purchase[] Purchase;
	
	/**
	 * Default constructor set values of each member variable to a default value
	 */
	public PurchaseCollection()
	{
		Customer = new Customer();
		size = 0;
		Purchase = new Purchase[size];
		for (int i = 0; i <Purchase.length; i++)
		{
			Purchase[i] = new Purchase();	
		}
	}
	
	/**
	 * This method sets customer data
	 * @param c sets c value to customer
	 */
	public void SetCustomer(Customer c)
	{
		Customer = c;
	}
	
	/**
	 * GetCustomer returns a customer value
	 * @return Customer variable data
	 */
	public Customer GetCustomer()
	{
		
		return Customer;
	}
	
	/**
	 * GetArraySize returns that size of the array.
	 * @return the size of Purchase size
	 */
	public int GetAraySize()
	{
		return Purchase.length;
	}
	
	/**
	 * This method searches the array for the purchase that costs the most.
	 * @return The purchase with the highest cost
	 */
	public Purchase GetMaxPurchase()
	{
		int max = 0;
		
		if(Purchase == null)
		{
			return null;
		}

		for (int i = 0; i <Purchase.length; i++)
		{
			if( Purchase[i].GetProduct().GetPrice() * Purchase[i].Getquantity() > Purchase[max].GetProduct().GetPrice() * Purchase[max].Getquantity())
			{
				max =i;
			}	
		}
		
		
		return Purchase[max];
		
		
	}
	/**
	 *  
	 * @param index holds an integer 
	 * @return Returns the purchase at the given index. 
	 */
	public Purchase GetByIndex(int index) 
	{	
		if((index >Purchase.length ) || (index < 0))
		{
		   throw new ArrayIndexOutOfBoundsException();
		}
		else
		{
		return Purchase[index-1];
		}
	}
	
	/**
	 * The method report is used to print to the screen
	 * @param ps Uses PrintStream to print member variable data
	 */
	public void Report(PrintStream ps)
	{
		double cost =0;
		double totalQ = 0; 
		double totalC = 0;
		ps.printf("Purchase Report\n");
		ps.printf("---------------\n");
		ps.println(Customer.GetfirstName() +" " +Customer.GetlastName());
		ps.println(Customer.GetAddress().Getnumber()+" "+Customer.GetAddress().Getstreet());
		ps.println(Customer.GetAddress().Getstate()+", "+Customer.GetAddress().Getcity()+" "+Customer.GetAddress().Getzip());
		ps.println();
		String D = "Description", P= "Price",Q= "Quantity", C= "Cost";
		String filler = "-----------";
		ps.printf("%-30s %12s %10s %12s\n", D, P, Q, C);
		ps.printf("%-30s %12s %10s %12s\n", filler, filler, filler, filler);
		for (int i =0; i <Purchase.length; i++)
		{
			cost = Purchase[i].GetProduct().GetPrice() * Purchase[i].Getquantity();
			totalQ = Purchase[i].Getquantity() + totalQ;
			totalC = cost + totalC; 
			ps.printf("%-30s %12s %10d %12s\n",Purchase[i].GetProduct().GetDescription(), Purchase[i].GetProduct().GetPrice() ,Purchase[i].Getquantity(), cost);
		}	
		ps.printf("%-30s %12s %10s %12s\n", filler, filler, filler, filler);
		ps.printf("Total %48.0f %12.2f\n", totalQ, totalC);
	}
	
	/**
	 * The method write is used to print to a file
	 * @param ps Uses PrintStream to print member variable data
	 */
	public void Write(PrintStream ps)
	{
		
		Customer.write(ps);
		ps.println(size);
		for (int i =0; i <Purchase.length; i++)
		{
			Purchase[i].Write(ps);		
		}	
	}
	
	/**
	 * This method is used to read in data
	 * @param s Takes in a Scanner variable to read data from a file
	 */
	public void Read(Scanner s)
	{
		Customer.Read(s);
		size = s.nextInt();
		s.nextLine();
		Purchase = new Purchase[size];
		
		for (int i =0; i <Purchase.length; i++)
		{
			Purchase[i] = new Purchase();
			Purchase[i].Read(s);		
		}
	}

	/**
	 * This method prints data in JSON format
	 * @return s Return a string in JSON format
	 */
	public String GetJSON()
	{
		String s;
		s = "";
		s+= "{\n" + "\"" +  "Customer" + "\"" + " : \n";
		s += Customer.GetJSON();
		s+= "\"" +"Purchases" + "\"" + " : \n";
		s+= "[" + "\n";
		for (int i =0; i <Purchase.length; i++)
		{
			s += Purchase[i].GetJSON();
			if (i < Purchase.length -1)
			{
				s += "," + "\n"; 
			}
		}
		s+= "\n";
		s+= "]" + "\n";
		s+= "}" + "\n";
		return s;
	}
	

	/**
	 * ToString override toStirng class and return a formatted string
	 */
	@Override
	public String toString()
	{
		String s;
		s = "";
		s += Customer.toString();
		
		for (int i =0; i <Purchase.length; i++)
		{
			s += Purchase[i].toString();	
		}
		
		return s;
	}

	
}
