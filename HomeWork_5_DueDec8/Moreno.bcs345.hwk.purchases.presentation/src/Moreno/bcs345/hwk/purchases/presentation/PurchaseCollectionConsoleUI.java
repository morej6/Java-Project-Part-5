package Moreno.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import Moreno.bcs345.hwk.purchases.business.PurchaseCollection;

/**
 * Contains menu used to call PurchaseCollection class to process a collection of data.
 * @author Juan Moreno
 * @version 1.2
 * @since 11/15/16
 */
public class PurchaseCollectionConsoleUI {
	

		/**
		 * Method that contains menu that appear on screen for the user to use.
		 */
		public void ShowUI()
		{
			//Scanner used to take in user input. This scanner will hold the name of the file the user wants to open.
			Scanner keyboard = new Scanner(System.in);
			
			//Crating two instances of Scanner to read input files
			Scanner sc = null;
			Scanner sc2 = null;

			//Crating two instances of PrintStream to write output files
			PrintStream ps = null;
			PrintStream ps2 = null;

			//Declaring an instance of PurchaseCollection
			PurchaseCollection a = new PurchaseCollection();
			
	

		
			//Declaring and initializing count. 
			int count =0;
			//While Loop used to repeat menu until 8 is selected.
			while (count != 8)
			{
				
				System.out.print("Customer/Purchases UI\n");
				System.out.print("-----------------------\n");
				System.out.print("1 – Read PurchaseCollection from file\n");
				System.out.print("2 – Write PurchaseCollection to file\n");
				System.out.print("3 – Show purchase by index\n");
				System.out.print("4 – Show maximum purchase\n");
				System.out.print("5 – Show PurchaseCollection as JSON string on screen\n");
				System.out.print("6 - Show PurchaseCollection report on screen\n");
				System.out.print("7 – Show PurchaseCollection toString on screen\n");
				System.out.print("8 - Exit\n");
				System.out.print("Enter Choice:");
				Scanner keyboard2 = new Scanner(System.in); //Scanner used to read in user selection for the menu
				try{
					count = keyboard2.nextInt();
				} catch (InputMismatchException e)
				{
				}
				 
				System.out.print("");
				if(count == 1) //Used to read collection file
				{
					System.out.print("Enter Collection file: ");
					String infile = keyboard.nextLine();
					
					//Try and catch block used for file handling
					try
					{
					FileReader fr = new FileReader(infile);
					sc = new Scanner(fr);
					a.Read(sc); //Calling Read method from PurchaseCollection class
					}
					catch (Exception e)
					{
						System.out.println("File not found");
					}
					
				}
				else if (count ==2) //Used to write collection data to an output file
				{
					System.out.print("Enter new outfile name: ");
					String outfile = keyboard.nextLine(); 
					
					//Try and catch block used for file handling
					try {
						ps = new PrintStream(outfile);
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
					a.Write(ps); //Calling write method from PurchaseCollection class
					
				}
				else if (count ==3) //Prints a Purchase at a given index
				{
					int index = 0;
					
					try{
						System.out.print("Enter Index: ");
						index = keyboard2.nextInt(); 
						System.out.print(a.GetByIndex(index)); //Calling and printing GetByIndex method from PurchaseCollection class
					}catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.print("Error - Bad index\n");
					}
					
				}
				else if (count ==4) //Prints a the highest purchase in the file
				{
					try{
					System.out.print(a.GetMaxPurchase()); //Calling and printing GetMaxPurchase method from PurchaseCollection class
					}catch (ArrayIndexOutOfBoundsException e)
					{
							System.out.print("Array is Null\n");
					}
					
				
				}
				else if (count ==5) //Prints a file information to the screen in JSON format
				{
					
					System.out.print(a.GetJSON());
					
				}
				else if (count ==6) //Prints a file information to the screen 
				{
					try {
						ps2 = new PrintStream(System.out);
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					a.Report(ps2); //Calling and printing Report method from PurchaseCollection class
				}
				else if (count ==7) //Prints a file information to the screen
				{
					System.out.print(a.toString());
				}
				else 
				{
					
					return; //Returning to Menu in Driver 
				}
				
			}
			keyboard.close();//Closing Scanner
		}	
		
	}



