package jejunu.daumkakaotrack.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView moveToLoginPage(
			@RequestParam(value="failed", required=false, defaultValue="false") boolean isFailed) {
		
		String message = "";
		
		if(isFailed){
			message =  "로그인에 실패했습니다.";
		}
		
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("message", message);
        return modelAndView; 
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
	public String moveToDeniedPage() {
        return "denied"; 
	}
	
	@RequestMapping(value="/product/register", method = RequestMethod.GET)
	public String moveToRegisterProductPage() {
        return "addProduct"; 
	}
	
}
