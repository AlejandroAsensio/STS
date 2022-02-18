package org.aasensio.pruebaExamen.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Profesor extends Usuario{
	@OneToMany(mappedBy = "profesor",cascade = CascadeType.ALL)
	private Collection<Asignatura> asignaturas;
	
	// ====================================
	
	public Profesor(String dni,String password, String nombre,String apellido) {
		super(dni,password,nombre,apellido);
		this.asignaturas = new ArrayList<Asignatura>();
		
	}
	public Profesor() {
		this.asignaturas = new ArrayList<Asignatura>();
	}
	// ====================================
	public Collection<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Collection<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
}
