package com.ayudamos.presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AgregarUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarUsuario frame = new AgregarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgregarUsuario() {
		setBounds(100, 100, 450, 300);

	}

}
