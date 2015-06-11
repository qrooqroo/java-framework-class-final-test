package jejunu.daumkakaotrack.shoppingmall.controller;

import jejunu.daumkakaotrack.shoppingmall.model.User;
import jejunu.daumkakaotrack.shoppingmall.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserInfoController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public String addUser(@RequestParam String id, @RequestParam String password,
			@RequestParam String authority, RedirectAttributes redirectAttributes){
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setEnabled(true);
		
		if(authority.equals("seller"))
			user.setRole("ROLE_SELLER");
		else
			user.setRole("ROLE_USER");
		
		userService.createUser(user);
		redirectAttributes.addAttribute("message", "회원가입이 완료되었습니다.");
		
		return "redirect:/";
	}
	
}
