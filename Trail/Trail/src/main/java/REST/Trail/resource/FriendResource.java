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

import REST.Trail.model.Friend;
import REST.Trail.service.FriendService;


@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FriendResource {
	
private FriendService friendService = new FriendService();
	
	/*@GET
	public List<Friend> getAllFriends(@PathParam("userId") long userId) {
		return friendService.getAllFriends(userId);
	}
	
	@POST
	public Friend addFriend(@PathParam("userId") long userId, Friend friend) {
		return friendService.addFriend(userId, friend);
	}
	
	@PUT
	@Path("/{friendId}")
	public Friend updateFriend(@PathParam("userId") long userId, @PathParam("friendId") long id, Friend friend) {
		friend.setId(id);
		return friendService.updateFriend(userId, friend);
	}
	
	@DELETE
	@Path("/{friendId}")
	public void deleteFriend(@PathParam("userId") long userId, @PathParam("friendId") long friendId) {
		friendService.removeFriend(userId, friendId);
	}

	@GET
	@Path("/{friendId}")
	public Friend getFriend(@PathParam("userId") long userId, @PathParam("friendId") long friendId) {
		return friendService.getFriend(userId, friendId);
	}*/

}
