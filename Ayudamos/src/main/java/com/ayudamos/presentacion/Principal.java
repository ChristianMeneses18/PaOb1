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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private AgregarUsuario agregarUsuarioInternalFrame;
	private AltaDonacion altaDonacionInternalFrame;
	private ListarBeneficiarios listarBeneficiariosInternalFrame;
	private ListarBeneficiariosZona listarBeneficiariosZonaInternalFrame;
	private ListarBeneficiariosEstado listarBeneficiariosEstadoInternalFrame;

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
		
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 619);
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
				
			}
		});
		mnAltas.add(mntmUsuario);
		
		JMenuItem mntmDonacion = new JMenuItem("Alta Donacion");
		mntmDonacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaDonacionInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmDonacion);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmBeneficiario = new JMenuItem("Listar Beneficiario");
		mntmBeneficiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosInternalFrame.setVisible(true);
				agregarUsuarioInternalFrame.setVisible(false);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosEstadoInternalFrame.setVisible(false);
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
				
			}
		});
		mnListar.add(mntmBeneficiarioZona);
		
		JMenuItem mntmBeneficiarioEstado = new JMenuItem("Listar Beneficiarios por Estado");
		mntmBeneficiarioEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBeneficiariosEstadoInternalFrame.setVisible(true);
				listarBeneficiariosZonaInternalFrame.setVisible(false);
				listarBeneficiariosInternalFrame.setVisible(false);
				agregarUsuarioInternalFrame.setVisible(false);
			}
		});
		mnListar.add(mntmBeneficiarioEstado);
		frame.getContentPane().setLayout(null);
	}
}
