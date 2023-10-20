package project.bg3.model;

public class Armor extends Item {
	private int ac;
	private String stealth;
	private String type;

	public Armor() {
		super();
	}

	public Armor(int ac, String stealth, String type) {
		this.ac = ac;
		this.stealth = stealth;
		this.type = type;
	}

	public int getAc() {
		return ac;
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

	public void setStealth(String stealth) {
		this.stealth = stealth;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Armor [id=" + id + ", name=" + name + ", description=" + description + ", rarity=" + rarity + ", ac=" + ac + ", stealthdisadv=" + stealth + ", type=" + type + "]";
	}
}