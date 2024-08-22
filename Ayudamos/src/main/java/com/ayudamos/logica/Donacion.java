package com.ayudamos.logica;

import java.util.Date;

public class Donacion {
	private Integer id;
	private Date fechaIngresada;
	
	public Donacion() {
		super();
	}
	
	public Donacion(Integer id, Date fechaIngresada) {
		super();
		this.id = id;
		this.fechaIngresada = fechaIngresada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaIngresada() {
		return fechaIngresada;
	}

	public void setFechaIngresada(Date fechaIngresada) {
		this.fechaIngresada = fechaIngresada;
	}
	

}
