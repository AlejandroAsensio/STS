package org.aasensio.pap2022.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,nullable = false)
	
	private String nombre;
	private String pwd;
	private LocalDate fNac;
	
	@ManyToOne
	private Pais nace;
	
	@ManyToMany
	private Collection<Aficion> aficionesGusta;

	// ============================
	
	
	
	public Persona() {
		this.nombre = "Dormir";
		this.aficionesGusta = new ArrayList<Aficion>();
	}

	public Persona(String nombre,String pwd, LocalDate fNac, Pais nace) {
		this.nombre = nombre;
		this.pwd = encriptar(pwd);
		this.fNac = fNac;
		this.nace = nace;
		this.nace.getNativos().add(this);
		this.aficionesGusta = new ArrayList<Aficion>();
	}
	// =============================

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = encriptar(pwd);
	}
	
	
	public LocalDate getfNac() {
		return fNac;
	}

	public void setfNac(LocalDate fNac) {
		this.fNac = fNac;
	}

	public Pais getNace() {
		return nace;
	}

	public void setNace(Pais nace) {
		this.nace = nace;
		this.nace.getNativos().add(this);
	}
	
	public Collection<Aficion> getAficionesGusta() {
		return aficionesGusta;
	}

	public void setAficionesGusta(Collection<Aficion> aficionesGusta) {
		this.aficionesGusta = aficionesGusta;
	}
	
	
	
	// =============================
	
	
	public void addAficionGusta(Aficion aficion) {
		this.aficionesGusta.add(aficion);
		aficion.getPersonasGustan().add(this);
	}
	

	private String encriptar(String pwd) {
		return (new BCryptPasswordEncoder()).encode(pwd);
	}
	public Integer getEdad() {
		int sol = 0;
		LocalDate fNac = this.getfNac();
		if(fNac!=null) {
		LocalDate hoy = LocalDate.now();
		
		Period intervalo = Period.between(fNac, hoy);
		sol=intervalo.getYears();
		}
		return sol;
	}
}
