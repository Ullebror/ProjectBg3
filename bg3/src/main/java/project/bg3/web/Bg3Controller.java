package project.bg3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import project.bg3.model.Item;
import project.bg3.model.ItemRepository;
import project.bg3.model.Armor;
import project.bg3.model.ArmorRepository;
import project.bg3.model.Weapon;
import project.bg3.model.WeaponRepository;
import project.bg3.dto.UserDto;

@Controller
public class Bg3Controller {
	@Autowired
	private WeaponRepository wrepository;
	@Autowired
	private ArmorRepository arepository;
	@Autowired
	private ItemRepository irepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/user/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "registration";
	}

	// RESTful service to get all armor
	@RequestMapping(value = "/armor", method = RequestMethod.GET)
	public @ResponseBody List<Armor> armorListRest() {
		return (List<Armor>) arepository.findAll();
	}

	// RESTful service to get all weapons
	@RequestMapping(value = "/weapons", method = RequestMethod.GET)
	public @ResponseBody List<Weapon> weaponListRest() {
		return (List<Weapon>) wrepository.findAll();
	}

	// for showing both weapons and armor as their own tables on the same page
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

	// a way to create a page where the user with ADMIN rights can add new weapon as
	// an Item to
	// the database using ModelAndView
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addweapon" })
	public ModelAndView addWeapon() {
		ModelAndView mav = new ModelAndView("addweapon");
		Item weapon = new Weapon();

		mav.addObject("weapon", weapon);
		return mav;
	}

	// a way to create a page where the user with ADMIN rights can add new armor as
	// an Item to
	// the database using ModelAndView
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addarmor" })
	public ModelAndView addArmor() {
		ModelAndView mav = new ModelAndView("addarmor");
		Item armor = new Armor();

		mav.addObject("armor", armor);

		return mav;
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

	// PreAuthorize protects from users that should only have viewing rights. links
	// also hidden on pages just in case.
	// gives the attributes of an existing armor to be updated in the database
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/editarmor/{armorId}" })
	public String editArmor(@PathVariable("armorid") Long armorId, Model model) {
		model.addAttribute("armor", arepository.findById(armorId));
		return "editarmor";
	}

	// PreAuthorize protects from users that should only have viewing rights. links
	// also hidden on pages just in case.
	// gives the attributes of an existing weapon to be updated in the database
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/editweapon/{id}" })
	public String editWeapon(@PathVariable("id") Long weaponId, Model model) {
		model.addAttribute("weapon", wrepository.findById(weaponId));
		return "editweapon";
	}

	// PreAuthorize protects from users that should only have viewing rights. links
	// also hidden on pages just in case.
	// deletes a weapon
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/deleteweapon/{id}" }, method = RequestMethod.GET)
	public String deleteWeapon(@PathVariable("id") Long id, Model model) {
		wrepository.deleteById(id);
		return "redirect:../itemlist";
	}

	// deletes an armor
	
	@PreAuthorize("hasAuthority('ADMIN')")

	@RequestMapping(value = { "/deletearmor/{id}" }, method = RequestMethod.GET)
	public String deleteArmor(@PathVariable("id") Long id, Model model) {
		arepository.deleteById(id);
	
		return "redirect:../itemlist";
	} 

}