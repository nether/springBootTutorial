package jorge.empleados.departamentosrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartamentoRest {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "departamentos-rest");
		SpringApplication.run(DepartamentoRest.class, args);
	}
}