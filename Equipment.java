package edu.neu.cs5200.hw5.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Equipment {
	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String brand;
	private String description;
	private double price;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="towerId")
	@JsonBackReference
	private Tower tower;
	
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Tower getTower() {
		return tower;
	}
	public void setTower(Tower tower) {
		this.tower = tower;
	}
	public Equipment(Integer id, String name, String brand, String description,
			double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}
	public Equipment() {
		super();
	}
}
