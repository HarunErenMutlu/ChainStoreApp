package Shopping;


/*
 * It is a helper class for PrintEverything class.
 * It includes all the necessary functions that satisfies requires for homework.
 * It calls Initialization class to get data for functions.
 * 
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
import java.io.IOException;

public class StoreQuery {
	private Initialization initial; // class that includes data
	private AnnualSale annualSale; // class that stores itemTransactions
	private ItemTransaction[] listItemTransactions; // list of itemTransactions
	
	public StoreQuery() throws IOException{//constructor class
	initial = new Initialization();
	annualSale = initial.getAnualSale();
	listItemTransactions = annualSale.getItemTransaction();
	}
	
	//method that calculates profit for a single sale transaction
	private float calculateProfitSingleSale(Transaction transaction) {
		return (transaction.getSalePrice()-transaction.getPurchasePrice());
	}
	//method that calculates	profit for a monthly sale transaction
	private float calculateProfit(Transaction transaction) {
		return (transaction.getSalePrice()-transaction.getPurchasePrice())*transaction.getNumberOfSales();
	}

	//method that calculates annual profit of item that is given in brackets 
	private float calculateWholeProfitItem(ItemTransaction itemTransaction){
		float profit = 0;
		for(int i=0;i<itemTransaction.getTransactions().length;i++) {
			for(int j=0;j<itemTransaction.getTransactions()[0].length;j++) {
				Transaction transaction = itemTransaction.getTransactions()[i][j];
				profit += calculateProfit(transaction);
	}}
		
		return profit;}
	
	
	//method that calculates annual profit of category that is given in brackets 
	private float calculateWholeProfitCategory(ItemTransaction itemTransaction, String category) {
		float profit = 0;
		for(int i=0;i<itemTransaction.getTransactions().length;i++) {
			for(int j=0;j<itemTransaction.getTransactions()[0].length;j++) {
				if(itemTransaction.getItem().getCategory().equals(category)) {
					Transaction transaction = itemTransaction.getTransactions()[i][j];
					profit += calculateProfit(transaction);
				}}
			}
		return profit;
	}
	
	// method that calculates annual number of sales of the list that is given in brackets
	private int sellingWholeYear(Transaction[][] transaction) {
		int selling = 0;
		for(int i=0; i<transaction.length; i++) {
			for(int j = 0; j<transaction[0].length;j++) {
				selling += transaction[i][j].getNumberOfSales();
			}
			
		}
		return selling;
	}
	
	// method that calculates the profit of all items of the given store and the given month
	private float calculateStoreProfitMonthly(int moon,int store){
		float profit = 0;
		for(int i=0; i<32; i++) {// that traces all the items (in this homework there are 32 items)
			profit += calculateProfit(listItemTransactions[i].getTransactions()[store][moon]);}
		return profit;
	}
	
	// method that calculates the most profitable item for whole year
	
	public Item calculateMostProfitableItemWholeYear() {
		Item maxItem =listItemTransactions[0].getItem();
		float maxProfit = calculateWholeProfitItem(listItemTransactions[0]);
		
		for(int i=0; i<listItemTransactions.length; i++) {
			if (calculateWholeProfitItem(listItemTransactions[i])> maxProfit){
				maxItem = listItemTransactions[i].getItem();
				maxProfit = calculateWholeProfitItem(listItemTransactions[i]);
			}
		}
		return maxItem;	
	}
	
	// method that calculates the most profitable category for whole year
	public String calculateMostProfitableCategoryWholeYear() {
		String maxCategory = listItemTransactions[0].getItem().getCategory(); // it is the first item that for loop traces
		// it is the profit of the first item that for loop traces
		float maxProfit = calculateWholeProfitCategory(listItemTransactions[0],listItemTransactions[0].getItem().getCategory());
		
		for(int i=0; i<listItemTransactions.length; i++) {
			
			ItemTransaction itemTransaction = listItemTransactions[i];
			
			if (calculateWholeProfitCategory(itemTransaction,itemTransaction.getItem().getCategory())> maxProfit){
				maxCategory = listItemTransactions[i].getItem().getCategory();
				maxProfit = calculateWholeProfitCategory(itemTransaction,itemTransaction.getItem().getCategory());
			}
		}
		return maxCategory;
	}
	
	
	// method that calculates the least profitable item for whole year
	public Item calculateLeastProfitableItemWholeYear() {
		Item minItem =listItemTransactions[0].getItem();// it is the first item that for loop traces
		float minProfit = calculateWholeProfitItem(listItemTransactions[0]); // it is the profit of the first item that for loop traces
		for(int i=0; i<listItemTransactions.length; i++) {
			if (calculateWholeProfitItem(listItemTransactions[i])< minProfit){
				minItem = listItemTransactions[i].getItem();
				minProfit = calculateWholeProfitItem(listItemTransactions[i]);
			}
		}
		return minItem;	
	}
	
	// method that calculates the least profitable category for whole year
	
	public String calculateLeastProfitableCategoryWholeYear() {
		String minCategory = listItemTransactions[0].getItem().getCategory(); // it is the first category that for loop traces
		// it is the profit of the first category that for loop traces
		float minProfit = calculateWholeProfitCategory(listItemTransactions[0],listItemTransactions[0].getItem().getCategory());
		
		for(int i=0; i<listItemTransactions.length; i++) {
			ItemTransaction itemTransaction = listItemTransactions[i];
			if (calculateWholeProfitCategory(itemTransaction,itemTransaction.getItem().getCategory())< minProfit){
				minCategory = listItemTransactions[i].getItem().getCategory();
				minProfit = calculateWholeProfitCategory(itemTransaction,itemTransaction.getItem().getCategory());
			}
		}
		return minCategory;
	}
	
	// method that calculates the most profitable item for a single sale
	public Item findMostProfitableItemSingleSale() {
		Item maxItem =listItemTransactions[0].getItem(); // it is the first category that for loop traces
		// it is the profit of the first item that for loop traces
		float maxProfit = calculateProfitSingleSale(listItemTransactions[0].getTransactions()[0][0]);
		
		for(int i=0; i<listItemTransactions.length; i++) {
			for(int j=0;j<listItemTransactions[0].getTransactions().length;j++) {
				for(int k=0;k<listItemTransactions[0].getTransactions()[0].length;k++) {
					Transaction transaction = listItemTransactions[i].getTransactions()[j][k];
					if(calculateProfitSingleSale(transaction)>maxProfit) {
						maxProfit = calculateProfitSingleSale(transaction);
						maxItem = listItemTransactions[i].getItem();
					}
				}
			}
		}
		return maxItem;
	}
	
	// method that calculates the best selling item for whole year
	public Item findBestSellingItemWholeYear() {
		Item maxItem =listItemTransactions[0].getItem();// it is the first item that for loop traces
		// it is the first number of sales of the first item that for loop traces
		int maxSelling = sellingWholeYear(listItemTransactions[0].getTransactions());
		for(int i=1; i<listItemTransactions.length; i++) {
			if(sellingWholeYear(listItemTransactions[i].getTransactions())>maxSelling) {
				maxSelling = sellingWholeYear(listItemTransactions[i].getTransactions());
				maxItem = listItemTransactions[i].getItem();
			}
		}
		return maxItem;
	}
	
	// method that calculates the most profitable stores for each months.
	public int[] findBestStore() {
		int[] stores= new int[12];
		for(int i=0; i<12; i++) { // there are 12 months to trace
			float maxProfit = calculateStoreProfitMonthly(i, 0);
			int moon = 0;
			for(int j=0; j<4;j++) {// there are 4 stores to trace
				if(calculateStoreProfitMonthly(i, j)>maxProfit) {
					moon = j;
					maxProfit = calculateStoreProfitMonthly(i, j);
				}
			}
			stores[i] = moon+1;
		}
		return stores;
	}



}
