package org.aasensio.pruebaExamen.service;

import java.util.List;

import org.aasensio.pruebaExamen.entities.Asignatura;
import org.aasensio.pruebaExamen.entities.Profesor;
import org.aasensio.pruebaExamen.repository.AsignaturaRepository;
import org.aasensio.pruebaExamen.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	public void crearProfesor(String dni, String password, String nombre, String apellido, List<Long>idAsignatura) throws Exception {
		Profesor profesor = new Profesor(dni,password,nombre,apellido);
		if (idAsignatura!=null) {
		for(Long id: idAsignatura) {
			Asignatura asignatura = asignaturaRepository.getById(id);
			if(asignatura.getProfesor()!=null) {
				throw new Exception("La asignatura "+asignatura.getNombre()+ " ya está siendo impartida por otro profesor");
			}
			asignatura.setProfesor(profesor);
//			profesor.getAsignaturas().add(asignatura);
			}
		}
		
		profesorRepository.save(profesor);
	}
	public List<Profesor> findAll(){
		return profesorRepository.findAll();
	}
}
