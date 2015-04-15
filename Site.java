package edu.neu.cs5200.hw5.model;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Site {
	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double latitude;
	private double longitude;
	
	@OneToMany(mappedBy="site", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Tower> towers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public List<Tower> getTowers() {
		return towers;
	}
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
	public Site(Integer id, String name, double latitude, double longitude) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Site() {
		super();
	}
	
}
