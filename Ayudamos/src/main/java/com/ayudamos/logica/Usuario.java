package com.ayudamos.logica;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPOUSUARIO")
@Table(name="USUARIOS")

public class Usuario{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private int idUsuario;
	
	@Column(name="Email", unique = true)
	private String email;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Contrasenia")
	private String contrasenia;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String email, String contrasenia) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
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
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	

}