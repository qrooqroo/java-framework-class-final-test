package jejunu.daumkakaotrack.shoppingmall.controller;

import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductInfoController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/product/info", method = RequestMethod.GET)
	public ModelAndView productInfo(@RequestParam int productid) {
		ModelAndView modelAndView = new ModelAndView("productInfo");
	
		Product product = productService.findProductById(productid);
		modelAndView.addObject("product", product);
        return modelAndView; 
	}

	@RequestMapping(value="/product/register/process", method = RequestMethod.POST)
	public String addProduct(@RequestParam String title, @RequestParam String price,
			@RequestParam String comment, RedirectAttributes redirectAttributes){
		
		Product product = new Product();
		product.setTitle(title);
		product.setPrice(Integer.parseInt(price));
		product.setComment(comment);
		
		SecurityContext context = SecurityContextHolder.getContext();
		String name = context.getAuthentication().getName();
		product.setSeller(name);
		
		productService.addProduct(product);
		redirectAttributes.addAttribute("message", "상품이 등록되었습니다.");
		
        return "redirect:/"; 
	}
	
	@RequestMapping(value="/product/edit", method = RequestMethod.POST)
	public ModelAndView moveToEditProductPage(@RequestParam int productid) {
		
		ModelAndView modelAndView = new ModelAndView("editProduct");
		
		Product product = productService.findProductById(productid);
		modelAndView.addObject("product", product);
        return modelAndView; 
	}
	
	
	@RequestMapping(value="/product/edit/process", method = RequestMethod.POST)
	public String editProduct(@RequestParam int productid, @RequestParam String title, 
			@RequestParam String price, @RequestParam String comment, RedirectAttributes redirectAttributes){
		   
		Product product = new Product();
		product.setId(productid);
		product.setTitle(title);
		product.setPrice(Integer.parseInt(price));
		product.setComment(comment);
		
		SecurityContext context = SecurityContextHolder.getContext();
		String name = context.getAuthentication().getName();
		product.setSeller(name);
		
		productService.editProduct(product);
		redirectAttributes.addAttribute("message", "상품이 수정되었습니다.");
		
        return "redirect:/"; 
	}
}
