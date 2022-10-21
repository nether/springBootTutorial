package jorge.empleados.departamentosrest.negocio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import jorge.empleados.departamentosrest.daos.DptosDAO;
import jorge.empleados.departamentosrest.services.EmpleadoService;
import jorge.empleados.model.Departamento;
import jorge.empleados.model.Empleado;

@Service
@Primary
public class DepartamentosServiceImpl implements DepartamentosService {
	
	@Autowired
	DptosDAO dao;
	
	@Autowired
	EmpleadoService service;
	
	
//	public List<Departamento> getAllDepartamentosSlow() {				
//		List<Departamento> dptos = dao.getAllDepartamentos();
//		for(Departamento dpto : dptos) {
//			for(Empleado emp : dpto.getEmpleados()) {
//				Empleado empAux = service.getEmpleado(emp.getCif());
//				emp.setNombre(empAux.getNombre());
//				emp.setApellidos(empAux.getApellidos());
//				emp.setEdad(empAux.getEdad());
//			}
//		}			
//		return dptos;
// }
	
	@Override
	public List<Departamento> getAllDepartamentos() {		
		List<Departamento> dptos = dao.getAllDepartamentos();
		// Recupero todos los empleados del servicio
		HashMap<String, Empleado> empleadosMap = 
				(HashMap<String, Empleado>) Arrays.asList(service.getEmpleados())
				.stream().collect(Collectors.toMap(Empleado::getCif, Function.identity())); 

		// Recupero empleados_departamentos
		dptos.forEach(dpto -> {
			List<Empleado> empleados = dpto
					.getEmpleados()
					.stream().map(Empleado::getCif)
					.map(cif -> empleadosMap.get(cif)).collect(Collectors.toList());
			dpto.setEmpleados(empleados);
		});
		return dptos;
	}	
}
