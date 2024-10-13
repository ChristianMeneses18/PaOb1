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
import com.ayudamos.datatypes.DtUsuario;
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
	public ArrayList<DtDistribucion> listarDistribuciones(){
		ArrayList<DtDistribucion> aRetornar = icon.listarDistribuciones();
		return aRetornar;
	}
	
	@WebMethod
	public ArrayList<DtUsuario> listarUsuarios(){
		ArrayList<DtUsuario> aRetornar = icon.listarUsuarios();
		return aRetornar;
	}
	
	@WebMethod
	public DtUsuario obtenerUsuario(String email){
		DtUsuario aRetornar = icon.obtenerUsuario(email);
		return aRetornar;
}
	
	@WebMethod
	public void modificarContrasenia(DtUsuario usuario , String nuevaContrasenia) {
		icon.modificarContrasenia(usuario, nuevaContrasenia);	
	}
}
