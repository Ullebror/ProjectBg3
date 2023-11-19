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

import project.bg3.entity.Armor;
import project.bg3.repository.ArmorRepository;
import project.bg3.repository.RarityRepository;

//This controller is for all things that have something to do with armor entity
@Controller
public class ArmorController {

	@Autowired
	private ArmorRepository arepository;
	@Autowired
	private RarityRepository rrepository;
	
	// RESTful service to get all armor
	@RequestMapping(value = "/armor", method = RequestMethod.GET)
	public @ResponseBody List<Armor> armorListRest() {
		return (List<Armor>) arepository.findAll();
	}

	// showing only armours as a table
	@RequestMapping(value = { "/armorlist" })
	public String armorList(Model model) {
		model.addAttribute("armors", arepository.findAll());
		return "armorlist";
	}

	// a way to create a page where the user with ADMIN rights can add new armor
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/addarmor" })
	public String addArmor(Model model) {
		model.addAttribute("armor", new Armor());
		model.addAttribute("rarities", rrepository.findAll());
		return "addarmor";
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
	@RequestMapping(value = { "/editarmor/{id}" })
	public String editArmor(@PathVariable("id") Long armorId, Model model) {
		model.addAttribute("armor", arepository.findById(armorId));
		model.addAttribute("rarities", rrepository.findAll());
		return "editarmor";
	}

	// deletes an armor
	@PreAuthorize("hasAuthority('ADMIN')")

	@RequestMapping(value = { "/deletearmor/{id}" }, method = RequestMethod.GET)
	public String deleteArmor(@PathVariable("id") Long id, Model model) {
		arepository.deleteById(id);

		return "redirect:../itemlist";
	}

}