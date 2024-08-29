package com.ayudamos.logica;

import java.util.ArrayList;

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
			nuevoUsuario = new Beneficiario(usuario.getNombre(),usuario.getEmail(),((DtBeneficiario) usuario).getDireccion(),((DtBeneficiario) usuario).fechaNacimiento(),((DtBeneficiario) usuario).getEstadoBeneficiario(),((DtBeneficiario) usuario).getBarrio());
		}else if (usuario instanceof DtRepartidor) {
			nuevoUsuario = new Repartidor(usuario.getNombre(),usuario.getEmail(),((DtRepartidor)usuario).getNumeroLicencia());
		}
		mU.agregarUsuario(nuevoUsuario);
		
	}
	@Override
	public ArrayList<DtBeneficiario> listarBeneficiarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtBeneficiario> aRetornar = new ArrayList<>();
		ArrayList<Beneficiario> beneficiarios = mU.obtenerBeneficiarios();
		for (Beneficiario b : beneficiarios) {
			DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(),b.getEmail(), b.getDireccion(), b.getFechaNacimiento() , b.getEstado(), b.getBarrio());
			aRetornar.add(dtBeneficiario);
		}
		
		
		return aRetornar;
		
		 
	}
	
	@Override
	public ArrayList<DtBeneficiario> listarBeneficiariosZona(String Barrio) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtBeneficiario> aRetornar = new ArrayList<>();
		ArrayList<Beneficiario> beneficiarios = mU.obtenerBeneficiarios();
		for (Beneficiario b : beneficiarios) {
			if (b.getBarrio().toString().equals(Barrio)) {
				DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(),b.getEmail(), b.getDireccion(), b.getFechaNacimiento() , b.getEstado(), b.getBarrio());
				aRetornar.add(dtBeneficiario);	
			}
			
		}
		
		
		return aRetornar;
		
		 
	}
	
	@Override
	public ArrayList<DtBeneficiario> listarBeneficiariosEstado(String estado) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtBeneficiario> aRetornar = new ArrayList<>();
		ArrayList<Beneficiario> beneficiarios = mU.obtenerBeneficiarios();
		for (Beneficiario b : beneficiarios) {
			if (b.getEstado().toString().equals(estado)) {
				DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(),b.getEmail(), b.getDireccion(), b.getFechaNacimiento() , b.getEstado(), b.getBarrio());
				aRetornar.add(dtBeneficiario);	
			}
			
		}
		
		
		return aRetornar;
		
		 
	}
	
	@Override
	public ArrayList<DtUsuario> listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuario> listaDT = new ArrayList<>();
		ArrayList<Usuario> usuarios = mU.obtenerUsuarios();
		
		
		
		for (Usuario u : usuarios) {
			if (u instanceof Beneficiario) {
				DtBeneficiario dtBeneficiario = new DtBeneficiario(u.getNombre(), u.getEmail(), u.getDireccion(), u.getFechaNacimiento() , u.getEstado(), u.getBarrio());
				listaDT.add(dtBeneficiario);
	        } else {
	        	DtUsuario dtUsuario = new DtUsuario(u.getNombre(), u.getEmail(), u.getDireccion(), u.getFechaNacimiento() , b.getEstado(), b.getBarrio());
				listaDT.add(dtUsuario);
	        }
			
		}
		
		for (Usuario u : usuarios) {
			DtUsuario dtUsuario = new DtUsuario(u.getNombre(), u.getEmail(), u.getDireccion(), u.getFechaNacimiento() , b.getEstado(), b.getBarrio());
			listaDT.add(dtUsuario);
		}
		
		return listaDT;
		
	}

}
