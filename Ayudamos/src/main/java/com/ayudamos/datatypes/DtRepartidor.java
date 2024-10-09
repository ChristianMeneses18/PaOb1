package com.ayudamos.datatypes;


public class DtRepartidor extends DtUsuario {
	private String numeroLicencia;
	
	public DtRepartidor(String nombre, String email, String contrasenia, String numeroLicencia) {
		super(nombre, email, contrasenia);
		this.numeroLicencia = numeroLicencia;
	}
	public String getNumeroLicencia() {
		return numeroLicencia;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Numero de licencia:" + numeroLicencia;
	}
	
}
