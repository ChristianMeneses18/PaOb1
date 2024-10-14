package com.ayudamos.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ayudamos.enums.Barrio;
import com.ayudamos.enums.EstadoBeneficiario;

@XmlRootElement(name = "dtBeneficiario") 
@XmlAccessorType(XmlAccessType.FIELD)
public class DtBeneficiario extends DtUsuario {
	 @XmlElement(name = "direccion")
	 private String direccion;
	 @XmlElement(name = "fechaNacimiento")
	 private DtFecha fechaNacimiento;
	 @XmlElement(name = "estado")
	 private EstadoBeneficiario estado;
	 @XmlElement(name = "barrio")
	 private Barrio barrio;
	
	public DtBeneficiario(String nombre, String email, String contrasenia, String direccion, DtFecha fechaNacimiento, EstadoBeneficiario estado,Barrio barrio ) {
		super(nombre, email, contrasenia);
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.setBarrio(barrio);
	}
	
	public DtBeneficiario() {
		
	}
	
	public DtBeneficiario(String nombre, String email, String contrasenia, String tipoUsuario,  String direccion, DtFecha fechaNacimiento, EstadoBeneficiario estado,Barrio barrio ) {
		super(nombre, email, contrasenia , tipoUsuario);
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.setBarrio(barrio);
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	
	public DtFecha getFechaNacimiento() {
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
