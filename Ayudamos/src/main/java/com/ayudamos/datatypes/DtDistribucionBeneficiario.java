package com.ayudamos.datatypes;

import com.ayudamos.enums.Barrio;
import com.ayudamos.enums.EstadoDistribucion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Calendar;

@XmlRootElement(name = "dtDistribucion") // Nombre del elemento raíz en XML
@XmlAccessorType(XmlAccessType.FIELD) // Acceso a los campos directamente
public class DtDistribucionBeneficiario {
    
	@XmlElement(name = "idBeneficiario") 
	private int idBeneficiario;
	
    @XmlElement(name = "nombre") 
    private String nombre;

    @XmlElement(name = "email") // Nombre del elemento en XML
    private String email;
    
    @XmlElement(name = "barrio") // Nombre del elemento en XML
    private Barrio barrio;
    
    @XmlElement(name = "idDonacion") // Nombre del elemento en XML
    private int idDonacion;
    
    @XmlElement(name = "descripcionDonacion") // Nombre del elemento en XML
    private String descripcionDonacion;

    @XmlElement(name = "fechaPreparacion") // Nombre del elemento en XML
    private Date fechaPreparacion;

    @XmlElement(name = "estado") // Nombre del elemento en XML
    private EstadoDistribucion estado;
    
    
    
    
    public DtDistribucionBeneficiario() {}
    
    public DtDistribucionBeneficiario(int idBeneficiario , String nombre, String email, Barrio barrio , int idDonacion, String descripcionDonacion, Date fechaPreparacion, EstadoDistribucion estado) {
       this.idBeneficiario = idBeneficiario;
       this.nombre = nombre;
       this.email = email;
       this.barrio = barrio;
       this.idDonacion = idDonacion;
       this.descripcionDonacion = descripcionDonacion;
       this.fechaPreparacion = fechaPreparacion;
       this.estado = estado;
    }
    
    public int getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(int idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	// Getters
    public Date getFechaPreparacion() {
        return fechaPreparacion;
    }

    public EstadoDistribucion getEstado() {
        return estado;
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public void setIdDonacion(int idDonacion) {
		this.idDonacion = idDonacion;
	}

	public void setDescripcionDonacion(String descripcionDonacion) {
		this.descripcionDonacion = descripcionDonacion;
	}

	public void setFechaPreparacion(Date fechaPreparacion) {
		this.fechaPreparacion = fechaPreparacion;
	}

	public void setEstado(EstadoDistribucion estado) {
		this.estado = estado;
	}

	public int getIdDonacion() {
        return idDonacion;
    }
    
    public String getDescripcionDonacion() {
    	return descripcionDonacion;
    }

    @Override
    public String toString() {
        return "Fecha de preparación: " + fechaPreparacion.toString() + ", Estado: " + estado;
    }
}
