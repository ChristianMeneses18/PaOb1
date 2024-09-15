package com.ayudamos.presentacion;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ayudamos.datatypes.DtDistribucion;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.ayudamos.enums.Barrio;
import com.ayudamos.enums.EstadoDistribucion;

public class ListarDistribucionesEstado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JTable tablaBeneficiarios;
	private DefaultTableModel model;
	private JButton btnListar;
	private JButton btnCancelar;
	private JComboBox comboBoxEstado;
	private ArrayList<DtDistribucion> datos;

	public ListarDistribucionesEstado(IControlador icon) {
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
		
		model.addColumn("Estado");
		model.addColumn("Fecha de preparacion");
		model.addColumn("Fecha de entrega");
		model.addColumn("Beneficiario");
		model.addColumn("Donación");
		
		scrollPane.setViewportView(tablaBeneficiarios);
		
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
				listarBeneficiarioCancelarActionPerformed(arg0);
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(309, 69, 117, 30);
		getContentPane().add(btnCancelar);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxEstado.setModel(new DefaultComboBoxModel(Barrio.values()));
		comboBoxEstado.setBounds(24, 69, 148, 30);
		getContentPane().add(comboBoxEstado);
	}
	
	protected void listarDistribucionActionPerformed(ActionEvent arg0) {
		model.setRowCount(0);
		String estado = comboBoxEstado.getSelectedItem().toString();
		
		if (estado.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debera seleccionar el estado", "Listar Distribución", JOptionPane.INFORMATION_MESSAGE);
		}else{
			datos = icon.listarBeneficiariosZona(estado);
		}
		
		if (datos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No existen Distribuciones a listar", "Listar Beneficiario", JOptionPane.INFORMATION_MESSAGE);
			}else {
				for (DtDistribucion d : datos) {
					Object[] fila = new Object[3];
					fila[0] = d.getEstado();
					fila[1] = d.getFechaPreparacion();
					fila[2] = d.getFechaEntrega().toString();
					fila[3] = d.getIdBeneficiario();
					fila[4] = d.getIdDonacion();
					
					model.addRow(fila);
					
				}
				
			}
		
		
	}
	
	 protected void listarBeneficiarioCancelarActionPerformed(ActionEvent arg0) {
		 	btnListar.setBounds(182, 69, 117, 30);
		 	btnCancelar.setBounds(309, 69, 117, 30);
		 	model.setRowCount(0);
	        setVisible(false);
		}
}