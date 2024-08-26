package com.ayudamos.logica;


public class Alimento extends Donacion {
	private String descripcionProductos;
	private Integer cantElementos;
	
	public Alimento() {
		super();
	}
	
	public Alimento(String descripcionProductos, Integer cantElementos) {
		super();
		this.descripcionProductos = descripcionProductos;
		this.cantElementos = cantElementos;
	}

	public String getDescripcionProductos() {
		return descripcionProductos;
	}

	public void setDescripcionProductos(String descripcionProductos) {
		this.descripcionProductos = descripcionProductos;
	}

	public Integer getCantElemntos() {
		return cantElementos;
	}

	public void setCantElemntos(Integer cantElementos) {
		this.cantElementos = cantElementos;
	}
	
	

}
