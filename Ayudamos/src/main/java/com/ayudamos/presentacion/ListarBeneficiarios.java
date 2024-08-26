package com.ayudamos.presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;

public class ListarBeneficiarios extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tablaBeneficiarios;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarBeneficiarios frame = new ListarBeneficiarios();
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
	public ListarBeneficiarios() {
		setBounds(100, 100, 551, 459);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 515, 222);
		getContentPane().add(scrollPane);
		
		tablaBeneficiarios = new JTable();
		tablaBeneficiarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		model = new DefaultTableModel();
		tablaBeneficiarios.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Direccion");
		model.addColumn("Estado");
		model.addColumn("Barrio");
		
		scrollPane.setViewportView(tablaBeneficiarios);
		
		JLabel lblNewLabel = new JLabel("Listar Beneficiarios");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 11, 535, 47);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(152, 69, 105, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(282, 69, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
}
