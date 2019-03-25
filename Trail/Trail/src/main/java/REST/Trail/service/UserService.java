package REST.Trail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import REST.Trail.*;
import REST.Trail.model.User;
import REST.Trail.persistence.PersistenceUtil;


public class UserService {

	//private Map<Long, User> users = Database.getUsers();
	
	public UserService() {
		/*users.put(1L, new User(1, "Sean", "Sean@gmail.com", "123"));
		users.put(2L, new User(2, "Jordan", "Jordan@gmail.com", "123"));*/ 
	}
	
	public List<User> getAllUsers() {
		//return new ArrayList<User>(users.values());
		List<User> users = PersistenceUtil.findAllUsers();
		return users;
	}
	
	public void addUser(User user) {
		//List<User> users = PersistenceUtil.findAllUsers();
		//user.setId(users.size() + 1);
		//users.put(user.getId(), user);
		PersistenceUtil.persist(user);
		//return user;
	}
	
	public User loginUser(String email, String password) {
		User user = PersistenceUtil.findUserByEmail(email);

		if (user != null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
			return user;
		}
		return null;
	}
	
	/*public User getUser(long id) {
		return users.get(id);
	}
	
	
	
	public User updateUser(User user) {
		if (user.getId() <= 0) {
			return null;
		}
		users.put(user.getId(), user);
		return user;
	}
	
	public User removeUser(long id) {
		return users.remove(id);
	}*/
}
