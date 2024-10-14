package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

import com.ayudamos.datatypes.DtAlimento;
import com.ayudamos.datatypes.DtArticulo;
import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtDistribucionZona;
import com.ayudamos.datatypes.DtDonacion;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.datatypes.DtRepartidor;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.interfaces.IControlador;
import com.ayudamos.logica.ManejadorUsuario;
import com.ayudamos.logica.ManejadorDistribucion;
import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.excepciones.DistribucionRepetidaExcepcion;
import com.ayudamos.enums.EstadoDistribucion;
import com.ayudamos.datatypes.DtDistribucionZona;

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
                usuario.getContrasenia(),
                ((DtBeneficiario) usuario).getDireccion(),
                ((DtBeneficiario) usuario).getFechaNacimiento(),
                ((DtBeneficiario) usuario).getEstadoBeneficiario(),
                ((DtBeneficiario) usuario).getBarrio()
            );
        } else if (usuario instanceof DtRepartidor) {
            nuevoUsuario = new Repartidor(
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getContrasenia(),
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
			DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(), b.getEmail(), null, b.getDireccion(), b.getFechaNacimiento(), b.getEstado(), b.getBarrio());
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
				DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(),b.getEmail(), null, b.getDireccion(), b.getFechaNacimiento() , b.getEstado(), b.getBarrio());
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
				DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(), b.getEmail(), null, b.getDireccion(), b.getFechaNacimiento(), b.getEstado(), b.getBarrio());
				aRetornar.add(dtBeneficiario);	
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
			if (u instanceof Beneficiario) {
	            Beneficiario b = (Beneficiario) u;

	            DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(), b.getEmail(), null, b.getDireccion(), b.getFechaNacimiento(), b.getEstado(), b.getBarrio());
	            listaDT.add(dtBeneficiario);
	        } else {
	        	DtUsuario dtUsuario = new DtUsuario(u.getNombre(), u.getEmail(), null);
	        	listaDT.add(dtUsuario);
		
	        }
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
	
	@Override
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
	

	public void modificarBeneficiario(String emailViejo, DtBeneficiario beneficiario) throws UsuarioRepetidoExcepcion{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuarioExistenteConMailIngresado = mU.buscarUsuarioPorEmail(beneficiario.getEmail());
		
		Beneficiario beneficiarioAModificar = (Beneficiario) mU.buscarUsuarioPorEmail(emailViejo);
		
		if (emailViejo.equals(beneficiario.getEmail())) {
			beneficiarioAModificar.setNombre(beneficiario.getNombre());
			beneficiarioAModificar.setEstado(beneficiario.getEstadoBeneficiario());
			
			mU.modificarUsuario(beneficiarioAModificar);
		}else if (usuarioExistenteConMailIngresado != null) {
			throw new UsuarioRepetidoExcepcion("El usuario con email: " + beneficiario.getEmail() + " ya está registrado");
		}else {
			beneficiarioAModificar.setEmail(beneficiario.getEmail()); 
			beneficiarioAModificar.setNombre(beneficiario.getNombre());
			beneficiarioAModificar.setEstado(beneficiario.getEstadoBeneficiario());
			
			mU.modificarUsuario(beneficiarioAModificar);
		}
	}
	
	@Override
	public void modificarAlimento(DtAlimento alimento) {
		ManejadorDonacion mD = ManejadorDonacion.getInstancia();
		Alimento aliBuscado = (Alimento) mD.buscarDonacion(alimento.getId());
		
		aliBuscado.setDescripcionProductos(alimento.getDescripcionProductos());
		aliBuscado.setCantElemntos(alimento.getCantElementos());
		
		mD.modificarDonacion(aliBuscado);			
	}
	
	@Override
	public void modificarArticulo(DtArticulo articulo) {
		ManejadorDonacion mD = ManejadorDonacion.getInstancia();
		Articulo artBuscado = (Articulo) mD.buscarDonacion(articulo.getId());
		
		artBuscado.setDescripcion(articulo.getDescripcion());
		artBuscado.setPeso(articulo.getPeso());
		artBuscado.setDimensiones(articulo.getDimensiones());
		
		mD.modificarDonacion(artBuscado);			
	}
	
	@Override
	public ArrayList<Object[]> listarDistribucionPorZona(DtFecha fechaInicio, DtFecha fechaFin){
		ManejadorDistribucion mD = ManejadorDistribucion.getInstancia();
		return mD.obtenerDistribucionesPorZona(fechaInicio, fechaFin);
	}
	
	@Override
	public void agregarDistribucion(DtDistribucion distribucion)  {
		ManejadorDistribucion mDi = ManejadorDistribucion.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorDonacion mDo = ManejadorDonacion.getInstancia();
		Distribucion nuevaDistribucion = null;
		Usuario usuarioBeneficiario = mU.buscarUsuario(((DtDistribucion) distribucion).getIdBeneficiario());
		Beneficiario beneficiario = mU.buscarBeneficiario(usuarioBeneficiario);
		Donacion donacion = mDo.buscarDonacion(((DtDistribucion) distribucion).getIdDonacion());
		
		nuevaDistribucion = new Distribucion(
				((DtDistribucion) distribucion).getFechaPreparacion(), 
				((DtDistribucion) distribucion).getFechaEntrega(), 
				((DtDistribucion) distribucion).getEstado(),
				beneficiario,
				donacion
		);
		
		mDi.agregarDistribucion(nuevaDistribucion);
		
		
		 
	}
	
	@Override
	public ArrayList<DtDistribucion> listarDistribuciones() {
		
		ManejadorDistribucion mD = ManejadorDistribucion.getInstancia();
        
		ArrayList<DtDistribucion> aRetornar = new ArrayList<>();
		List<Distribucion> distribuciones = mD.obtenerDistribuciones();
		for (Distribucion d : distribuciones) {
			int beneficiario = d.getBeneficiario().getIdUsuario();
			int donacion = d.getDonacion().getId();
			DtDistribucion dtDistribucion = new DtDistribucion( beneficiario, donacion, d.getFechaPreparacion(),d.getFechaEntrega(), d.getEstado());
			aRetornar.add(dtDistribucion);	
			
		}
		
		
		return aRetornar;
		
		 
	}
	
	@Override
	public void modificarDistribucion(Date fechaEntrega, EstadoDistribucion estado, DtDistribucion distribucion) {
		ManejadorDistribucion mD = ManejadorDistribucion.getInstancia();
		Distribucion distribucionBuscada = (Distribucion) mD.buscarDistribucion(distribucion);
		
		
		
		distribucionBuscada.setFechaEntrega(fechaEntrega);
		distribucionBuscada.setEstado(estado);

		mD.modificarDistribucion(distribucionBuscada);			
	}
	
	
	@Override
	public ArrayList<DtDistribucion> listarDistribucionesEstado(String estado){
		ManejadorDistribucion mDi = ManejadorDistribucion.getInstancia();
	    
		ArrayList<DtDistribucion> aRetornar = new ArrayList<>();
		List<Distribucion> distribuciones = mDi.obtenerDistribuciones();
		for (Distribucion d : distribuciones) {
			
			if (d.getEstado().toString()==estado) {				
				int donacion = d.getDonacion().getId();
				DtDistribucion dtD = new DtDistribucion(d.getBeneficiario().getIdUsuario(),donacion, d.getFechaPreparacion(),d.getFechaEntrega(), d.getEstado());
				aRetornar.add(dtD);	
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
	public DtUsuario obtenerUsuario(String email){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuarioPorEmail(email);
		
		if(usuario instanceof Beneficiario) {
			DtBeneficiario aRetornar = new DtBeneficiario(usuario.getNombre(),usuario.getEmail(),usuario.getContrasenia(),"B",
					((Beneficiario) usuario).getDireccion(),((Beneficiario) usuario).getFechaNacimiento(),
					((Beneficiario) usuario).getEstado(), ((Beneficiario) usuario).getBarrio());
			return aRetornar;
		}else {
			DtRepartidor aRetornar = new DtRepartidor(usuario.getNombre(),usuario.getEmail(),usuario.getContrasenia(),"R",((Repartidor) usuario).getNumeroLicencia());
			return aRetornar;
		}
}
	
	@Override
	public void modificarContrasenia(String email , String nuevaContrasenia) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuarioBuscado = mU.buscarUsuarioPorEmail(email);
		
		usuarioBuscado.setContrasenia(nuevaContrasenia);
		
		mU.modificarContrasenia(usuarioBuscado);		
	}

}
