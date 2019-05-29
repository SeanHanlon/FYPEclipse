package REST.Trail.resource;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import REST.Trail.model.Trail;
import REST.Trail.model.User;
import REST.Trail.service.UserService;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;



import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.Uri;



@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addUser")
	public void addUser(@FormParam(value = "name") String name, @FormParam(value = "email") String email,
			@FormParam(value = "password") String pass) {
		User user = new User(name, email, pass);
		userService.addUser(user);
	}
	
	@Context
	private HttpServletRequest request;
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/login")
	public void login(@FormParam(value = "email") String email, @FormParam(value = "password") String password) {
		User user = userService.loginUser(email, password);
		
		if (user == null)
		{
			System.out.println("cannot find user");
		}
		else
		{
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("name", user.getId());
			System.out.println(request.getSession().getAttribute("name")+" is logged in");
		}
	}
	
	@POST
	@Path("/logout")
	public void logout() {
		request.getSession().setAttribute("user", null);
	}
	
	@GET
	@Path("/getFavs")
	public List<Trail> getFavs() {
		User user = (User) request.getSession().getAttribute("user");
		//List<Trail> trails = user.getFavourites().getTrails();
		return null;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addFav")
	public void addFav(@FormParam(value = "name") String name) {
		
	}
	
	/*@PUT
	@Path("/{userId}")
	public User updateUser(@PathParam("userId") long id, User user) {
		user.setId(id);
		return userService.updateUser(user);
	}
	
	@DELETE
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") long id) {
		userService.removeUser(id);
	}
	
	@GET
	@Path("/{userId}")
	public User getUser(@PathParam("userId") long id) {
		return userService.getUser(id);
	}
	
	
	@Path("{userId}/friends")
	public FriendResource getFriendResource() {
		return new FriendResource();
	}*/
	
}
