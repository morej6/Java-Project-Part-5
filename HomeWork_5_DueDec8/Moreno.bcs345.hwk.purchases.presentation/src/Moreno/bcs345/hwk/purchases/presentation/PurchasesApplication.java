
package Moreno.bcs345.hwk.purchases.presentation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.input.KeyCombination;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import Moreno.bcs345.hwk.purchases.business.PurchaseCollection;
/**
 * Application class used to process a purchase collection.
 * @author Juan Moreno
 * @version 1.0
 * @since 11/15/16
 */
public class PurchasesApplication extends Application {
	
	private  PurchaseCollection Purchase;
	private ListView<String>list = new ListView<>();
	ObservableList<String> items =FXCollections.observableArrayList (); 
	
	/**
	 * This method will create the GUI. 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Purchases");	
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.show();
		
		VBox vbox = new VBox();
		MenuBar mainMenu = new MenuBar();  
		TabPane tabPane = new TabPane();
		//Creating a customer and purchase tab.
		Tab customerTab = new Tab(); 
		Tab purchaseTab = new Tab();
		
		//Drop down Menu for File...Open..Save As etc
		Menu dropDownFileMenu = new Menu("File");
		MenuItem open = new MenuItem("Open...");
		MenuItem save_As = new MenuItem("Save As...");
		MenuItem save_Report = new MenuItem("Save Report...");
		MenuItem exit = new MenuItem("Exit");
		dropDownFileMenu.getItems().addAll(open, new SeparatorMenuItem(), save_As, save_Report, new SeparatorMenuItem(),  exit);
		//Adds everything to one button ei file..open etc
		mainMenu.getMenus().addAll(dropDownFileMenu);
		
		//Assing mainMenu and tabpane to vbox
		vbox.getChildren().add(mainMenu);
		vbox.getChildren().add(tabPane);
		//Setting title to both tabs.
		customerTab.setText("Customer");
		purchaseTab.setText("Purchase");
		tabPane.getTabs().add(customerTab);
		tabPane.getTabs().add(purchaseTab);
		
		GridPane grid = new GridPane();
		//Sets space between TextFields and Labels.
		grid.setVgap(10);
		grid.setHgap(10);
		
		//Each label with its given text.
		Label firstName = new Label("First name");
		Label LastName = new Label("Last name");
		Label number = new Label("Number");
		Label street = new Label("Street");
		Label city = new Label("City");
		Label state = new Label("State");
		Label zip = new Label("Zip");
		
		//Sets space between each label in customer tab.
		GridPane.setConstraints(firstName, 0,0);
		GridPane.setConstraints(LastName, 0,2);
		GridPane.setConstraints(number, 0,4);
		GridPane.setConstraints(street, 0,6);
		GridPane.setConstraints(city, 0,8);
		GridPane.setConstraints(state, 0,10);
		GridPane.setConstraints(zip, 0,12);
		
		//Sets the labels to the customerTab only!!
		customerTab.setContent(grid);
		
		//Creates TextField.
		TextField textFirst = new TextField();
		TextField textLast = new TextField();
		TextField textNumber = new TextField();
		TextField textStreet = new TextField();
		TextField textCity = new TextField();
		TextField textState = new TextField();
		TextField textZip = new TextField();
		

		//Sets space between each TextField in customer tab.
		GridPane.setConstraints(textFirst,9,0);
		GridPane.setConstraints(textLast,9,2);
		GridPane.setConstraints(textNumber,9,4);
		GridPane.setConstraints(textStreet,9,6);
		GridPane.setConstraints(textCity,9,8);
		GridPane.setConstraints(textState,9,10);
		GridPane.setConstraints(textZip,9,12);
		
		//Adds all TextFields into one
		grid.getChildren().addAll(textFirst,textLast,textNumber, textStreet, textCity,textState,textZip,firstName,LastName,number,street,city,state,zip);

		//Makes it so you can't exit out of the tabs
		customerTab.setClosable(false);
		purchaseTab.setClosable(false);
		
		list.setItems(items);
	
		//Open used to find the desired file.
		open.setOnAction( new EventHandler<ActionEvent>()
		{
		      public void handle(ActionEvent t) 
		      {
		    	  FileReader fr;
		    	  String filename="";
		    	  
		    	  try{
		    	 
		    	  FileChooser filechooser = new FileChooser();
		    	  filechooser.setTitle("Open PurchaseCollection file");
		    	  
		    	  File file = filechooser.showOpenDialog(primaryStage);
		    	  
		    	  //Makes sure that if the user clicks on cancel it will not cause the rogram to crash.
		    	  if(file != null)
		    	  {
		    		  filename = file.getName();
		    	  
		    	  fr = new FileReader(filename);
		    	  Scanner s = new Scanner(fr);
		    	  Purchase = new PurchaseCollection();
		    	  
		    	  Purchase.Read(s);
		    	  //Get methods used to populate TextFields
				  textFirst.setText(Purchase.GetCustomer().GetfirstName());
		    	  textLast.setText(Purchase.GetCustomer().GetlastName());
				  textNumber.setText(Purchase.GetCustomer().GetAddress().Getnumber());
				  textStreet.setText(Purchase.GetCustomer().GetAddress().Getstreet());
				  textCity.setText(Purchase.GetCustomer().GetAddress().Getcity());
				  textState.setText(Purchase.GetCustomer().GetAddress().Getstate());
				  textZip.setText(Purchase.GetCustomer().GetAddress().Getzip());
				  
				  for (int i =1; i <=Purchase.GetAraySize(); i++)
				  {
				  // I found two ways to populate the listview. I modiefied Product toString to include the $ so it appears before the price.
				  // But if that isn't right I have another line that uses the get methods to build it. Both work I was confused as to which you wanted
				  // us to use for the homework.
				  //items.add(Integer.toString(Purchase.GetByIndex(i).Getquantity())+","+" "+Purchase.GetByIndex(i).GetProduct().GetDescription()+","+" "+"$"+ Purchase.GetByIndex(i).GetProduct().GetPrice());
				  items.add(Purchase.GetByIndex(i).toString());
				  }
				  
		    	  }
		    	  }catch(FileNotFoundException e){
		    		  e.printStackTrace();
		    	    
		    	  }
		    	  
		      }
		           
		 }
		   
		);
		//Shortcut used for the open choice.
		open.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));
		//Used to populate listview in Purchasetab
		purchaseTab.setContent(list);
		
		//Save_As used to save a read text file
		save_As.setOnAction(new EventHandler<ActionEvent>(){
			 public void handle(ActionEvent t) {
		    	 try
		    	 { 		
				 FileChooser filechooser = new FileChooser();
		    	 filechooser.setTitle("Save As PurchaseCollection file");
		    	 File file = filechooser.showSaveDialog(primaryStage);
		    	 if(file != null)
		    	  {
			    	  PrintStream ps = null;
			    	  ps = new PrintStream(file);
			    	  Purchase.Write(ps);
		    	  }
		    	 
		    	 
		    	 }catch(Exception e)
		    	 {
		    		 System.out.print("Error\n");
		    	 }				  
			}
		}
		
	    );
		//Shortcut used for the Save_As choice.
		save_As.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
		
		//Save_Report creates a full report from a read file, and saves it.
		save_Report.setOnAction(new EventHandler<ActionEvent>(){
			 public void handle(ActionEvent t) {
		    	 try
		    	 {
		    	 
				 FileChooser filechooser = new FileChooser();
		    	 filechooser.setTitle("Save PurchaseCollection Report");
		    	 File file = filechooser.showSaveDialog(primaryStage);
		    	 if(file != null)
		    	  {
			    	  PrintStream ps = null;
			    	  ps = new PrintStream(file);
			    	  Purchase.Report(ps);
		    	  }
		    	 
		    	 }catch(Exception e)
		    	 {
		    		 System.out.print("Error\n");
		    	 }
				 
			}
		}
		
	    );
		//Exit used to close application window. 
		exit.setOnAction(new EventHandler<ActionEvent>(){
			 public void handle(ActionEvent t) {
				 System.exit(0);
			}
		}
		
	    );
		//Shortcut used to close the application window.
		exit.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
		
		//Shows application window.
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
