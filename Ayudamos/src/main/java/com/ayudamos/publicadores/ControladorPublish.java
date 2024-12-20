package com.ayudamos.publicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import com.ayudamos.configuraciones.WebServiceConfiguracion;
import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtListaDistribucion;
import com.ayudamos.datatypes.DtListaDistribucionB;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.enums.Barrio;
import com.ayudamos.enums.EstadoDistribucion;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.interfaces.Fabrica;
import com.ayudamos.interfaces.IControlador;
import com.ayudamos.logica.Beneficiario;
import com.ayudamos.logica.ManejadorUsuario;
import com.ayudamos.logica.Usuario;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublish {
	private Fabrica fabrica;
	private IControlador icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControlador();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void modificarUsuario(String emailViejo, DtUsuario usuario) throws UsuarioRepetidoExcepcion {
		icon.modificarUsuario(emailViejo, usuario);
	}
	
	@WebMethod
	public void modificarDistribucion(Date fechaEntrega, EstadoDistribucion estado, DtDistribucion distribucion) {
		icon.modificarDistribucion(fechaEntrega, estado, distribucion);
	}

	@WebMethod
	public DtDistribucion[] listarDistribuciones(){
		List<DtDistribucion> dtdistribucion = icon.listarDistribuciones();
		int i = 0;
	    DtDistribucion[] ret = new  DtDistribucion[dtdistribucion.size()];
        for(DtDistribucion d : dtdistribucion) {
            ret[i]=d;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public DtUsuario[] listarUsuarios(){
		List<DtUsuario> dtusuario = icon.listarUsuarios();
		int i = 0;
		DtUsuario[] ret = new DtUsuario[dtusuario.size()];
        for(DtUsuario u : dtusuario) {
            ret[i]=u;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public DtUsuario obtenerUsuario(String email){
		DtUsuario aRetornar = icon.obtenerUsuario(email);
		return aRetornar;
}
	
	@WebMethod
	public void modificarContrasenia(String email , String nuevaContrasenia) {
		icon.modificarContrasenia(email, nuevaContrasenia);	
	}
		
	@WebMethod
	public DtListaDistribucion obtenerDistribucionesBeneficiario(String email) {
		DtListaDistribucion aRetornar = icon.obtenerDistribucionesBeneficiario(email);
	    return aRetornar;
	}
	
	@WebMethod
	public void modificarDatosUsuario(String email, DtUsuario usuario) {
		icon.modificarDatosUsuario(email, usuario);
	}
	
	@WebMethod
	public DtListaDistribucion obtenerDistribucionesBeneficiarioFiltradas(String email, EstadoDistribucion estadoSelect) {
		DtListaDistribucion aRetornar = icon.obtenerDistribucionesBeneficiarioFiltradas(email, estadoSelect);
	    return aRetornar;
	}
	
	@WebMethod
	public DtListaDistribucionB obtenerDistribucionesFiltradas(Barrio barrioSelect) {
		DtListaDistribucionB aRetornar = icon.obtenerDistribucionesFiltradas(barrioSelect);
	    return aRetornar;
	}
	
	@WebMethod
	public void modificarEstadoDistribucion(int idBeneficiario, int idDonacion, Date fechaPreparacion, EstadoDistribucion estado) {
		icon.modificarEstadoDistribucion(idBeneficiario, idDonacion , fechaPreparacion , estado);
	}
}
