package com.ayudamos.logica;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ART")
public class Articulo extends Donacion {
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "Peso")
	private float peso;
	
	@Column(name = "Dimensiones")
	private String dimensiones;
	
	public Articulo() {
		super();
	}

	public Articulo(String descripcion, float peso, String dimensiones) {
		super();
		this.descripcion = descripcion;
		this.peso = peso;
		this.dimensiones = dimensiones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	
	

}
