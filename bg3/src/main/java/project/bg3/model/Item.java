package project.bg3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected Long id;

	@Column(nullable = false)
	protected String name;

	protected String description1;
	protected String description2;
	protected String description3;
	protected String description4;

	@Column(nullable = false)
	public String rarity;

	@Column(nullable = false)
	public String location;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "weapon_id", referencedColumnName = "id")
	private Weapon weapon;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "armor_id", referencedColumnName = "id")
	private Armor armor;

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