package MarketSysGUI;

public class Payment{
	private String py_customerID;
	private String py_PaymentID;
	
	private double py_currentPoints;
	private double py_pointEarned;
	// $10 = 1 point, 20 point = $5 discount
	
	// get from product
	private Product sh_product; //*
	private String sh_ProductID; //*
	// get from customer
	private Customer sh_Customer;
	private String sh_CustomerID;
	//get from shoppingCart
	private int py_Quantity;
	private double py_totalAmount;
	private double py_ProductPrice;
	private double py_calcAmount;
	private ShoppingCart py_ShoppingCart;
	
	
	public Payment(){
	
	}
	
	
	
	public Payment(String py_PaymentID, ShoppingCart s){
		py_ShoppingCart = s;
		this.py_PaymentID = py_PaymentID;
		
		py_Quantity = s.getQuantity();
		py_totalAmount = getTotalAmount(s.CaculateTotalPrice());
		py_pointEarned = caculatePoint(py_totalAmount);
		// this.py_totalAmount = py_totalAmount;
		
	}
	
	public int getQuantity(){
		return py_Quantity;
	}
	
	public double getTotal(){
		return py_totalAmount;
	}
	
	public double caculatePoint(double p_totalAmount){
		py_pointEarned = py_totalAmount/10;
		return py_pointEarned;
	}
	public double getAmount(ShoppingCart sh){
		py_totalAmount = sh.CaculateTotalPrice();
		return py_totalAmount;
	}
	/*
	public String toString(){
		
		System.out.printf("CustomerId: %s \tTotalAmount: $ %4.2f \tCurrentPoint: %4.2f \tPointEarned: %4.2f", 
				py_customerID, py_totalAmount, py_currentPoints, py_pointEarned);
	} */
	
	public String toString() {
		return "\nPayment ID: " + py_PaymentID+
				"\nTotal Amount: " + py_totalAmount +
				"\nPoints Earned: " + py_pointEarned;
	}
	
	public double getTotalAmount(double totalAmount){
		
		py_totalAmount = totalAmount;
		return py_totalAmount;
	}
	public double getCurrentPoint(double currentPoint){
		py_currentPoints = currentPoint;
		return py_currentPoints;
	}
	public String getCustomerID(String customer){
		py_customerID = customer;
		return py_customerID;
	}
	public double getEarnePoing(double point){
		py_pointEarned = point;
		return py_pointEarned;
	}
	// public String get
}
