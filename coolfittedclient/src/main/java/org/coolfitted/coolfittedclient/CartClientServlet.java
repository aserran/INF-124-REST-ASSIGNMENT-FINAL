package org.coolfitted.coolfittedclient;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class CartClientServlet
 */
public class CartClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<String> ordertemp = (ArrayList)session.getAttribute("orders");
        if(ordertemp == null){
            ordertemp = new ArrayList();
        }
        String model = request.getParameter("model");
        String quant = request.getParameter("quant");
        String price = request.getParameter("price");
        ordertemp.add(model+"_"+quant+"_"+price);
        price = price.substring(1);
        double tot;
        Object nulltemp = session.getAttribute("total");
        if(nulltemp==null){
            tot = 0.0;
        }else{
            tot = (double)session.getAttribute("total");
        }
        System.out.println(tot+"HEEER");

        request.setAttribute("tot", tot);
        int q = Integer.parseInt(quant);
        //double total = (Double.parseDouble(price.substring(1))*Integer.parseInt(quant))+(double)session.getAttribute("total");
        double total = (Double.parseDouble(price))*q+tot;
        total = (double) Math.round(total * 100) / 100;
        Float.parseFloat(price.substring(1));
        session.setAttribute("total", total);
        session.setAttribute("orders",ordertemp);
        if(session.getAttribute("quant")==null){
        	session.setAttribute("quant",q);
        }
        else{
        	session.setAttribute("quant", Integer.toString(Integer.parseInt(session.getAttribute("quant").toString())+q));
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart.jsp");
        rd.forward(request, response);
    }

}
