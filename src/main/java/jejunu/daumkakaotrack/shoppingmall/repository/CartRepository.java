package jejunu.daumkakaotrack.shoppingmall.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jejunu.daumkakaotrack.shoppingmall.model.Cart;
import jejunu.daumkakaotrack.shoppingmall.model.Product;

@Repository
public interface CartRepository {

	List<Cart> select(String userid);
	void insert(Cart cart);
	void delete(String userid, int productid);
	void update(Cart cart);
	int getCount(String userid, int productid);
	Cart selectOne(String userid, int productid);
}
