package shoppingCart;

public class User extends UserDBO {
	private int id;
	private String name;
	private String username;
	private String password;
	
	public User() {}
	
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}

}
