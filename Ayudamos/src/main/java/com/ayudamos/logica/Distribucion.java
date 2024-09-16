package com.ayudamos.logica;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;

import com.ayudamos.enums.EstadoDistribucion;


@Entity
@IdClass(com.ayudamos.persistencia.DistribucionID.class)
public class Distribucion {
	
	@Id 
	@ManyToOne
    @JoinColumn(name = "donacion_id")
    private Donacion donacion;
	
	@Id 
	@ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
	
	@Id
    @Column(name = "fecha_preparacion")
	private	Date fechaPreparacion;
	
    @Column(name = "fecha_entrega")
	private Date fechaEntrega;
	
	@Enumerated(EnumType.STRING)
	private EstadoDistribucion estado;
	
	
	public Distribucion() {
		super();
	}
	
	public Distribucion(Date fechaPreparacion, Date fechaEntrega, EstadoDistribucion estado , Beneficiario beneficiario, Donacion donacion) {
		super();
		this.fechaPreparacion = fechaPreparacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.beneficiario = beneficiario;
		this.donacion = donacion;
	}
	
	
	public Date getFechaPreparacion() {
		return fechaPreparacion;
	}
	public void setFechaPreparacion(Date fechaPreparacion) {
		this.fechaPreparacion = fechaPreparacion;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public EstadoDistribucion getEstado() {
		return estado;
	}
	public void setEstado(EstadoDistribucion estado) {
		this.estado = estado;
	}

	public Donacion getDonacion() {
		return donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
	
}
