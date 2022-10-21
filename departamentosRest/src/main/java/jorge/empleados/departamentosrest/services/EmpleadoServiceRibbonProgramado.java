package jorge.empleados.departamentosrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import jorge.empleados.model.Empleado;

@Service
@Primary
public class EmpleadoServiceRibbonProgramado implements EmpleadoService {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private LoadBalancerClient lbClient;
	
	@Value("${app.empleadosServiceAlias}")
	private String empleadoServiceAlias;
		
	@Override
	public Empleado getEmpleado(String cif) {
		String getEmpleadoPath = getBaseUrl() + cif;
		System.out.println("Programmatic Ribbon GET a " + getEmpleadoPath);
		return getRestTemplate().getForObject(getEmpleadoPath, Empleado.class);		
	}

	@Override
	public Empleado[] getEmpleados() {
		System.out.println("Programmatic Ribbon GET a " + getBaseUrl());
		return getRestTemplate().getForObject(getBaseUrl(), Empleado[].class);		
	}

	@Override
	public void insertarEmpleado(Empleado empleado) {
		System.out.println("Programmatic Ribbon POST a " + getBaseUrl());
		getRestTemplate().postForLocation(getBaseUrl(), empleado);		
	}
	

	@Override
	public void modificarEmpleado(String cif, Empleado empleado) {
		String putEmpleadoPath = getBaseUrl() + cif;
		System.out.println("Programmatic Ribbon PUT a " + putEmpleadoPath);
		getRestTemplate().put(putEmpleadoPath, empleado);		
	}
	
	@Override
	public void eliminarEmpleado(@RequestParam String cif) {
		String deleteEmpleadoPath = getBaseUrl() + cif;
		System.out.println("Programmatic Ribbon DELETE a " + deleteEmpleadoPath);
		getRestTemplate().delete(deleteEmpleadoPath);
		return;
	}
	
	private String getBaseUrl() {
		ServiceInstance serviceInstance = 
				lbClient.choose(this.empleadoServiceAlias);		
		return serviceInstance.getUri().toString() + "/empleados/";
	}
	
	private RestTemplate getRestTemplate() {
		return restTemplateBuilder
				.errorHandler(new EmpleadosResponseErrorHandled())
				.build();
	}
}
