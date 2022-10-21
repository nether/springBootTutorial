package jorge.empleados.departamentosrest.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jorge.empleados.model.Departamento;

@Repository
@Primary
public class DptosDAOMongo implements DptosDAO {

	@Autowired
	private DptosMongoRepository repository;
	
	@Override
	public List<Departamento> getAllDepartamentos() {
		return repository.findAll();
	}

}
