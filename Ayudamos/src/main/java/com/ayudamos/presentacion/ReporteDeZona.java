package com.ayudamos.presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.enums.Barrio;
import com.ayudamos.interfaces.IControlador;
import com.toedter.calendar.JDateChooser;

public class ReporteDeZona extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JLabel lblTitulo;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFin;
	private JLabel lblGuion;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFin;
	private JScrollPane scrollPane;
	private JTable tablaDistribuciones;
	private DefaultTableModel model;
	private ArrayList<Object[]> lista;
	private JButton btnListar;
	private JButton btnCancelar;
	
	
	public ReporteDeZona(IControlador icon) {
		this.icon = icon;
		setBounds(100, 100, 583, 514);
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Reporte de Zona con Mayor Distribuciones");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setBackground(UIManager.getColor("Button.focus"));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(10, 11, 535, 47);
		getContentPane().add(lblTitulo);
		
		lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaInicio.setBounds(50, 92, 100, 30);
        getContentPane().add(lblFechaInicio);

        dateChooserInicio = new JDateChooser();
        dateChooserInicio.getCalendarButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        dateChooserInicio.setBounds(34, 133, 136, 30);
        getContentPane().add(dateChooserInicio);
        
        lblGuion = new JLabel("-");
        lblGuion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblGuion.setBounds(216, 92, 16, 30);
        getContentPane().add(lblGuion);
        
        lblFechaFin = new JLabel("Fecha Fin");
        lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFechaFin.setBounds(304, 92, 89, 30);
        getContentPane().add(lblFechaFin);
        
        dateChooserFin = new JDateChooser();
        dateChooserFin.getCalendarButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        dateChooserFin.setBounds(275, 133, 136, 30);
        getContentPane().add(dateChooserFin);
        
        
        scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 181, 515, 244);
		getContentPane().add(scrollPane);
		
		tablaDistribuciones = new JTable();
		tablaDistribuciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model = new DefaultTableModel();
		tablaDistribuciones.setModel(model);
		
		model.addColumn("Zona");
		model.addColumn("Cantidad de Distribuciones");
		model.addColumn("Cantidad de Beneficiarios");
		
		scrollPane.setViewportView(tablaDistribuciones);
		
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				
				Date selectedDate;
				Calendar calendar;
				int dia , mes , anio;
				
				selectedDate = dateChooserInicio.getDate();
				calendar = Calendar.getInstance();
				calendar.setTime(selectedDate);
				
				dia = calendar.get(Calendar.DAY_OF_MONTH);
				mes = calendar.get(Calendar.MONTH) + 1;
				anio = calendar.get(Calendar.YEAR);
				DtFecha fechaInicio = new DtFecha(dia,mes,anio);
				
				selectedDate = dateChooserFin.getDate();
				calendar = Calendar.getInstance();
				calendar.setTime(selectedDate);
				
				dia = calendar.get(Calendar.DAY_OF_MONTH);
				mes = calendar.get(Calendar.MONTH) + 1;
				anio = calendar.get(Calendar.YEAR);
				DtFecha fechaFin = new DtFecha(dia,mes,anio);
				
				
				lista = icon.listarDistribucionPorZona(fechaInicio, fechaFin);
				
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(ReporteDeZona.this, "No existen distribucion en la fecha seleccionada", "Reporte de Zonas", JOptionPane.INFORMATION_MESSAGE);
				}else {
					for (Object[] d : lista) {
						int barrio = (int) d[0];
						int numDistribuciones = ((BigInteger) d[1]).intValue();
						int numBeneficiarios = ((BigInteger) d[2]).intValue();

						Object[] fila = new Object[3];
						fila[0] = barrioAString(barrio);
						fila[1] = numDistribuciones;
						fila[2] = numBeneficiarios;

						model.addRow(fila);
					}
				}
			}
		});
		btnListar.setBounds(456, 132, 89, 47);
		getContentPane().add(btnListar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(10, 436, 107, 39);
		getContentPane().add(btnCancelar);

	}
	
	private String barrioAString(int barrio) {
		String rt = "";
		
		if(barrio == 0) {
			rt = "CIUDAD_VIEJA";
		}else if (barrio == 1) {
			rt = "CORDON";
		}else if (barrio == 2) {
			rt = "PARQUE_RODO";
		}else if (barrio == 3) {
			rt = "CENTRO";
		}else if (barrio == 4) {
			rt = "PALERMO";
		}
		
		return rt;
	}
	
	private void limpiar() {
		dateChooserInicio.setCalendar(null);
		dateChooserFin.setCalendar(null);
        model.setRowCount(0);

	}

}
