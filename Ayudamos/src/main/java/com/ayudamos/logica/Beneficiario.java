package com.ayudamos.logica;

import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.enums.EstadoBeneficiario;
import com.ayudamos.enums.Barrio;

public class Beneficiario extends Usuario {
	private String direccion;
	private DtFecha fechaNacimiento;
	private EstadoBeneficiario estado;
	private Barrio barrio;
	private Distribucion distribucion;
	
	public Beneficiario() {
		super();
	}

	public Beneficiario(String direccion, DtFecha fechaNacimiento, EstadoBeneficiario estado, Barrio barrio) {
		super();
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public DtFecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(DtFecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EstadoBeneficiario getEstado() {
		return estado;
	}

	public void setEstado(EstadoBeneficiario estado) {
		this.estado = estado;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Distribucion getDistribucion() {
		return distribucion;
	}

	public void setDistribucion(Distribucion distribucion) {
		this.distribucion = distribucion;
	}
	
	
}
