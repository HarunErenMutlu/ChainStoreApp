package Shopping;
/*
 *ItemTransaction class and it's getters and setters
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
public class ItemTransaction {
	private Shopping.Item Item;
	private Shopping.Transaction[][] Transactions = new Shopping.Transaction[4][12];
	
	
	
	
	public Shopping.Item getItem() {
		return Item;
	}
	public void setItem(Shopping.Item item) {
		Item = item;
	}
	public Shopping.Transaction[][] getTransactions() {
		return Transactions;
	}
	public void setTransactions(int moon,int shop, Transaction transaction) {
		this.Transactions[shop][moon]= transaction;
	}
	
	
}
