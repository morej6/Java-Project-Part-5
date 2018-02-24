package Moreno.bcs345.hwk.purchases.presentation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import Moreno.bcs345.hwk.purchases.business.Customer;
import Moreno.bcs345.hwk.purchases.business.Purchase;
/**
 * Contains menu used to call various classes to process a person data.
 * @author Juan Moreno
 * @version 1.2
 * @since 11/15/16
 */
public class CustomerPurchaseConsoleUI {
	
	/**
	 * Method that contains menu that appear on screen for the user to use.
	 */
	public void ShowUI()
	{
		//Scanner used to take in user input. This scanner will hold the name of the file the user wants to open.
		Scanner keyboard = new Scanner(System.in);
		
		//Crating two instances of Scanner to read inpu files
		Scanner sc = null;
		Scanner sc2 = null;

		//Crating two instances of PrintStream to write output files
		PrintStream ps = null;
		PrintStream ps2 = null;

		//Declaring an instance of Customer
		Customer a = new Customer();	
		
		//Declaring an instance of Purchase 
		Purchase b = new Purchase();
		
		
	
		//Declaring and initializing count. 
		int count =0;
		//While Loop used to repeat menu until 9 is selected.
		while (count != 9)
		{
			
			System.out.print("Customer/Purchases UI\n");
			System.out.print("-----------------------\n");
			System.out.print("1 – Read customer from file\n");
			System.out.print("2 – Write customer to file\n");
			System.out.print("3 – Show customer info on screen\n");
			System.out.print("4 – Show customer JSON on screen\n");
			System.out.print("5 – Read purchase from file\n");
			System.out.print("6 – Write purchase to file\n");
			System.out.print("7 – Show purchase info on screen\n");
			System.out.print("8 – Show purchase JSON on screen\n");
			System.out.print("9 - Exit\n");
			System.out.print("Enter Choice:");
			Scanner keyboard2 = new Scanner(System.in); //Scanner used to read in user selection for the menu
			try{
				count = keyboard2.nextInt();
			} catch (InputMismatchException e)
			{
				System.out.print("Invalid Input\n");
			}
			System.out.print("");
			if(count == 1) //Used to read customer data
			{
				System.out.print("Enter Customer file: ");
				String infile = keyboard.nextLine();
				
				//Try and catch block used for file handling
				try
				{
				FileReader fr = new FileReader(infile);
				sc = new Scanner(fr);
				a.Read(sc); //Calling Read method from Customer class
				}
				catch (Exception e)
				{
					System.out.println("File not found");
				}
				
			}
			else if (count ==2) //Used to write customer data to an output file
			{
				System.out.print("Enter new Customer outfile name: ");
				String outfile = keyboard.nextLine(); 
				
				//Try and catch block used for file handling
				try {
					ps = new PrintStream(outfile);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				a.write(ps); //Calling write method from Customer class
				
			}
			else if (count ==3) //Prints a customer information to the screen
			{
				System.out.print(a.toString());
			}
			else if (count ==4) //Prints a customer information to the screen in JSON format
			{
				System.out.print(a.GetJSON());
			
			}
			else if (count ==5) //Reads in Purchase data
			{
				System.out.print("Enter Purchase file: ");
				String infile2 = keyboard.nextLine();

				//Try and catch block used for file handling
				try
				{
				FileReader fr2 = new FileReader(infile2);
				sc2 = new Scanner(fr2);
				}
				catch (FileNotFoundException e)
				{
					System.out.println("File not found");
				}
				b.Read(sc2); //Calling Read method from Purchase class
				
			}
			else if (count ==6) //Used to write Purchase data to an output file
			{
				System.out.print("Enter new Purchase outfile name: ");
				String outfile2 = keyboard.nextLine();
				
				//Try and catch block used for file handling
				try {
					ps2 = new PrintStream(outfile2);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				b.Write(ps2); //Calling Write method from Purchase class
			}
			else if (count ==7) //Prints a person purchase information to the screen
			{
				System.out.print(b.toString());
			}
			else if (count ==8) //Prints a person purchase information to the screen in JSON format
			{
				System.out.println(b.GetJSON());
			}
			else  
			{	
				return;	//Returning to Menu in Driver 
			}
		}
		
		keyboard.close();//Closing Scanner
		
	}	
	
}
