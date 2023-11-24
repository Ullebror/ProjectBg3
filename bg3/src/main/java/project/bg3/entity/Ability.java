package project.bg3.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "abilities")
public class Ability {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	protected Long id;

	@Column(nullable = false)
	private String attribute;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "ability")
	private List<Weapon> weapons;
	
	public Ability() {
		super();
	}
	
	public Ability(String attribute) {
		this.attribute = attribute;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}