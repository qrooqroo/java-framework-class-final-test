package jejunu.daumkakaotrack.shoppingmall;


import jejunu.daumkakaotrack.shoppingmall.service.ProductService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class PageLoadingTest extends CommonConfigTest{

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
		
		String message = "message";
		mockMvc.perform(get("/").param("message", message))
								.andExpect(status().isOk())
								.andExpect(model().attributeExists("message"))
								.andExpect(model().attributeExists("list"));
	}
	
	@Test
	public void testAddProductLoading() throws Exception{
		
		mockMvc.perform(get("/product/register"))
				.andExpect(status().isOk())
				.andExpect(view().name("addProduct"));
	}
	
	
	@Test
	public void testDeniedLoading() throws Exception{
		mockMvc.perform(get("/denied"))
				.andExpect(status().isOk())
				.andExpect(view().name("denied"));
	}
	
	@Test
	public void testLoginLoading() throws Exception{
		mockMvc.perform(get("/login"))
				.andExpect(status().isOk())
				.andExpect(view().name("login"));
	}
	
	@Test
	public void testSignUpLoading() throws Exception{
		mockMvc.perform(get("/signup"))
				.andExpect(status().isOk())
				.andExpect(view().name("signup"));
	}
	
	@Test
	@WithMockUser
	public void testMypageLoading() throws Exception{
		mockMvc.perform(get("/mypage"))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username="admin",roles={"USER","ADMIN"})
	public void testAdminLoading() throws Exception{

		mockMvc.perform(get("/admin"))
				.andExpect(status().isOk());
	}
}
