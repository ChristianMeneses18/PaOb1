package com.ayudamos.presentacion;

import java.awt.EventQueue;
import java.awt.Dimension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


import com.ayudamos.interfaces.Fabrica;
import com.ayudamos.interfaces.IControlador;
import com.ayudamos.publicadores.ControladorPublish;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private AgregarUsuario agregarUsuarioInternalFrame;
	private ListarBeneficiarios listarBeneficiariosInternalFrame;
	private ListarBeneficiariosZona listarBeneficiariosZonaInternalFrame;
	private ListarBeneficiariosEstado listarBeneficiariosEstadoInternalFrame;
	private ListarDistribucionesZona listarDistribucionesZonaInternalFrame;
	private ModificarUsuario modificarUsuarioFrame;
	private AltaDonacion altaDonacionInternalFrame;
	private ModificarDonacion modificarDonacionInternalFrame;
	private ReporteDeZona reporteDeZonaFrame;
	private AgregarDistribucion agregarDistribucionInternalFrame;
	private ModificarDistribucion modificarDistribucionInternalFrame;
	private ListarDistribucionesEstado listarDistribucionesEstadoInternalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		ControladorPublish cp = new ControladorPublish();
		cp.publicar();	
		Fabrica fabrica = Fabrica.getInstancia();
        IControlador icon = fabrica.getIControlador();
        
        Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		agregarUsuarioInternalFrame = new AgregarUsuario(icon);
		jInternalFrameSize = agregarUsuarioInternalFrame.getSize();
		 int x = (desktopSize.width - jInternalFrameSize.width) / 2;
		 int y = (desktopSize.height - jInternalFrameSize.height) / 2;
		agregarUsuarioInternalFrame.setLocation(x, y);
		agregarUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(agregarUsuarioInternalFrame);
		
		altaDonacionInternalFrame = new AltaDonacion(icon);
		jInternalFrameSize = altaDonacionInternalFrame.getSize();
		altaDonacionInternalFrame.setVisible(false);
		frame.getContentPane().add(altaDonacionInternalFrame);
		
		listarBeneficiariosInternalFrame = new ListarBeneficiarios(icon);
		jInternalFrameSize = listarBeneficiariosInternalFrame.getSize();
		listarBeneficiariosInternalFrame.setLocation(x, y);
		listarBeneficiariosInternalFrame.setVisible(false);
		frame.getContentPane().add(listarBeneficiariosInternalFrame);
		
		listarBeneficiariosZonaInternalFrame = new ListarBeneficiariosZona(icon);
		jInternalFrameSize = listarBeneficiariosZonaInternalFrame.getSize();
		listarBeneficiariosZonaInternalFrame.setLocation(x, y);
		listarBeneficiariosZonaInternalFrame.setVisible(false);
		frame.getContentPane().add(listarBeneficiariosZonaInternalFrame);
		
		listarBeneficiariosEstadoInternalFrame = new ListarBeneficiariosEstado(icon);
		jInternalFrameSize = listarBeneficiariosEstadoInternalFrame.getSize();
		listarBeneficiariosEstadoInternalFrame.setLocation(x, y);
		listarBeneficiariosEstadoInternalFrame.setVisible(false);
		frame.getContentPane().add(listarBeneficiariosEstadoInternalFrame);
		
		listarDistribucionesZonaInternalFrame = new ListarDistribucionesZona(icon);
		jInternalFrameSize = listarDistribucionesZonaInternalFrame.getSize();
		listarDistribucionesZonaInternalFrame.setLocation(x, y);
		listarDistribucionesZonaInternalFrame.setVisible(false);
		frame.getContentPane().add(listarDistribucionesZonaInternalFrame);
		
		listarDistribucionesEstadoInternalFrame = new ListarDistribucionesEstado(icon);
		jInternalFrameSize = listarDistribucionesEstadoInternalFrame.getSize();
		listarDistribucionesEstadoInternalFrame.setLocation(x, y);
		listarDistribucionesEstadoInternalFrame.setVisible(false);
		frame.getContentPane().add(listarDistribucionesEstadoInternalFrame);

		
		modificarUsuarioFrame = new ModificarUsuario(icon);
		jInternalFrameSize = modificarUsuarioFrame.getSize();
		modificarUsuarioFrame.setLocation(x, y);
		modificarUsuarioFrame.setVisible(false);
		frame.getContentPane().add(modificarUsuarioFrame);
		
		modificarDonacionInternalFrame = new ModificarDonacion(icon);
		jInternalFrameSize = modificarDonacionInternalFrame.getSize();
		modificarDonacionInternalFrame.setLocation(x, y);
		modificarDonacionInternalFrame.setVisible(false);
		frame.getContentPane().add(modificarDonacionInternalFrame);
		
		
		reporteDeZonaFrame = new ReporteDeZona(icon);
		jInternalFrameSize = reporteDeZonaFrame.getSize();
		reporteDeZonaFrame.setLocation(x, y);
		reporteDeZonaFrame.setVisible(false);
		frame.getContentPane().add(reporteDeZonaFrame);
		
		
		agregarDistribucionInternalFrame = new AgregarDistribucion(icon);
		jInternalFrameSize = agregarDistribucionInternalFrame.getSize();
		agregarDistribucionInternalFrame.setLocation(x, y);
		agregarDistribucionInternalFrame.setVisible(false);
		frame.getContentPane().add(agregarDistribucionInternalFrame);
		
		modificarDistribucionInternalFrame = new ModificarDistribucion(icon);
		jInternalFrameSize = modificarDistribucionInternalFrame.getSize();
		modificarDistribucionInternalFrame.setLocation(x, y);
		modificarDistribucionInternalFrame.setVisible(false);
		frame.getContentPane().add(modificarDistribucionInternalFrame);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmUsuario = new JMenuItem("Alta Usuario");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUsuarioInternalFrame.setVisible(true);
				listarBeneficiariosInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
			}
		});
		mnAltas.add(mntmUsuario);
		
		JMenuItem mntmDonacion = new JMenuItem("Alta Donacion");
		mntmDonacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaDonacionInternalFrame.setVisible(true);
				modificarUsuarioFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
			}
		});
		mnAltas.add(mntmDonacion);
		
		JMenuItem mntmDistribucion = new JMenuItem("Alta Distribución");
		mntmDistribucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(true);
				modificarDistribucionInternalFrame.setVisible(false);
			}
		});
		mnAltas.add(mntmDistribucion);
		
		JMenu mnModificaciones = new JMenu("Modificaciones");
		menuBar.add(mnModificaciones);
		
		JMenuItem mntmModUsuario = new JMenuItem("Modificar Usuario");
		mntmModUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(true);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
			}
		});
		mnModificaciones.add(mntmModUsuario);
		
		JMenuItem mntmModDonacion = new JMenuItem("Modificar Donación");
		mntmModDonacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(true);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
				
			}
		});
		mnModificaciones.add(mntmModDonacion);
		
		JMenuItem mntmModDistribucion = new JMenuItem("Modificar Distribucion");
		mntmModDistribucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(true);
				
			}
		});
		mnModificaciones.add(mntmModDistribucion);

		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmBeneficiario = new JMenuItem("Listar Beneficiario");
		mntmBeneficiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosInternalFrame.setVisible(true);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
			}
		});
		mnListar.add(mntmBeneficiario);
		
		JMenuItem mntmBeneficiarioZona = new JMenuItem("Listar Beneficiarios por Zona");
		mntmBeneficiarioZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosZonaInternalFrame.setVisible(true);
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
			}
		});
		mnListar.add(mntmBeneficiarioZona);
		
		JMenuItem mntmBeneficiarioEstado = new JMenuItem("Listar Beneficiarios por Estado");
		mntmBeneficiarioEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosEstadoInternalFrame.setVisible(true);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				reporteDeZonaFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				
			}
		});
		mnListar.add(mntmBeneficiarioEstado);
		
		JMenuItem mntmReporteDeZona = new JMenuItem("Reporte de Zonas con Mayor Distribuciones");
		mntmReporteDeZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporteDeZonaFrame.setVisible(true);
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
							
			}
		});
		mnListar.add(mntmReporteDeZona);
		
		JMenuItem mntmDistribucionZona = new JMenuItem("Listar Distribuciones por Zona");
		mntmDistribucionZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporteDeZonaFrame.setVisible(false);
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(true);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(false);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
				
			}
		});
		mnListar.add(mntmDistribucionZona);
		
		JMenuItem mntmDistribucionEstado = new JMenuItem("Listar Distribuciones por Estado");
		mntmDistribucionEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporteDeZonaFrame.setVisible(false);
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
				listarDistribucionesZonaInternalFrame.setVisible(false);
				modificarUsuarioFrame.setVisible(false);
				modificarDonacionInternalFrame.setVisible(false);
				altaDonacionInternalFrame.setVisible(false);
				listarDistribucionesEstadoInternalFrame.setVisible(true);
				agregarDistribucionInternalFrame.setVisible(false);
				modificarDistribucionInternalFrame.setVisible(false);
			}
		});
		mnListar.add(mntmDistribucionEstado);
		
		frame.getContentPane().setLayout(null);
	}
}
