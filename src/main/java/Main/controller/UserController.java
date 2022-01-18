package Main.controller;


import Main.model.User;
import Main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan(value = "Main.service")
public class UserController{
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("users",userService.getAllUser());
		return "User/Users";
	}
	@RequestMapping(value = "/Del",method = RequestMethod.POST)
	public String delUser(@RequestParam(value = "id") int id, ModelMap model){
		userService.dell(id);
		model.addAttribute("users",userService.getAllUser());
		return "User/Users";
	}
	@RequestMapping(value = "/Add",method = RequestMethod.POST)
		public String addUser(@RequestParam(value = "firstName") String firstname,@RequestParam(value = "lastName") String lastname, ModelMap model){
		User user = new User(firstname,lastname);
		userService.add(user);
		model.addAttribute("users",userService.getAllUser());
		return "User/Users";
	}
	//Я не могу понять откуда у меня появляються запятые перед firstName & lastName при выполнении update&add
	@RequestMapping(value = "/Update",method = RequestMethod.POST)
	public String updateUser(@RequestParam(value = "firstName") String firstname,@RequestParam(value = "lastName") String lastname,@RequestParam(value = "id") int id, ModelMap model){
		userService.update(id,firstname, lastname);
		model.addAttribute("users",userService.getAllUser());
		return "User/Users";
	}
	
}