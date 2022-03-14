package org.aasensio.exP.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "personal")
	private Collection<Coche> personales;
	
	@OneToMany(mappedBy = "empresa")
	private Collection<Coche> empresariales;
	
	public Persona() {
		this.personales = new ArrayList<Coche>();
		this.empresariales = new ArrayList<Coche>();
	}

	public Persona(String nombre) {
		this.personales = new ArrayList<Coche>();
		this.empresariales = new ArrayList<Coche>();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Coche> getPersonales() {
		return personales;
	}

	public void setPersonales(Collection<Coche> personales) {
		this.personales = personales;
	}

	public Collection<Coche> getEmpresariales() {
		return empresariales;
	}

	public void setEmpresariales(Collection<Coche> empresariales) {
		this.empresariales = empresariales;
	}
	
}