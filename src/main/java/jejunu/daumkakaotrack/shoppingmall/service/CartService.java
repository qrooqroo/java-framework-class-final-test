package jejunu.daumkakaotrack.shoppingmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jejunu.daumkakaotrack.shoppingmall.model.Cart;
import jejunu.daumkakaotrack.shoppingmall.model.Product;

public interface CartService {

	public List<Cart> getCartListByUserid(String userid);
	public void chageCartAmount(Cart cart);
	public void deleteCart(String userid, int productid);
	public void addCart(Cart cart);
	public Cart getCartByInfo(String userid, int productid);
}
