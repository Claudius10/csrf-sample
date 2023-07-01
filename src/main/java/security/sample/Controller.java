package security.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Controller {

	private final Service service;

	public Controller(Service service) {
		this.service = service;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
		service.login(loginDTO);
		return ResponseEntity.ok().body("Authenticated");
	}

	@PostMapping("/post")
	public ResponseEntity<?> create() {
		return ResponseEntity.ok().body("POST Mapping accessed");
	}
}


