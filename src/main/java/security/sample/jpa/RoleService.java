package security.sample.jpa;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import security.sample.models.Role;

import java.util.Optional;

@Service
@Transactional
public class RoleService {

	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public void create(String roleName) {
		roleRepository.create(new Role(roleName));
	}

	public Optional<Role> findByName(String roleName) {
		return roleRepository.findByName(roleName);
	}
}
