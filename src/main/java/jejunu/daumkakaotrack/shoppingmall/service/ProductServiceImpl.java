package jejunu.daumkakaotrack.shoppingmall.service;

import java.util.List;

import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> list() {
		return productRepository.findAll();
	}

	@Override
	public void addProduct(Product product) {
		productRepository.insert(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.delete(productId);
	}

	@Override
	public Product getProductById(int productId) {
		return productRepository.selectOne(productId);
	}

}
