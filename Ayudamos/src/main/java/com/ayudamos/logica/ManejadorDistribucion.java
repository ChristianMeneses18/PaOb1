package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ayudamos.persistencia.Conexion;

public class ManejadorDistribucion {
private static ManejadorDistribucion instancia = null;
	
	
	public static ManejadorDistribucion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorDistribucion();
		return instancia;
	}

	public ArrayList<Distribucion> obtenerDistribuciones(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("SELECT d FROM Distribucion d ", Distribucion.class);
		List<Distribucion> distribuciones = query.getResultList();

		return new ArrayList<>(distribuciones);
	}
}
