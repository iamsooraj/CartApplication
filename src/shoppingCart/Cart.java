package shoppingCart;

public class Cart extends User implements Product {
	private int cart_id;
	private String cartUsername;
	private String cartProductId;
	private int quantity;
	
	public Cart() {}
	
	public int getCartId()
	{
		return cart_id;
	}
	public void putCartID(int cart_id) {
		this.cart_id=cart_id;
	}
	
	public String getCartUsername()
	{
		return cartUsername;
	}
	public void putUser_Name(String cartUsername)
	{
		this.cartUsername=cartUsername;
	}
	public String getCartProductId() {
		return cartProductId;
	}
	public void putProd_Id(String cartProductId) {
		this.cartProductId = cartProductId;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void putQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	
	
	@Override
	public String getProductID() {
		
		return product_id;
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return product_name;
	}

	@Override
	public void setProductId(String product_id) {}
	@Override
	public void setProductName(String product_name) {}

}
