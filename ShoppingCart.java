package MarketSysGUI;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart {
	private String sh_cartID;

	private int sh_quantity;
	private double sh_productPrice;
	private String sh_itemName;
	// private date sh_date; // sth need to fix
	private double sh_weight;
	private double sh_totalPrice;
	private double sh_discount;
	private double sh_bulkDiscount;

	private Customer sh_Customer; // *
	private String sh_CustomerID; // *
	private Product sh_product; // *
	private String sh_ProductID; // *
	private String sh_ProductType;
	private double sh_PriceWeight;
	private double sh_ProductWeight;
	private int sh_BulkDiscountNum;


	// constructor

	public ShoppingCart() {

	}

	public ShoppingCart(Customer c, Product p /* */, String cartID, int quantity) {
		this.sh_cartID = cartID;
		sh_product = p; // *
		sh_Customer = c; // *
		this.sh_CustomerID = sh_Customer.getCustomerID();
		this.sh_ProductID = sh_product.getProductID(); // *
		this.sh_itemName = sh_product.getProductName(); // *
		this.sh_quantity = quantity;
		this.sh_productPrice = sh_product.getProductPrice(); // *
		sh_totalPrice = 0;
		this.sh_discount = sh_product.getDiscount();
		this.sh_bulkDiscount = sh_product.getBulkDiscount();
		sh_ProductType = sh_product.getProductType();
		sh_PriceWeight = sh_product.getPriceWeight();
		sh_ProductWeight = sh_product.getProductWeight();
		sh_BulkDiscountNum = sh_product.getBulkDiscountNum();
	}

	ArrayList<ShoppingCart> cart = new ArrayList<ShoppingCart>();

	/*
	 * public void addItem(){ ShoppingCart sh1 = new
	 * ShoppingCart(sh_CartID,addProductID,addItemName,
	 * addquantity,addPrice,addWeight,addDiscount,addBulkDiscou nt);
	 * cart.add(sh1); }
	 */
	public void setProduct(Product p)
	{
		sh_product = p;
	}
	public double getPrice() {
		return sh_productPrice;
	}

	public int getQuantity() {
		return sh_quantity;
	}
	public String guiToString(){
		return "Product Name: " + sh_itemName + " Quantity: " + sh_quantity + " Price: $" + sh_productPrice
				+ " Weight: " + sh_ProductWeight + "KG" +" PriceWeight: $" + sh_PriceWeight +  " per/kg " + "\nTotalPrice: $"+ String.valueOf(CaculateTotalPrice()) + "\n";
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "CustomerID: " + sh_CustomerID + "\nCartID: " + sh_cartID + "\nProductID: " + sh_ProductID
				+ "\nProductName: " + sh_itemName + "\nQuantity: " + sh_quantity + "\nPrice: $" + sh_productPrice
				+ "\nWeight: " + sh_ProductWeight + "KG"  + "\nDiscount: "
				+ sh_discount + "% \nBulkDiscount: " + sh_bulkDiscount +  "% \nPriceWeight: $" + sh_PriceWeight +  "per/kg" + "\nTotalPrice: $" + String.valueOf(CaculateTotalPrice()) + " \n";
	}

	public double CaculateTotalPrice(){
		if (sh_discount == 0) {
			sh_totalPrice = sh_productPrice* sh_quantity;
			System.out.println(sh_totalPrice);
			return sh_totalPrice;
		
		} else {
			sh_totalPrice = sh_quantity * sh_quantity * sh_discount;
			return sh_totalPrice;
		}
		
	}
	/*
	 * ArrayList <ShoppingCart> cartList; public addList(){ cartList = new
	 * ArrayList <ShoppingCart>(); cartList.add(sh); // return cartList;
	 */
}
