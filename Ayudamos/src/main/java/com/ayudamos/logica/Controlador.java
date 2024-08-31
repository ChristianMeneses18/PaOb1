package com.ayudamos.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ayudamos.datatypes.DtBeneficiario;
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
		emf = Persistence.createEntityManagerFactory("Conexion");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Usuario nuevoUsuario = em.find(Usuario.class, usuario.getEmail());
        
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
        
        em.persist(nuevoUsuario);
        
       
        em.getTransaction().commit();
        
        em.close();
    }

	@Override
	public ArrayList<DtBeneficiario> listarBeneficiarios() {
		emf = Persistence.createEntityManagerFactory("Conexion");
        EntityManager em = emf.createEntityManager();
        
		ArrayList<DtBeneficiario> aRetornar = new ArrayList<>();
		List<Beneficiario> beneficiarios = em.createQuery("SELECT b FROM Beneficiario b", Beneficiario.class).getResultList();
		for (Beneficiario b : beneficiarios) {
			DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(),b.getEmail(), b.getDireccion(), b.getFechaNacimiento() , b.getEstado(), b.getBarrio());
			aRetornar.add(dtBeneficiario);
		}
		
		
		return aRetornar;
		
		 
	}
	
	@Override
	public ArrayList<DtBeneficiario> listarBeneficiariosZona(String Barrio) {
		emf = Persistence.createEntityManagerFactory("Conexion");
        EntityManager em = emf.createEntityManager();
        
		ArrayList<DtBeneficiario> aRetornar = new ArrayList<>();
		List<Beneficiario> beneficiarios = em.createQuery("SELECT b FROM Beneficiario b", Beneficiario.class).getResultList();
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
		emf = Persistence.createEntityManagerFactory("Conexion");
        EntityManager em = emf.createEntityManager();
        
		ArrayList<DtBeneficiario> aRetornar = new ArrayList<>();
		List<Beneficiario> beneficiarios = em.createQuery("SELECT b FROM Beneficiario b", Beneficiario.class).getResultList();
		for (Beneficiario b : beneficiarios) {
			if (b.getEstado().toString().equals(estado)) {
				DtBeneficiario dtBeneficiario = new DtBeneficiario(b.getNombre(),b.getEmail(), b.getDireccion(), b.getFechaNacimiento() , b.getEstado(), b.getBarrio());
				aRetornar.add(dtBeneficiario);	
			}
			
		}
		
		
		return aRetornar;
		
		 
	}

}
