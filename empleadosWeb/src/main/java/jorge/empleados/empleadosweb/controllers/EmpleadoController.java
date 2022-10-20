package jorge.empleados.empleadosweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jorge.empleados.empleadosweb.services.EmpleadoService;
import jorge.empleados.model.Empleado;

/*
 * 	<input type="submit" value="Listar" name="listar"/>
	<input type="submit" value="Mostrar Uno" name="getOne"/>
	<input type="submit" value="Insertar" name="insertar"/>
	<input type="submit" value="Modificar" name="modificar"/>
	<input type="submit" value="Eliminar" name="eliminar"/>
 */


@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
//	@GetMapping
//	public String sayHello(Model model) {
//		//System.out.println("Holaaaaaa");
//		model.addAttribute("listaEmpleados",empleadoService.getEmpleados());
//		return "form-empleados";
//	}
	
	@GetMapping
	public String muestraFormulario(Model model) {
		System.out.println("mostrando form");
		return "form-empleados";
	}
	
	@PostMapping(params= {"listar"})
	public String listarEmpleado(Model model) {
		System.out.println("listado");
		model.addAttribute("listaEmpleados",empleadoService.getEmpleados());
		return "form-empleados";
	}
	
	@PostMapping(params= {"getOne"})
	public String listarUnEmpleado(Model model, @RequestParam String cif) {
		System.out.println("listado de un empleado: " + cif);
		model.addAttribute("empleadoAMostrar",empleadoService.getEmpleado(cif));
		return "form-empleados";
	}
	
	@PostMapping(params= {"eliminar"})
	public String eliminarEmpleado(Model model, @RequestParam String cif) {
		System.out.println("Eliminando empleado: " + cif);
		empleadoService.eliminarEmpleado(cif);
		model.addAttribute("mensaje","Empleado " + cif + " eliminado");
		return "form-empleados";
	}
	
	@PostMapping(params= {"insertar"})
	public String insertarEmpleado(Model model, Empleado empleado) {
		System.out.println("insertando empleado" + empleado.toString());
		//empleadoService.
		empleadoService.insertarEmpleado(empleado);
		model.addAttribute("mensaje", "Empleado " + empleado.toString() + " creado");
		return "form-empleados";
	}
	
	@PostMapping(params= {"modificar"})
	public String modificarEmpleado(Model model, @ModelAttribute Empleado empleado) {
		System.out.println("modificando empleado" + empleado.toString());
		//empleadoService.
		empleadoService.modificarEmpleado(empleado.getCif(), empleado);
		model.addAttribute("mensaje", "Empleado " + empleado.toString() + " modificado");
		return "form-empleados";
	}
}
