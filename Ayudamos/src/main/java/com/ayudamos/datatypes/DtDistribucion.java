package com.ayudamos.datatypes;

import com.ayudamos.enums.EstadoDistribucion;

import java.util.Calendar;
import java.util.Date;


public class DtDistribucion {
	private Date fechaPreparacion;
	private Date fechaEntrega;
	private EstadoDistribucion estado;
	private String beneficiario;
	private String donacion;
	
	
	public DtDistribucion(Date fechaPreparacion, Date fechaEntrega, EstadoDistribucion estado, String beneficiario, String donacion){
		this.fechaPreparacion = fechaPreparacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.beneficiario = beneficiario;
		this.donacion = donacion;
	}
	public Date getFechaPreparacion(){
		return fechaPreparacion;
	}
	
	public Date getFechaEntrega(){
		return fechaEntrega;
	}
	
	public EstadoDistribucion getEstado(){
		return estado;
	}
	
	public String getBeneficiario(){
		return beneficiario;
	}
	
	public String getDonacion(){
		return donacion;
	}
	
	@Override
	public String toString() {
		return "Fecha de preparación:"+ fechaPreparacion.toString()+ "Fecha de Entrega:" + fechaEntrega.toString()+ estado;
	}
}
