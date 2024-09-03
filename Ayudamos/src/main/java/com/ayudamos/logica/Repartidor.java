package com.ayudamos.logica;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Repartidor extends Usuario {
	
	@Column(name="NumeroLicencia")
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