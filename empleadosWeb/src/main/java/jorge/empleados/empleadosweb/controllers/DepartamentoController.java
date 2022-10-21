package jorge.empleados.empleadosweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jorge.empleados.empleadosweb.services.DepartamentoService;

/*
 * 	<input type="submit" value="Listar" name="listar"/>
	<input type="submit" value="Mostrar Uno" name="getOne"/>
	<input type="submit" value="Insertar" name="insertar"/>
	<input type="submit" value="Modificar" name="modificar"/>
	<input type="submit" value="Eliminar" name="eliminar"/>
 */


@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	
//	@GetMapping
//	public String sayHello(Model model) {
//		//System.out.println("Holaaaaaa");
//		model.addAttribute("listaEmpleados",empleadoService.getEmpleados());
//		return "form-empleados";
//	}
	
	@GetMapping
	public String muestraFormulario(Model model) {
		System.out.println("listado");
		model.addAttribute("listaDepartamentos",service.getDepartamentos());
		return "form-departamentos";
	}
	
	
}
