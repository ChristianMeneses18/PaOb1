package com.ayudamos.logica;


import java.util.ArrayList;
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

import com.ayudamos.datatypes.DtFechaHora;
import com.ayudamos.enums.EstadoDistribucion;


@Entity
@IdClass(DistribucionID.class)
public class Distribucion {
	
	@Id 
	@ManyToOne
    @JoinColumn(name = "donacion_id", insertable=false, updatable=false)
    private Donacion donacion;
	
	@Id 
	@ManyToOne
    @JoinColumn(name = "beneficiario_id", insertable=false, updatable=false)
    private Beneficiario beneficiario;
	
    @Convert(converter = com.ayudamos.datatypes.DtFechaHoraConverter.class)
    @Column(name = "fecha_preparacion")
	private	DtFechaHora fechaPreparacion;
	
    @Convert(converter = com.ayudamos.datatypes.DtFechaHoraConverter.class)
    @Column(name = "fecha_entrega")
	private DtFechaHora fechaEntrega;
	
	@Enumerated(EnumType.STRING)
	private EstadoDistribucion estado;
	
	
	public Distribucion() {
		super();
	}
	
	public Distribucion(DtFechaHora fechaPreparacion, DtFechaHora fechaEntrega, EstadoDistribucion estado , Beneficiario beneficiario, Donacion donacion) {
		super();
		this.fechaPreparacion = fechaPreparacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.beneficiario = beneficiario;
		this.donacion = donacion;
	}
	
	
	public DtFechaHora getFechaPreparacion() {
		return fechaPreparacion;
	}
	public void setFechaPreparacion(DtFechaHora fechaPreparacion) {
		this.fechaPreparacion = fechaPreparacion;
	}
	public DtFechaHora getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(DtFechaHora fechaEntrega) {
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
