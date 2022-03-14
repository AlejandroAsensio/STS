package org.aasensio.exP.controller;

import java.util.List;

import org.aasensio.exP.entity.Coche;
import org.aasensio.exP.exception.DangerException;
import org.aasensio.exP.exception.PRG;
import org.aasensio.exP.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/coche")
public class CocheController {
	
	@Autowired
	private CocheRepository cocheRepository;
	
	@GetMapping("r")
	public String r(ModelMap m) {
		List<Coche> coches = cocheRepository.findAll();
		m.put("coches", coches);
		m.put("view", "coche/r");
		return "_t/frame";
	}
	
	@GetMapping("c")
	public String c(ModelMap m) {
		m.put("view", "coche/c");
		return "_t/frame";
	}
	@PostMapping("c")
	public String cPost(
			@RequestParam("matricula") String matricula,
			@RequestParam("marca") String marca,
			@RequestParam("modelo") String modelo	
			) throws DangerException {
		try {
		Coche coche = new Coche(matricula, marca, modelo);
		cocheRepository.save(coche);
		}
		catch(Exception e) {
			PRG.error("El coche "+matricula+" ya existe","coche/c");
		}
		
		return "redirect:/coche/r";
	}
}
