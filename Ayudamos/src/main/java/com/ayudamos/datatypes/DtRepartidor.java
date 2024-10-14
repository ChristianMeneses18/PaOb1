package com.ayudamos.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dtRepartidor") 
@XmlAccessorType(XmlAccessType.FIELD)
public class DtRepartidor extends DtUsuario {
	 @XmlElement(name = "numeroLicencia")
	private String numeroLicencia;
	
	public DtRepartidor(String nombre, String email, String contrasenia, String numeroLicencia) {
		super(nombre, email, contrasenia);
		this.numeroLicencia = numeroLicencia;
	}
	
	public DtRepartidor(String nombre, String email, String contrasenia, String numeroLicencia,String tipoUsuario) {
		super(nombre, email, contrasenia , tipoUsuario);
		this.numeroLicencia = numeroLicencia;
	}
	
	public DtRepartidor() {
		
	}
	
	public String getNumeroLicencia() {
		return numeroLicencia;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Numero de licencia:" + numeroLicencia;
	}
	
}
