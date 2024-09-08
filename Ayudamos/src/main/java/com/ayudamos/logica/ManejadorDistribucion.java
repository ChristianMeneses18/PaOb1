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

		String inicio = fechaInicio.getAnio()+"-"+fechaInicio.getMes()+"-"+fechaInicio.getDia();
		String fin = fechaFin.getAnio()+"-"+fechaFin.getMes()+"-"+fechaFin.getDia();

		String consulta = "SELECT b.barrio, COUNT(*) as numDistribuciones"
						+ "FROM Distribucion d JOIN usuarios b on d.beneficiario_id = b.IdUsuario"
						+ "WHERE d.fecha_Preparacion BETWEEN "+inicio+" AND "+fin
						+ "GROUP BY b.barrio"
						+ "ORDER BY numDistribuciones DESC";

		Query query = em.createQuery(consulta);

		List<Object[]> resultados = query.getResultList();
		ArrayList<Object[]> distribuciones = new ArrayList<>(resultados);

		return distribuciones;
	}

}
