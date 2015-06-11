package jejunu.daumkakaotrack.shoppingmall.service;

import jejunu.daumkakaotrack.shoppingmall.model.User;
import jejunu.daumkakaotrack.shoppingmall.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void createUser(User user) {
		userRepository.insertUser(user);
		userRepository.insertRole(user);
	}

	@Override
	public User findById(String id) {
		return userRepository.selectOne(id);
	}

}
