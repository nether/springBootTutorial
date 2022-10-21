package jorge.empleados.empleadosweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Primary;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jorge.empleados.exceptions.EmpleadosException;
import jorge.empleados.model.Departamento;
import jorge.empleados.model.Empleado;

@Service
@Primary
@Retryable(exclude = {EmpleadosException.class}, include = {Exception.class})
public class DepartamentoServiceRibbonProgramado implements DepartamentoService {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private LoadBalancerClient lbClient;
	
	@Value("${app.departamentosServiceAlias}")
	private String departamentoServiceAlias;
		
	@Override
	public Departamento[] getDepartamentos() {
		System.out.println("Programmatic Ribbon GET a " + getBaseUrl());
		return getRestTemplate().getForObject(getBaseUrl(), Departamento[].class);		
	}


	private String getBaseUrl() {
		ServiceInstance serviceInstance = 
				lbClient.choose(this.departamentoServiceAlias);		
		return serviceInstance.getUri().toString() + "/departamentos/";
	}
	
	private RestTemplate getRestTemplate() {
		return restTemplateBuilder
				.errorHandler(new EmpleadosResponseErrorHandled())
				.build();
	}
}
