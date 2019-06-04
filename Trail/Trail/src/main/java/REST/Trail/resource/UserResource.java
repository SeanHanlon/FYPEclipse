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
public class UserResource {

	UserService userService = new UserService();
	TrailService trailService = new TrailService();
	
	@GET
	@Path("/getUsers")
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
	@Produces(MediaType.TEXT_PLAIN)
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
			request.getSession().setAttribute("trails", user.getTrails());
			request.setAttribute("trails", user.getTrails());
			//System.out.println(request.getSession().getAttribute("name")+" is logged in");
			String name = (String) request.getSession().getAttribute("name");
			//System.out.println(name);
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
	
	/*@GET
	@Path("/getFavs")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Trail> getFavs() {
		List<Trail> trails = new ArrayList<>();
		User user = (User) request.getSession().getAttribute("user");
		//User user = PersistenceUtil.findUserByEmail("sean@gmail.com");
		//request.getSession().setAttribute("user", user);
		//User user = (User) request.getSession().getAttribute("user");
		System.out.println("TheUser" + user.getName()+ " is logged in");
		System.out.println(user.getTrails().get(0).getName());
		
		for(int i = 0;i< user.getTrails().size(); i++) 
		{
			trails.add(user.get)
		}
		//System.out.println(user.getName());
		//Set<Trail> trails = (Set<Trail>) request.getSession().getAttribute("trails");
		
		trails.addAll(user.getTrails());
		System.out.println(trails.get(0).getName());
		//trails = (List<Trail>) request.getAttribute("trails");
		return trails;
	}*/
	
	@GET
	@Path("/getFavs")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Trail> getFavs() {
		List<Trail> trails = new ArrayList<>();
		User user = (User) request.getSession().getAttribute("user");
		//User user = PersistenceUtil.findUserByEmail("sean@gmail.com");
		//request.getSession().setAttribute("user", user);
		//User user = (User) request.getSession().getAttribute("user");
		System.out.println("TheUser" + user.getName()+ " is logged in");
		System.out.println(user.getTrails().get(0).getName());
		
		/*for(int i = 0;i< user.getTrails().size(); i++) 
		{
			trails.add(user.get)
		}*/
		//System.out.println(user.getName());
		//Set<Trail> trails = (Set<Trail>) request.getSession().getAttribute("trails");
		
		trails.addAll(user.getTrails());
		System.out.println(trails.get(0).getName());
		//trails = (List<Trail>) request.getAttribute("trails");
		return trails;
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addFav")
	public void addFav(@FormParam(value = "id") long id) {
		
		User user = (User) request.getSession().getAttribute("user");
		//long theId = id;
		System.out.println(user.getName());
		
		//Set<Trail> trails = null;
		
		Trail trail = trailService.getTrailById(id);
		user.addFav(trail);
		
		//trails.add(trail);
		//user.setTrails(trails);
		//user.getTrails().add(trail);
		//System.out.println(user.getTrails());
		//user.getTrails().add(trail);
		//user.addFav(trail);
		//user.addFav(trail);
		//trail.getUsers().add(user);
		/*trail.getUsers().add(user);
		
		PersistenceUtil.merge(user);
		PersistenceUtil.merge(trail);*/
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
