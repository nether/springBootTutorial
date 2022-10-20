package jorge.empleados.empleadosrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmpleadoRest {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "empleados-rest");
		SpringApplication.run(EmpleadoRest.class, args);
	}
}