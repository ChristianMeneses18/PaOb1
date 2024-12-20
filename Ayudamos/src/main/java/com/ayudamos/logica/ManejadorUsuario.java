package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	
	public Usuario buscarUsuario(int id) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Usuario usuario = em.find(Usuario.class, id);
		return usuario;
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
	    query.setParameter("email", email);
	    try {
	        Usuario usuario = (Usuario) query.getSingleResult();
	        return usuario;
	    } catch (NoResultException e) {
	        
	        return null;
	    }
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
	
	public void modificarUsuario(Usuario usuario) {
	    Conexion conexion = Conexion.getInstancia();
	    EntityManager em = conexion.getEntityManager();
	    em.getTransaction().begin();
	    
	    em.merge(usuario);
	    
	    em.getTransaction().commit();
	}
	
	public Beneficiario buscarBeneficiario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
	    query.setParameter("email", usuario.getEmail());
	    try {
	        Beneficiario beneficiario= (Beneficiario) query.getSingleResult();
	        return beneficiario;
	    } catch (NoResultException e) {
	        return null;
	    }
	}
	
	public void modificarContrasenia(Usuario usuario) {
	    Conexion conexion = Conexion.getInstancia();
	    EntityManager em = conexion.getEntityManager();
	    em.getTransaction().begin();
	    
	    em.merge(usuario);
	    
	    em.getTransaction().commit();
	}

}
