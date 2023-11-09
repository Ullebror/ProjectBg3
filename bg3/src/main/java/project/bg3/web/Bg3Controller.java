package project.bg3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.bg3.model.Armor;
import project.bg3.model.ArmorRepository;
//import project.bg3.model.ItemRepository;
import project.bg3.model.Weapon;
import project.bg3.model.WeaponRepository;

@Controller
public class Bg3Controller {
	@Autowired
	private WeaponRepository wrepository;
	@Autowired
	private ArmorRepository arepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// for showing both weapons and items as their own tables on the same page
	@RequestMapping(value = { "/", "/itemlist" })
	public String itemList(Model model) {
		model.addAttribute("armors", arepository.findAll());
		model.addAttribute("weapons", wrepository.findAll());
		return "itemlist";
	}

	// showing only weapons as a table
	@RequestMapping(value = { "/weaponlist" })
	public String weaponList(Model model) {
		model.addAttribute("weapons", wrepository.findAll());
		return "weaponlist";
	}

	// showing only armours as a table
	@RequestMapping(value = { "/armorlist" })
	public String armorList(Model model) {
		model.addAttribute("armors", arepository.findAll());
		return "armorlist";
	}

	// a way to create a page where the user with ADMIN rights can add new weapon to
	// the database
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addweapon" })
	public String addWeapon(Model model) {
		model.addAttribute("weapon", new Weapon());
		return "addweapon";
	}

	// a way to create a page where the user with ADMIN rights can add new armour to
	// the database
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addarmor" })
	public String addArmor(Model model) {
		model.addAttribute("armor", new Armor());
		return "addarmor";
	}

	// PreAuthorize protects from users that should only have viewing rights. links
	// also hidden on pages just in case.
	// used to save a weapon to the database, when editing or adding a new one
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/saveweapon", method = RequestMethod.POST)
	public String save(Weapon weapon) {
		wrepository.save(weapon);
		return "redirect:itemlist";
	}

	// used to save an armour to the database, when editing or adding a new one
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/savearmor", method = RequestMethod.POST)
	public String save(Armor armor) {
		arepository.save(armor);
		return "redirect:itemlist";
	}

	// gives the attributes of an existing armour to be updated in the database
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/editarmor/{id}" })
	public String editArmor(@PathVariable("id") Long armorId, Model model) {
		model.addAttribute("armor", arepository.findById(armorId));
		return "editarmor";
	}

	// gives the attributes of an existing weapon to be updated in the database
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/editweapon/{id}" })
	public String editWeapon(@PathVariable("id") Long weaponId, Model model) {
		model.addAttribute("weapon", wrepository.findById(weaponId));
		return "editweapon";
	}

}