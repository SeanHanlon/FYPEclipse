package REST.Trail.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import REST.Trail.*;
import REST.Trail.model.Trail;
import REST.Trail.model.User;
  
public class PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trailapp");
	
	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();		
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}
	
	public static List<User> findAllUsers(){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findAll").getResultList();
		em.close();
		return users;
	}

	public static User findUserByName(String name){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findByName").setParameter("name", name).getResultList();
		em.close();
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}
	
	public static User findUserByEmail(String email){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findByEmail").setParameter("email", email).getResultList();
		em.close();
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}
	
	public static List<Trail> getAllTrails(){
		EntityManager em = emf.createEntityManager();
		List<Trail> trails = (List<Trail>) em.createNamedQuery("Trail.getAll").getResultList();
		em.close();
		return trails;
	}
	
	public static List<Trail> searchTrail(String searchParam) {
		EntityManager em = emf.createEntityManager();
		List<Trail> trails = (List<Trail>) em.createNamedQuery("Trail.nameSearch").setParameter("name", searchParam).getResultList();
		em.close();
		if (trails.size() == 0)
			return null;
		else 
			return trails;
	}
	/*
	public static User findUserByName(String name){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findByName").setParameter("name", name).getResultList();
		em.close();
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}*/
}

