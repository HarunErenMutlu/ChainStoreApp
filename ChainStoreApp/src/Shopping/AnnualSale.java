package Shopping;
/*
 *AnnualSale class and it's getter and setter 
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
public class AnnualSale {
	
	private Shopping.ItemTransaction[] ItemTransaction = new ItemTransaction[32];
	

	public Shopping.ItemTransaction[] getItemTransaction() {
		return ItemTransaction;
	}

	public void setItemTransaction(Shopping.ItemTransaction[] itemTransaction) {
		ItemTransaction = itemTransaction;
	}

}
