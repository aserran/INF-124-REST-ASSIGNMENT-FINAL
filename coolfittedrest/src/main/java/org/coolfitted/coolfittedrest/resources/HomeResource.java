package org.coolfitted.coolfittedrest.resources;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.coolfitted.coolfittedrest.model.Hat;
import org.coolfitted.coolfittedrest.service.HatService;

@Path("/home")
public class HomeResource {

	HatService hatService = new HatService();
	public HomeResource(){
		
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getHats(){
		//return hatService.getAllHats();
		List<Hat> hatlist = HatService.getAllHats();
		return Response.ok(hatlist).build();
	}
	
	
}
