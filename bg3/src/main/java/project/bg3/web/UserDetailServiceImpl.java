package project.bg3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.bg3.dto.UserDto;
import project.bg3.model.AppUser;
import project.bg3.model.AppUserRepository;
import project.bg3.validation.AppUserAlreadyExistsAuthenticationException;

//This is for authenticating and authorising users
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final AppUserRepository repository;

	@Autowired
	public UserDetailServiceImpl(AppUserRepository userRepository) {
		this.repository = userRepository;
	}

	public AppUser registerNewUserAccount(UserDto userDto) throws AppUserAlreadyExistsAuthenticationException {
		if (usernameExists(userDto.getUsername())) {
			throw new AppUserAlreadyExistsAuthenticationException(
					"There is an account with that email address: " + userDto.getUsername());
		}

		 AppUser user = new AppUser();
	        user.setUsername(userDto.getUsername());
	        user.setPasswordHash(userDto.getPassword());
	        user.setRole("USER");

	        return user;

	}

	private boolean usernameExists(String username) {
		return repository.findByUsername(username) != null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}