package Shopping;
import java.io.IOException;

import FileAccess.FileIO;

/*
 * It is a helper class for StoreQuery class.
 * The class calls FileIO and get data from it and it convert that data to arrays. 
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
public class Initialization {
	private FileIO file;
	String[][] items,stores;
	private Item[] itemList; // that stores all the items
	
	public Initialization() throws IOException{// constructor class
		file=new FileIO();
		setItems();
		getAnualSale();
	}
	// method that converts the data from the given item file to item list 
	private void setItems() throws IOException {
		items = file.getItems();// data from FileIO
		Item[] listOfItems= new Item[32];
		for(int i=0; i<items.length; i++) {
			String name = items[i][0];
			int id= Integer.valueOf(items[i][1]);
			String category= items[i][2];
			Item newItem = new Item(id,name,category);
			listOfItems[i] = newItem;
		}
		this.itemList = listOfItems;
	}
	
	// This method gets the data from the given four transactions store files and classifies them into necessary classes.
	// Then combines then into AnnualSale class and returns the AnnualSale class. 
	public AnnualSale getAnualSale() throws IOException{
		AnnualSale annualSale = new AnnualSale();
		ItemTransaction[] itemTransactions = new ItemTransaction[32];// to be able to store all ItemTransaction objects
		stores = file.getStores();// data from FileIO
		int storeNumber = 0,itemNumber = 0,countMoon=0;// initialize numbers
		Transaction newTransaction = new Transaction();// to be able to create transactions in loops
		
		for(int i =0; i<file.getItems().length;i++) {
			itemTransactions[i] = new ItemTransaction();// it creates null ItemTransactions and store them in itemTransactions
		}
		
		for(int i=0;i<stores.length;i++) {
			if(i%(stores.length/4)==0 && i !=0) {// we divided by 4 because there were 4 stores 
				storeNumber++;}
			String[] transactions = stores[i];
			for(int j=0; j<transactions.length; j++) {
				if(j==0) {
					itemNumber = Integer.valueOf(transactions[j]);
					countMoon= 0;
				}
				else if(j%3==1) {// The number of data of transactions are three for each months. 
					//So we create a new transaction at every three number 
					newTransaction = new Transaction();
					newTransaction.setPurchasePrice(Float.valueOf(transactions[j]));}
				
				else if(j%3==2) {
					newTransaction.setSalePrice(Float.valueOf(transactions[j]));}
				
				else if(j%3==0) { 
					newTransaction.setNumberOfSales(Integer.valueOf(transactions[j]));
					Item[] items = this.itemList;
					for(int k=0; k<items.length; k++) {// to find the related item
						if(items[k].getId() == itemNumber && itemNumber != 0) 
						{
							itemTransactions[itemNumber-1].setItem(items[k]);
						}
					}
					itemTransactions[itemNumber-1].setTransactions(countMoon, storeNumber, newTransaction);
					countMoon++;
								}
				
				
			}
			
		}
		annualSale.setItemTransaction(itemTransactions);
		return annualSale;
		}
	
}
