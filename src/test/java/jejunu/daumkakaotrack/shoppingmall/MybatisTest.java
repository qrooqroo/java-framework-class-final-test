package jejunu.daumkakaotrack.shoppingmall;

import static org.junit.Assert.*;

import java.util.List;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/servlet-context.xml",
								"file:src/main/webapp/WEB-INF/repository.xml"})
public class MybatisTest {
	
	@Autowired
	ProductService productService;
	
	@Test
	public void testGetProductList() throws Exception {
		List<Product> list = productService.list();
		assertNotNull(list);
	}
}
