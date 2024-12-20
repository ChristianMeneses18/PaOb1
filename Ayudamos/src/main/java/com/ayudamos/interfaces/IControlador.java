package com.ayudamos.interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ayudamos.datatypes.DtAlimento;
import com.ayudamos.datatypes.DtArticulo;
import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtDistribucionZona;
import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtDonacion;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.datatypes.DtListaDistribucion;
import com.ayudamos.datatypes.DtListaDistribucionB;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.excepciones.DistribucionRepetidaExcepcion;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.datatypes.DtDistribucionZona;
import com.ayudamos.enums.Barrio;
import com.ayudamos.enums.EstadoDistribucion;

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
	
	public void modificarBeneficiario(String emailViejo, DtBeneficiario beneficiario) throws UsuarioRepetidoExcepcion;
	
	public ArrayList<Object[]> listarDistribucionPorZona(DtFecha fechaInicio, DtFecha fechaFin);

	public void modificarAlimento(DtAlimento alimento);
	
	public void modificarArticulo(DtArticulo articulo);
	
	public void agregarDistribucion(DtDistribucion distribucion) ;

	public ArrayList<DtDistribucion> listarDistribuciones();
	
	public void modificarDistribucion(Date fechaEntrega, EstadoDistribucion estado, DtDistribucion distribucion);
	
	public ArrayList<DtDistribucion> listarDistribucionesEstado(String estado);
	
	public ArrayList<DtDistribucionZona> listarDistribucionesZona(String barrio);
	
	public DtUsuario obtenerUsuario(String email);
	
	public void modificarContrasenia(String email , String nuevaContrasenia);
	
	public DtListaDistribucion obtenerDistribucionesBeneficiario(String email);
	
	public void modificarDatosUsuario(String email, DtUsuario usuario);
	
	public DtListaDistribucion obtenerDistribucionesBeneficiarioFiltradas(String email, EstadoDistribucion estadoSelect);
	
	public DtListaDistribucionB obtenerDistribucionesFiltradas(Barrio barrioSelect);
	
	public void modificarEstadoDistribucion(int idBeneficiario, int idDonacion, Date fechaPreparacion, EstadoDistribucion estado);

}
