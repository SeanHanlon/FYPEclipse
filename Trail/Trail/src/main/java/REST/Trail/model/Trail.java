package REST.Trail.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;



//@NamedQuery(name = "Item.findByCategory", query = "select o from Item o where o.category like concat('%', :category, '%') "),
@NamedQueries( {
	@NamedQuery(name = "Trail.getAll", query = " select o from Trail o"),
	@NamedQuery(name = "Trail.findById", query = "select o from Trail o where o.id=:id"),
	@NamedQuery(name = "Trail.findByName", query = "select o from Trail o where o.name=:name"),
	@NamedQuery(name = "Trail.findByFormat", query = "select o from Trail o where o.format=:format"),
	@NamedQuery(name = "Trail.nameSearch", query = "select o from Trail o where o.name like concat('%', :name, '%')"),
	@NamedQuery(name = "Trail.countySearch", query = "select o from Trail o where o.county like concat('%', :county, '%')"),
	@NamedQuery(name = "Trail.gradeSearch", query = "select o from Trail o where o.grade like concat('%', :grade, '%')")
})

@Entity
@XmlRootElement
public class Trail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String county;
	private String format;
	private double length;
	private String climb;
	private String grade;
	private double time;
	private double startLat;
	private double startLong;
	private double finLat;
	private double finLong;
	
	
	//private Set<Favourites> user_favs = new HashSet<>();
	
	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_favs", joinColumns = {
			@JoinColumn(name = "trail_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "item_id", referencedColumnName = "id") })
	@ElementCollection(targetClass = Item.class)
	private Set<Favourites> user_favs = new HashSet<>();*/
	
	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "FAVOURITES", joinColumns = {
			@JoinColumn(name = "TRAIL_ID", referencedColumnName = "id")}, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", referencedColumnName = "id")})
	@ElementCollection(targetClass = User.class)
	private Set<User> users;*/
	
	@ManyToMany(mappedBy = "trails", fetch = FetchType.EAGER)
	private Set<User> users = new HashSet<>();
	
	
	public Trail() {
		
	}

	public Trail(String name, String county, String format, double length, String climb, String grade, 
			double time, double startLat, double startLong, double finLat, double finLong) {
		this.name=name;
		this.county=county;
		this.format=format;
		this.length=length;
		this.climb=climb;
		this.grade=grade;
		this.time=time;
		this.startLat=startLat;
		this.startLong=startLong;
		this.finLat=finLat;
		this.finLong=finLong;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getClimb() {
		return climb;
	}

	public void setClimb(String climb) {
		this.climb = climb;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getStartLat() {
		return startLat;
	}

	public void setStartLat(double startLat) {
		this.startLat = startLat;
	}

	public double getStartLong() {
		return startLong;
	}

	public void setStartLong(double startLong) {
		this.startLong = startLong;
	}

	public double getFinLat() {
		return finLat;
	}

	public void setFinLat(double finLat) {
		this.finLat = finLat;
	}

	public double getFinLong() {
		return finLong;
	}

	public void setFinLong(double finLong) {
		this.finLong = finLong;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}*/

	/*public Favourites getFavourites() {
		return favourites;
	}

	public void setFavourites(Favourites favourites) {
		this.favourites = favourites;
	}*/

	
	
	
}
