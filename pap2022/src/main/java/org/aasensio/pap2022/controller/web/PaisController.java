package org.aasensio.pap2022.controller.web;

import java.util.List;

import org.aasensio.pap2022.entities.Pais;
import org.aasensio.pap2022.exception.DangerException;
import org.aasensio.pap2022.exception.InfoException;
import org.aasensio.pap2022.exception.PRG;
import org.aasensio.pap2022.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("/pais/r")
	public String r(
			ModelMap m
			) {
		
		List<Pais> paises = paisRepository.findAll();
		
//		m.put("saludo", "hola");
		
		m.put("paises", paises);
		m.put("view", "pais/r");
		
		return "_t/frame";
	}

	@GetMapping("/pais/c")
	public String c(ModelMap m) {
		
		m.put("view", "pais/c");
		
		return "_t/frame";
	}
	
	@PostMapping("/pais/c")
	public String cPost(@RequestParam("nombre") String nombre) throws DangerException, InfoException {
		
		try {
		paisRepository.save(new Pais(nombre));
		
		}
		catch (Exception e) {
				PRG.error("El país "+nombre+" ya existe","/pais/c");
		}
		
//		PRG.info(nombre +" creado correctamente","/pais/r");
		
		return "redirect:/pais/r";
	}
	
	@GetMapping("/pais/u")
	public String u(
			@RequestParam("idPais") Long idPais,
			ModelMap m
			) {
		m.put("pais", paisRepository.getById(idPais));
		m.put("view", "pais/u");
		
		return "_t/frame";
	}
	@PostMapping("/pais/u")
	public String uPost(
			@RequestParam("nombre") String nombre,
			@RequestParam("idPais") Long idPais
			) throws DangerException {
		try {
		Pais pais = paisRepository.getById(idPais);
		pais.setNombre(nombre);
		paisRepository.save(pais);
		}
		catch (Exception e) {
			PRG.error("El país "+nombre+" ya existe","/pais/r");
		}
		
		return "redirect:/pais/r";
	}
}
