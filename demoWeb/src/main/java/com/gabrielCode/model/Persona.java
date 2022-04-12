package com.gabrielCode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "personas")
public class Persona {
	@Id
	private int codigo;
	@Column(name ="PER_NOMBRE", length = 50)
	private String nombre;
	
	
	
	public Persona() {};
	public Persona(int pCod, String pNom) {
		super();
		this.codigo = pCod;
		this.nombre = pNom;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
