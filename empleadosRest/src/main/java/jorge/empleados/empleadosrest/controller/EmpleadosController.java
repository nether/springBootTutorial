package jorge.empleados.empleadosrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jorge.empleados.empleadosrest.negocio.EmpleadosService;
import jorge.empleados.model.Empleado;

/*
 * 		- GET /empleados/: devuelve todos los empleados
		- GET /empleados/x: devuelve el empleado con cif x
		- PUT /empleados/x: modifica un empleado (sólo admin)
		- DELETE /empleados/x: elimina el empleado con cif x (sólo admin)
		- POST /empleados/: inserta un empleado (sólo admin)
 */



@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

	@Autowired
	private EmpleadosService empleados;
	
	@GetMapping
	public List<Empleado> getEmpleados() {
		return empleados.getEmpleados();		
	}	
	
	@GetMapping(value="/{cif}")
	public Empleado getEmpleado(@PathVariable String cif) {
		return empleados.getEmpleado(cif);
	}
	
	@PutMapping(value="/{cif}")
	public Boolean updateEmpleado(@PathVariable String cif, @RequestBody Empleado empleado) {	
		//empleado.setCif(cif);
		return empleados.updateEmpleado(cif, empleado);
	}	
	
	@DeleteMapping(value="/{cif}")
	public Boolean deleteEmpleado(@PathVariable String cif) {		
		return empleados.deleteEmpleado(cif);
	}
	
	@PostMapping(value="/")
	public Boolean insertaEmpleado(@RequestBody Empleado empleado) {		
		return empleados.insertaEmpleado(empleado);
	}
}
