package REST.Trail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import REST.Trail.model.Friend;
import REST.Trail.model.User;


public class FriendService {

//private Map<Long, User> users = Database.getUsers();
	
	/*public List<Friend> getAllFriends(long userId) {
		Map<Long, Friend> friends = users.get(userId).getFriends();
		return new ArrayList<Friend>(friends.values());
	}
	
	public Friend getFriend(long userId, long friendId) {
		Map<Long, Friend> friends = users.get(userId).getFriends();
		return friends.get(friendId);
	}
	
	public Friend addFriend(long userId, Friend friend) {
		Map<Long, Friend> friends = users.get(userId).getFriends();
		friend.setId(friends.size() +1);
		friends.put(friend.getId(), friend);
		return friend;
	}
	
	public Friend updateFriend(long userId, Friend friend) {
		Map<Long, Friend> friends = users.get(userId).getFriends();
		if (friend.getId() <= 0) {
			return null;
		}
		friends.put(friend.getId(), friend);
		return friend;
	}
	
	public Friend removeFriend(long userId, long friendId) {
		Map<Long, Friend> friends = users.get(userId).getFriends();
		return friends.remove(friendId);
	}*/
}
