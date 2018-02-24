package Moreno.bcs345.hwk.purchases.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.application.Application;

/**
 * Calls a instance of CustomerPurchaseConsoleUI and PurchaseCollectionConsoleUI to show menu
 * 
 * @author Juan Moreno
 * @version 1.2
 * @since 11/15/16
 */
public class Driver {

	/**
	 * Main is where the code is run.
	 * @param args contains the command-line arguments
	 */
	public static void main(String[] args) {

		int count =0; //Sets count to zero
		PurchaseCollectionConsoleUI a = new PurchaseCollectionConsoleUI(); //Creates an instance of PurchaseCollectionUI
		CustomerPurchaseConsoleUI b = new CustomerPurchaseConsoleUI(); //Creates an instance of CustomerPurchaseConsoleUI
		PurchasesGraphicalUI c = new PurchasesGraphicalUI(); //Creates an instance of PurchasesGraphicalUI
		while (count != 4)
		{
			System.out.print("Customer/Purchases UI\n");
			System.out.print("-----------------------\n");
			System.out.print("1 – CustomerPurchaseConsoleUI\n");
			System.out.print("2 – PurchaseCollectionConsoleUI\n");
			System.out.print("3 – PurchasesGraphicalUI\n");
			System.out.print("4 - Exit\n");
			System.out.print("Enter Choice:");
			Scanner keyboard2 = new Scanner(System.in); //Scanner used to take user input
			try{ //Try and catch block used to check if input is valid.
				count = keyboard2.nextInt();
			} catch (InputMismatchException e)
			{
				System.out.print("Invalid Input\n");
			}
			 
			if (count ==1) //Used to show CustomerPurchaseConsoleUI class
			{
				b.ShowUI();
			}
			else if (count ==2) //Used to show PurchaseCollectionConsoleUI class
			{
				a.ShowUI();
			}
			else if (count == 3) //Used to call the GUI
			{
				c.ShowUI();
			}
			else if (count ==4) //Terminates program
			{
				System.out.print("Program terminated");
				break;
			}
		}
	}

}
