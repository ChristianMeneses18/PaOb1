package com.ayudamos.datatypes;

import com.ayudamos.enums.EstadoDistribucion;

public class DtDistribucion {
	private int idBeneficiario;
	private int idDonacion;
	private DtFechaHora fechaPreparacion;
	private DtFechaHora fechaEntrega;
	private EstadoDistribucion estado;
	
	
	public DtDistribucion(int idBeneficiario, int idDonacion, DtFechaHora fechaPreparacion, DtFechaHora fechaEntrega, EstadoDistribucion estado){
		this.idBeneficiario = idBeneficiario;
		this.idDonacion = idDonacion;
		this.fechaPreparacion = fechaPreparacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
	}
	
	public int getIdBeneficiario(){
		return idBeneficiario;
	}
	
	public int getIdDonacion(){
		return idDonacion;
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
