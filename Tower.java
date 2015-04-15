package edu.neu.cs5200.hw5.model;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Tower {
	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double height;
	private int sides;
//	@XmlAttribute
//	private Integer siteId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="siteId")
	@JsonBackReference
	private Site site;
	
	@OneToMany(mappedBy="tower", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Equipment> equipments;
	
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public Tower(Integer id, String name, double height, int sides) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
	}
	public Tower() {
		super();
	}
	
	
	
}
