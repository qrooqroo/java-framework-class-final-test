package jejunu.daumkakaotrack.shoppingmall;

import static org.junit.Assert.*;

import java.util.Random;

import jejunu.daumkakaotrack.shoppingmall.model.User;
import jejunu.daumkakaotrack.shoppingmall.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisUserTest extends CommonConfigTest{
	
	@Autowired
	UserService userService;
	
	@Test
	public void testFindById(){
		User user = userService.findById("younghwan");
		assertEquals("younghwan", user.getPassword());
	}
	
	@Test
	public void testCreateUser(){
		String randomString = (new Random().longs(10)).toString();
		
		User user = new User();
		user.setId(randomString);
		user.setPassword(randomString);
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		
		userService.createUser(user);
		User user2 = userService.findById(randomString);
		assertEquals(randomString, user.getPassword());
	}
	
}
