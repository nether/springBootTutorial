package jorge.empleados.empleadosweb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Value("${app.helloServiceUrl}")
	private String helloServiceUrl;
	
	@Override
	public String getMensaje() {
		return restTemplate.getForObject(helloServiceUrl, String.class);
	}

}
