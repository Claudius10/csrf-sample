package security.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.sample.jpa.RoleService;
import security.sample.models.LoginDTO;

@RestController
@RequestMapping("/auth")
public class Controller {

	private final Service service;
	private final RoleService roleService;

	public Controller(RoleService roleService, Service service) {
		this.roleService = roleService;
		this.service = service;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
		service.login(loginDTO);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{role}")
	public ResponseEntity<?> create(@PathVariable String role) {
		roleService.create(role);
		return ResponseEntity.ok().build();
	}
}


