package com.ayudamos.datatypes;

import com.ayudamos.enums.EstadoDistribucion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Calendar;

@XmlRootElement(name = "dtDistribucion") // Nombre del elemento raíz en XML
@XmlAccessorType(XmlAccessType.FIELD) // Acceso a los campos directamente
public class DtDistribucion {
    
    @XmlElement(name = "idBeneficiario") // Nombre del elemento en XML
    private int idBeneficiario;

    @XmlElement(name = "idDonacion") // Nombre del elemento en XML
    private int idDonacion;

    @XmlElement(name = "fechaPreparacion") // Nombre del elemento en XML
    private Date fechaPreparacion;

    @XmlElement(name = "fechaEntrega") // Nombre del elemento en XML
    private Date fechaEntrega;

    @XmlElement(name = "estado") // Nombre del elemento en XML
    private EstadoDistribucion estado;
    
    @XmlElement(name = "descripcionDonacion") // Nombre del elemento en XML
    private String descripcionDonacion;
    
    
    public DtDistribucion() {}
    
    public DtDistribucion(int beneficiario, int donacion, Date fechaPreparacion, Date fechaEntrega, EstadoDistribucion estado) {
        this.idBeneficiario = beneficiario;
        this.idDonacion = donacion;
        this.fechaPreparacion = fechaPreparacion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.descripcionDonacion = null;
    }
    
    public DtDistribucion(String descripcionDonacion,int beneficiario, int donacion, Date fechaPreparacion, Date fechaEntrega, EstadoDistribucion estado) {
        this.idBeneficiario = beneficiario;
        this.idDonacion = donacion;
        this.fechaPreparacion = fechaPreparacion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.descripcionDonacion = descripcionDonacion;
    }
    
    public DtDistribucion(int donacion, String descripcionDonacion, Date fechaPreparacion) {
        this.idBeneficiario = 0;
        this.idDonacion = donacion;
        this.fechaPreparacion = fechaPreparacion;
        this.fechaEntrega = fechaEntrega;
        this.estado = null;
        this.descripcionDonacion = descripcionDonacion;
    }
    // Getters
    public Date getFechaPreparacion() {
        return fechaPreparacion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public EstadoDistribucion getEstado() {
        return estado;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public int getIdDonacion() {
        return idDonacion;
    }
    
    public String getDescripcionDonacion() {
    	return descripcionDonacion;
    }

    @Override
    public String toString() {
        return "Fecha de preparación: " + fechaPreparacion.toString() + ", Fecha de Entrega: " + fechaEntrega.toString() + ", Estado: " + estado;
    }
}
