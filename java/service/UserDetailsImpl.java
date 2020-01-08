package final_blog.final_blog.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import final_blog.final_blog.entity.Role;
import final_blog.final_blog.entity.User;
import final_blog.final_blog.repo.UserRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {
		
	@Autowired
	private UserRepository userRepo;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		User user = userRepo.findByFullName(username);
		
		if (user == null) throw new UsernameNotFoundException(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getFullName(), user.getPassword(), grantedAuthorities);
	}
	

}