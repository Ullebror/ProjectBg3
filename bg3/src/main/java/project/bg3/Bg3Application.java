package project.bg3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import project.bg3.model.AppUser;
import project.bg3.model.AppUserRepository;
import project.bg3.model.Armor;
import project.bg3.model.ArmorRepository;
//import project.bg3.model.ItemRepository;
import project.bg3.model.Weapon;
import project.bg3.model.WeaponRepository;

@SpringBootApplication
public class Bg3Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Bg3Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Bg3Application.class, args);
	}

	@Bean
	public CommandLineRunner bg3Demo(ArmorRepository arepository, 
			AppUserRepository urepository, WeaponRepository wrepository) {
		return (args) -> {

			/*arepository.save(new Armor("Helldusk Armour",
					"Helldusk armour: You are considered Proficient with this armour while wearing it.",
					"Infernal Retribution: When you succeed a Saving Thow, the caster receives Burning for 3 turns.",
					"Prime Aegis of Fire: You have Resistance to Fire damage and cannot be burned. you take 3 less damage from all sources.",
					"Grants the ability to Fly.", "Legendary", "House of Hope", 21, "No", "No", "Heavy"));
			arepository.save(new Armor("Chain Mail +1", "Superior Material: You take 1 less Slashing damage.", "", "",
					"", "Uncommon", "", 17, "No", "Yes", "Heavy"));
			arepository.save(new Armor("Plate Armour +1",
					"Superior Plate: You take 1 less damage from Slashing, Piercing and Bludgeoning sources.", "", "",
					"", "Uncommon", "", 19, "No", "Yes", "Heavy"));
			wrepository.save(new Weapon("Nyrulna",
					"Zephyr Connection: This weapon will return to your hand when thrown. You cannot be forced to drop the trident. When thrown, the weapon creates an explosion that deals 3d4 Thunder damage in a 6m blast centered on target.",
					"Veil of the Wind:  You gain a +3m/10ft bonus to movement speed and jump distance. Equipping this weapon gives you Immunity to falling damage.",
					"Nyrulna: Glowing: This object shines with a glowing light in a radius of 6m",
					"Zephyr Flash: Rush forward, creating an air vortex that blasts foes and possibly inflicts Bleeding.",
					"Legendary", "Circus of the Last Days", "1d6 + 3", "Piercing", "Trident", "STR", "1d6")); */

			/*AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2); */

		};

	}

}
