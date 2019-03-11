package REST.Trail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import REST.Trail.model.Trail;
import REST.Trail.model.User;
import REST.Trail.persistence.PersistenceUtil;

public class TrailService {

	//private Map<Long, Trail> trails = Database.getTrails();
	
	public TrailService() {
		/*trails.put(1L, new Trail(1, "Glendalough", "Advanced", 15, "Circular"));
		trails.put(2L, new Trail(2, "Killiney Hill", "Easy", 5, "Linear"));*/ 
	}
	
	public List<Trail> getAllTrails() {
		List<Trail> trails = PersistenceUtil.getAllTrails();
		return trails;
		//return new ArrayList<Trail>(trails.values());
	}
	
	/*
	 * public List<String> getMarkers() { //ArrayList<>() lat = new ArrayList<>;
	 * List<String> lat = new ArrayList<>(); List<String> longitude = new
	 * ArrayList<>(); List<Trail> trails = PersistenceUtil.getAllTrails(); }
	 */
	/*
	public Trail getTrail(long id) {
		return trails.get(id);
	}
	
	public Trail addTrail(Trail trail) {
		trail.setId(trails.size() + 1);
		trails.put(trail.getId(), trail);
		return trail;
	}
	
	public Trail updateTrail(Trail trail) {
		if (trail.getId() <= 0) {
			return null;
		}
		trails.put(trail.getId(), trail);
		return trail;
	}
	
	public Trail removeTrail(long id) {
		return trails.remove(id);
	}*/
}
