package jorge.empleados.empleadosweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class EmpleadosWebServer {

	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "empleado-web");
		SpringApplication.run(EmpleadosWebServer.class, args);
	}
	
	@Bean //El resultado de este método lo guarda en el contenedor
	@LoadBalanced //Recubre el objeto devuelto con código de balanceo de carga de Ribbon
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}