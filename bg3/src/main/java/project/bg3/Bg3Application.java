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
import project.bg3.model.Item;
import project.bg3.model.ItemRepository;
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
	public CommandLineRunner bg3Demo(ArmorRepository arepository, ItemRepository irepository, AppUserRepository urepository, WeaponRepository wrepository) {
		return (args) -> {
			

			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			

			

		};
		
	}

}
