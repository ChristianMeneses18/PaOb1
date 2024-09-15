package com.ayudamos.presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtDistribucionZona;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.enums.Barrio;
import com.ayudamos.interfaces.IControlador;

public class ListarDistribucionesZona extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JTable tablaDistribuciones;
	private DefaultTableModel model;
	private JButton btnListar;
	private JButton btnCancelar;
	private JComboBox comboBox;
	private ArrayList<DtDistribucionZona> datos;

	public ListarDistribucionesZona(IControlador icon) {
		this.icon = icon;
		setBounds(100, 100, 551, 459);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 515, 222);
		getContentPane().add(scrollPane);
		
		tablaDistribuciones = new JTable();
		tablaDistribuciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model = new DefaultTableModel();
		tablaDistribuciones.setModel(model);
		
		model.addColumn("Fecha Entrega");
		model.addColumn("Beneficiario");
		model.addColumn("Estado");
		
		scrollPane.setViewportView(tablaDistribuciones);
		
		JLabel lblNewLabel = new JLabel("Listar Distribuciones Por Zona");
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
				listarDistribucionActionPerformed(arg0);
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListar.setBounds(182, 69, 117, 30);
		getContentPane().add(btnListar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarDistribucionCancelarActionPerformed(arg0);
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(309, 69, 117, 30);
		getContentPane().add(btnCancelar);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(Barrio.values()));
		comboBox.setBounds(24, 69, 148, 30);
		getContentPane().add(comboBox);
	}
	
	protected void listarDistribucionActionPerformed(ActionEvent arg0) {
		String barrio;
		model.setRowCount(0);
		barrio= comboBox.getSelectedItem().toString();
		
		if (comboBox.getSelectedItem().toString().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debera seleccionar el barrio", "Listar Distribucion", JOptionPane.INFORMATION_MESSAGE);
		}else{
			barrio= comboBox.getSelectedItem().toString();
			datos = icon.listarDistribucionesZona(barrio);		
			
		}
		
		if (datos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No existen distribuciones a listar", "Listar Distribucion", JOptionPane.INFORMATION_MESSAGE);
			}else {
				for (DtDistribucionZona d : datos) {
					Object[] fila = new Object[3];
					fila[0] = d.getFechaEntrega();
					fila[1] = d.getNombreBeneficiario();
					fila[2] = d.getEstado();
					
					model.addRow(fila);
					
				}
				
			}
		
		
	}
	protected void listarDistribucionCancelarActionPerformed(ActionEvent arg0) {
	 	btnListar.setBounds(182, 69, 117, 30);
	 	btnCancelar.setBounds(309, 69, 117, 30);
	 	model.setRowCount(0);
        setVisible(false);
	}
}