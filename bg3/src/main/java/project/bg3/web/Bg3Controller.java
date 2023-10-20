package project.bg3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.bg3.model.ArmorRepository;
import project.bg3.model.ItemRepository;
import project.bg3.model.WeaponRepository;

@Controller
public class Bg3Controller {
	@Autowired
	private ItemRepository irepository;
	@Autowired
	private WeaponRepository wrepository;
	@Autowired
	private ArmorRepository arepository;
	
	@RequestMapping(value = {"/", "/itemlist"})
	public String itemList(Model model) {
		model.addAttribute("items", irepository.findAll());
		return "itemlist";
	}
	
	@RequestMapping(value = {"/weaponlist"})
	public String weaponList(Model model) {
		model.addAttribute("weapons", wrepository.findAll());
		return "weaponlist";
	}
	
	@RequestMapping(value = {"/armorlist"})
	public String armorList(Model model) {
		model.addAttribute("armors", arepository.findAll());
		return "armorlist";
	}
	
}