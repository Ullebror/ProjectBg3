package project.bg3.entity;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Item {

	
	protected String name;

	protected String description1;
	protected String description2;
	protected String description3;
	protected String description4;

	public String location;

	public Item() {
		super();
	}

	public Item(String name, String description1, String description2, String description3, String description4,  String location) {
		super();
		this.name = name;
		this.description1 = description1;
		this.description2 = description2;
		this.description3 = description3;
		this.location = location;
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

	public String getLocation() {
		return location;
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

	public void setLocation(String location) {
		this.location = location;
	}

}