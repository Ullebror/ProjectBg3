package project.bg3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Armor extends Item {

	@Column(nullable = false)
	private int ac;
	
	@Column(nullable = false)
	private String dexBonus;
	
	@Column(nullable = false)
	private String stealth;
	
	@Column(nullable = false)
	private String type;

	public Armor() {
		super();
	}

	public Armor(String name, String description1, String description2, String description3, String description4,
			String rarity, String location, int ac, String dexBonus, String stealth, String type) {
		super();
		this.name = name;
		this.description1 = description1;
		this.description2 = description2;
		this.description3 = description3;
		this.description4 = description4;
		this.rarity = rarity;
		this.location = location;
		this.ac = ac;
		this.stealth = stealth;
		this.type = type;
		this.dexBonus = dexBonus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAc() {
		return ac;
	}

	public String getDexBonus() {
		return dexBonus;
	}

	public String getStealth() {
		return stealth;
	}

	public String getType() {
		return type;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public void setDexBonus(String dexBonus) {
		this.dexBonus = dexBonus;
	}

	public void setStealth(String stealth) {
		this.stealth = stealth;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Armor [id=" + id + ", name=" + name + ", description1=" + description1 + ", description2="
				+ description2 + ", description3=" + description3 + ", description4=" + description4 + ", rarity="
				+ rarity + ", location=" + location + ", ac=" + ac + ", attribute=" + dexBonus + ", stealthdisadv="
				+ stealth + ", type=" + type + "]";
	}
}