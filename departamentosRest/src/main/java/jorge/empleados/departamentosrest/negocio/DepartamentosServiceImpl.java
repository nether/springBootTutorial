package jorge.empleados.departamentosrest.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jorge.empleados.model.Departamento;

@Service
public class DepartamentosServiceImpl implements DepartamentosService {
	
	@Override
	public List<Departamento> getDepartamentos() {
		List<Departamento> dptos = new ArrayList<>();
		dptos.add(new Departamento("RRHH", "Recursos Humanos"));
		dptos.add(new Departamento("I+D", "Investigación y Desarrollo"));
		return dptos;
	}
	

}
