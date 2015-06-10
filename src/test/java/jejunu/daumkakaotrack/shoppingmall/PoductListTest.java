package jejunu.daumkakaotrack.shoppingmall;

import java.util.List;

import jejunu.daumkakaotrack.shoppingmall.model.Product;
import jejunu.daumkakaotrack.shoppingmall.service.ProductService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-security.xml",
						"file:src/main/webapp/WEB-INF/servlet-context.xml",
						"file:src/main/webapp/WEB-INF/repository.xml"})
@WebAppConfiguration
public class PoductListTest {

	@Autowired
	ProductService productService;
	
	@Autowired
	WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		DelegatingFilterProxy securityFilter = new DelegatingFilterProxy();
		securityFilter.setTargetBeanName("springSecurityFilterChain");
		securityFilter.setServletContext(context.getServletContext());
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.addFilter(securityFilter, "/*")
				.build();
	}
	
	@Test
	public void testHomeLoading() throws Exception {
		
		List<Product> list = productService.list();
		mockMvc.perform(get("/").flashAttr("list", list))
								.andExpect(status().isOk());
	}

}
