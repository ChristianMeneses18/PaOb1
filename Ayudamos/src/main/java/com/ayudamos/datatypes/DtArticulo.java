package com.ayudamos.datatypes;

public class DtArticulo extends DtDonacion {
	private String descripcion;
	private float peso;
	private String dimensiones;

	public DtArticulo(Integer id, DtFecha fechaIngresada, String descripcion, float peso, String dimensiones) {
		super(id, fechaIngresada);
		this.descripcion = descripcion;
		this.peso = peso;
		this.dimensiones = dimensiones;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public String getDimensiones(){
		return dimensiones;
	}
	
	@Override
	public String toString() {
		return super.toString()+ "descripcion:"+ descripcion + "peso:" + peso + "dimensiones:"+dimensiones;
	}
}
