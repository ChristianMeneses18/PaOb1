package com.ayudamos.presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ayudamos.datatypes.DtAlimento;
import com.ayudamos.datatypes.DtArticulo;
import com.ayudamos.datatypes.DtDonacion;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.interfaces.IControlador;
import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AltaDonacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JTextField textId;
	private JTextField textPeso;
	private JTextField textDimensiones;
	private JTextArea textAreaDesc;
	private JSpinner spinnerCantElem;	
	private JComboBox<String> comboBoxTipo;
	private JDateChooser dateChooser;
	
	private JLabel lblCantElem;
	private JLabel lblPeso;
	private JLabel lblDimensiones;
	private JButton btnCancelar;
	
	
	public AltaDonacion(IControlador icon) {
		this.icon = icon;
		setTitle("Alta de Donacion");
        setBounds(100, 100, 583, 514);
        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Alta de Donacion");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 10, 567, 40);
        getContentPane().add(lblTitulo);
        
        JLabel lblId = new JLabel("Id:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblId.setBounds(10, 60, 100, 30);
        getContentPane().add(lblId);
        
        textId = new JTextField();
        textId.setEditable(false);
        textId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textId.setBounds(182, 60, 126, 30);
        getContentPane().add(textId);
        textId.setColumns(10);
        
        JLabel lblFechaIng = new JLabel("Fecha Ingreso:");
        lblFechaIng.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFechaIng.setBounds(10, 100, 162, 30);
        getContentPane().add(lblFechaIng);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(182, 101, 145, 30);
        getContentPane().add(dateChooser);
        
        JLabel lblTipoDonacion = new JLabel("Tipo de Donación:");
        lblTipoDonacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTipoDonacion.setBounds(10, 140, 150, 30);
        getContentPane().add(lblTipoDonacion);
        
        comboBoxTipo = new JComboBox<>(new String[] {"Alimento", "Artículo"});
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Alimento", "Artículo"}));
        comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxTipo.setBounds(182, 140, 150, 30);
        getContentPane().add(comboBoxTipo);
        
        JLabel lblDescripcionProd = new JLabel("Descripción:");
        lblDescripcionProd.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDescripcionProd.setBounds(10, 180, 145, 30);
        getContentPane().add(lblDescripcionProd);
        
        textAreaDesc = new JTextArea();
        textAreaDesc.setBounds(182, 180, 312, 90);
        textAreaDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(textAreaDesc);
        
        lblCantElem = new JLabel("Elementos:");
        lblCantElem.setBounds(10, 360, 162, 14);
        //lblCantElem.setBounds(10, 280, 162, 14);
        lblCantElem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblCantElem);
        
        spinnerCantElem = new JSpinner();
        spinnerCantElem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        spinnerCantElem.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
        spinnerCantElem.setBounds(182, 360, 30, 20);
        //spinnerCantElem.setBounds(182, 280, 30, 20);
        getContentPane().add(spinnerCantElem);
        
        lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(10, 280, 162, 14);
        lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblPeso);
        
        textPeso = new JTextField();
        textPeso.setBounds(182, 280, 130, 20);
        textPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(textPeso);
        textPeso.setColumns(10);
        
        lblDimensiones = new JLabel("Dimensiones:");
        lblDimensiones.setBounds(10, 320, 145, 14);
        lblDimensiones.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblDimensiones);
        
        textDimensiones = new JTextField();
        textDimensiones.setBounds(182, 320, 86, 20);
        textDimensiones.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(textDimensiones);
        textDimensiones.setColumns(10);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		altaDonacionAceptarActionPerformed(arg0);
        	}        
        });
        
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAgregar.setBounds(167, 413, 117, 30);
        getContentPane().add(btnAgregar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancelar.setBounds(315, 413, 117, 30);
        getContentPane().add(btnCancelar);
        
        
        
        
        
        
        
     // Add action listener to JComboBox to handle visibility changes
        comboBoxTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCamposVisibles();
            }
        });

        actualizarCamposVisibles();
    }

    private void actualizarCamposVisibles() {
        String tipoDonacion = (String) comboBoxTipo.getSelectedItem();
        boolean esAlimento = "Alimento".equals(tipoDonacion);

        lblCantElem.setVisible(esAlimento);
        spinnerCantElem.setVisible(esAlimento);
        
        lblPeso.setVisible(!esAlimento);
        textPeso.setVisible(!esAlimento);
        
        lblDimensiones.setVisible(!esAlimento);
        textDimensiones.setVisible(!esAlimento);
        
        if(esAlimento) {
        	spinnerCantElem.setBounds(182, 280, 30, 20);
        	lblCantElem.setBounds(10, 280, 162, 14);
        }    
                
        
        revalidate();
        repaint();
}

protected void altaDonacionCancelarActionPerformed(ActionEvent arg0) {
	limpiarFormulario();
	setVisible(false);
}

protected void altaDonacionAceptarActionPerformed(ActionEvent arg0) {
	
	DtDonacion dt = null;
	Date selectedDate;
	Calendar calendar;
	int dia, mes, anio;	
	String descripcion = this.textAreaDesc.getText();
	selectedDate = dateChooser.getDate();
	calendar = Calendar.getInstance();
	calendar.setTime(selectedDate);	
	dia = calendar.get(Calendar.DAY_OF_MONTH);
	mes = calendar.get(Calendar.MONTH) + 1;
	anio = calendar.get(Calendar.YEAR);
	

	
	
	if(comboBoxTipo.getSelectedItem().toString().equals("Alimento")) {
		Integer elementos = (Integer) this.spinnerCantElem.getValue();
		dt = new DtAlimento(0,selectedDate,descripcion,elementos);		
	} else {
		//try {
			float peso = Float.parseFloat(this.textPeso.getText());
		//} catch (NumberFormatException e) {
	        // Manejo de errores si la cadena no es un número flotante válido
	     //   System.out.println("La cadena no es un número flotante válido.");
	    //}	
		String dimensiones = this.textDimensiones.getText();
		dt = new DtArticulo(0,selectedDate,descripcion,peso,dimensiones);
	}
	
	this.icon.altaDonacion(dt);
	JOptionPane.showMessageDialog(this, "Se dio de alta a la donación", "Alta Donación", JOptionPane.INFORMATION_MESSAGE);
	setVisible(false);
    limpiarFormulario();	
	
}

private void limpiarFormulario() {
	textAreaDesc.setText("");
	dateChooser.setCalendar(null);
    textPeso.setText("");
    spinnerCantElem.setValue(1);
    textDimensiones.setText("");    
}
}
