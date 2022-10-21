package jorge.empleados.departamentosrest.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import jorge.empleados.departamentosrest.daos.DptosDAO;
import jorge.empleados.model.Departamento;

@Service
@Primary
public class DepartamentosServiceImpl implements DepartamentosService {
	
	@Autowired
	DptosDAO dao;
	
	@Override
	public List<Departamento> getAllDepartamentos() {				
		return dao.getAllDepartamentos();				
	}
	

}
