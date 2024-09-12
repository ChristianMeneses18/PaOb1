package com.ayudamos.presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import com.ayudamos.datatypes.DtAlimento;
import com.ayudamos.datatypes.DtArticulo;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
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
	private int selectedRow = -1;
	private JButton btnSeleccionar;
	private JButton btnModificar;
	private JButton btnAtras;
	private JLabel lblId;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JLabel lblCantElem;
	
	private JTextField txtId;
	private JTextField txtFecha;
	private JTextArea txtAreaDesc;
	private JSpinner spinnerCantElem;
	
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
        
        //label y text ocultos
        
        lblId = new JLabel("Id: ");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblId.setBounds(20, 126, 100, 30);
		getContentPane().add(lblId);
		lblId.setVisible(false);
		
		lblFecha = new JLabel("Fecha ingreso: ");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFecha.setBounds(20, 156, 100, 30);
		getContentPane().add(lblFecha);
		lblFecha.setVisible(false);
		
		lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcion.setBounds(20, 186, 100, 30);
		getContentPane().add(lblDescripcion);
		lblDescripcion.setVisible(false);
		
		lblCantElem = new JLabel("Elementos: ");
		lblCantElem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantElem.setBounds(20, 216, 100, 30);
		getContentPane().add(lblCantElem);
		lblCantElem.setVisible(false);
		
		
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setBounds(155, 126, 350, 30);
        getContentPane().add(txtId);
        txtId.setColumns(10);
        txtId.setVisible(false);
        
        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtFecha.setColumns(10);
        txtFecha.setBounds(155, 156, 350, 30);
		getContentPane().add(txtFecha);
		txtFecha.setVisible(false);
		
		txtAreaDesc = new JTextArea();
		txtAreaDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAreaDesc.setColumns(10);
		txtAreaDesc.setBounds(155, 186, 350, 30);
		getContentPane().add(txtAreaDesc);
		txtAreaDesc.setVisible(false);
        
		spinnerCantElem = new JSpinner();
        spinnerCantElem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        spinnerCantElem.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
        spinnerCantElem.setBounds(182, 216, 60, 20);
        getContentPane().add(spinnerCantElem);
        
        
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
	    
		
	btnSeleccionar = new JButton("Seleccionar");
	btnSeleccionar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(comboBoxTipo.getSelectedItem().toString().equals("Alimentos")) {
				selectedRow = tablaAlimentos.getSelectedRow();
				if (selectedRow != -1) {
		        	String idSel = String.valueOf(modelAlimentos.getValueAt(selectedRow, 0));
		        	String fechaSel = (String) modelAlimentos.getValueAt(selectedRow, 1);
		        	String descripcionProdSel = (String) modelAlimentos.getValueAt(selectedRow, 2);
					int cantElemSel = (int)modelAlimentos.getValueAt(selectedRow, 3);
					
					
					txtId.setText(idSel);
					txtFecha.setText(fechaSel);
					txtAreaDesc.setText(descripcionProdSel);
					spinnerCantElem.setValue(cantElemSel);
					
					lblTipoDonacion.setVisible(false);
					btnSeleccionar.setVisible(false);
					scrollPane.setVisible(false);					
					comboBoxTipo.setVisible(false);
					
					txtId.setVisible(true);					
					txtFecha.setVisible(true);
					txtAreaDesc.setVisible(true);
					spinnerCantElem.setVisible(true);
					txtId.setEditable(false);
					txtFecha.setEditable(false);
					
					lblId.setVisible(true);
					lblFecha.setVisible(true);
					lblDescripcion.setVisible(true);
					lblCantElem.setVisible(true);
					
					btnModificar.setVisible(true);
					btnAtras.setVisible(true);
					
					
		            
				} else {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona una donacion de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
				
				
			} /*else {
				selectedRow = tablaArticulos.getSelectedRow();
				
				if (selectedRow!= -1) {
					String idSel = (String) modelAlimentos.getValueAt(selectedRow, 0);
					String fechaSel = (String) modelAlimentos.getValueAt(selectedRow, 1);
		        	String descripcionSel = (String) modelAlimentos.getValueAt(selectedRow, 2);
		        	String elemSel = (String) modelAlimentos.getValueAt(selectedRow, 3);
		        	String pesoSel = (String) modelAlimentos.getValueAt(selectedRow, 4);
				} else {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona una donacion de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
			} */
			
	        
			
		}
	});
	btnSeleccionar.setBounds(450, 434, 107, 39);
	getContentPane().add(btnSeleccionar);
	
	btnModificar = new JButton("Modificar");
	btnModificar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			if(comboBoxTipo.getSelectedItem().toString().equals("Alimentos")) {				
				DtAlimento Dt = new DtAlimento(Integer.parseInt(txtId.getText()),null,txtAreaDesc.getText(),(Integer)spinnerCantElem.getValue());
				icon.modificarAlimento(Dt);
				JOptionPane.showMessageDialog(ModificarDonacion.this, "Donacion modificada con exito", "Modificar Donacion", JOptionPane.INFORMATION_MESSAGE);
	            setVisible(false);
			}
		}
			
	});
	
	
	btnModificar.setBounds(450, 434, 107, 39);
	getContentPane().add(btnModificar);
	btnModificar.setVisible(false);
	
	btnAtras = new JButton("Atras");
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			limpiarFormulario();
			
			btnSeleccionar.setVisible(true);
			scrollPane.setVisible(true);					
			comboBoxTipo.setVisible(true);
			
			txtId.setVisible(false);					
			txtFecha.setVisible(false);
			txtAreaDesc.setVisible(false);
			spinnerCantElem.setVisible(false);
			
			lblId.setVisible(false);
			lblFecha.setVisible(false);
			lblDescripcion.setVisible(false);
			lblCantElem.setVisible(false);
			
			btnModificar.setVisible(false);
			btnAtras.setVisible(false);
		}
	});
	btnAtras.setBounds(5, 434, 107, 39);
	getContentPane().add(btnAtras);
	btnAtras.setVisible(false);
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
		private void limpiarFormulario() {
			txtId.setText("");
			txtFecha.setText("");
			txtAreaDesc.setText("");
			spinnerCantElem.setValue(1);;    
		}
}
