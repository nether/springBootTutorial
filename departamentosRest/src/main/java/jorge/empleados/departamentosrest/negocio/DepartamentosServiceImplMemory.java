package jorge.empleados.departamentosrest.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jorge.empleados.departamentosrest.daos.DptosDAO;
import jorge.empleados.model.Departamento;

@Service
public class DepartamentosServiceImplMemory implements DepartamentosService {
		
	@Override
	public List<Departamento> getAllDepartamentos() {
		List<Departamento> dptos = new ArrayList<>();
		dptos.add(new Departamento("RRHH", "Recursos Humanos"));
		dptos.add(new Departamento("I+D", "Investigación y Desarrollo"));
		return dptos;				
	}
	

}
