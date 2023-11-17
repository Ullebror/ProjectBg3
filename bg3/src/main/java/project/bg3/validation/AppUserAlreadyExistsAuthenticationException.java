package project.bg3.validation;

import org.springframework.security.core.AuthenticationException;

public class AppUserAlreadyExistsAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public AppUserAlreadyExistsAuthenticationException(String msg) {
		super(msg);
	}


}