package REST.Trail.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@NamedQueries( {
	@NamedQuery(name = "User.findAll", query = "select o from User o"),
	@NamedQuery(name = "User.findByName", query = "select o from User o where o.name=:name"),
	@NamedQuery(name = "User.findByEmail", query = "select o from User o where o.email=:email")
})

@Entity
@XmlRootElement
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String email;
	private String password;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Favourites favourites;
	
	public User() {
		
	}
	
	public User(String name, String email, String password) {
		this.name=name;
		this.email=email;
		this.password=password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Favourites getFavourites() {
		return favourites;
	}

	public void setFavourites(Favourites favourites) {
		this.favourites = favourites;
	}
	
	
	
}
