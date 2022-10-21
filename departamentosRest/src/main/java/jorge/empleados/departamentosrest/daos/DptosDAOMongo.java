package jorge.empleados.departamentosrest.daos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jorge.empleados.model.Departamento;
import jorge.empleados.model.Empleado;

@Repository
@Primary
public class DptosDAOMongo implements DptosDAO {

	@Autowired
	private DptosMongoRepository repository;
	
	@Override
	public List<Departamento> getAllDepartamentos() {
		return repository.findAll();
	}
	
	@Override
	public List<String> getEmpleadosXDpto(String idDpto) {
		return repository.findById(idDpto).get().getEmpleados().stream()
				.map(Empleado::getCif).collect(Collectors.toList());
	}

}
