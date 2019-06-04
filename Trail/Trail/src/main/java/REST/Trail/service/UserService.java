package REST.Trail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import REST.Trail.*;
import REST.Trail.model.User;
import REST.Trail.model.Trail;
import REST.Trail.persistence.PersistenceUtil;


public class UserService {
	
	//private Set<Trail> trails;
	List<Trail> trails = null;

	public UserService() {

	}
	
	public List<User> getAllUsers() {
		List<User> users = PersistenceUtil.findAllUsers();
		return users;
	}
	
	public void addUser(User user) {
		PersistenceUtil.persist(user);
	}
	
	public User loginUser(String email, String password) {
		User user = PersistenceUtil.findUserByEmail(email);

		if (user != null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
			return user;
		}
		return null;
	}
	
	public List<Trail> getUserFavs(User user) {
		//trails = null;
		//trails = PersistenceUtil.getFavs(user);
		//Set<Trail> trails = null;
		trails.addAll(user.getTrails());
		return trails;
		
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
