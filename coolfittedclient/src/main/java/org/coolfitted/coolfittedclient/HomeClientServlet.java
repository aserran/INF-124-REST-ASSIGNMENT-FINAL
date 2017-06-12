package org.coolfitted.coolfittedclient;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

public class HomeClientServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		System.out.println(target);
		
		String jsonResponse = 
				target.path("webapi").path("home").request().
				accept(MediaType.APPLICATION_JSON).
				get(String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Hat> hatlist = objectMapper.readValue(jsonResponse, new TypeReference<List<Hat>>(){});
		// session stuff
		request.setAttribute("hatlist", hatlist);
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static URI getBaseURI(){
		return UriBuilder.fromUri("http://localhost:8080/coolfittedrest").build();
	}
	
}
