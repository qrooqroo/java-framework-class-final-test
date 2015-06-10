package jejunu.daumkakaotrack.shoppingmall.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jejunu.daumkakaotrack.shoppingmall.model.Product;

@Repository
public interface ProductRepository {

	List<Product> findAll();
	void insert(Product product);
	void delete(int id);
	Product selectOne(int id);
}
