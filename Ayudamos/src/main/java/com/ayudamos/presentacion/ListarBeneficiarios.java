package com.ayudamos.presentacion;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.interfaces.IControlador;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListarBeneficiarios extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JTable tablaBeneficiarios;
	private DefaultTableModel model;
	private JButton btnListar;
	private JButton btnCancelar;

	public ListarBeneficiarios(IControlador icon) {
		this.icon = icon;
		setBounds(100, 100, 551, 459);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 515, 222);
		getContentPane().add(scrollPane);
		
		tablaBeneficiarios = new JTable();
		tablaBeneficiarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
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
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnListar.setBounds(96, 348, 117, 30);
				btnCancelar.setBounds(324, 348, 117, 30);
				listarBeneficiarioActionPerformed(arg0);
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListar.setBounds(100, 69, 117, 30);
		getContentPane().add(btnListar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarBeneficiarioCancelarActionPerformed(arg0);
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(317, 69, 117, 30);
		getContentPane().add(btnCancelar);
	}
	
	protected void listarBeneficiarioActionPerformed(ActionEvent arg0) {
		ArrayList<DtBeneficiario>datos = icon.listarBeneficiarios();
		model.setRowCount(0);
		
		if (datos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No existen beneficiarios a listar", "Listar Beneficiario", JOptionPane.INFORMATION_MESSAGE);
			}else {
				for (DtBeneficiario b : datos) {
					Object[] fila = new Object[4];
					fila[0] = b.getNombre();
					fila[1] = b.getDireccion();
					fila[2] = b.getEstadoBeneficiario().toString();
					fila[3] = b.getBarrio().toString();
					
					model.addRow(fila);
					
				}
				
			}
		
		
	}
	
	 protected void listarBeneficiarioCancelarActionPerformed(ActionEvent arg0) {
		 	btnListar.setBounds(100, 69, 117, 30);
		 	btnCancelar.setBounds(317, 69, 117, 30);
		 	model.setRowCount(0);
	        setVisible(false);
		}
}
