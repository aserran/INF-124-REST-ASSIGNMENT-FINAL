package org.coolfitted.coolfittedclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class ConfClientServlet
 */
public class ConfClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://andromeda-40.ics.uci.edu:5540/coolfittedrest/webapi/conf");
        HttpSession session = request.getSession(false);

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
        arguments.add(new BasicNameValuePair("owner", request.getParameter("owner")));
        arguments.add(new BasicNameValuePair("card", request.getParameter("card")));
        arguments.add(new BasicNameValuePair("cvv", request.getParameter("cvv")));
        arguments.add(new BasicNameValuePair("date", request.getParameter("expMonth")+request.getParameter("expYear")));
        arguments.add(new BasicNameValuePair("total", request.getParameter("total")));
        arguments.add(new BasicNameValuePair("quant", request.getParameter("quant")));
        
        try {
            post.setEntity(new UrlEncodedFormEntity(arguments));
            HttpResponse postresponse = client.execute(post);
            // Print out the response message
            String resp = EntityUtils.toString(postresponse.getEntity());
            if(resp!=""){
            	request.setAttribute("orderid", resp);
	            request.setAttribute("name", arguments.get(0).getValue()+" "+arguments.get(1).getValue());
	            request.setAttribute("address", arguments.get(4).getValue()+" "+arguments.get(5).getValue()+", "+arguments.get(6).getValue()+" "+arguments.get(7).getValue());
	            request.setAttribute("total", arguments.get(12).getValue());
	            request.setAttribute("email", arguments.get(3).getValue());
	            request.setAttribute("last", arguments.get(9).getValue().substring(arguments.get(9).getValue().length() - 4));
	            session.invalidate();
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmation.jsp");
	            rd.forward(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		String callResult = target
				  .path("coolfittedrest")
				  .path("webapi")
				  .path("conf")
				  .path("orders")
				  .path(request.getParameter("orderid"))
    	         .request(MediaType.APPLICATION_JSON)
    	         .delete(String.class);
		if("<result>success</result>".equals(callResult)){
			session.invalidate();
			response.sendRedirect("/coolfittedclient/home");
		}else{
			request.setAttribute("deleted", "Order could not be deleted. Please contact Support for more details");
			RequestDispatcher rd = request.getRequestDispatcher("/confirmation.jsp");
			try {
				rd.include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static URI getBaseURI(){
		return UriBuilder.fromUri("http://andromeda-40.ics.uci.edu").port(5540).build();
	}

}
