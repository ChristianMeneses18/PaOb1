package com.ayudamos.interfaces;

import java.util.ArrayList;
import java.util.Date;

import com.ayudamos.datatypes.DtAlimento;
import com.ayudamos.datatypes.DtArticulo;
import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtDonacion;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;

public interface IControlador {
	
	public void agregarUsuario(DtUsuario usuario) throws UsuarioRepetidoExcepcion;
	
	public void altaDonacion(DtDonacion donacion);
	
	public ArrayList<DtBeneficiario> listarBeneficiarios();
	
	public ArrayList<DtBeneficiario> listarBeneficiariosZona(String Barrio);
	
	public ArrayList<DtBeneficiario> listarBeneficiariosEstado(String estado);
	
	public ArrayList<DtUsuario> listarUsuarios();
	
	public ArrayList<DtAlimento> listarAlimentos();
	
	public ArrayList<DtArticulo> listarArticulos();
	
	public void modificarUsuario(String emailViejo, DtUsuario usuario) throws UsuarioRepetidoExcepcion;
	
	public ArrayList<Object[]> listarDistribucionPorZona(DtFecha fechaInicio, DtFecha fechaFin);

	public void modificarAlimento(DtAlimento alimento);
	
	public void modificarArticulo(DtArticulo articulo);
	
	public void agregarDistribucion(DtDistribucion distribucion);

}
