package project.bg3.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.bg3.dto.UserDto;
import project.bg3.model.AppUser;
import project.bg3.model.AppUserRepository;
import project.bg3.validation.AppUserAlreadyExistsAuthenticationException;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private AppUserRepository repository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public AppUser registerNewUserAccount(UserDto userDto) throws AppUserAlreadyExistsAuthenticationException {
        if (usernameExists(userDto.getUsername())) {
            throw new AppUserAlreadyExistsAuthenticationException("There is an account with that email address: "
              + userDto.getUsername());
        }

        AppUser user = new AppUser();
        user.setUsername(userDto.getUsername());
       
        user.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));
        user.setRole("USER");

        return repository.save(user);
    }

    private boolean usernameExists(String username) {
		return repository.findByUsername(username) != null;
	}
}