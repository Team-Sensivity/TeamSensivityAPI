package team.sensivity.ServerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import team.sensivity.ServerAPI.auth.Roles;
import team.sensivity.ServerAPI.auth.UserAuth;

@SpringBootApplication
public class ServerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApiApplication.class, args);
		UserAuth.initialJWTToken("System", Roles.ADMIN);
	}

}
