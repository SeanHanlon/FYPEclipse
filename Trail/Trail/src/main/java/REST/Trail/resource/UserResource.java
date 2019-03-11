package REST.Trail.resource;

import java.util.List;
import java.util.Map;

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

import REST.Trail.model.User;
import REST.Trail.service.UserService;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	UserService userService = new UserService();
	
	@GET
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@POST
	public void addUser(User user) 
	{
		/*
		 * System.out.println(name+email+password); User user = new User(name, email,
		 * password);
		 */
		userService.addUser(user);
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
