package com.ayudamos.interfaces;

import java.util.ArrayList;
import java.util.Date;

import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;

public interface IControlador {
	
	public void agregarUsuario(DtUsuario usuario) throws UsuarioRepetidoExcepcion;
	
	public ArrayList<DtBeneficiario> listarBeneficiarios();
	
	public ArrayList<DtBeneficiario> listarBeneficiariosZona(String Barrio);
	
	public ArrayList<DtBeneficiario> listarBeneficiariosEstado(String estado);

}
