package REST.Trail.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
	/*
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
