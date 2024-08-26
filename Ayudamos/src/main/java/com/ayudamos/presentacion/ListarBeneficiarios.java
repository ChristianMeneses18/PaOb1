package com.ayudamos.presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarBeneficiarios extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tablaBeneficiarios;

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
		tablaBeneficiarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Barrio", "Estado", "Direccion", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tablaBeneficiarios);

	}
}
