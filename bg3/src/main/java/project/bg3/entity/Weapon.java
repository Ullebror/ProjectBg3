package project.bg3.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;



@Entity
@Table(name="weapons")
public class Weapon extends Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	protected Long id;
	
	@Column(nullable = false)
	@NotEmpty
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "rarityid")
	private Rarity rarity;
	
	@Column(nullable = false)
	@NotEmpty
	private String damage;
	
	@Column(nullable = false)
	@NotEmpty
	private String damageType;
	
	@Column(nullable = false)
	@NotEmpty
	private String type;
	
	@ManyToOne
	@JoinColumn(name ="abilityid")
	private Ability ability;
	
	private String extra;

	public Weapon() {
		
	}
	

	public Weapon(String name, String description1, String description2, String description3, String description4,
			Rarity rarity, String location, String damage, String damageType, String type, Ability ability,
			String extra) {
		super();
		this.name = name;
		this.rarity = rarity;
		this.damage = damage;
		this.damageType = damageType;
		this.type = type;
		this.ability = ability;
		this.extra = extra;
	}

	
	
    public Long getId() {
        return id;
    }

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Rarity getRarity() {
		return rarity;
	}
	
	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
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

	public Ability getAbility() {
		return ability;
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

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + name + ", description1=" + description1 + ", description2="
				+ description2 + ", description3=" + description3 + ", description4=" + description4 + ", rarity="
				+ rarity + ", location=" + location + ", damage=" + damage + ", damageType=" + damageType + ", type="
				+ type + ", attribute=" + ability + ", extra=" + extra + "]";
	}
}