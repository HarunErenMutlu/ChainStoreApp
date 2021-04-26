package StoreApp;

/*
 * This program PrintEverything where includes all the prints for our homework.
 * This program calls StoreQuery for functions that does the missions.
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */

import java.io.IOException;

import Shopping.StoreQuery;

public class PrintEverything {
	private StoreQuery storeQuery; // All calculations are in this class
	
	public void PrintEvetything() throws IOException {

		 storeQuery = new StoreQuery();
		 run();
		 
	}
	
	private void run() { // this will print everything
		MostProfitableItemWholeYear();
		MostProfitableCategoryWholeYear();
		LeastProfitableItemWholeYear();
		LeastProfitableCategoryWholeYear();
		MostProfitableItemSingleSale();
		BestSellingItemWholeYear();
		BestStores();
	}
	
	//method that prints most profitable item for whole year
	private void MostProfitableItemWholeYear() {
		System.out.println("Most Profitable item for whole year is "+
							storeQuery.calculateMostProfitableItemWholeYear().getName());
	}
	
	//method that prints most profitable category for whole year
	private void MostProfitableCategoryWholeYear() {
		System.out.println("Most Profitable category for whole year is "+
							storeQuery.calculateMostProfitableCategoryWholeYear());
	}
	
	//method that prints least profitable item for whole year
	private void LeastProfitableItemWholeYear() {
		System.out.println("Least Profitable item for whole year is "+
							storeQuery.calculateLeastProfitableItemWholeYear().getName());
	}
	
	//method that prints least profitable category for whole year
	private void LeastProfitableCategoryWholeYear() {
		System.out.println("Least Profitable category for whole year is "+
							storeQuery.calculateLeastProfitableCategoryWholeYear());
	}
	
	//method that prints most profitable item for a single sale
	private void MostProfitableItemSingleSale() {
		System.out.println("Most profitable item for a single sale is "+
							storeQuery.findMostProfitableItemSingleSale().getName());
	}
	
	//method that prints best selling item for whole year
	private void BestSellingItemWholeYear() {
		System.out.println("Best selling item for whole year is "+
							storeQuery.findBestSellingItemWholeYear().getName());
	}
	
	//method that prints most profitable store for each months
	private void BestStores() {
		for(int i=0;i<storeQuery.findBestStore().length;i++) {
			System.out.println(String.format("Most profitable store for Month %d is Store ", i+1)+
								storeQuery.findBestStore()[i]);
	}
		}
	}
	
