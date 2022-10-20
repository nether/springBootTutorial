package jorge.empleados.empleadosweb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import jorge.empleados.model.Empleado;

@Service
public class EmpleadoServiceStatic implements EmpleadoService {


	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Value("${app.empleadosServiceUrl}")
	private String empleadoServiceUrl;
	
	@Override
	public Empleado getEmpleado(String cif) {
		String getEmpleadoPath = empleadoServiceUrl + cif;
		System.out.println("GET a " + getEmpleadoPath);
		return restTemplate.getForObject(getEmpleadoPath, Empleado.class);		
	}

	@Override
	public Empleado[] getEmpleados() {
		System.out.println("GET a " + empleadoServiceUrl);
		return restTemplate.getForObject(empleadoServiceUrl, Empleado[].class);		
	}

	@Override
	public void insertarEmpleado(Empleado empleado) {
		System.out.println("POST a " + empleadoServiceUrl);
		restTemplate.postForLocation(empleadoServiceUrl, empleado);		
	}
	

	@Override
	public void modificarEmpleado(String cif, Empleado empleado) {
		String putEmpleadoPath = empleadoServiceUrl + cif;
		System.out.println("PUT a " + putEmpleadoPath);
		restTemplate.put(putEmpleadoPath, empleado);		
	}
	
	@Override
	public void eliminarEmpleado(@RequestParam String cif) {
		String deleteEmpleadoPath = empleadoServiceUrl + cif;
		System.out.println("DELETE a " + deleteEmpleadoPath);
		restTemplate.delete(deleteEmpleadoPath);
		return;
	}
}
