package jejunu.daumkakaotrack.shoppingmall.controller;

import java.util.ArrayList;
import java.util.List;

import jejunu.daumkakaotrack.shoppingmall.model.Cart;
import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.service.CartService;
import jejunu.daumkakaotrack.shoppingmall.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CartController {
	
	@Autowired 
	CartService cartService;
	
	@Autowired
	ProductService productService;

	@RequestMapping(value="/{userid}/cart", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView moveToCartPage(@PathVariable String userid, @RequestParam int productid) {
		
		ModelAndView modelAndView = new ModelAndView("cart");
		
		Cart cart = new Cart();
		cart.setUserid(userid);
		cart.setProductid(productid);
		cart.setAmount(1);
		
		cartService.addCart(cart);
		
		List<Cart> userCarts = cartService.getCartListByUserid(userid);
		List<Product> productList = new ArrayList<Product>();
		for (int i = 0; i < userCarts.size(); i++) {
			Product product = productService.findProductById(userCarts.get(i).getProductid());
			productList.add(product);
		}
		modelAndView.addObject("list", productList);
		modelAndView.addObject("userid", userid);
	
        return modelAndView; 
	}
	
	@RequestMapping(value="/{userid}/cart/{productid}/delete", method = RequestMethod.POST)
	public String deleteCart(@PathVariable String userid, @PathVariable int productid, RedirectAttributes redirectAttributes) {
	
		cartService.deleteCart(userid, productid);

		List<Cart> userCarts = cartService.getCartListByUserid(userid);
		List<Product> productList = new ArrayList<Product>();
		for (int i = 0; i < userCarts.size(); i++) {
			Product product = productService.findProductById(userCarts.get(i).getProductid());
			productList.add(product);
		}
		
		redirectAttributes.addAttribute("userid", userid);
		redirectAttributes.addAttribute("productid", productid);

        return "redirect:/{userid}/cart"; 
	}
	
}
