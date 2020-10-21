package com.springboot.clienteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/index", "/" })
	public String index(Model modelo) {

		modelo.addAttribute("hola", "Hola desde SpringBoot");
		modelo.addAttribute("mensaje", "Este es el inicio de nuestra app");
		return "home";

	}

}
