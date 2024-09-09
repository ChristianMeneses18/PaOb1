package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.persistencia.Conexion;


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
	                      //"HAVING cantD = MAX(cantD)";
	    
	    
	    // Forma de hacer con having (funciona en mysql pero aca no)
	    /*
	     SELECT u.Barrio, COUNT(*) as cantD, COUNT(DISTINCT d.beneficiario_id)
		FROM distribucion d JOIN usuarios u ON d.beneficiario_id = u.IdUsuario
		WHERE d.fecha_entrega BETWEEN '2024-01-01' AND '2024-02-02'
		GROUP BY u.Barrio
		HAVING cantD = (
		SELECT MAX(cantD_sub)
		FROM ( SELECT COUNT(*) as cantD_sub
				FROM distribucion d_sub 
				JOIN usuarios u_sub ON d_sub.beneficiario_id = u_sub.IdUsuario
				WHERE d_sub.fecha_entrega BETWEEN '2024-01-01' AND '2024-02-02'
				GROUP BY u_sub.Barrio) as pp
		)
		ORDER BY cantD DESC; 
	     */

	    Query query = em.createNativeQuery(consulta);
	    query.setParameter("inicio", inicio);
	    query.setParameter("fin", fin);

	    List<Object[]> resultados = query.getResultList();
	    return new ArrayList<>(resultados);
	}

}
