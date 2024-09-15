package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ayudamos.persistencia.Conexion;
import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.persistencia.Conexion;
import java.util.Date;


public class ManejadorDistribucion {
	private static ManejadorDistribucion instancia = null;
	
	
	public static ManejadorDistribucion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorDistribucion();
		return instancia;
	}
	
	public ArrayList<Object[]> obtenerDistribucionesPorZona(DtFecha fechaInicio, DtFecha fechaFin) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		String inicio = fechaInicio.getAnio() + "-" + fechaInicio.getMes() + "-" + fechaInicio.getDia();
	    String fin = fechaFin.getAnio() + "-" + fechaFin.getMes() + "-" + fechaFin.getDia();

	    String consulta = "SELECT u.Barrio, COUNT(*) AS cantD, COUNT(DISTINCT d.beneficiario_id) " +
	                      "FROM distribucion d JOIN usuarios u ON d.beneficiario_id = u.IdUsuario " +
	                      "WHERE d.fecha_entrega BETWEEN :inicio AND :fin " +
	                      "GROUP BY u.Barrio " +
	                      "ORDER BY cantD DESC";
	    

	    Query query = em.createNativeQuery(consulta);
	    query.setParameter("inicio", inicio);
	    query.setParameter("fin", fin);

	    List<Object[]> resultados = query.getResultList();
	    return new ArrayList<>(resultados);
	}
	
	public void agregarDistribucion(Distribucion distribucion) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(distribucion);
		
		em.getTransaction().commit();
	}
	
	public ArrayList<Distribucion> obtenerDistribuciones() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("SELECT d FROM distribucion d", Distribucion.class);
		List<Distribucion> distribuciones = query.getResultList();

		return new ArrayList<>(distribuciones);
	}

	
	public void modificarDistribucion(Distribucion distribucion) {
	    Conexion conexion = Conexion.getInstancia();
	    EntityManager em = conexion.getEntityManager();
	    em.getTransaction().begin();
	    
	    em.merge(distribucion);
	    
	    em.getTransaction().commit();
	}
	
	public Distribucion buscarDistribucion(DtDistribucion d) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Date fechaPreparacion = d.getFechaPreparacion();
		int beneficiario = d.getIdBeneficiario();
		int donacion = d.getIdDonacion();
		
		Query query = em.createQuery("SELECT d FROM distribucion d WHERE d.beneficiario_id = :beneficiario AND d.donacion_id = :donacion AND fecha_preparacion = DATE_FORMAT(':fechaPreparacion', '%Y-%m-%d')", Distribucion.class);
		query.setParameter("donacion", donacion);
		query.setParameter("beneficiario", beneficiario);
		query.setParameter("fechaPreparacion", fechaPreparacion);
		List<Distribucion> distribuciones = query.getResultList();
		Distribucion distribucion = distribuciones.get(0);
		return  distribucion;
	}
	
	
	public ArrayList<Distribucion> obtenerDistribucionesEstado(String estado){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("SELECT d FROM distribucion d WHERE d.estado = :estado", Distribucion.class);
		query.setParameter("estado", estado);
		List<Distribucion> distribuciones = query.getResultList();

		return new ArrayList<>(distribuciones);
	}

}
