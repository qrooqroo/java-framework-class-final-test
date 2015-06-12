package jejunu.daumkakaotrack.shoppingmall;

import static org.junit.Assert.*;

import java.util.List;

import jejunu.daumkakaotrack.shoppingmall.model.Cart;
import jejunu.daumkakaotrack.shoppingmall.service.CartService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisCartTest extends CommonConfigTest{
	
	@Autowired
	CartService cartService;

	@Test
	public void testGet() {
		String name = "younghwan";
		List<Cart> carts = cartService.getCartListByUserid(name);
		for (int i = 0; i < carts.size(); i++) {
			assertEquals(name, carts.get(0).getUserid());
		}
	}
	
	@Test
	public void testAddDelete(){
		
		String userid = "younghwan";
		int productid = 5;
		int amount = 5;
		
		Cart cart = new Cart();
		cart.setUserid(userid);
		cart.setProductid(productid);
		cart.setAmount(amount);
		
		cartService.addCart(cart);
		
		Cart cart2 = cartService.getCartByInfo(userid, productid); 
		
		assertEquals(userid, cart2.getUserid());
		assertEquals(productid, cart2.getProductid());
		assertEquals(amount, cart2.getAmount());
		
		cartService.deleteCart(userid, productid);
	}
}
