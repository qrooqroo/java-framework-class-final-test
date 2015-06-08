package jejunu.daumkakaotrack.shoppingmall.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jejunu.daumkakaotrack.shoppingmall.model.Product;

@Repository
public interface ProductRepository {

	List<Product> findAll();

}
