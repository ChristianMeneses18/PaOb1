package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private List<Usuario> usuarios = new ArrayList<>();
	
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public Usuario BuscarUsuario(String email) {
		Usuario aretornar=null;
		if (email == null) {
	        return null; 
	    }
		
		for(Usuario u: usuarios) {
			if (u.getEmail().equals(email))
				aretornar=u;
		}
		return aretornar;
	}
	
	public ArrayList<Beneficiario> obtenerBeneficiarios() {
	    ArrayList<Beneficiario> aRetornar = new ArrayList<>();
	    for (Usuario u : usuarios) {
	        if (u instanceof Beneficiario) {
	            aRetornar.add((Beneficiario) u);
	        }
	    }
	    return aRetornar;
	}
	
	public ArrayList<Usuario> obtenerUsuarios() {
	    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	    
	    for (Usuario u : usuarios) {
	        listaUsuarios.add((Usuario) u); //probar sin (Usuario)
	    }
	    
	    return listaUsuarios;
	}

}
