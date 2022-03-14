package org.aasensio.exP.controller;

import java.util.ArrayList;
import java.util.List;

import org.aasensio.exP.entity.Coche;
import org.aasensio.exP.entity.Persona;
import org.aasensio.exP.exception.DangerException;
import org.aasensio.exP.exception.PRG;
import org.aasensio.exP.repository.CocheRepository;
import org.aasensio.exP.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private CocheRepository cocheRepository;

	@GetMapping("r")
	public String r(ModelMap m) {
		List<Persona> personas = personaRepository.findAll();
		m.put("personas", personas);
		m.put("view", "persona/r");
		return "_t/frame";
	}

	@GetMapping("c")
	public String c(ModelMap m) {
		m.put("view", "persona/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre) throws DangerException {

		try {
			Persona persona = new Persona(nombre);
			personaRepository.save(persona);
		} catch (Exception e) {
			PRG.error("Error al crear persona", "persona/c");
		}

		return "redirect:/persona/r";
	}

	@GetMapping("v")
	public String v(ModelMap m) {
		List<Persona> personas = personaRepository.findAll();
		List<Coche> coches = cocheRepository.findAll();
		m.put("personas", personas);
		m.put("coches", coches);

		m.put("view", "persona/v");
		return "_t/frame";

	}
	@PostMapping("v")
	public String vPost(
			@RequestParam("idPersona") Long idPersona,
			@RequestParam(value="idsCochesPersonales[]",required = false) ArrayList<Long> idsCochesPersonales,
			@RequestParam(value="idsCochesEmpresariales[]",required = false) ArrayList<Long> idsCochesEmpresariales
			) {
		idsCochesPersonales = idsCochesPersonales == null ? new ArrayList<Long>() : idsCochesPersonales;
		idsCochesEmpresariales = idsCochesEmpresariales == null ? new ArrayList<Long>() : idsCochesEmpresariales;
		
		Persona persona = personaRepository.getById(idPersona);
		
		for(Long idCochePersonal : idsCochesPersonales) {
			Coche coche = cocheRepository.getById(idCochePersonal);
			coche.setPersonal(persona);
		}
		for(Long idCocheEmpresa : idsCochesEmpresariales) {
			
			Coche coche = cocheRepository.getById(idCocheEmpresa);
			coche.setEmpresa(persona);
		}
		
		personaRepository.save(persona);
		
		return "redirect:/persona/r";
	}
}
