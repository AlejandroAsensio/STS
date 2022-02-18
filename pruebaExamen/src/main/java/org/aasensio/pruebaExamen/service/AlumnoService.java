package org.aasensio.pruebaExamen.service;

import java.util.List;

import org.aasensio.pruebaExamen.entities.Alumno;
import org.aasensio.pruebaExamen.entities.Asignatura;

import org.aasensio.pruebaExamen.repository.AlumnoRepository;
import org.aasensio.pruebaExamen.repository.AsignaturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	public void crearAlumno(String dni, String password, String nombre, String apellido, List<Long>idsAsignatura) throws Exception {
		Alumno alumno= new Alumno(dni,password,nombre,apellido);
		if (idsAsignatura!=null) {
		for(Long id: idsAsignatura) {
			Asignatura asignatura = asignaturaRepository.getById(id);
			asignatura.addAlumno(alumno);

			}
		}
		
		alumnoRepository.save(alumno);
	}
	public List<Alumno> findAll(){
		return alumnoRepository.findAll();
	}
}
