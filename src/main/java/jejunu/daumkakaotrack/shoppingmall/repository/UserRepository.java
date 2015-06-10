package jejunu.daumkakaotrack.shoppingmall.repository;

import jejunu.daumkakaotrack.shoppingmall.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	public User getUserByUsername();
}
