package profe.hello.helloweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import profe.hello.helloweb.services.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping
	public String sayHello(Model model) {
		//System.out.println("Holaaaaaa");
		model.addAttribute("mensaje",empleadoService.getEmpleado(0));
		return "muestra-empleado";
	}
}
