package REST.Trail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import REST.Trail.model.Trail;
import REST.Trail.model.User;
import REST.Trail.persistence.PersistenceUtil;

public class TrailService {
	
	public TrailService() {

	}
	
	public List<Trail> getAllTrails() {
		List<Trail> trails = PersistenceUtil.getAllTrails();
		return trails;
	}
	
	public List<Trail> searchTrail(String searchParam) {
		
		List<Trail> finalTrails = new ArrayList<>();
		
		List<Trail> nameTrails = PersistenceUtil.searchTrail(searchParam);
		List<Trail> countyTrails = PersistenceUtil.countyTrails(searchParam);
		List<Trail> gradeTrails = PersistenceUtil.gradeTrails(searchParam);
		
		if(nameTrails != null) {
			finalTrails.addAll(nameTrails);
		}
		
		if(countyTrails != null) {
			finalTrails.addAll(countyTrails);
		}
		
		if(gradeTrails != null) {
			finalTrails.addAll(gradeTrails);
		}
		
		return finalTrails;
	}
	
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
