package shoppingCart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
		Cart newCart = new Cart();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /*report an error*/ }


		String jsonString=jb.toString();
		ObjectMapper mapper = new ObjectMapper();
		try{
			
			newCart = mapper.readValue(jsonString, Cart.class);

			String cartUsername;
			String cartProductId;
			int quantity;
			cartUsername = newCart.getCartUsername(); //from JSON
			cartProductId = newCart.getCartProductId();
			quantity = newCart.getQuantity();
			if(quantity == 0)
			{
				//first time adding to cart
				System.out.println("Added to cart Successfully "+cartProductId+cartUsername+"");
			}
			else
			{
				//updating the quantity value
				System.out.println("Updated to cart Successfully");
			}
			
			JSONObject jsonObj1 = new JSONObject();
			jsonObj1.put("username", cartUsername);
			jsonObj1.put("product", cartProductId);
			jsonObj1.put("quantity", quantity);
			
			
			JSONArray jsonArray = new JSONArray();
			jsonArray.add(jsonObj1);
			
			PrintWriter out = response.getWriter();
			out.print(jsonArray);
			out.flush();

			//String res;  
			
		//	response.getWriter().append(res);

		}
		catch (JsonParseException e) { e.printStackTrace();}
		catch (JsonMappingException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
