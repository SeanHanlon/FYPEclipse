package REST.Trail.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import REST.Trail.persistence.PersistenceUtil;
import REST.Trail.service.TrailService;
import REST.Trail.service.UserService;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;



import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.Uri;



@Path("/users")
/*@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)*/
public class UserResource {

	UserService userService = new UserService();
	TrailService trailService = new TrailService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@Context
	private HttpServletRequest request;
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addUser")
	public void addUser(@FormParam(value = "name") String name, @FormParam(value = "email") String email,
			@FormParam(value = "password") String pass) {
		User user = new User(name, email, pass);
		userService.addUser(user);
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("name", user.getName());
		System.out.println(request.getSession().getAttribute("name")+" is logged in");
		//String name = (String) request.getSession().getAttribute("name");
	}
	
	/*@Context
	private HttpServletRequest request;*/
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/login")
	public String login(@FormParam(value = "email") String email, @FormParam(value = "password") String password) {
		User user = userService.loginUser(email, password);
		
		if (user == null)
		{
			System.out.println("cannot find user");
			return null;
		}
		else
		{
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("name", user.getName());
			request.getSession().setAttribute("id", user.getId());
			System.out.println(request.getSession().getAttribute("name")+" is logged in");
			String name = (String) request.getSession().getAttribute("name");
			System.out.println(name);
			return name;
		}
		
		/*int sNum = Integer.parseInt(request.getParameter("sNum"));
		int dNum = Integer.parseInt(request.getParameter("dNum"));
		int cNum = Integer.parseInt(request.getParameter("cNum"));

		request.getSession().setAttribute("sNum", sNum);
		request.getSession().setAttribute("dNum", dNum);
		request.getSession().setAttribute("cNum", cNum);

		request.getRequestDispatcher("page_two.jsp").forward(request, response);*/
	}
	
	@POST
	@Path("/logout")
	public void logout() {
		request.getSession().setAttribute("user", null);
	}
	
	@GET
	@Path("/getFavs")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Trail> getFavs() {
		
		User user = PersistenceUtil.findUserByName("Sean");
		return user.getTrails();
		
		/*HttpSession sess = request.getSession(false);
		if (sess != null) {
		   // it's valid
			User user = (User) request.getSession().getAttribute("user");
			return user.getTrails();
		}
		else {
			return null;
		}*/
		
		/*String name = (String) request.getSession().getAttribute("name");
		
		if(name == null) {
			return null;
		}
		else {
			User user = PersistenceUtil.findUserByName(name);
			
			return user.getTrails();
		}*/
		
		
		/*String name = (String) request.getSession().getAttribute("name");
		
		User user = PersistenceUtil.findUserByName(name);
		
		return user.getTrails();*/
		
		/*if(request.getSession().getAttribute("user") == null) {
			return null;
		}
		else {
			System.out.println(user.getName());
			
			
			return user.getTrails();
		}*/
		
		
		
		
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addFav")
	public void addFav(@FormParam(value = "id") long id) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		Set<Trail> trails = new HashSet<Trail>();
		
		System.out.println(user.getName());
		
		Trail trail = trailService.getTrailById(id);
		trails.add(trail);
		
		//user.getTrails().add(trail);
		//user.setTrails(trails);
		user.setTrails(trails);
		
		PersistenceUtil.merge(user);
		
		
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
