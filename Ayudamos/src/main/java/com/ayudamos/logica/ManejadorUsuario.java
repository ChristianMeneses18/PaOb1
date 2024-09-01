package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.persistencia.Conexion;


public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(usuario);
		
		em.getTransaction().commit();
	}
	
	
	public Usuario buscarUsuario(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Usuario usuario = em.find(Usuario.class, email);
		return usuario;
	}
	
	
	public ArrayList<Beneficiario> obtenerBeneficiarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("SELECT b FROM Beneficiario b", Beneficiario.class);
		List<Beneficiario> beneficiarios = query.getResultList();

		return new ArrayList<>(beneficiarios);
	}
	
	
	public List<Usuario> obtenerUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	    
	    Query query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
	    
	    List<Usuario> listaUsuarios = query.getResultList();

	    return listaUsuarios;
	}
	
	
	public void modificarUsuario(String emailViejo, DtUsuario usuario) {
		
		
		
		/*
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(usuario);
		
		em.getTransaction().commit();
		*/
	}
}
