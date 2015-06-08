package jejunu.daumkakaotrack.shoppingmall;

import static org.junit.Assert.*;

import java.util.List;

import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.repository.ProductRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductTest {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void ProductRepositoryTest() {
		List<Product> list = productRepository.findAll();
		assertNotNull(productRepository);
	}

}
