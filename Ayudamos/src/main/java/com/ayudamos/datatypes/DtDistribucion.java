package com.ayudamos.datatypes;

import com.ayudamos.enums.EstadoDistribucion;
import java.util.Date;

public class DtDistribucion {
	private int idBeneficiario;
	private int idDonacion;
	private Date fechaPreparacion;
	private Date fechaEntrega;
	private EstadoDistribucion estado;
	
	
	public DtDistribucion(int idBeneficiario, int idDonacion, Date fechaPreparacion, Date fechaEntrega, EstadoDistribucion estado){
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
	public Date getFechaPreparacion(){
		return fechaPreparacion;
	}
	
	public Date getFechaEntrega(){
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
