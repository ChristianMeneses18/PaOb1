package com.ayudamos.presentacion;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ayudamos.datatypes.DtDistribucion;
import com.ayudamos.datatypes.DtFechaHora;
import com.ayudamos.enums.Barrio;
import com.ayudamos.enums.EstadoDistribucion;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.interfaces.IControlador;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;

public class AgregarDistribucion extends JInternalFrame {

			
			private IControlador icon;
			
		    private static final long serialVersionUID = 1L;
		    private JTextField txtBeneficiario;
		    private JTextField txtDonacion;
		    private JLabel lblBeneficiario;
		    private JLabel lblMinutosPreparacion;
		    private JLabel lblHorasPreparacion;
		    private JComboBox<String> comboBoxHora;
		    private JComboBox<String> comboBoxMinutos;
		    private JDateChooser dateChooserFechaPreparacion;
		    private JLabel lblDonacion;
		    private JButton btnAgregar;
		    private JButton btnCancelar;
		     
	/**
	 * Create the application.
	 */
	public AgregarDistribucion(IControlador icon) {
		
		this.icon = icon;
        setTitle("Alta de Distribución");
        setBounds(100, 100, 583, 515);
        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        getContentPane().setLayout(null);
	//	initialize();
		
        JLabel lblTitulo = new JLabel("Alta de Distribución");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 10, 567, 40);
        getContentPane().add(lblTitulo);

        JLabel lblFechaPreparacion = new JLabel("Fecha Preparación:");
        lblFechaPreparacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFechaPreparacion.setBounds(10, 159, 150, 30);
        getContentPane().add(lblFechaPreparacion);

        dateChooserFechaPreparacion = new JDateChooser();
        dateChooserFechaPreparacion.setBounds(182, 159, 212, 30);
        getContentPane().add(dateChooserFechaPreparacion);
        
        lblBeneficiario = new JLabel("Email Beneficiario:");
        lblBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBeneficiario.setBounds(10, 242, 150, 30);
        getContentPane().add(lblBeneficiario);

        txtBeneficiario = new JTextField();
        txtBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtBeneficiario.setBounds(182, 242, 350, 30);
        getContentPane().add(txtBeneficiario);
        txtBeneficiario.setColumns(10);
        
        lblDonacion = new JLabel("ID de Donación:");
        lblDonacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDonacion.setBounds(10, 283, 150, 30);
        getContentPane().add(lblDonacion);

        txtDonacion = new JTextField();
        txtDonacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtDonacion.setBounds(182, 283, 350, 30);
        getContentPane().add(txtDonacion);
        txtDonacion.setColumns(10);
		
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		agregarDistribucionAceptarActionPerformed(arg0);
        	}
        });
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAgregar.setBounds(167, 413, 117, 30);
        getContentPane().add(btnAgregar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		agregarDistribucionCancelarActionPerformed(arg0);
        		
        	}
        });
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancelar.setBounds(315, 413, 117, 30);
        getContentPane().add(btnCancelar);
        
        JLabel lblHoraPreparacin = new JLabel("Hora:");
        lblHoraPreparacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHoraPreparacin.setBounds(101, 201, 56, 30);
        getContentPane().add(lblHoraPreparacin);
        
        lblMinutosPreparacion = new JLabel("Minutos:");
        lblMinutosPreparacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMinutosPreparacion.setBounds(239, 200, 76, 30);
        getContentPane().add(lblMinutosPreparacion);
        

        comboBoxHora = new JComboBox(this.agregarHoras());
        comboBoxHora.setBounds(164, 209, 62, 22);
        getContentPane().add(comboBoxHora);
        
        comboBoxMinutos = new JComboBox(this.agregarMinutos());
        comboBoxMinutos.setBounds(325, 209, 62, 22);
        getContentPane().add(comboBoxMinutos);
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

    protected void agregarDistribucionCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
    protected void agregarDistribucionAceptarActionPerformed(ActionEvent arg0) {
    	Date selectedDate;
		Calendar calendar;
		int dia , mes , anio;
		
		String beneficiario = this.txtBeneficiario.getText();
		String donacion = this.txtDonacion.getText();
		DtDistribucion dt = null;
		
		selectedDate = dateChooserFechaPreparacion.getDate();
		calendar = Calendar.getInstance();
		calendar.setTime(selectedDate);
		
	
	    int horaSeleccionada = Integer.parseInt(comboBoxHora.getSelectedItem().toString());
	    int minutosSeleccionados = Integer.parseInt(comboBoxMinutos.getSelectedItem().toString());

	    calendar.setTime(selectedDate);
	    calendar.set(Calendar.HOUR_OF_DAY, horaSeleccionada);
	    calendar.set(Calendar.MINUTE, minutosSeleccionados);

	    Date fechaPreparacion = calendar.getTime();
		System.out.print(fechaPreparacion);
		
		dt = new DtDistribucion(fechaPreparacion,null,EstadoDistribucion.PENDIENTE, txtBeneficiario.getText(), txtDonacion.getText());

            this.icon.agregarDistribucion(dt);
           
    }
    
      
	 private void limpiarFormulario() {
	        dateChooserFechaPreparacion.setCalendar(null);
	        txtBeneficiario.setText("");
	        txtDonacion.setText(""); 
	 }
}
