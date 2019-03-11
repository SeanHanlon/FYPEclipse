package REST.Trail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries( {
	@NamedQuery(name = "Trail.getAll", query = " select o from Trail o"),
	@NamedQuery(name = "Trail.findByName", query = "select o from Trail o where o.name=:name"),
	@NamedQuery(name = "Trail.findByFormat", query = "select o from Trail o where o.format=:format")
})

@Entity
@XmlRootElement
public class Trail {

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

	
	
	
}
