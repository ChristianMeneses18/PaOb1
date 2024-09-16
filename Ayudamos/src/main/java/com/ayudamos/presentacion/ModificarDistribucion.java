package com.ayudamos.presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Date;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtRepartidor;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.excepciones.DistribucionRepetidaExcepcion;
import com.ayudamos.interfaces.IControlador;
import com.toedter.calendar.JDateChooser;

import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.ayudamos.enums.EstadoDistribucion;

public class ModificarDistribucion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
	private IControlador icon;
	private JPanel contentPane;
	private JTable tablaDistribuciones;
	private DefaultTableModel model;
	private ArrayList<DtDistribucion> lista;
	private JButton btnListar;
	private JButton btnSeleccionar;
	private JButton btnModificar;
	private JButton btnAtras;
	private JButton btnCancelar;
	private JTextField txtEmail;
	private String emailSeleccionado;
	private JLabel lblHoras;
	private JLabel lblMinutos;
	private JComboBox<String> comboBoxHora;
	private JComboBox<String> comboBoxMinutos;
	private JComboBox<String> comboBoxEstado;
	private JDateChooser dateChooserFechaEntrega;

	
	public ModificarDistribucion(IControlador icon) {
		this.icon = icon;
		setBounds(100, 100, 583, 514);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 534, 257);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Modificar Distribución");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 535, 47);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione una distribución: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 79, 244, 14);
		getContentPane().add(lblNewLabel_1);
		
		tablaDistribuciones = new JTable();
		tablaDistribuciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model = new DefaultTableModel();
		tablaDistribuciones.setModel(model);
		
		model.addColumn("Estado");
		model.addColumn("Fecha de Preparación");
		model.addColumn("Fecha de Entrega");
		model.addColumn("Beneficiario");
		model.addColumn("Donacion");

		
		scrollPane.setViewportView(tablaDistribuciones);
		
		JLabel lblFechaEntrega = new JLabel("Fecha de entrega: ");
		lblFechaEntrega.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaEntrega.setBounds(23, 145, 147, 30);
		getContentPane().add(lblFechaEntrega);
		lblFechaEntrega.setVisible(false);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstado.setBounds(66, 227, 71, 30);
		getContentPane().add(lblEstado);
		lblEstado.setVisible(false);
		
		lblHoras = new JLabel("Hora:");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoras.setBounds(87, 186, 54, 30);
		getContentPane().add(lblHoras);
		lblHoras.setVisible(false);
		
		lblMinutos = new JLabel("Minutos:");
		lblMinutos.setBounds(252, 186, 79, 30);
		lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblMinutos);
		lblMinutos.setVisible(false);
		
		dateChooserFechaEntrega = new JDateChooser();
		dateChooserFechaEntrega.setBounds(180, 145, 212, 30);
        getContentPane().add(dateChooserFechaEntrega);
        dateChooserFechaEntrega.setVisible(false);

        
		
	    comboBoxHora = new JComboBox(this.agregarHoras());
	    comboBoxHora.setBounds(148, 193, 62, 22);
	    getContentPane().add(comboBoxHora);
	    comboBoxHora.setVisible(false);

	    
	    comboBoxMinutos = new JComboBox(this.agregarMinutos());
	    comboBoxMinutos.setBounds(341, 193, 62, 22);
	    getContentPane().add(comboBoxMinutos);
	    comboBoxMinutos.setVisible(false);

	    
	    comboBoxEstado = new JComboBox<>(new String[] {"Pendiente", "En camino", "Entregado"});
	    comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoDistribucion.values()));
	    comboBoxEstado.setBounds(147, 230, 245, 30);
	    getContentPane().add(comboBoxEstado);
	    comboBoxEstado.setVisible(false);

		
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				
				lista = icon.listarDistribuciones();
				
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(ModificarDistribucion.this, "No existen distribuciones a listar", "Listar Usuario", JOptionPane.INFORMATION_MESSAGE);
				}else {
					for (DtDistribucion d : lista) {
						Object[] fila = new Object[5];
						fila[0] = d.getEstado();
						fila[1] = d.getFechaPreparacion();
						fila[2] = d.getFechaEntrega();
						fila[3] = d.getIdBeneficiario();
						fila[4] = d.getIdDonacion();
								
						model.addRow(fila);
						
					}
				}
			}
		});
		btnListar.setBounds(477, 77, 67, 23);
		getContentPane().add(btnListar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tablaDistribuciones.getSelectedRow();
				
				if (selectedRow != -1) {
		        	Date fechaEntrega = (Date) model.getValueAt(selectedRow, 2);
		        	EstadoDistribucion estado = (EstadoDistribucion) model.getValueAt(selectedRow, 0);
		            
		        	Calendar calendar = Calendar.getInstance();
		        	calendar.setTime(fechaEntrega);
		        	dateChooserFechaEntrega.setDate(calendar.getTime());
		        	int hora = calendar.get(Calendar.HOUR_OF_DAY);
		        	int minutos = calendar.get(Calendar.MINUTE);
		        	
		            comboBoxEstado.setSelectedItem(estado);
		            comboBoxHora.setSelectedItem(String.format("%02d",hora));
		            comboBoxMinutos.setSelectedItem(String.format("%02d",minutos));
		            
		            btnSeleccionar.setVisible(false);
					lblNewLabel_1.setVisible(false);
					btnListar.setVisible(false);
					scrollPane.setVisible(false);
					
					dateChooserFechaEntrega.setVisible(true);
					comboBoxEstado.setVisible(true);
					comboBoxHora.setVisible(true);
					comboBoxMinutos.setVisible(true);
					lblFechaEntrega.setVisible(true);
					lblEstado.setVisible(true);
					btnModificar.setVisible(true);
					btnAtras.setVisible(true);
		            
				} else {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona una distribución de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
		btnSeleccionar.setBounds(450, 434, 107, 39);
		getContentPane().add(btnSeleccionar);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				int selectedRow = tablaDistribuciones.getSelectedRow();
				Date selectedDateEntrega;
				Calendar calendar;
				
				DtDistribucion distribucion = new DtDistribucion(
						(int) model.getValueAt(selectedRow, 3),
						(int) model.getValueAt(selectedRow, 4),
						(Date) model.getValueAt(selectedRow, 1),
						(Date) model.getValueAt(selectedRow, 2),
						(EstadoDistribucion) model.getValueAt(selectedRow, 0)
						);
				
				selectedDateEntrega = dateChooserFechaEntrega.getDate();
				calendar = Calendar.getInstance();
				calendar.setTime(selectedDateEntrega);
			    int horaSeleccionadaEntrega = Integer.parseInt(comboBoxHora.getSelectedItem().toString());
			    int minutosSeleccionadosEntrega = Integer.parseInt(comboBoxMinutos.getSelectedItem().toString());
			    
			    calendar.setTime(selectedDateEntrega);
			    calendar.set(Calendar.HOUR_OF_DAY, horaSeleccionadaEntrega);
			    calendar.set(Calendar.MINUTE, minutosSeleccionadosEntrega);
			    Date fechaEntrega = calendar.getTime();
				
				icon.modificarDistribucion(fechaEntrega,(EstadoDistribucion) comboBoxEstado.getSelectedItem(), distribucion);
				JOptionPane.showMessageDialog(ModificarDistribucion.this, "Distribucion modificado con exito", "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				limpiar();

				btnSeleccionar.setVisible(true);
				lblNewLabel_1.setVisible(true);
				btnListar.setVisible(true);
				scrollPane.setVisible(true);

				dateChooserFechaEntrega.setVisible(false);
				comboBoxEstado.setVisible(false);
				comboBoxHora.setVisible(false);
				comboBoxMinutos.setVisible(false);
				lblFechaEntrega.setVisible(false);
				lblEstado.setVisible(false);
				btnModificar.setVisible(false);
				btnAtras.setVisible(false);


			}
		});
		btnModificar.setBounds(450, 434, 107, 39);
		getContentPane().add(btnModificar);
		btnModificar.setVisible(false);
		
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				
				btnSeleccionar.setVisible(true);
				lblNewLabel_1.setVisible(true);
				btnListar.setVisible(true);
				scrollPane.setVisible(true);
				
				comboBoxEstado.setVisible(false);
				comboBoxHora.setVisible(false);
				comboBoxMinutos.setVisible(false);
				lblFechaEntrega.setVisible(false);
				lblEstado.setVisible(false);
				btnModificar.setVisible(false);
				btnAtras.setVisible(false);

			}
		});
		btnAtras.setBounds(5, 434, 107, 39);
		getContentPane().add(btnAtras);
		btnAtras.setVisible(false);
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(5, 434, 107, 39);
		getContentPane().add(btnCancelar);
		



	}

	private void limpiar() {
		comboBoxEstado.setSelectedIndex(1);
		comboBoxHora.setSelectedIndex(1);
		comboBoxMinutos.setSelectedIndex(1);
      //  dateChooserFechaEntrega.setDate(null);
        model.setRowCount(0);

	}
	
	private String[] agregarHoras() {
		String[] horas = new String[24];
		for(int i = 0; i<=23; i++) {
			horas[i] = String.format("%02d", i);
		}
		return horas;
	}
	
	private String[] agregarMinutos() {
		String[] minutos = new String[60];
		for(int i = 0; i<=59; i++) {
			minutos[i] = String.format("%02d", i);
		}
		return minutos;
	}
}
