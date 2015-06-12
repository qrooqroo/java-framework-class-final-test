package jejunu.daumkakaotrack.shoppingmall.service;

import java.util.List;

import jejunu.daumkakaotrack.shoppingmall.model.Cart;
import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.repository.CartRepository;
import jejunu.daumkakaotrack.shoppingmall.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;

	@Override
	public List<Cart> getCartListByUserid(String userid) {
		return cartRepository.select(userid);
	}

	@Override
	public void chageCartAmount(Cart cart) {
		cartRepository.update(cart);
	}

	@Override
	public void deleteCart(String userid, int productid) {
		cartRepository.delete(userid, productid);
	}

	@Override
	public void addCart(Cart cart) {
		
		String userid = cart.getUserid();
		int productid = cart.getProductid();
		int amount = cartRepository.getCount(userid, productid);
		if(amount==0){
			cartRepository.insert(cart);
		}else{
			int sum = amount + cart.getAmount();
			cart.setAmount(sum);
			cartRepository.update(cart);
		}
	}

	@Override
	public Cart getCartByInfo(String userid, int productid) {
		return cartRepository.selectOne(userid, productid);
	}
}
