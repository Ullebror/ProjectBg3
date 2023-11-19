package project.bg3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.bg3.repository.ArmorRepository;
import project.bg3.repository.WeaponRepository;

//This Controller is for the front page to not fill up the other controllers.
// I created more than one controller to make viewing the methods easier.
@Controller
public class Bg3Controller {
	@Autowired
	private WeaponRepository wrepository;
	@Autowired
	private ArmorRepository arepository;

	@RequestMapping(value = { "/", "/itemlist" })
	public String itemList(Model model) {
		model.addAttribute("armors", arepository.findAll());
		model.addAttribute("weapons", wrepository.findAll());
		return "itemlist";
	}

}