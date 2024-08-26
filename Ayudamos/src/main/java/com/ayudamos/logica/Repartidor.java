package com.ayudamos.logica;

public class Repartidor extends Usuario {
	private String numeroLicencia;

	
	public Repartidor() {
		super();
	};
	
	public Repartidor(String nombre, String email, String numeroLicencia) {
		super(nombre,email);
		this.numeroLicencia = numeroLicencia;
	}

	public String getNumeroLicencia() {
		return numeroLicencia;
	}

	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}
	
	

}
