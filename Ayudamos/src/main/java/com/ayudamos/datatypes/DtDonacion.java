package com.ayudamos.datatypes;

public class DtDonacion {
	private Integer id;
	private DtFecha fechaIngresada;
	
	public DtDonacion(Integer id , DtFecha fechaIngresada){
		this.id = id;
		this.fechaIngresada = fechaIngresada;
	}
	
	public Integer getId() {
		return id;
	}
	
	public DtFecha getFechaIngresada() {
		return fechaIngresada;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Id:" + id + "Fecha de ingreso" + fechaIngresada.toString();
	}
	
}
