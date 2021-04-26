package Shopping;
/*
 *Transaction class and it's getters and setter 
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
public class Transaction {
	float PurchasePrice;
	float SalePrice;
	int NumberOfSales;
	
	public float getPurchasePrice() {
		return PurchasePrice;
	}
	public void setPurchasePrice(float purchasePrice) {
		PurchasePrice = purchasePrice;
	}
	public float getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(float salePrice) {
		SalePrice = salePrice;
	}
	public int getNumberOfSales() {
		return NumberOfSales;
	}
	public void setNumberOfSales(int numberOfSales) {
		NumberOfSales = numberOfSales;
	}
}
