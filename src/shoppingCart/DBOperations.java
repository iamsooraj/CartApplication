package shoppingCart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class DBOperations {
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/ecommerce";
			String user = "trudy";
			String password = "password";

			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("Connected");

			return conn;
		}catch(Exception e) { System.out.println(e);}
		return null;
	}

	//Add a new user
	public Exception addUser(String name, String username, String password) throws Exception{

		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("INSERT INTO user(name,username,password) VALUES ('"+name+"', '"+username+"', '"+password+"')");
			insert.executeUpdate();
			System.out.println("Inserted Successfully");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e;
		}

	}

	//Get User details

	public HashMap<String,String> getUser(String username) throws Exception
	{
		Connection con = getConnection();
		Statement statement = con.createStatement();
		String query= "select * from user where username='"+username+"'";
		ResultSet db = statement.executeQuery(query);
		db.next();
		HashMap<String, String> result = new HashMap<>();

		//	result.put("id",db.getString("id"));
		result.put("name",db.getString("name"));
		result.put("username",db.getString("username"));
		result.put("password",db.getString("password"));

		return result;
	}
	
	
	
	
}
