package org.coolfitted.coolfittedrest;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.coolfitted.coolfittedrest.model.Hat;
import org.coolfitted.coolfittedrest.service.HatService;
import org.glassfish.jersey.server.mvc.Viewable;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/details/{param}")
public class details {
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Response sayHtmlResponse(@PathParam("param") String item) {
      Map<String, Object> map = new HashMap<String, Object>();
      List<Hat> hatlist = HatService.getHatByName(item);
		return Response.ok(hatlist).build();
  }
}