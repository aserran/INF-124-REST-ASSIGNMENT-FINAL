package org.coolfitted.coolfittedrest.resources;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.coolfitted.coolfittedrest.model.Hat;
import org.coolfitted.coolfittedrest.service.HatService;
import org.glassfish.jersey.server.mvc.Viewable;
import org.coolfitted.coolfittedrest.database.DatabaseAccess;
// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

@Path("/conf")
public class Confirmation {
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String FAILURE_RESULT="<result>failure</result>";
	public Confirmation(){		
		}
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Response generatePOSTresponse(MultivaluedMap<String, String> formParams) {
	  String output = DatabaseAccess.insertOrder(formParams);
      return Response.status(200).entity(output).build();
  }
  @Path("/orders/{orderid}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteOrder(@PathParam("orderid") int orderid){
     boolean result = DatabaseAccess.deleteOrder(orderid);
     if(result == true){
        return SUCCESS_RESULT;
     }
     return FAILURE_RESULT;
  }
}