package jejunu.daumkakaotrack.shoppingmall.controller;

import jejunu.daumkakaotrack.shoppingmall.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("list", productService.list());
		
		return modelAndView;
	}
}
