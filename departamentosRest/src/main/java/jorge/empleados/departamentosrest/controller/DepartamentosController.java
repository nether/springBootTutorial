package jorge.empleados.departamentosrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jorge.empleados.departamentosrest.negocio.DepartamentosService;
import jorge.empleados.model.Departamento;


@RestController
@RequestMapping("/departamentos")
public class DepartamentosController {

	@Autowired
	private DepartamentosService departamentos;
	
	@GetMapping
	public List<Departamento> getEmpleados() {
		return departamentos.getDepartamentos();		
	}	
	
	
}
