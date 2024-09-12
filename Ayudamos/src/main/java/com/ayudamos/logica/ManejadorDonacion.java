package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ayudamos.persistencia.Conexion;


public class ManejadorDonacion {
	private static ManejadorDonacion instancia = null;
	
	
	public static ManejadorDonacion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorDonacion();
		return instancia;
	}
	
	public void altaDonacion(Donacion donacion) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(donacion);
		
		em.getTransaction().commit();
	}
	
	public ArrayList<Alimento> obtenerAlimento() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("SELECT d FROM Donacion d WHERE TYPE(d) = Alimento", Donacion.class);
		List<Alimento> alimentos = query.getResultList();

		return new ArrayList<>(alimentos);
	}
	
	public ArrayList<Articulo> obtenerArticulo() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("SELECT d FROM Donacion d WHERE TYPE(d) = Articulo", Donacion.class);
		List<Articulo> articulos = query.getResultList();

		return new ArrayList<>(articulos);
	}
	
	
	public Donacion buscarDonacion(int id) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Donacion donacion = em.find(Donacion.class, id);
		return donacion;
	}
	public void modificarDonacion(Donacion donacion) {
	    Conexion conexion = Conexion.getInstancia();
	    EntityManager em = conexion.getEntityManager();
	    em.getTransaction().begin();
	    
	    em.merge(donacion);
	    
	    em.getTransaction().commit();
	}
}
