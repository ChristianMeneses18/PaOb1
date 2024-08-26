package com.ayudamos.logica;

import com.ayudamos.datatypes.DtFecha;

public class Donacion {
	private Integer id;
	private DtFecha fechaIngresada;
	
	public Donacion() {
		super();
	}
	
	public Donacion(Integer id, DtFecha fechaIngresada) {
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

	public DtFecha getFechaIngresada() {
		return fechaIngresada;
	}

	public void setFechaIngresada(DtFecha fechaIngresada) {
		this.fechaIngresada = fechaIngresada;
	}
	

}
