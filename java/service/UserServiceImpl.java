package final_blog.final_blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import final_blog.final_blog.entity.User;
import final_blog.final_blog.repo.UserRepository;

public class UserServiceImpl implements UserService {	

		
	//ez itt a dependency injection
	private UserRepository userRepository;
		
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
		
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email); 
	}
	
	
	@Override
	public User findByFullName(String fullName) {
		return userRepository.findByFullName(fullName); 
	}

}