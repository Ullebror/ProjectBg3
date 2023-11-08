package project.bg3.model;

import jakarta.persistence.Entity;

@Entity
public class Weapon extends Item {
	private String damage;
	private String damageType;
	private String type;
	private String attribute;
	private String extra;

	public Weapon() {
		super();
	}

	public Weapon(String name, String description, String rarity, String damage, String damageType, String type, String attribute, String extra) {
		this.name = name;
		this.description = description;
		this.rarity = rarity;
		this.damage = damage;
		this.damageType = damageType;
		this.type = type;
		this.attribute = attribute;
		this.extra = extra;
	}

	public String getDamage() {
		return damage;
	}

	public String getDamageType() {
		return damageType;
	}

	public String getType() {
		return type;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getExtra() {
		return extra;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + name + ", description" + description + ", rarity=" + rarity + "damage="
				+ damage + ", damageType=" + damageType + ", type=" + type + ", attribute=" + attribute + ", extra="
				+ extra + "]";
	}
}