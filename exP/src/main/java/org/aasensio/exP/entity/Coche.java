package org.aasensio.exP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Coche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String matricula;
	
	private String marca;
	private String modelo;
	
	@ManyToOne
	private Persona personal;
	
	@ManyToOne
	private Persona empresa;
	
	public Coche() {
	
	}

	public Coche(String matricula, String marca, String modelo) {
		
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Persona getPersonal() {
		return personal;
	}

	public void setPersonal(Persona personal) {
		this.personal = personal;
		this.personal.getPersonales().add(this);
	}

	public Persona getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Persona empresa) {
		this.empresa = empresa;
		this.empresa.getEmpresariales().add(this);
	}
	
	
}
