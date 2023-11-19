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

import project.bg3.entity.Weapon;
import project.bg3.repository.WeaponRepository;

//This controller is for weapon specific methods.
@Controller
public class WeaponController {
	@Autowired
	private WeaponRepository wrepository;

	// RESTful service to get all weapons
	@RequestMapping(value = "/weapons", method = RequestMethod.GET)
	public @ResponseBody List<Weapon> weaponListRest() {
		return (List<Weapon>) wrepository.findAll();
	}

	// showing only weapons as a table
	@RequestMapping(value = { "/weaponlist" })
	public String weaponList(Model model) {
		model.addAttribute("weapons", wrepository.findAll());
		return "weaponlist";
	}

	// a way to create a page where the user with ADMIN rights can add a new weapon
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addweapon" })
	public String addWeapon(Model model) {
		model.addAttribute("weapon", new Weapon());
		return "addweapon";
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

}