package jejunu.daumkakaotrack.shoppingmall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String moveToLoginPage() {
        return "login"; 
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String moveToSignUpPage() {
        return "signup"; 
	}
}
