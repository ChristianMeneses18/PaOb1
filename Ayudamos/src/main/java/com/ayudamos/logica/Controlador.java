package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ayudamos.datatypes.DtAlimento;
import com.ayudamos.datatypes.DtArticulo;
import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtDistribucionZona;
import com.ayudamos.datatypes.DtDonacion;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.datatypes.DtRepartidor;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.interfaces.IControlador;
import com.ayudamos.logica.ManejadorUsuario;

public class Controlador implements IControlador {
	private static EntityManager em;
	private static EntityManagerFactory emf;

	@Override
    public void agregarUsuario(DtUsuario usuario) throws UsuarioRepetidoExcepcion {
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario nuevoUsuario = mU.buscarUsuarioPorEmail(usuario.getEmail());
        
        if (nuevoUsuario != null) {
            throw new UsuarioRepetidoExcepcion("El usuario con email: " + usuario.getEmail() + " ya está registrado");
        } else if (usuario instanceof DtBeneficiario) {
            nuevoUsuario = new Beneficiario(
                usuario.getNombre(),
                usuario.getEmail(),
                ((DtBeneficiario) usuario).getDireccion(),
                ((DtBeneficiario) usuario).getFechaNacimiento(),
                ((DtBeneficiario) usuario).getEstadoBeneficiario(),
                ((DtBeneficiario) usuario).getBarrio()
            );
        } else if (usuario instanceof DtRepartidor) {
            nuevoUsuario = new Repartidor(
                usuario.getNombre(),
                usuario.getEmail(),
                ((DtRepartidor) usuario).getNumeroLicencia()
            );
        }
        
        mU.agregarUsuario(nuevoUsuario);
    }
	
	@Override
	public void altaDonacion(DtDonacion donacion) {
		ManejadorDonacion mD = ManejadorDonacion.getInstancia();
		Donacion nuevaDonacion = null;
		if(donacion instanceof DtAlimento) {
			nuevaDonacion = new Alimento(((DtAlimento) donacion).getDescripcionProductos(), ((DtAlimento) donacion).getCantElementos());
		} else if (donacion instanceof DtArticulo) {
			nuevaDonacion = new Articulo(((DtArticulo) donacion).getDescripcion(), ((DtArticulo) donacion).getPeso(), ((DtArticulo) donacion).getDimensiones());
			
		}
		nuevaDonacion.setFechaIngresada(donacion.getFechaIngresada());
		mD.altaDonacion(nuevaDonacion);
		 
	}

	@Override
	public ArrayList<DtBeneficiario> listarBeneficiarios() {
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		ArrayList<DtBeneficiario> aRetornar = new ArrayList<>();
		List<Beneficiario> beneficiarios = mU.obtenerBeneficiarios();
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
		List<Beneficiario> beneficiarios = mU.obtenerBeneficiarios();
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
		List<Beneficiario> beneficiarios = mU.obtenerBeneficiarios();
		for (Beneficiario b : beneficiarios) {
			if (b.getEstado().toString().equals(estado)) {
				DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(),b.getEmail(), b.getDireccion(), b.getFechaNacimiento() , b.getEstado(), b.getBarrio());
				aRetornar.add(dtBeneficiario);	
			}
			
		}
		
		
		return aRetornar;
		
		 
	}
	
	@Override
	public ArrayList<DtDistribucionZona> listarDistribucionesZona(String barrio){
		ManejadorDistribucion mDi = ManejadorDistribucion.getInstancia();
    
		ArrayList<DtDistribucionZona> aRetornar = new ArrayList<>();
		List<Distribucion> distribuciones = mDi.obtenerDistribuciones();
		for (Distribucion d : distribuciones) {
			
			if (d.getBeneficiario().getBarrio().toString()==barrio) {				
				
				DtDistribucionZona dtDZ = new DtDistribucionZona(d.getFechaEntrega(),d.getBeneficiario().getNombre(), d.getEstado());
				aRetornar.add(dtDZ);	
			}
			
		}
	return aRetornar;
	
	 
}
	
	@Override
	public ArrayList<DtUsuario> listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<DtUsuario> listaDT = new ArrayList<>();
		List<Usuario> usuarios = mU.obtenerUsuarios();
		
		for (Usuario u : usuarios) {
			DtUsuario dtUsuario = new DtUsuario(u.getNombre(), u.getEmail());
			listaDT.add(dtUsuario);
		}
		
		return listaDT;
		
	}
	
	@Override
	public ArrayList<DtAlimento> listarAlimentos() {
		
		ManejadorDonacion mD = ManejadorDonacion.getInstancia();
        
		ArrayList<DtAlimento> aRetornar = new ArrayList<>();
		List<Alimento> alimentos = mD.obtenerAlimento();
		for (Alimento al : alimentos) {
			DtAlimento dtAl= new DtAlimento(al.getId(), al.getFechaIngresada(), al.getDescripcionProductos(), al.getCantElemntos());
			aRetornar.add(dtAl);
			
		}
		
		
		return aRetornar;
		
		 
	}
	
	@Override
	public ArrayList<DtArticulo> listarArticulos() {
		
		ManejadorDonacion mD = ManejadorDonacion.getInstancia();
        
		ArrayList<DtArticulo> aRetornar = new ArrayList<>();
		List<Articulo> articulos = mD.obtenerArticulo();
		for (Articulo ar : articulos) {
			DtArticulo dtAr= new DtArticulo(ar.getId(), ar.getFechaIngresada(), ar.getDescripcion(), ar.getPeso(), ar.getDimensiones());
			aRetornar.add(dtAr);
			
		}
		
		
		return aRetornar;
		
		 
	}
	
	
	
	public void modificarUsuario(String emailViejo, DtUsuario usuario) throws UsuarioRepetidoExcepcion {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuarioExistenteConMailIngresado = mU.buscarUsuarioPorEmail(usuario.getEmail());
		
		Usuario usuarioAModificar = mU.buscarUsuarioPorEmail(emailViejo);
		
		if (emailViejo.equals(usuario.getEmail())) {
			usuarioAModificar.setNombre(usuario.getNombre());
		
			mU.modificarUsuario(usuarioAModificar);
		}else if (usuarioExistenteConMailIngresado != null) {
			throw new UsuarioRepetidoExcepcion("El usuario con email: " + usuario.getEmail() + " ya está registrado");
		}else {
			usuarioAModificar.setEmail(usuario.getEmail()); 
			usuarioAModificar.setNombre(usuario.getNombre());
		
			mU.modificarUsuario(usuarioAModificar);
		}
		
	}
	
	
	public void modificarAlimento(DtAlimento alimento) {
		ManejadorDonacion mD = ManejadorDonacion.getInstancia();
		Alimento aliBuscado = (Alimento) mD.buscarDonacion(alimento.getId());
		
		aliBuscado.setDescripcionProductos(alimento.getDescripcionProductos());
		aliBuscado.setCantElemntos(alimento.getCantElementos());
		
		mD.modificarDonacion(aliBuscado);			
	}
	
	public void modificarArticulo(DtArticulo articulo) {
		ManejadorDonacion mD = ManejadorDonacion.getInstancia();
		Articulo artBuscado = (Articulo) mD.buscarDonacion(articulo.getId());
		
		artBuscado.setDescripcion(articulo.getDescripcion());
		artBuscado.setPeso(articulo.getPeso());
		artBuscado.setDimensiones(articulo.getDimensiones());
		
		mD.modificarDonacion(artBuscado);			
	}
	
}
