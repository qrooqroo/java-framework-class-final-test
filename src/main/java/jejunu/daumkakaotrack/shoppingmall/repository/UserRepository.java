package jejunu.daumkakaotrack.shoppingmall.repository;

import jejunu.daumkakaotrack.shoppingmall.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	public void insertUser(User user);
	public void insertRole(User user);
	public User selectOne(String id);
	
}
