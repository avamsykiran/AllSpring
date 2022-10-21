package in.tp.sbcrud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.tp.sbcrud.dao.AppUserEntityRepository;
import in.tp.sbcrud.model.AppUserModel;
import in.tp.sbcrud.model.AppUserEntity;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserEntityRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUserEntity user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(),
				new ArrayList<>());
	}
	
	public AppUserEntity save(AppUserModel userDTO) {
		AppUserEntity user = new AppUserEntity();
		user.setUsername(userDTO.getUsername());
		user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		return userDao.save(user);
	}

}