package org.aasensio.pruebaExamen.controller;

import org.aasensio.pruebaExamen.entities.Asignatura;
import org.aasensio.pruebaExamen.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {
	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@GetMapping("r")
	public String r(
			ModelMap m
			) {
		m.put("view","asignatura/r");
		return "_t/frame";
	}
	@GetMapping("c")
	public String c(
			ModelMap m
			) {
		m.put("view", "asignatura/c");
		return "_t/frame";
	}
	@PostMapping("c")
	public String cPost(
			@RequestParam("nombre") String nombre
			) {
		Asignatura asignatura = new Asignatura(nombre);
		asignaturaRepository.save(asignatura);
		return "redirect:/asignatura/r";
		
	}
}
