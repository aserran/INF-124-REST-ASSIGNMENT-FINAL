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
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.mvc.Viewable;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/{parameter: details|cart}")
public class details {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "here";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Path("/hat")
  @Produces(MediaType.TEXT_HTML)
  public Response sayHtmlResponse(@QueryParam("name") String item, @Context HttpServletRequest request) {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("title", "usul");
      List<String> l = new ArrayList<String>();
      l.add("light saber");
      l.add("fremen clothes");
      return Response.ok(new Viewable("/inf124pa4client/details", map)).build();
  }
}