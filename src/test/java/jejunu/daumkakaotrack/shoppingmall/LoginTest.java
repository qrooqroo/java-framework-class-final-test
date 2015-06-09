package jejunu.daumkakaotrack.shoppingmall;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-security.xml",
						"file:src/main/webapp/WEB-INF/servlet-context.xml",
						"file:src/main/webapp/WEB-INF/repository.xml"})
@WebAppConfiguration
public class LoginTest {

	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testLogin(){
		Assert.assertEquals(1, 1);
	}
}
