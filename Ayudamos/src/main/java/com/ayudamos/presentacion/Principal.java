package com.ayudamos.presentacion;

import java.awt.EventQueue;
import java.awt.Dimension;

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
		agregarUsuarioInternalFrame.setLocation(59,
		    11);
		agregarUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(agregarUsuarioInternalFrame);
		
		altaDonacionInternalFrame = new AltaDonacion(icon);
		jInternalFrameSize = altaDonacionInternalFrame.getSize();
		altaDonacionInternalFrame.setLocation(59,
		    11);
		altaDonacionInternalFrame.setVisible(false);
		frame.getContentPane().add(altaDonacionInternalFrame);
		
		
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
			}
		});
		
		JMenuItem mntmDonacion = new JMenuItem("Alta Donacion");
		mntmDonacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaDonacionInternalFrame.setVisible(true);
			}
		});
		
		
		mnAltas.add(mntmUsuario);
		mnAltas.add(mntmDonacion);
		frame.getContentPane().setLayout(null);
	}
}
