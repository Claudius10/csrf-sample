package security.sample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import security.sample.jpa.RoleService;
import security.sample.jpa.UserService;

@SpringBootApplication
public class SecuritySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritySampleApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleService roleService, UserService userService) {
		return args -> {
			if (roleService.findByName("USER").isPresent()) return;
			roleService.create("USER");
			userService.create("user", "password");
		};
	}
}
