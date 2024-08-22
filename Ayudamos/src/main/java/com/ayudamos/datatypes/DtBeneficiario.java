package com.ayudamos.datatypes;

import com.ayudamos.enums.EstadoBeneficiario;

public class DtBeneficiario extends DtUsuario {
	private String direccion;
	private DtFecha fechaNacimiento;
	private EstadoBeneficiario estado;
	
	public DtBeneficiario(String nombre, String email, String direccion, DtFecha fechaNacimiento, EstadoBeneficiario estado) {
		super(nombre, email);
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public DtFecha fechaNacimiento() {
		return fechaNacimiento;
	}
	
	public EstadoBeneficiario getEstadoBeneficiario() {
		return estado;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Direccion:" + direccion + "Fecha de nacimiento" + fechaNacimiento.toString()+ "Estado:" + estado;
	}
	
}
