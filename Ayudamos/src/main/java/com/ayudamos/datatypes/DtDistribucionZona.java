package com.ayudamos.datatypes;

import java.util.Date;

import com.ayudamos.enums.EstadoDistribucion;

public class DtDistribucionZona {
	private Date fechaEntrega;
	private String nombreBeneficiario;
	private EstadoDistribucion estado;
	
	
	public DtDistribucionZona(Date fechaEntrega, String nombreBeneficiario, EstadoDistribucion estado) {
		this.fechaEntrega = fechaEntrega;
		this.nombreBeneficiario = nombreBeneficiario;
		this.estado = estado;
		
	}
	
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}
	
	public EstadoDistribucion getEstado() {
		return estado;
	}
	
}
