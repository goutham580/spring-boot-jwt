package ezc.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ezc.config.EzPasswordEncoder;
import ezc.dao.EzUserDao;
import ezc.model.EzcUsers;
import ezc.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EzUserDao ezUserDao;

	/*
	 * @Autowired private PasswordEncoder bcryptEncoder;
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<EzcUsers> userOpt = ezUserDao.findById(username);
		if (!userOpt.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(userOpt.get().getEuId(), userOpt.get().getEuPassword(),
				new ArrayList<>());
	}
	
	public EzcUsers save(UserDTO user) {
		EzcUsers newUser = new EzcUsers();
		newUser.setEuId(user.getUsername());
		newUser.setEuPassword(new EzPasswordEncoder().encode(user.getPassword()));
		return ezUserDao.save(newUser);
	}
}