package project.bg3.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="rarities")
public class Rarity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	private String rarity;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "rarity")
	private List<Armor> armors;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "rarity")
	private List<Weapon> weapons;
	
	
	public Rarity() {
		super();
	}
	
	public Rarity(String rarity) {
		this.rarity = rarity;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
}