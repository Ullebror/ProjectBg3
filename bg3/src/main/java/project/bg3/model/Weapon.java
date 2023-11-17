package project.bg3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="weapons")
public class Weapon extends Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	

	@Column(nullable = false)
	private String damage;
	
	@Column(nullable = false)
	private String damageType;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String attribute;
	
	private String extra;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="id")
	private Item item;

	public Weapon() {
		
	}
	

	public Weapon(String name, String description1, String description2, String description3, String description4,
			String rarity, String location, String damage, String damageType, String type, String attribute,
			String extra) {
		super();
		this.name = name;
		this.damage = damage;
		this.damageType = damageType;
		this.type = type;
		this.attribute = attribute;
		this.extra = extra;
	}

	
	
    public Long getId() {
        return id;
    }

	public void setId(Long id) {
		this.id = id;
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
		return "Weapon [id=" + id + ", name=" + name + ", description1=" + description1 + ", description2="
				+ description2 + ", description3=" + description3 + ", description4=" + description4 + ", rarity="
				+ rarity + ", location=" + location + ", damage=" + damage + ", damageType=" + damageType + ", type="
				+ type + ", attribute=" + attribute + ", extra=" + extra + "]";
	}
}