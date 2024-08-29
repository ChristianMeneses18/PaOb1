package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.enums.EstadoBeneficiario;
import com.ayudamos.enums.Barrio;

@Entity
@DiscriminatorValue("B")
public class Beneficiario extends Usuario {
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="FECHANACIMIENTO")
	private DtFecha fechaNacimiento;
	@Column(name="ESTADO")
	private EstadoBeneficiario estado;
	@Column(name="BARRIO")
	private Barrio barrio;
	
	@OneToMany(mappedBy="Beneficiario",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Distribucion> distribucion = new ArrayList<>();
	
	
	public Beneficiario() {
		super();
	}

	public Beneficiario(String nombre, String email ,String direccion, DtFecha fechaNacimiento, EstadoBeneficiario estado, Barrio barrio) {
		super(nombre,email);
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

	public List<Distribucion> getDistribucion() {
		return distribucion;
	}

	public void setDistribucion(List<Distribucion> distribucion) {
		this.distribucion = distribucion;
	}

	
	
	
}
