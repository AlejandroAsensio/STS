package org.aasensio.pruebaExamen.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Localidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String provincia;
	
	@OneToMany(mappedBy = "localidad")
	private Collection<Cliente> clientes;
	
	
	public Localidad() {
		this.clientes = new ArrayList<Cliente>();
	}
	public Localidad(String nombre, String provincia) {
	
		this.nombre = nombre;
		this.provincia = provincia;
		this.clientes = new ArrayList<Cliente>();
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Collection<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
