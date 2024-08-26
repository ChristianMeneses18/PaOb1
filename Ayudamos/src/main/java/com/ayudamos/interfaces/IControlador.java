package com.ayudamos.interfaces;

import com.ayudamos.datatypes.DtDonacion;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;

public interface IControlador {
	
	public void agregarUsuario(DtUsuario usuario) throws UsuarioRepetidoExcepcion;
	public void altaDonacion(DtDonacion donacion);

}
