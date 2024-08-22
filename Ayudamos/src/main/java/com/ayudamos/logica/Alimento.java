package com.ayudamos.logica;


public class Alimento extends Donacion {
	private String descripcionProductos;
	private Integer cantElemntos;
	
	public Alimento() {
		super();
	}
	
	public Alimento(String descripcionProductos, Integer cantElemntos) {
		super();
		this.descripcionProductos = descripcionProductos;
		this.cantElemntos = cantElemntos;
	}

	public String getDescripcionProductos() {
		return descripcionProductos;
	}

	public void setDescripcionProductos(String descripcionProductos) {
		this.descripcionProductos = descripcionProductos;
	}

	public Integer getCantElemntos() {
		return cantElemntos;
	}

	public void setCantElemntos(Integer cantElemntos) {
		this.cantElemntos = cantElemntos;
	}
	
	

}
