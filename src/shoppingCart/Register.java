package shoppingCart;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		// TODO Auto-generated method stub

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

			String name;
			String username;
			String password;
			name = newUser.getName();
			username = newUser.getUsername(); //from JSON
			password = newUser.getPassword(); //from JSON
			Exception e;
			e = dbUser.addUser(name, username, password);
			String res;
			if(e == null)
			{
				res = "{\"status\" : \"Successful\"}";  
			}
			else
			{
				res = e.toString();
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
