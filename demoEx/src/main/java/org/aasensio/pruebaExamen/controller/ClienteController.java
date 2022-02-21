package org.aasensio.pruebaExamen.controller;

import java.util.List;

import org.aasensio.pruebaExamen.entity.Cliente;
import org.aasensio.pruebaExamen.entity.Localidad;
import org.aasensio.pruebaExamen.exception.DangerException;
import org.aasensio.pruebaExamen.exception.PRG;
import org.aasensio.pruebaExamen.repository.ClienteRepository;
import org.aasensio.pruebaExamen.repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private LocalidadRepository localidadRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("r")
	public String r(ModelMap m) {
		List<Cliente> clientes = clienteRepository.findAll();
		m.put("clientes", clientes);
		m.put("view", "cliente/r");
		return "_t/frame";
		
	}
	@GetMapping("c")
	public String c(ModelMap m) {
		List<Localidad> localidades = localidadRepository.findAll();
		m.put("localidades", localidades);
		m.put("view", "cliente/c");
		return "_t/frame";
	}
	@PostMapping("c")
	public String cPost(
			@RequestParam(value="nombre",required = true) String nombre,
			@RequestParam(value="localidad",required = true) Long idLocalidad
			) throws DangerException {
		try {
		Cliente cliente = new Cliente(nombre,localidadRepository.getById(idLocalidad));
		clienteRepository.save(cliente);
		}
		catch(Exception e) {
			PRG.error("Error creando cliente");
		}
		return "redirect:/cliente/r";
	}
}
