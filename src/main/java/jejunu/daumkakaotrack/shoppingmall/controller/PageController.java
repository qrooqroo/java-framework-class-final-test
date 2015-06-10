package jejunu.daumkakaotrack.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String moveToLoginPage() {
        return "login"; 
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String moveToSignUpPage() {
        return "signup"; 
	}
	
	@RequestMapping(value="/mypage", method = RequestMethod.GET)
	public String moveToMyPage() {
        return "mypage"; 
	}
	
	@RequestMapping(value="/denied", method = RequestMethod.GET)
	public String moveToDeny() {
        return "denied"; 
	}
}
