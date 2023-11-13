package project.bg3.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

//This is to map the superclass to subclasses weapon and armor without Item having a table for itself and it not being an entity.
@MappedSuperclass
public abstract class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected String name;
	protected String description1;
	protected String description2;
	protected String description3;
	protected String description4;
	public String rarity;
	public String location;

	public Item() {
		super();
	}

	public Item(String name, String description1, String description2, String description3, String description4,
			String rarity, String location) {
		super();
		this.name = name;
		this.description1 = description1;
		this.description2 = description2;
		this.description3 = description3;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription1() {
		return description1;
	}

	public String getDescription2() {
		return description2;
	}

	public String getDescription3() {
		return description3;
	}

	public String getDescription4() {
		return description4;
	}

	public String getRarity() {
		return rarity;
	}

	public String getLocation() {
		return location;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public void setDescription3(String description3) {
		this.description3 = description3;
	}

	public void setDescription4(String description4) {
		this.description4 = description4;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description1=" + description1 + ", description2=" + description2
				+ ", description3=" + description3 + ", description4=" + description4 + ", rarity=" + rarity
				+ ", location=" + location + "]";
	}

}