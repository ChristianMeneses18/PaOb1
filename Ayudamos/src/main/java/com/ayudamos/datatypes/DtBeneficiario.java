package com.ayudamos.datatypes;

import com.ayudamos.enums.Barrio;
import com.ayudamos.enums.EstadoBeneficiario;

public class DtBeneficiario extends DtUsuario {
	private String direccion;
	private DtFecha fechaNacimiento;
	private EstadoBeneficiario estado;
	private Barrio barrio;
	
	public DtBeneficiario(String nombre, String email, String direccion, DtFecha fechaNacimiento, EstadoBeneficiario estado,Barrio barrio ) {
		super(nombre, email);
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.setBarrio(barrio);
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
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
}
