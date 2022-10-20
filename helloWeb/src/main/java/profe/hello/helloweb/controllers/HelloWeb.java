package profe.hello.helloweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import profe.hello.helloweb.services.HelloService;

@Controller
@RequestMapping("/saludaweb")
public class HelloWeb {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping
	public String sayHello(Model model) {
		//System.out.println("Holaaaaaa");
		model.addAttribute("mensaje",helloService.getMensaje());
		return "muestra-mensaje";
	}
}