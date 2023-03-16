package Main.controller;


import Main.model.User;
import Main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController{
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("users",userService.getAllUser());
		model.addAttribute("updateUser",new User());
		return "User/Users";
	}
	@PostMapping(value = "/del")
	public String delUser(@RequestParam int id, ModelMap model){
		userService.dell(id);
		//model.addAttribute("users",userService.getAllUser());
		return "redirect:/";
	}
	@PostMapping(value = "/add")
	public String addUser(@ModelAttribute("updateUser")User user){
		userService.add(user);
		return "redirect:/";
	}
	//Я не могу понять откуда у меня появляються запятые перед firstName & lastName при выполнении update&add
	@PostMapping(value = "/update")
	public String updateUser(@ModelAttribute("updateUser")User user){
		System.out.printf(user.toString());
		userService.update(user);
		return "redirect:/";
	}
	
}