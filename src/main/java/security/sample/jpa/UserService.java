package security.sample.jpa;

import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.sample.models.Role;
import security.sample.models.User;

@Service
@Transactional
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final RoleService roleService;

	private final PasswordEncoder bCryptEncoder;

	public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder bCryptEncoder) {
		this.userRepository = userRepository;
		this.roleService = roleService;
		this.bCryptEncoder = bCryptEncoder;
	}

	public void create(String username, String password) {
		Role userRole = roleService.findByName("USER").orElseThrow();
		String encodedPassword = bCryptEncoder.encode(password);
		User newUser = new User.Builder()
				.withUsername(username)
				.withPassword(encodedPassword)
				.withRoles(userRole)
				.build();
		userRepository.create(newUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
	}
}
