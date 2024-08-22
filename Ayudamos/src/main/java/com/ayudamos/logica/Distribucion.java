package com.ayudamos.logica;


import java.util.ArrayList;
import java.util.List;

import com.ayudamos.datatypes.DtFechaHora;
import com.ayudamos.enums.EstadoDistribucion;

public class Distribucion {
	private	DtFechaHora fechaPreparacion;
	private DtFechaHora fechaEntrega;
	private EstadoDistribucion estado;
	
	private List<Beneficiario> beneficiarios;
    private List<Donacion> donaciones;
	
	public Distribucion() {
		super();
	}
	
	public Distribucion(DtFechaHora fechaPreparacion, DtFechaHora fechaEntrega, EstadoDistribucion estado) {
		super();
		this.fechaPreparacion = fechaPreparacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.beneficiarios = new ArrayList<>();
		this.donaciones = new ArrayList<>();
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
	
	
}
