package jejunu.daumkakaotrack.shoppingmall.controller;

import jejunu.daumkakaotrack.shoppingmall.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(value="message", required=false) String message,
			@RequestParam(value="pageSize", required=false, defaultValue="10") int pageSize,
			@RequestParam(value="pageno", required=false, defaultValue="1") int pageno) {
		
		SecurityContext context = SecurityContextHolder.getContext();
		String name = context.getAuthentication().getName();
		
		if(message==null){
			message = name + "님 안녕하세요.";	
			
			if(name.equals("anonymousUser")) 
				message = "";
		}
		
		
		
		int totalCount = (int) Math.ceil((double)(productService.getTotalCount()) / pageSize);
		
		if(pageno<1) pageno = 1;
		if(pageno>totalCount) pageno = totalCount;
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("totalCount", totalCount);
		modelAndView.addObject("pageno", pageno);
		modelAndView.addObject("message", message);
		modelAndView.addObject("list", productService.list(pageno, pageSize));
		
		return modelAndView;
	}
}
