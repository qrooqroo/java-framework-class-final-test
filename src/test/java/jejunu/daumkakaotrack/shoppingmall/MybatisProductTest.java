package jejunu.daumkakaotrack.shoppingmall;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.service.ProductService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class MybatisProductTest extends CommonConfigTest{
	
	@Autowired
	ProductService productService;
	
	@Test
	public void testGetProductList(){
		List<Product> list = productService.list();
		assertNotNull(list);
	}
	
	@Test
	public void testGetOneProduct(){
		
		Product product = productService.findProductById(1);
		assertEquals(product.getTitle(), "product1");
	}
	
	@Test
	public void testAddDeleteProduct(){
		
		String title = (new Random().doubles(20)).toString();
		
		Product product = new  Product();
		product.setTitle(title);
		product.setPrice(10000);
		product.setSeller("권영환");
		product.setComment("comment about " + title);
		
		productService.addProduct(product);
		
		List<Product> productList = productService.list();
		int lastIndex = productList.size()-1;
		product = productList.get(lastIndex);
		int id = product.getId();
		String title2 = product.getTitle();
		assertEquals(title, title2); // assert add
		
		productService.deleteProduct(id);
		
		productList = productService.list();
		lastIndex = productList.size()-1;
		product = productList.get(lastIndex);
		int id2 = product.getId();
		
		assertNotEquals(id, id2); // assert delete
	}
	
	@Test
	public void testRangeSelectProduct(){
		int pageno = 3;
		int size = 10;
		List<Product> list = productService.list(pageno, size);
		assertEquals(10, list.size());
		for (Product product : list) {
			System.out.println(product.getTitle());
		}
	}
	
	@Test
	public void testTotalProductCout(){
		int totalCount = productService.getTotalCount();
		System.out.println(totalCount);
		assertNotNull(totalCount);
	}
	
	@Test
	public void testUpdateProduct(){
		
		Product product = productService.findProductById(1);
		assertEquals(product.getTitle(), "product1");
		
		int price = 200000;
		String title = "product2";
		
		product.setPrice(price);
		product.setTitle(title);
		
		productService.editProduct(product);
		
		product = productService.findProductById(1);
	
		assertTrue(price == product.getPrice());
		assertEquals(title, product.getTitle());
		
		product.setTitle("product1");
		product.setPrice(100000);
		
		productService.editProduct(product);
		
	}
}
