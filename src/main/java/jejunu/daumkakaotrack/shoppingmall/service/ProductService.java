package jejunu.daumkakaotrack.shoppingmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jejunu.daumkakaotrack.shoppingmall.model.Product;

public interface ProductService {

	List<Product> list();
	public void addProduct(Product product);
	public void deleteProduct(int productId);
	public Product getProductById(int productId);
}
