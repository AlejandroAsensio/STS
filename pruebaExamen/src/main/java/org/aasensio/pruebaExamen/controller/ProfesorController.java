package org.aasensio.pruebaExamen.controller;

import java.util.List;

import org.aasensio.pruebaExamen.exception.DangerException;
import org.aasensio.pruebaExamen.exception.PRG;
import org.aasensio.pruebaExamen.service.AsignaturaService;
import org.aasensio.pruebaExamen.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	private AsignaturaService asignaturaService;
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("c")
	public String c(
			ModelMap m
			) {
		m.put("asignaturas", asignaturaService.findAll());
		m.put("view", "profesor/c");
		return "_t/frame";
	}
	@PostMapping("c")
	public String cPost(
			@RequestParam("dni") String dni,
			@RequestParam("password") String password,
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value="idAsignatura[]", required = false) List<Long> idAsignatura
			) throws DangerException {
		try {
			profesorService.crearProfesor(dni, password, nombre, apellido, idAsignatura);
		} catch (Exception e) {
			PRG.error(e.getMessage(),"/profesor/c");
		}
		return "redirect:/profesor/r";
	}
	
	
	@GetMapping("r")
	public String r(
			ModelMap m
			) {
		m.put("profesores", profesorService.findAll());
		m.put("view", "profesor/r");
		return "_t/frame";
	}
}
