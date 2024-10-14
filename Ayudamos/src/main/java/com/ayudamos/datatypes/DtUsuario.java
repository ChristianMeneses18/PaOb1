package com.ayudamos.datatypes;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dtUsuario") // Nombre del elemento raíz en XML
@XmlAccessorType(XmlAccessType.FIELD) 
@XmlSeeAlso({DtBeneficiario.class, DtRepartidor.class})
public class DtUsuario {

    @XmlElement(name = "nombre") // Nombre del elemento en XML
    private String nombre;

    @XmlElement(name = "email") // Nombre del elemento en XML
    private String email;

    @XmlElement(name = "contrasenia") // Nombre del elemento en XML
    private String contrasenia;

    @XmlElement(name = "tipoUsuario") // Nombre del elemento en XML
    private String tipoUsuario;

    
    public DtUsuario() {}
    
    public DtUsuario(String nombre, String email, String contrasenia, String tipoUsuario) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    // Constructor sin tipoUsuario
    public DtUsuario(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.tipoUsuario = null;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + ", Email: " + email;
    }
}
