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
import com.ayudamos.excepciones.DistribucionRepetidaExcepcion;

public class AgregarDistribucion extends JInternalFrame {

			
			private IControlador icon;
			
		    private static final long serialVersionUID = 1L;
		    private JTextField txtBeneficiario;
		    private JTextField txtDonacion;
		    private JLabel lblBeneficiario;
		    private JLabel lblMinutosPreparacion;
		    private JLabel lblHorasPreparacion;
		    private JComboBox<String> comboBoxHoraPreparacion;
		    private JComboBox<String> comboBoxMinutosPreparacion;
		    private JComboBox<String> comboBoxHoraEntrega;
		    private JComboBox<String> comboBoxMinutosEntrega;
		    private JDateChooser dateChooserFechaPreparacion;
		    private JDateChooser dateChooserFechaEntrega;
		    private JLabel lblDonacion;
		    private JButton btnAgregar;
		    private JButton btnCancelar;
		     
	/**
	 * Create the application.
	 */
	public AgregarDistribucion(IControlador icon) {
		
		this.icon = icon;
        setTitle("Alta de Distribución");
        setBounds(100, 100, 643, 515);
        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        getContentPane().setLayout(null);
		
        JLabel lblTitulo = new JLabel("Alta de Distribución");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 10, 567, 40);
        getContentPane().add(lblTitulo);

        JLabel lblFechaEntrega = new JLabel("Fecha Entrega:");
        lblFechaEntrega.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFechaEntrega.setBounds(23, 233, 150, 30);
        getContentPane().add(lblFechaEntrega);

        dateChooserFechaPreparacion = new JDateChooser();
        dateChooserFechaPreparacion.setBounds(182, 192, 212, 30);
        getContentPane().add(dateChooserFechaPreparacion);
        
        lblBeneficiario = new JLabel("Id de Beneficiario:");
        lblBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBeneficiario.setBounds(23, 274, 150, 30);
        getContentPane().add(lblBeneficiario);

        txtBeneficiario = new JTextField();
        txtBeneficiario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtBeneficiario.setBounds(195, 274, 350, 30);
        getContentPane().add(txtBeneficiario);
        txtBeneficiario.setColumns(10);
        
        lblDonacion = new JLabel("ID de Donación:");
        lblDonacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDonacion.setBounds(23, 315, 150, 30);
        getContentPane().add(lblDonacion);

        txtDonacion = new JTextField();
        txtDonacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtDonacion.setBounds(195, 315, 350, 30);
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
        
        JLabel lblHoraPreparacion = new JLabel("H:");
        lblHoraPreparacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHoraPreparacion.setBounds(407, 192, 25, 30);
        getContentPane().add(lblHoraPreparacion);
        
        lblMinutosPreparacion = new JLabel("M:");
        lblMinutosPreparacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMinutosPreparacion.setBounds(500, 192, 25, 30);
        getContentPane().add(lblMinutosPreparacion);
        

        comboBoxHoraPreparacion = new JComboBox(this.agregarHoras());
        comboBoxHoraPreparacion.setBounds(428, 199, 62, 22);
        getContentPane().add(comboBoxHoraPreparacion);
        
        comboBoxMinutosPreparacion = new JComboBox(this.agregarMinutos());
        comboBoxMinutosPreparacion.setBounds(535, 199, 62, 22);
        getContentPane().add(comboBoxMinutosPreparacion);
        
        JLabel lblFechaPreparacion = new JLabel("Fecha Preparación:");
        lblFechaPreparacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFechaPreparacion.setBounds(23, 192, 150, 30);
        getContentPane().add(lblFechaPreparacion);
        
        dateChooserFechaEntrega = new JDateChooser();
        dateChooserFechaEntrega.setBounds(183, 233, 212, 30);
        getContentPane().add(dateChooserFechaEntrega);
        
        comboBoxMinutosEntrega = new JComboBox(this.agregarMinutos());
        comboBoxMinutosEntrega.setBounds(535, 240, 62, 22);
        getContentPane().add(comboBoxMinutosEntrega);
        
        JLabel lblMinutosEntrega = new JLabel("M:");
        lblMinutosEntrega.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMinutosEntrega.setBounds(500, 233, 25, 30);
        getContentPane().add(lblMinutosEntrega);
        
        comboBoxHoraEntrega = new JComboBox(this.agregarHoras());
        comboBoxHoraEntrega.setBounds(428, 240, 62, 22);
        getContentPane().add(comboBoxHoraEntrega);
        
        JLabel lblHoraEntrega = new JLabel("H:");
        lblHoraEntrega.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHoraEntrega.setBounds(405, 233, 25, 30);
        getContentPane().add(lblHoraEntrega);
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
    	Date selectedDatePreparacion;
    	Date selectedDateEntrega;
		Calendar calendar;
		int dia , mes , anio;
		
		int beneficiario = Integer.parseInt(this.txtBeneficiario.getText());
		int donacion = Integer.parseInt(this.txtDonacion.getText());
		
		selectedDatePreparacion = dateChooserFechaPreparacion.getDate();
		calendar = Calendar.getInstance();
		calendar.setTime(selectedDatePreparacion);
	    int horaSeleccionadaPreparacion = Integer.parseInt(comboBoxHoraPreparacion.getSelectedItem().toString());
	    int minutosSeleccionadosPreparacion = Integer.parseInt(comboBoxMinutosPreparacion.getSelectedItem().toString());
	    
	    calendar.setTime(selectedDatePreparacion);
	    calendar.set(Calendar.HOUR_OF_DAY, horaSeleccionadaPreparacion);
	    calendar.set(Calendar.MINUTE, minutosSeleccionadosPreparacion);
	    Date fechaPreparacion = calendar.getTime();
	    
	    selectedDateEntrega = dateChooserFechaEntrega.getDate();
		calendar = Calendar.getInstance();
		calendar.setTime(selectedDateEntrega);
	    
	    int horaSeleccionadaEntrega = Integer.parseInt(comboBoxHoraEntrega.getSelectedItem().toString());
	    int minutosSeleccionadosEntrega = Integer.parseInt(comboBoxMinutosEntrega.getSelectedItem().toString());

	    calendar.setTime(selectedDateEntrega);
	    calendar.set(Calendar.HOUR_OF_DAY, horaSeleccionadaEntrega);
	    calendar.set(Calendar.MINUTE, minutosSeleccionadosEntrega);
	    Date fechaEntrega = calendar.getTime();
	   
		
		
		DtDistribucion dt = new DtDistribucion(beneficiario, donacion, fechaPreparacion,fechaEntrega,EstadoDistribucion.PENDIENTE);

            this.icon.agregarDistribucion(dt);
        
            JOptionPane.showMessageDialog(this, "Distribucion agregado con exito", "Agregar Distribucion", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            limpiarFormulario();
           
    }
    
      
	 private void limpiarFormulario() {
	        dateChooserFechaPreparacion.setCalendar(null);
	        dateChooserFechaEntrega.setCalendar(null);
	        comboBoxHoraPreparacion.setSelectedIndex(-1);
	        comboBoxMinutosPreparacion.setSelectedIndex(-1);
	        comboBoxHoraEntrega.setSelectedIndex(-1);
	        comboBoxMinutosEntrega.setSelectedIndex(-1);
	        txtBeneficiario.setText("");
	        txtDonacion.setText(""); 
	 }
}
