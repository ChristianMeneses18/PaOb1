package com.ayudamos.presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class AgregarUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCedula;
	private JTextField txtEmail;

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
		setBounds(100, 100, 447, 539);
		getContentPane().setLayout(null);
		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCedula.setToolTipText("Ingrese la cedula del usuario");
		txtCedula.setBounds(228, 87, 167, 20);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Alta de Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 421, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(45, 89, 68, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(45, 117, 68, 17);
		getContentPane().add(lblNewLabel_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(228, 119, 167, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Beneficiario", "Repartidor"}));
		comboBox.setBounds(228, 163, 167, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo de Usuario");
		lblNewLabel_1_1_1.setLabelFor(comboBox);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(45, 165, 148, 19);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JPanel beneficiarioPanel = new JPanel();
		beneficiarioPanel.setBounds(10, 195, 411, 103);
		getContentPane().add(beneficiarioPanel);

	}
}
