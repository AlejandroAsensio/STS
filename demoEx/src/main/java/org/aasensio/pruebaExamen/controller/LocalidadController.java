package org.aasensio.pruebaExamen.controller;

import java.util.List;

import org.aasensio.pruebaExamen.entity.Localidad;
import org.aasensio.pruebaExamen.exception.DangerException;
import org.aasensio.pruebaExamen.exception.PRG;
import org.aasensio.pruebaExamen.repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/localidad")
public class LocalidadController {
	@Autowired
	private LocalidadRepository localidadRepository;

	@GetMapping("r")
	public String r(ModelMap m) {
		List<Localidad> localidades = localidadRepository.findAll();
		m.put("localidades", localidades);
		m.put("view", "localidad/r");
		return "_t/frame";
	}

	@GetMapping("c")
	public String c(ModelMap m) {
		m.put("view", "localidad/c");
		return "_t/frame";
	}

	@PostMapping("c")
	public String cPost(@RequestParam("nombre") String nombre,
			@RequestParam(value="provincia",required = true) String provincia)
			throws DangerException {
		try {
			Localidad localidad = new Localidad(nombre, provincia);
			localidadRepository.save(localidad);
		} catch (Exception e) {
			PRG.error("Error creando localidad", "/localidad/c");
		}

		return "redirect:/localidad/r";
	}
	
}
