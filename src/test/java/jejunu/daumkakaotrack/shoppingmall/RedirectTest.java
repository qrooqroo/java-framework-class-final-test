package jejunu.daumkakaotrack.shoppingmall;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

public class RedirectTest extends CommonConfigTest{
	
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
	public void testLogin() throws Exception{
		
		mockMvc.perform(post("/j_spring_security_check")
						.param("j_username", "younghwan")
						.param("j_password", "younghwan")
						.with(csrf()))
				.andExpect(redirectedUrl("/"));
	}
	
	@Test
	public void testAddProduct() throws Exception{
		
		mockMvc.perform(post("/product/register/process")
						.param("title", "product test")
						.param("price", "2000")
						.param("comment", "comment")
						.with(csrf()))
				.andExpect(redirectedUrl("/?message=%3F%3F%3F+%3F%3F%3F%3F%3F%3F%3F."));
	}
}
