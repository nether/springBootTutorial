package jorge.empleados.empleadosrest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public Empleado getEmpleado(@PathVariable String cif, HttpServletResponse response)  throws IOException{
		Empleado empleado = empleados.getEmpleado(cif);
		if(empleado==null ) {
			response.sendError(HttpStatus.NOT_FOUND.value());
		}
		return empleado;
	}
	
	@PutMapping(value="/{cif}")
	public Boolean updateEmpleado(@PathVariable String cif, @RequestBody Empleado empleado, HttpServletResponse response) throws IOException {	
		//empleado.setCif(cif);
		if(!empleados.updateEmpleado(cif, empleado)) {
			response.sendError(HttpStatus.NOT_FOUND.value());
		}
		return true;
	}	
	
	@DeleteMapping(value="/{cif}")
	public Boolean deleteEmpleado(@PathVariable String cif, HttpServletResponse response) throws IOException {		
		return empleados.deleteEmpleado(cif);
	}
	
	@PostMapping(value="/")
	public Boolean insertaEmpleado(@RequestBody Empleado empleado, HttpServletResponse response) throws IOException {
		if(!empleados.insertaEmpleado(empleado)) {
			response.sendError(HttpStatus.CONFLICT.value());
		}
		response.setStatus(HttpStatus.CREATED.value());
		return true;
	}
}
