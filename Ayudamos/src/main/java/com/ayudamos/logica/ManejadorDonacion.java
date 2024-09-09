package com.ayudamos.logica;

import javax.persistence.EntityManager;

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
}
