package shoppingCart;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		User newUser = new User();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /*report an error*/ }


		String jsonString=jb.toString();
		ObjectMapper mapper = new ObjectMapper();
		try{
			User dbUser = new User(); 
			newUser = mapper.readValue(jsonString, User.class);

			HashMap<String, String> fromDB = new HashMap<>();
			String user,username;
			String pass,password;

			username = newUser.getUsername(); //from JSON
			password = newUser.getPassword(); //from JSON
			fromDB= dbUser.getUser(username);
			user = fromDB.get("username");  //from DB
			pass = fromDB.get("password");  //from DB


			String res;  
			if(username.equals(user) && password.equals(pass))
			{
				//response.set("Login Successful");
				res="{\"status\" : \"Welcome "+fromDB.get("name")+"\"}";
			}
			else
			{
				//response.set("Invalid Credentials");
				res = "{\"status\" : \"Invalid Credentials\"}";
			}
			response.getWriter().append(res);

		}
		catch (JsonParseException e) { e.printStackTrace();}
		catch (JsonMappingException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
