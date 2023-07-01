package security.sample;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class Service {

	private final AuthenticationManager authManager;

	public Service(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	public void login(LoginDTO login) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
	}
}
