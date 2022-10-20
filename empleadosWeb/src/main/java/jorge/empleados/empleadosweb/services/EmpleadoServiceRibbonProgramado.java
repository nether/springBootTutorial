package jorge.empleados.empleadosweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import jorge.empleados.model.Empleado;

@Service
public class EmpleadoServiceRibbonProgramado implements EmpleadoService {


	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private LoadBalancerClient lbClient;
	
	@Value("${app.empleadosServiceAlias}")
	private String empleadoServiceAlias;
		
	@Override
	public Empleado getEmpleado(String cif) {
		String getEmpleadoPath = getBaseUrl() + cif;
		System.out.println("Programmatic Ribbon GET a " + getEmpleadoPath);
		return restTemplate.getForObject(getEmpleadoPath, Empleado.class);		
	}

	@Override
	public Empleado[] getEmpleados() {
		System.out.println("Programmatic Ribbon GET a " + getBaseUrl());
		return restTemplate.getForObject(getBaseUrl(), Empleado[].class);		
	}

	@Override
	public void insertarEmpleado(Empleado empleado) {
		System.out.println("Programmatic Ribbon POST a " + getBaseUrl());
		restTemplate.postForLocation(getBaseUrl(), empleado);		
	}
	

	@Override
	public void modificarEmpleado(String cif, Empleado empleado) {
		String putEmpleadoPath = getBaseUrl() + cif;
		System.out.println("Programmatic Ribbon PUT a " + putEmpleadoPath);
		restTemplate.put(putEmpleadoPath, empleado);		
	}
	
	@Override
	public void eliminarEmpleado(@RequestParam String cif) {
		String deleteEmpleadoPath = getBaseUrl() + cif;
		System.out.println("Programmatic Ribbon DELETE a " + deleteEmpleadoPath);
		restTemplate.delete(deleteEmpleadoPath);
		return;
	}
	
	private String getBaseUrl() {
		ServiceInstance serviceInstance = 
				lbClient.choose(this.empleadoServiceAlias);		
		return serviceInstance.getUri().toString() + "/empleados/";
	}
}
