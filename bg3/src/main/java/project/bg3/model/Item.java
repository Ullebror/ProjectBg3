package project.bg3.model;

public class Item {
	protected Long id;
	protected String name;
	protected String description;
	public String rarity;

	public Item() {
		super();
	}

	public Item(String name, String description, String rarity) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getRarity() {
		return rarity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", rarity=" + rarity + "]";
	}

}