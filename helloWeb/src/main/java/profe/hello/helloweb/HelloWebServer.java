package profe.hello.helloweb;

import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWebServer {

	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "hello-web");
		SpringApplication.run(HelloWebServer.class, args);
	}
	
}