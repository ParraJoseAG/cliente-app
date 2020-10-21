package com.springboot.clienteapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.clienteapp.models.entity.Ciudad;
import com.springboot.clienteapp.models.entity.Cliente;
import com.springboot.clienteapp.models.service.ICiudadService;
import com.springboot.clienteapp.models.service.IClienteService;

@Controller
@RequestMapping("/views/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clientesService;
	@Autowired
	private ICiudadService ciudadService;

	@GetMapping("/listar")
	public String listar(Model modelo) {

		List<Cliente> listaDeClientes = clientesService.listarTodo();

		modelo.addAttribute("titulo", "Lista de Potenciales Clientes");
		modelo.addAttribute("futurosClientes", listaDeClientes);

		return "/views/clientes/listar";
	}

	@GetMapping("/registrar")
	public String registrar(Model modelo) {

		Cliente cliente = new Cliente();
		List<Ciudad> listaCiudades = ciudadService.listaCiudades();

		modelo.addAttribute("titulo", "Formulario: Nuevo Cliente");
		modelo.addAttribute("cliente", cliente);
		modelo.addAttribute("ciudades", listaCiudades);
		return "/views/clientes/formularioRegistro";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model modelo,
			RedirectAttributes attribute) {
		List<Ciudad> listaCiudades = ciudadService.listaCiudades();

		if (result.hasErrors()) {

			modelo.addAttribute("titulo", "Formulario: Nuevo Cliente");
			modelo.addAttribute("cliente", cliente);
			modelo.addAttribute("ciudades", listaCiudades);
			return "/views/clientes/formularioRegistro";

		} else {
			clientesService.guardarCliente(cliente);
			attribute.addFlashAttribute("success", "Cliente guardado con éxito!");
			return "redirect:/views/clientes/listar";
		}

	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer idCliente, Model modelo, RedirectAttributes attribute) {

		Cliente cliente = null;
		if (idCliente > 0) {
			cliente = clientesService.buscarPorId(idCliente);

			if (cliente == null) {

				attribute.addFlashAttribute("error", "ATENCIÓN: el ID del Cliente no existe!");
				return "redirect:/views/clientes/listar";
			}
		} else {
			attribute.addFlashAttribute("error", "ATENCIÓN: Error con el ID del Cliente!");
			return "redirect:/views/clientes/listar";
		}

		List<Ciudad> listaCiudades = ciudadService.listaCiudades();

		modelo.addAttribute("titulo",
				"Formulario: Editando al cliente " + cliente.getNombres() + " " + cliente.getApellidos());
		modelo.addAttribute("cliente", cliente);
		modelo.addAttribute("ciudades", listaCiudades);
		return "/views/clientes/formularioRegistro";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer idCliente, RedirectAttributes attribute) {
		Cliente cliente = null;
		if (idCliente > 0) {
			cliente = clientesService.buscarPorId(idCliente);

			if (cliente == null) {
				attribute.addFlashAttribute("error", "ATENCIÓN: el ID del Cliente no existe!");
				return "redirect:/views/clientes/listar";
			}
		} else {
			attribute.addFlashAttribute("error", "ATENCIÓN: Error con el ID del Cliente!");
			return "redirect:/views/clientes/listar";
		}
		clientesService.eliminar(idCliente);
		attribute.addFlashAttribute("warning", "Registro eliminado con éxito!");
		return "redirect:/views/clientes/listar";
	}

	// ..........................................................................................
	@ModelAttribute("generoLista")
	public List<String> listadoGenero() {

		List<String> listaGenero = new ArrayList<String>();
		listaGenero.add("FEMENINO");
		listaGenero.add("MASCULINO");

		return listaGenero;

	}

	// ..........................................................................................
	@ModelAttribute("paisLista")
	public List<String> listadoPaises() {

		List<String> listaPaises = new ArrayList<String>();
		listaPaises.add("CHILE");
		listaPaises.add("MÉXICO");
		listaPaises.add("COLOMBIA");
		listaPaises.add("BOLIVIA");
		listaPaises.add("ESPAÑA");
		listaPaises.add("ARGENTINA");
		listaPaises.add("VENEZUELA");
		listaPaises.add("OTRO");

		return listaPaises;

	}

	// .........................................................................................
	@ModelAttribute("hobbiesLista")
	public List<String> hobbiesPaises() {

		List<String> hobbiesPaises = new ArrayList<String>();
		hobbiesPaises.add("LIBROS");
		hobbiesPaises.add("DEPORTES");
		hobbiesPaises.add("PELÍCULAS");
		hobbiesPaises.add("VIDEO JUEGOS");
		hobbiesPaises.add("OTROS");

		return hobbiesPaises;

	}

}
