package security.sample;

import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import security.sample.models.LoginDTO;


@org.springframework.stereotype.Service
@Transactional
public class Service {

	private final AuthenticationManager authManager;

	public Service(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	public void login(LoginDTO login) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
	}
}
