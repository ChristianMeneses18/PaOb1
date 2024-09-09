package com.ayudamos.presentacion;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import com.ayudamos.interfaces.IControlador;

public class ModificarDonacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JComboBox<String> comboBoxTipo;
	private JTable tablaUsuarios;
	private DefaultTableModel model;
	
	public ModificarDonacion(IControlador icon) {
		this.icon = icon;
		setTitle("Modificar Donacion");
        setBounds(100, 100, 583, 514);
        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        getContentPane().setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 160, 515, 250);
		getContentPane().add(scrollPane);
        
        JLabel lblTitulo = new JLabel("Modificar Donacion");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 10, 567, 40);
        getContentPane().add(lblTitulo);     
        
        JLabel lblTipoDonacion = new JLabel("Ver:");
        lblTipoDonacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTipoDonacion.setBounds(10, 100, 150, 30);
        getContentPane().add(lblTipoDonacion);
        
        comboBoxTipo = new JComboBox<>(new String[] {"Alimentos", "Artículos"});
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Alimentos", "Artículos"}));
        comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxTipo.setBounds(182, 100, 150, 30);
        comboBoxTipo.setSelectedItem(lblTipoDonacion);
        getContentPane().add(comboBoxTipo);
        
        tablaUsuarios = new JTable();
		tablaUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model = new DefaultTableModel();
		tablaUsuarios.setModel(model);	
		
		model.addColumn("ID");
		model.addColumn("Fecha Ingresada");
		
		if(comboBoxTipo.getSelectedItem().toString().equals("Alimentos")) {
			model.addColumn("Cantidad Elementos");
			model.addColumn("Descripcion");
		} else {
			model.addColumn("Descripción");
			model.addColumn("Dimensiones");
			model.addColumn("Peso (kg)");
			
			
		}
		
		
		scrollPane.setViewportView(tablaUsuarios);
	}

}
