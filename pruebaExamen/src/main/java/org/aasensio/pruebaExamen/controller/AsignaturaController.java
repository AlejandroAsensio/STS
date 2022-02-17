package org.aasensio.pruebaExamen.controller;


import java.util.List;

import org.aasensio.pruebaExamen.entities.Asignatura;
import org.aasensio.pruebaExamen.exception.DangerException;
import org.aasensio.pruebaExamen.exception.PRG;
import org.aasensio.pruebaExamen.service.AsignaturaService;
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
	private AsignaturaService asignaturaService;
	
	@GetMapping("r")
	public String r(
			ModelMap m
			) {
		List<Asignatura> asignaturas = asignaturaService.findAll();
		m.put("asignaturas", asignaturas);
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
			) throws DangerException {
		try {
		asignaturaService.crearAsignatura(nombre);
		
		}
		catch(Exception e) {
			PRG.error(e.getMessage(),"/asignatura/c");
		}
		return "redirect:/asignatura/r";
	}
	
}
