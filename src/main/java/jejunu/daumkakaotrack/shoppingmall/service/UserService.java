package jejunu.daumkakaotrack.shoppingmall.service;

import jejunu.daumkakaotrack.shoppingmall.model.User;

public interface UserService {

	void createUser(User user);
	User findById(String id);
}
