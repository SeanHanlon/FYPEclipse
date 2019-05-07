package REST.Trail.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.Trail.model.Trail;
import REST.Trail.model.User;
import REST.Trail.service.TrailService;
import REST.Trail.service.UserService;


@Path("/trails")
public class TrailResource {
	
	TrailService trailService = new TrailService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trail> getTrails() {
		return trailService.getAllTrails();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/nameSearch")
	public List<Trail> nameSearch(@FormParam(value = "userSearch") String userSearch) {
		List<Trail> trails = trailService.searchTrail(userSearch);
		return trails;
		
	}
	
	/*
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/searchByCategory")
	public List<Item> searchCategory(@FormParam(value = "searchCat") String category) {
		List<Item> items = itemService.getItemByCategory(category);
		if(items != null)
		{
			return items;
		}
		else
		{
			return null;
		}
		
	}
	
	@POST
	public Trail addTrail(Trail trail) {
		return trailService.addTrail(trail); 
	}
	
	@PUT
	@Path("/{trailId}")
	public Trail updateTrail(@PathParam("trailId") long id, Trail trail) {
		trail.setId(id);
		return trailService.updateTrail(trail);
	}
	
	@DELETE
	@Path("/{trailId}")
	public void deleteTrail(@PathParam("trailId") long id) {
		trailService.removeTrail(id);
	}
	
	@GET
	@Path("/{trailId}")
	public Trail getTrail(@PathParam("trailId") long id) {
		return trailService.getTrail(id);
	}*/

}
