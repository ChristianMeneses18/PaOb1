package com.ayudamos.datatypes;


public class DtUsuario {
	private String nombre;
	private String email;
	
	public DtUsuario (String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "Usuario"+ nombre + "email" + email;
	}
}
