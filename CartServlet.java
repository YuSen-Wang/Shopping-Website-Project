package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Cart> items; 
	double total;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  try {	
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// route to the appropriate method
			switch (theCommand) {
			
		    case "ADD": 
		    	addCart(request, response);
		    	break;
			
		     case "DELETE": 
		    	removeCart(request, response);
		    	break;
		    	
		     case "VIEW": 
			    	viewCart(request, response);
			    	break;
			}

			}
			catch (Exception exc) {
				throw new ServletException(exc);
			}
			
	}

	
	private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		
		   for(Cart temp: items){
			   total += temp.getPrice();
		   }
		   
		
			request.setAttribute("item_list", items);
			
			request.setAttribute("total_price", total);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("view_cart.jsp");
			
		  	dispatcher.forward(request, response);	
		
	}


	private void removeCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		String theCartName = request.getParameter("cartId");
		
			
			for(int i = (items.size() - 1); i >= 0; i--){
				
				if(items.get(i).getName().equals(theCartName)){
					items.remove(items.get(i));
					 
				}
			} 
			   total=0;
			   for(Cart temp:items){
				   total += temp.getPrice();
				}
		
		request.setAttribute("item_list", items);
		request.setAttribute("total_price", total);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_cart.jsp");
		
	  	dispatcher.forward(request, response);	
		
	}


	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cart> Carts = CartDataUtil.getCarts();
		HttpSession session = request.getSession(true);
		double total = 0;
		
		// get the TO DO items from the session
			 items = (List<Cart>) session.getAttribute("theItems");
			// if the TO DO items doesn't exist, then create a new one
			if (items == null) {
				items = new ArrayList<Cart>();
				session.setAttribute("theItems", items);
			}
			// see if there is form data to add
		
			String addeditems[]  = request.getParameterValues("Books");
			
			for(Cart tempCart: Carts ){	
				
				for(String tempItems: addeditems){
			    if (tempCart.getName().equals(tempItems)) {
				    items.add(tempCart);
			    } 
		      }
			}
			
		    
			
			request.setAttribute("item_list", addeditems);
			
			
			// Step 1: set the content type
			response.setContentType("text/html");
			
			// Step 2: get the printwriter 
			
			PrintWriter out = response.getWriter();
			out.println("The following items has been added to your shopping cart successfully" + "<br>");
			for(Cart temp: items){
		 		out.println("-" + temp.getName() + "	$"+ temp.getPrice() + "<br>");
		 		total += temp.getPrice(); 
		 	}
			out.println("TOTAL:		" + "      $"+ total);
			request.setAttribute("total_price", total);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			
		  	dispatcher.forward(request, response);		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
