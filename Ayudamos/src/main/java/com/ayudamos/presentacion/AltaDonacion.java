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
import com.ayudamos.interfaces.IControlador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AltaDonacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JTextField textDimensiones;
	private JTextArea textAreaDesc;
	private JSpinner spinnerCantElem;	
	private JSpinner spinnerPeso;
	private JComboBox<String> comboBoxTipo;
	
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
        
        JLabel lblTipoDonacion = new JLabel("Tipo de Donación:");
        lblTipoDonacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTipoDonacion.setBounds(10, 100, 150, 30);
        getContentPane().add(lblTipoDonacion);
        
        comboBoxTipo = new JComboBox<>(new String[] {"Alimento", "Artículo"});
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Alimento", "Artículo"}));
        comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxTipo.setBounds(182, 100, 150, 30);
        getContentPane().add(comboBoxTipo);
        
        JLabel lblDescripcionProd = new JLabel("Descripción:");
        lblDescripcionProd.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDescripcionProd.setBounds(10, 140, 145, 30);
        getContentPane().add(lblDescripcionProd);
        
        textAreaDesc = new JTextArea();
        textAreaDesc.setBounds(182, 140, 312, 90);
        textAreaDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(textAreaDesc);
        
        lblCantElem = new JLabel("Elementos:");
        lblCantElem.setBounds(10, 320, 162, 14);
        lblCantElem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblCantElem);
        
        spinnerCantElem = new JSpinner();
        spinnerCantElem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        spinnerCantElem.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
        spinnerCantElem.setBounds(182, 320, 60, 20);
        getContentPane().add(spinnerCantElem);
        
        lblPeso = new JLabel("Peso (KG):");
        lblPeso.setBounds(10, 240, 162, 14);
        lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblPeso);
        
        spinnerPeso = new JSpinner();
        spinnerPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
        spinnerPeso.setModel(new SpinnerNumberModel(Float.valueOf((float) 0.1), null, null, Float.valueOf((float) 0.1)));
        spinnerPeso.setBounds(182, 240, 60, 20);
        getContentPane().add(spinnerPeso);
        
        lblDimensiones = new JLabel("Dimensiones:");
        lblDimensiones.setBounds(10, 280, 145, 14);
        lblDimensiones.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblDimensiones);
        
        textDimensiones = new JTextField();
        textDimensiones.setBounds(182, 280, 86, 20);
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
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		altaDonacionCancelarActionPerformed(arg0);
        		
        	}
        });
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
        spinnerPeso.setVisible(!esAlimento);
        
        lblDimensiones.setVisible(!esAlimento);
        textDimensiones.setVisible(!esAlimento);
        
        if(esAlimento) {
        	spinnerCantElem.setBounds(182, 240, 60, 20);
        	lblCantElem.setBounds(10, 240, 162, 14);
        }    
                
        limpiarFormulario();
        revalidate();
        repaint();
}

protected void altaDonacionCancelarActionPerformed(ActionEvent arg0) {
	limpiarFormulario();
	setVisible(false);
}

protected void altaDonacionAceptarActionPerformed(ActionEvent arg0) {
	
	DtDonacion dt = null;
	Date fechaActual;
	Calendar calendar;
	String descripcion = this.textAreaDesc.getText();
	calendar = Calendar.getInstance();
	fechaActual = calendar.getTime();	
	
	if(comboBoxTipo.getSelectedItem().toString().equals("Alimento")) {
		Integer elementos = (Integer) this.spinnerCantElem.getValue();
		dt = new DtAlimento(0,fechaActual,descripcion,elementos);		
	} else {		
		float peso = (float) this.spinnerPeso.getValue();			
		String dimensiones = this.textDimensiones.getText();
		dt = new DtArticulo(0,fechaActual,descripcion,peso,dimensiones);
	}
	
	this.icon.altaDonacion(dt);
	JOptionPane.showMessageDialog(this, "Se dio de alta a la donación", "Alta Donación", JOptionPane.INFORMATION_MESSAGE);
	setVisible(false);
    limpiarFormulario();	
	
}

private void limpiarFormulario() {
	textAreaDesc.setText("");
	spinnerPeso.setValue(0.0);
    spinnerCantElem.setValue(1);
    textDimensiones.setText("");    
}
}
