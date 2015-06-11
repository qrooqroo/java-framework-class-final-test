package jejunu.daumkakaotrack.shoppingmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jejunu.daumkakaotrack.shoppingmall.model.Product;

public interface ProductService {

	public void addProduct(Product product);
	public void deleteProduct(int productId);
	public Product findProductById(int productid);
	List<Product> list(int size, int pageno);
	List<Product> list();
	public int getTotalCount();
	public void editProduct(Product product);
}
