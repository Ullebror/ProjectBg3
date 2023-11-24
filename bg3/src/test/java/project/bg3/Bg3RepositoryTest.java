package project.bg3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.bg3.entity.Armor;
import project.bg3.entity.Weapon;
import project.bg3.repository.AbilityRepository;
import project.bg3.repository.ArmorRepository;
import project.bg3.repository.RarityRepository;
import project.bg3.repository.WeaponRepository;


@SpringBootTest
public class Bg3RepositoryTest {
	@Autowired
	private ArmorRepository arepository;
	@Autowired
	private AbilityRepository abirepository;
	@Autowired
	private WeaponRepository wrepository;
	@Autowired
	private RarityRepository rrepository;

	@Test
	public void findArmorByNameShouldReturnAc() {
		List<Armor> armors = arepository.findByName("Helldusk armour");
		assertThat(armors.get(0).getAc()).isEqualTo(21);

	}

	@Test
	public void createNewArmor() {
		Armor armor = new Armor("Leather armor +1", "Stealthy: Gain a +1 bonus to Stealth Checks.", "", "", "",
				rrepository.findByRarity("Uncommon"), "", 12, "+ Dex", "No", "Light");
		assertThat(armor.getId()).isNotNull();
	}

	@Test
	public void findWeaponByNameShouldReturnType() {
		List<Weapon> weapons = wrepository.findByName("Nyrulna");
		assertThat(weapons.get(0).getType()).isEqualTo("Trident");

	}

	@Test
	public void createNewWeapon() {
		Weapon weapon = new Weapon("Battleaxe +1", "Versatile - Wielding With Both Hands", "", "", "",
				rrepository.findByRarity("Uncommon"), "", "1d10 (1d8) +1", "Slashing", "Battleaxe",
				abirepository.findByAttribute("Strength"), "");
		assertThat(weapon.getId()).isNotNull();
	}

}