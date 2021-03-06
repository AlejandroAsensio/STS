package org.aasensio.pap2022.controller.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aasensio.pap2022.entities.Aficion;
import org.aasensio.pap2022.entities.Pais;
import org.aasensio.pap2022.entities.Persona;
import org.aasensio.pap2022.exception.DangerException;
import org.aasensio.pap2022.exception.PRG;
import org.aasensio.pap2022.repository.AficionRepository;
import org.aasensio.pap2022.repository.PaisRepository;
import org.aasensio.pap2022.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private AficionRepository aficionRepository;
	
	@GetMapping("/persona/r")
	public String r(
			ModelMap m
			) {	
		List<Persona> personas = personaRepository.findAll();		
		m.put("personas", personas);
		m.put("view", "persona/r");
		return "_t/frame";
	}

	@GetMapping("/persona/c")
	public String c(ModelMap m) {
		
		m.put("paises", paisRepository.findAll());
		m.put("aficiones", aficionRepository.findAll());
		m.put("view", "persona/c");
		
		return "_t/frame";
	}
	
	@PostMapping("/persona/c")
	public String cPost(
			@RequestParam("nombre") String nombre,
			@RequestParam("pwd") String pwd,
			@RequestParam("fNac") 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate fNac,
			@RequestParam("idPaisNace") Long idPaisNace,
			@RequestParam(value="idAficion[]",required=false) List<Long> idsAficion
			) throws DangerException {
		
		try {
		Persona persona = new Persona(nombre,pwd,fNac,paisRepository.getById(idPaisNace));
		if(idsAficion !=null) {
			for(Long idAficion : idsAficion) {
				persona.addAficionGusta(aficionRepository.getById(idAficion));
			}
		}
		personaRepository.save(persona);
		
		}
		catch (Exception e) {
			
			PRG.error("Error indeterminado al crear la persona"+e.getMessage());
		}
		return "redirect:/persona/r";
		
	}
	@GetMapping("/persona/u")
	public String u(
			@RequestParam("idPersona") Long idPersona,
			ModelMap m
			) {
		
		m.put("persona", personaRepository.getById(idPersona));
		m.put("paises", paisRepository.findAll());
		m.put("aficiones", aficionRepository.findAll());
		m.put("view", "persona/u");
		
		return "_t/frame";
	}
	
	@PostMapping("/persona/u")
	public String uPost(
			@RequestParam("nombre") String nombre,
			@RequestParam("idPaisNace") Long idPaisNace,
			@RequestParam("idPersona") Long idPersona,
			@RequestParam(value="idAficion[]",required=false) List<Long> idsAficion
			) throws DangerException {
		
		try {
			Persona persona = personaRepository.getById(idPersona);
			persona.setNombre(nombre);
			if(idPaisNace != persona.getNace().getId()) {
				Pais nuevoPaisNacimiento = paisRepository.getById(idPaisNace);
				persona.setNace(nuevoPaisNacimiento);
			}
			ArrayList<Aficion> nuevasAficiones = new ArrayList<Aficion>();
			
			if(idsAficion !=null) {
				for(Long idAficion : idsAficion) {
					nuevasAficiones.add(aficionRepository.getById(idAficion));
				}
			}
			
			persona.setAficionesGusta(nuevasAficiones);
			
			personaRepository.save(persona);
			
		}
		catch (Exception e) {
			
			PRG.error("Error indeterminado al editar la persona"+e.getMessage());
		}
		return "redirect:/persona/r";
		
	}
	
}
