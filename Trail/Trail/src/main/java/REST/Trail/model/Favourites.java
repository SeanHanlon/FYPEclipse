package REST.Trail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Favourites implements Serializable {
	
	@Id
	@OneToOne(fetch=FetchType.EAGER)
	private User user;
	
	@OneToMany(mappedBy = "favourites")
	private List<Trail> trails = new ArrayList<>();
	
	public Favourites() {
		
	}
	
	public Favourites(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Trail> getTrails() {
		return trails;
	}

	public void setTrails(List<Trail> trails) {
		this.trails = trails;
	}
	
	
	
	
}
