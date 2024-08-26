package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorDonacion {
	private static ManejadorDonacion instancia = null;
	private List<Donacion> donaciones = new ArrayList<>();
	private Integer ultimoId = 0;
	
	
	public static ManejadorDonacion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorDonacion();
		return instancia;
	}
	
	public void altaDonacion(Donacion donacion) {
		donaciones.add(donacion);
	}

	public Integer getUltimoId() {
		return ultimoId;
	}

	public void setUltimoId(Integer ultimoId) {
		this.ultimoId = ultimoId;
	}

}
