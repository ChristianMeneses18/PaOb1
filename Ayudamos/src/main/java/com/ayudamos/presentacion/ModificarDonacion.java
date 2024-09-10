package com.ayudamos.presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import com.ayudamos.datatypes.DtAlimento;
import com.ayudamos.datatypes.DtArticulo;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.interfaces.IControlador;

public class ModificarDonacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JComboBox<String> comboBoxTipo;
	private JTable tablaAlimentos;
	private JTable tablaArticulos;
	private DefaultTableModel modelAlimentos;
	private DefaultTableModel modelArticulos;
	private JScrollPane scrollPaneAlimentos;
	private JScrollPane scrollPaneArticulos;
	ArrayList<DtAlimento> listaAlimentos;
	ArrayList<DtArticulo> listaArticulos;
	
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
        comboBoxTipo.setSelectedItem("Alimentos");
        getContentPane().add(comboBoxTipo);
        
        //tabla alimentos
     // Modificar tabla alimentos
        modelAlimentos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas sean no editables
            }
        };
        modelAlimentos.addColumn("ID");
        modelAlimentos.addColumn("Fecha Ingresada");
        modelAlimentos.addColumn("Descripción");
        modelAlimentos.addColumn("Cantidad Elementos");
        
        tablaAlimentos = new JTable(modelAlimentos);
        tablaAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 15));	
        scrollPane.setViewportView(tablaAlimentos);
        
        //tabla articulos
        modelArticulos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas sean no editables
            }
        };
        modelArticulos.addColumn("ID");
        modelArticulos.addColumn("Fecha Ingresada");
        modelArticulos.addColumn("Descripción");
        modelArticulos.addColumn("Dimensiones");
        modelArticulos.addColumn("Peso (kg)");
        
        tablaArticulos = new JTable(modelArticulos);
        tablaArticulos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        cargarDatosAlimentos();
        revalidate();
        repaint();
        
	    comboBoxTipo.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(comboBoxTipo.getSelectedItem().toString().equals("Alimentos")) {
	    			scrollPane.setViewportView(tablaAlimentos);
	    			cargarDatosAlimentos();
	        	} else {
	        		scrollPane.setViewportView(tablaArticulos);
	        		cargarDatosArticulos();
	        	}
	        revalidate();
	        repaint();
	        }
	    });
	    
		}
	
	
		private void cargarDatosAlimentos(){
			modelAlimentos.setRowCount(0);
			listaAlimentos = icon.listarAlimentos();
			
			//formateo fechas
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			
			if(!listaAlimentos.isEmpty()) {
				for (DtAlimento a : listaAlimentos) {
					Object[] fila = new Object[4];
					fila[0] = a.getId();
					fila[1] = sdf.format(a.getFechaIngresada());
					fila[2] = a.getDescripcionProductos();
					fila[3] = a.getCantElementos();
					
					
					modelAlimentos.addRow(fila);
					
					tablaAlimentos.getColumnModel().getColumn(0).setPreferredWidth(20);
					tablaAlimentos.getColumnModel().getColumn(1).setPreferredWidth(120);
					
				}
			}
		}
		
		private void cargarDatosArticulos(){
			modelArticulos.setRowCount(0);
			listaArticulos = icon.listarArticulos();
			
			//formateo fechas
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			
			if(!listaArticulos.isEmpty()) {
				for (DtArticulo a : listaArticulos) {
					Object[] fila = new Object[5];
					fila[0] = a.getId();
					fila[1] = sdf.format(a.getFechaIngresada());
					fila[2] = a.getDescripcion();
					fila[3] = a.getDimensiones();
					fila[4] = a.getPeso();
					
					
					modelArticulos.addRow(fila);
					
					tablaArticulos.getColumnModel().getColumn(0).setPreferredWidth(20);
					tablaArticulos.getColumnModel().getColumn(1).setPreferredWidth(140);
					
				}
			}
		}
	
}
