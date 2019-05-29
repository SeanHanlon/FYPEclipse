package REST.Trail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Favourites implements Serializable {
	
	@Id
	@OneToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToMany(mappedBy = "user_favs")
	private Set<Trail> trails = new HashSet<>();
	
	public Favourites() {
		
	}
	
	public Favourites(User user, Set<Trail> trails) {
		this.user = user;
		this.trails = trails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Trail> getTrails() {
		return trails;
	}

	public void setTrails(Set<Trail> trails) {
		this.trails = trails;
	}

	/*public List<Trail> getTrails() {
		return trails;
	}

	public void setTrails(List<Trail> trails) {
		this.trails = trails;
	}
	*/
	
	
	
}
