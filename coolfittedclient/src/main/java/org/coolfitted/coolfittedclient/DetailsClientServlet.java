package org.coolfitted.coolfittedclient;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.ClientConfig;
import org.coolfitted.coolfittedclient.Hat;

public class DetailsClientServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// view history stuff
		Queue queue;
		String t = request.getParameter("param");
		HttpSession session = request.getSession(true);
		if (session.isNew()){
            queue = new LinkedList();
            queue.add(t);
            session.setAttribute("hatqueue", queue);
        }
        else{
            queue = (LinkedList)session.getAttribute("hatqueue");
            if (queue == null){// || queue.size() == 5){
                //queue.remove();
                queue = new LinkedList();
                queue.add(t);
                session.setAttribute("hatqueue",queue);
            }
            else if (queue.size() == 5){
                if(!queue.contains(t)){
                    queue.remove();
                    queue.add(t);
                    session.setAttribute("hatqueue", queue);
                }
            }else{
                if(!queue.contains(t)){
                   queue.add(t); 
                }
                session.setAttribute("hatqueue",queue);
            }
        }
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		System.out.println(target);
		
		String jsonResponse = 
				target.path("coolfittedrest").path("webapi").path("details").path(request.getParameter("param")).request().
				accept(MediaType.APPLICATION_JSON).
				get(String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Hat> hatlist = objectMapper.readValue(jsonResponse, new TypeReference<List<Hat>>(){});
		// session stuff
		request.setAttribute("hatlist", hatlist);
		try {
			request.getRequestDispatcher("/details.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static URI getBaseURI(){
		return UriBuilder.fromUri("http://localhost").port(8080).build();
	}
	
}
