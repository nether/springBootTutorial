package profe.hello.helloweb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {


	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Value("${app.empleadoServiceUrl}")
	private String empleadoServiceUrl;
	
	@Override
	public String getEmpleado(int i) {
		return restTemplate.getForObject(empleadoServiceUrl, String.class);
	}
}
