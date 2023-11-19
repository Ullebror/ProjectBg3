package project.bg3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import project.bg3.dto.UserDto;
import project.bg3.entity.AppUser;
import project.bg3.repository.AppUserRepository;
import project.bg3.service.UserService;
import project.bg3.validation.AppUserAlreadyExistsAuthenticationException;

//This controller is for user specific methods
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AppUserRepository urepository;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping("/user/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "registration";
	}
	
	@PostMapping("/user/registration")
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, HttpServletRequest request,
			Errors errors) {
		ModelAndView mav = new ModelAndView("user");
		try {
			AppUser registered = userService.registerNewUserAccount(userDto);
		} catch (AppUserAlreadyExistsAuthenticationException uaeEx) {
			mav.addObject("message", "An account for that username already exists.");
			return mav;
		}

		return new ModelAndView("successRegister", "user", userDto);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users")
	public String userList(Model model) {
		model.addAttribute("users", urepository.findAll());
		return "users";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String save(AppUser user) {
		urepository.save(user);
		return "redirect:itemlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = { "/edituser/{id}" })
	public String editUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", urepository.findById(id));
		return "edituser";
	}
}