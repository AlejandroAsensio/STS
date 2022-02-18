package org.aasensio.pruebaExamen.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Alumno extends Usuario{
	@OneToMany(mappedBy = "alumno")
	private Collection<Nota> notas;
	
	@ManyToMany
	private Collection<Asignatura> asignaturas;
	
	// ==========================
	public Alumno(String dni,String password,String nombre,String apellido	) {
		super(dni,password,nombre,apellido);
	this.notas = new ArrayList<Nota>();
	this.asignaturas= new ArrayList<Asignatura>();
	}
	public Alumno() {
		this.notas = new ArrayList<Nota>();
		this.asignaturas= new ArrayList<Asignatura>();
	}
	
	


	// ==========================
	
	
	public Collection<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Collection<Nota> notas) {
		this.notas = notas;
	}
	public Collection<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Collection<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
}
