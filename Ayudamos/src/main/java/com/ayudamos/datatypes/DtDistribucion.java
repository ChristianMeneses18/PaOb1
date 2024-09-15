package com.ayudamos.datatypes;

import com.ayudamos.enums.EstadoDistribucion;

import java.util.Calendar;
import java.util.Date;


public class DtDistribucion {
	private Date fechaPreparacion;
	private Date fechaEntrega;
	private EstadoDistribucion estado;
	private int idBeneficiario;
	private int idDonacion;
	
	
	public DtDistribucion(Date fechaPreparacion, Date fechaEntrega, EstadoDistribucion estado, int beneficiario, int donacion){
		this.fechaPreparacion = fechaPreparacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.idBeneficiario = beneficiario;
		this.idDonacion = donacion;
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
	
	public int getIdBeneficiario(){
		return idBeneficiario;
	}
	
	public int getIdDonacion(){
		return idDonacion;
	}
	
	@Override
	public String toString() {
		return "Fecha de preparación:"+ fechaPreparacion.toString()+ "Fecha de Entrega:" + fechaEntrega.toString()+ estado;
	}
}
