package com.ayudamos.datatypes;

public class DtAlimento extends DtDonacion {
	private String descripcionProducto;
	private Integer cantElementos;

	public DtAlimento(Integer id , DtFecha fechaIngresada , String descripcionProducto, Integer cantElementos) {
		super(id, fechaIngresada);
		this.descripcionProducto = descripcionProducto;
		this.cantElementos = cantElementos;
	}
	
	public String getDescripcionProductos() {
		return descripcionProducto;
	}

	public Integer getCantElementos() {
		return cantElementos;
	}
	
	@Override
	public String toString() {
		return super.toString() +"Descripcion del producto:" + descripcionProducto + "cantidad:" + cantElementos.toString();
	}
}
