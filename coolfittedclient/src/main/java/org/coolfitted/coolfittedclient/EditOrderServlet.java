package org.coolfitted.coolfittedclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Servlet implementation class EditOrderServlet
 */
public class EditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpClient client = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut("http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/edit");
        HttpSession session = request.getSession();

        // Create some NameValuePair for HttpPost parameters
        List<NameValuePair> arguments = new ArrayList<NameValuePair>();
        arguments.add(new BasicNameValuePair("fname", request.getParameter("fname")));
        arguments.add(new BasicNameValuePair("lname", request.getParameter("lname")));
        arguments.add(new BasicNameValuePair("phone", request.getParameter("phone")));
        arguments.add(new BasicNameValuePair("email", request.getParameter("email")));
        arguments.add(new BasicNameValuePair("street", request.getParameter("street")));
        arguments.add(new BasicNameValuePair("city", request.getParameter("city")));
        arguments.add(new BasicNameValuePair("state", request.getParameter("state")));
        arguments.add(new BasicNameValuePair("zip", request.getParameter("zip")));
        //arguments.add(new BasicNameValuePair("owner", request.getParameter("owner")));
        //arguments.add(new BasicNameValuePair("card", request.getParameter("card")));
        //arguments.add(new BasicNameValuePair("cvv", request.getParameter("cvv")));
        //arguments.add(new BasicNameValuePair("date", request.getParameter("expMonth")+request.getParameter("expYear")));
        //arguments.add(new BasicNameValuePair("total", request.getParameter("total")));
        //arguments.add(new BasicNameValuePair("quant", request.getParameter("quant")));
        
        try {
            put.setEntity(new UrlEncodedFormEntity(arguments));
            HttpResponse putresponse = client.execute(put);
            // Print out the response message
            String resp = EntityUtils.toString(putresponse.getEntity());
            if(resp!=""){
            	/*
            	request.setAttribute("orderid", resp);
	            request.setAttribute("name", arguments.get(0).getValue()+" "+arguments.get(1).getValue());
	            request.setAttribute("address", arguments.get(4).getValue()+" "+arguments.get(5).getValue()+", "+arguments.get(6).getValue()+" "+arguments.get(7).getValue());
	            request.setAttribute("total", arguments.get(12).getValue());
	            request.setAttribute("email", arguments.get(3).getValue());
	            request.setAttribute("last", arguments.get(9).getValue().substring(arguments.get(9).getValue().length() - 4));
	            session.invalidate();
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmation.jsp");
	            rd.forward(request, response);
	            */
            	request.setAttribute("status", resp);
            	RequestDispatcher rd = getServletContext().getRequestDispatcher("/editconfirmation.jsp");
            	rd.forward(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
