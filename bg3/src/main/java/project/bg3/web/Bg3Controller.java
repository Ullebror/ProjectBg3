package project.bg3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.bg3.entity.Ability;
import project.bg3.entity.Armor;
import project.bg3.entity.Rarity;
import project.bg3.repository.AbilityRepository;
import project.bg3.repository.ArmorRepository;
import project.bg3.repository.RarityRepository;
import project.bg3.repository.WeaponRepository;

//This Controller is for the front page to not fill up the other controllers.
// I created more than one controller to make viewing the methods easier.
@Controller
public class Bg3Controller {
	@Autowired
	private WeaponRepository wrepository;
	@Autowired
	private ArmorRepository arepository;
	@Autowired
	private RarityRepository rrepository;
	@Autowired
	private AbilityRepository abilityrepository;

	@RequestMapping(value = { "/", "/itemlist" })
	public String itemList(Model model) {
		model.addAttribute("armors", arepository.findAll());
		model.addAttribute("weapons", wrepository.findAll());
		return "itemlist";
	}

	// RESTful service to get all rarities
	@RequestMapping(value = "/rarity", method = RequestMethod.GET)
	public @ResponseBody List<Rarity> rarityListRest() {
		return (List<Rarity>) rrepository.findAll();
	}

	// RESTful service to get all rarities
	@RequestMapping(value = "/ability", method = RequestMethod.GET)
	public @ResponseBody List<Ability> abilityListRest() {
		return (List<Ability>) abilityrepository.findAll();
	}

}