package com.ayudamos.logica;

import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.datatypes.DtRepartidor;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.interfaces.IControlador;
import com.ayudamos.logica.ManejadorUsuario;

public class Controlador implements IControlador {

	@Override
	public void agregarUsuario(DtUsuario usuario) throws UsuarioRepetidoExcepcion{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario nuevoUsuario = mU.BuscarUsuario(usuario.getEmail());
		if(nuevoUsuario != null) {
			throw new UsuarioRepetidoExcepcion("El usuario con email: " + usuario.getEmail() + " ya esta registrado");
		}else if(usuario instanceof DtBeneficiario) {
			nuevoUsuario = new Beneficiario(((DtBeneficiario) usuario).getDireccion(),((DtBeneficiario) usuario).fechaNacimiento(),((DtBeneficiario) usuario).getEstadoBeneficiario(),((DtBeneficiario) usuario).getBarrio());
			nuevoUsuario.setNombre(usuario.getNombre());
			nuevoUsuario.setEmail(usuario.getEmail());
			mU.agregarUsuario(nuevoUsuario);
		}else if (usuario instanceof DtRepartidor) {
			nuevoUsuario = new Repartidor(((DtRepartidor)usuario).getNumeroLicencia());
			nuevoUsuario.setNombre(usuario.getNombre());
			nuevoUsuario.setEmail(usuario.getEmail());
			mU.agregarUsuario(nuevoUsuario);
			
		}
		
	}

}
