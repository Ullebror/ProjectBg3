package project.bg3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "armor")
public class Armor extends Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(nullable = false)
	private int ac;

	@Column(nullable = false)
	private String dexBonus;

	@Column(nullable = false)
	private String stealth;

	@Column(nullable = false)
	private String type;

	public Armor() {

	}

	public Armor(String name, String description1, String description2, String description3, String description4,
			String rarity, String location, int ac, String dexBonus, String stealth, String type) {
		super();
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