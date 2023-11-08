package project.bg3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Bookstore.model.Book;

import project.bg3.model.Armor;
import project.bg3.model.ArmorRepository;
import project.bg3.model.ItemRepository;
import project.bg3.model.Weapon;
import project.bg3.model.WeaponRepository;

@Controller
public class Bg3Controller {
	@Autowired
	private ItemRepository irepository;
	@Autowired
	private WeaponRepository wrepository;
	@Autowired
	private ArmorRepository arepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/", "/itemlist" })
	public String itemList(Model model) {
		model.addAttribute("items", irepository.findAll());
		model.addAttribute("armors", arepository.findAll());
		model.addAttribute("weapons", wrepository.findAll());
		return "itemlist";
	}

	@RequestMapping(value = { "/weaponlist" })
	public String weaponList(Model model) {
		model.addAttribute("weapons", wrepository.findAll());
		return "weaponlist";
	}

	@RequestMapping(value = { "/armorlist" })
	public String armorList(Model model) {
		model.addAttribute("armors", arepository.findAll());
		return "armorlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addweapon" })
	public String addWeapon(Model model) {
		model.addAttribute("weapon", new Weapon());
		return "addweapon";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addarmor" })
	public String addArmor(Model model) {
		model.addAttribute("armor", new Armor());
		return "addarmor";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/saveweapon", method = RequestMethod.POST)
	public String save(Weapon weapon) {
		wrepository.save(weapon);
		return "redirect:itemlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/savearmor", method = RequestMethod.POST)
	public String save(Armor armor) {
		arepository.save(armor);
		return "redirect:itemlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/editarmor/{id}" })
	public String editArmor(@PathVariable("id") Long armorId, Model model) {
		model.addAttribute("armor", arepository.findById(armorId));
		return "editarmor";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/editweapon/{id}" })
	public String editWeapon(@PathVariable("id") Long weaponId, Model model) {
		model.addAttribute("weapon", wrepository.findById(weaponId));
		return "editweapon";
	}

}