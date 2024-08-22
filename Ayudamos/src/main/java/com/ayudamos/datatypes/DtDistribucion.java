package com.ayudamos.datatypes;

import com.ayudamos.enums.EstadoDistribucion;

public class DtDistribucion {
	private DtFechaHora fechaPreparacion;
	private DtFechaHora fechaEntrega;
	private EstadoDistribucion estado;
	
	
	public DtDistribucion(DtFechaHora fechaPreparacion, DtFechaHora fechaEntrega, EstadoDistribucion estado){
		this.fechaPreparacion = fechaPreparacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
	}
	public DtFechaHora getFechaPreparacion(){
		return fechaPreparacion;
	}
	
	public DtFechaHora getFechaEntrega(){
		return fechaEntrega;
	}
	
	public EstadoDistribucion getEstado(){
		return estado;
	}
	
	@Override
	public String toString() {
		return "Fecha de preparación:"+ fechaPreparacion.toString()+ "Fecha de Entrega:" + fechaEntrega.toString()+ estado;
	}
}
