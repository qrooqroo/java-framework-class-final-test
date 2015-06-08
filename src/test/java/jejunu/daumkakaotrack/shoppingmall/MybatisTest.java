package jejunu.daumkakaotrack.shoppingmall;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.service.ProductService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/servlet-context.xml")
public class MybatisTest {

	@Autowired
	ProductService productService;
	
	@Test
	public void getProductListTest() throws Exception {
		
		List<Product> list = productService.list();
		assertNotNull(list);
	}
}
