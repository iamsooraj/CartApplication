package shoppingCart;

public interface Product {
	public String product_id=null;
	public String product_name=null;
	
	public String getProductID();
	public String getProductName();
	public void setProductId(String product_id);
	public void setProductName(String product_name);
}
