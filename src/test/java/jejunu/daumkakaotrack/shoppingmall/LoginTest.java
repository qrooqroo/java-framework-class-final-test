package jejunu.daumkakaotrack.shoppingmall;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-security.xml",
						"file:src/main/webapp/WEB-INF/servlet-context.xml",
						"file:src/main/webapp/WEB-INF/repository.xml"})
@WebAppConfiguration
public class LoginTest {
	
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
		
		mockMvc.perform(post("/shoppingmall/j_spring_security_check").with(csrf())
						.param("j_username", "younghwan")
						.param("j_password", "younghwan"))
				.andExpect(status().isOk());
	}
}
