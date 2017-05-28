package MarketSysGUI;

public class Warehouse {
	private int wh_stockLevel;
	private int wh_stockThresholdLevel;	
	private String wh_productID;
	private int wh_MaxStockLevel;
	private int wh_stockSold;
	
	
	
	/*empty constructor*/
	public Warehouse(){
		
	}
	
	/*constructor*/
	public Warehouse(Product p ,int wh_stockLevel, int wh_stockThresholdLevel, int wh_MaxStockLevel) {
		wh_productID = p.getProductID();
		this.wh_stockLevel = wh_stockLevel;
		// wh_stockSold = calcStockSold();
		this.wh_stockThresholdLevel = wh_stockThresholdLevel;
		this.wh_MaxStockLevel = wh_MaxStockLevel;
	}
	
	public int getStockSold(){
		return calcStockSold();
	}
	
	public String getProductID(){
		return wh_productID;
	}
	
	public int calcStockSold(){
		
		wh_stockSold = wh_MaxStockLevel - wh_stockLevel;
		return wh_stockSold;
	}
	
	/*calculate the stock level after every transaction*/
	public int qtyAfter(Payment py){
		wh_stockLevel -= py.getQuantity();
		return wh_stockLevel;
	}
	
	public String toString() {
		return "\nProduct ID: " + wh_productID +
				"\nStock Level: " + wh_stockLevel +
				"\nRestock level: " + wh_stockThresholdLevel;
	}
	
	/*update stock level by warehouse staff*/	
	public void updateStockLevel(int a){
		wh_stockLevel += a;
		//return wh_stockLevel;
}
	

	
	
	/*check the stock level*/
	public boolean overThresholdLevel(){
		if(wh_stockLevel < wh_stockThresholdLevel){
			System.out.println("Warning! Product" + wh_productID + "has lower stock level");
			return false;
		}
		else{
			return true;
		}
	}
	
	
	
	/*Automatically reorder*/
	public void reorder()
	{
		if(this.overThresholdLevel()){
			
		}else{
			System.out.println("Stock Level is low, Making an order to purchasing");
			
			
		}
		
	}

	public int getWh_stockLevel() {
		return wh_stockLevel;
	}

	public void setWh_stockLevel(int wh_stockLevel) {
		this.wh_stockLevel = wh_stockLevel;
	}

	public int getWh_stockThresholdLevel() {
		return wh_stockThresholdLevel;
	}

	public void setWh_stockThresholdLevel(int wh_stockThresholdLevel) {
		this.wh_stockThresholdLevel = wh_stockThresholdLevel;
	}

	
	
}
