package com.ayudamos.datatypes;


public class DtUsuario {
	private String nombre;
	private String email;
	private String contrasenia;
	
	public DtUsuario (String nombre, String email, String contrasenia) {
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	@Override
	public String toString() {
		return "Usuario"+ nombre + "email" + email;
	}
}
