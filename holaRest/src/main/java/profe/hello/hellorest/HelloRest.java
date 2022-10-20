package profe.hello.hellorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/saluda")
public class HelloRest {

	public static void main(String[] args) {
//		System.setProperty("spring.config.name", "empleados-web-server");
		SpringApplication.run(HelloRest.class, args);
	}

	@GetMapping
	public String sayHello() {
		return "¡¡¡Hola Campeón!!!";
	}
}