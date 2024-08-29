package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPODONACION")
@Table(name="DONACIONES")
public class Donacion {
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="FECHAINGRESADA")
	private Date fechaIngresada;
	
	@OneToMany(mappedBy="Beneficiario",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Distribucion> distribucion = new ArrayList<>();
	
	public List<Distribucion> getDistribucion() {
		return distribucion;
	}

	public void setDistribucion(List<Distribucion> distribucion) {
		this.distribucion = distribucion;
	}

	public Donacion() {
		super();
	}
	
	public Donacion(Integer id, Date fechaIngresada) {
		super();
		this.id = id;
		this.fechaIngresada = fechaIngresada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaIngresada() {
		return fechaIngresada;
	}

	public void setFechaIngresada(Date fechaIngresada) {
		this.fechaIngresada = fechaIngresada;
	}
	

}
