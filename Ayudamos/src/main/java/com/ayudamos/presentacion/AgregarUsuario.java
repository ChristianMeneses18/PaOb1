package com.ayudamos.presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.ayudamos.interfaces.IControlador;
import com.ayudamos.enums.EstadoBeneficiario;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtFecha;
import com.ayudamos.datatypes.DtRepartidor;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.enums.Barrio;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class AgregarUsuario extends JInternalFrame {

	private IControlador icon;
	
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JTextField txtDireccion;
    private JTextField txtLicencia;
    private JComboBox<String> comboBoxTipo;
    private JComboBox<Barrio> comboBoxBarrio;
    private JComboBox<EstadoBeneficiario> comboBoxEstado;
    private JLabel lblDireccion;
    private JLabel lblFechaNacimiento;
    private JDateChooser dateChooser;
    private JLabel lblBarrio;
    private JLabel lblEstado;
    private JLabel lblLicencia;
    private JButton btnAgregar;
    private JButton btnCancelar;

    /**
     * Create the frame.
     */
    public AgregarUsuario(IControlador icon) {
    	this.icon = icon;
        setTitle("Alta de Usuario");
        setBounds(100, 100, 583, 514);
        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Alta de Usuario");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 10, 567, 40);
        getContentPane().add(lblTitulo);

        JLabel lblCedula = new JLabel("Nombre:");
        lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCedula.setBounds(10, 60, 100, 30);
        getContentPane().add(lblCedula);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtNombre.setBounds(182, 60, 350, 30);
        getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setBounds(10, 100, 100, 30);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtEmail.setBounds(182, 101, 350, 30);
        getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblTipoUsuario = new JLabel("Tipo de Usuario:");
        lblTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTipoUsuario.setBounds(10, 140, 150, 30);
        getContentPane().add(lblTipoUsuario);

        comboBoxTipo = new JComboBox<>(new String[] {"Beneficiario", "Repartidor"});
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Beneficiario", "Repartidor"}));
        comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxTipo.setBounds(182, 140, 150, 30);
        getContentPane().add(comboBoxTipo);

        lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFechaNacimiento.setBounds(10, 180, 200, 30);
        getContentPane().add(lblFechaNacimiento);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(182, 180, 212, 30);
        getContentPane().add(dateChooser);

        lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDireccion.setBounds(10, 220, 100, 30);
        getContentPane().add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtDireccion.setBounds(182, 221, 350, 30);
        getContentPane().add(txtDireccion);
        txtDireccion.setColumns(10);

        lblEstado = new JLabel("Estado:");
        lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEstado.setBounds(10, 260, 100, 30);
        getContentPane().add(lblEstado);

        comboBoxEstado = new JComboBox<>(EstadoBeneficiario.values());
        comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxEstado.setBounds(182, 262, 150, 30);
        getContentPane().add(comboBoxEstado);

        lblBarrio = new JLabel("Barrio:");
        lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBarrio.setBounds(10, 300, 100, 30);
        getContentPane().add(lblBarrio);

        comboBoxBarrio = new JComboBox<>(Barrio.values());
        comboBoxBarrio.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxBarrio.setBounds(182, 300, 150, 30);
        getContentPane().add(comboBoxBarrio);

        lblLicencia = new JLabel("Número de Licencia:");
        lblLicencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLicencia.setBounds(10, 340, 200, 30);
        getContentPane().add(lblLicencia);

        txtLicencia = new JTextField();
        txtLicencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtLicencia.setBounds(182, 340, 250, 30);
        getContentPane().add(txtLicencia);
        txtLicencia.setColumns(10);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		agregarUsuarioAceptarActionPerformed(arg0);
        	}
        });
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAgregar.setBounds(167, 413, 117, 30);
        getContentPane().add(btnAgregar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		agregarUsuarioCancelarActionPerformed(arg0);
        		
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
        String tipoUsuario = (String) comboBoxTipo.getSelectedItem();
        boolean esBeneficiario = "Beneficiario".equals(tipoUsuario);

        lblDireccion.setVisible(esBeneficiario);
        txtDireccion.setVisible(esBeneficiario);

        lblFechaNacimiento.setVisible(esBeneficiario);
        dateChooser.setVisible(esBeneficiario);

        lblBarrio.setVisible(esBeneficiario);
        comboBoxBarrio.setVisible(esBeneficiario);

        lblEstado.setVisible(esBeneficiario);
        comboBoxEstado.setVisible(esBeneficiario);

        lblLicencia.setVisible(!esBeneficiario);
        txtLicencia.setVisible(!esBeneficiario);
        
        if (!esBeneficiario) {
            lblLicencia.setBounds(10, 180, 200, 30);
            txtLicencia.setBounds(182, 180, 250, 30);
        }
        revalidate();
        repaint();
    }
    
    
    protected void agregarUsuarioCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	

	
	protected void agregarUsuarioAceptarActionPerformed(ActionEvent arg0) {
		if (ValidarEmail(this.txtEmail.getText()) == false || this.txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Verificar correo electronico");
		}else {
			
			Date selectedDate;
			Calendar calendar;
			int dia , mes , anio;
			
			String nombre = this.txtNombre.getText();
			String email = this.txtEmail.getText();
			String direccion = this.txtDireccion.getText();
			String licencia = this.txtLicencia.getText();
			EstadoBeneficiario estado = (EstadoBeneficiario) comboBoxEstado.getSelectedItem();
			Barrio barrio = (Barrio) comboBoxBarrio.getSelectedItem();
			DtUsuario dt = null;
			
			if(comboBoxTipo.getSelectedItem().toString().equals("Beneficiario")) {
				selectedDate = dateChooser.getDate();
				calendar = Calendar.getInstance();
				calendar.setTime(selectedDate);
				
				dia = calendar.get(Calendar.DAY_OF_MONTH);
				mes = calendar.get(Calendar.MONTH) + 1;
				anio = calendar.get(Calendar.YEAR);
				DtFecha fechaNacimiento = new DtFecha(dia,mes,anio);
				dt = new DtBeneficiario(nombre, email, "0000000", direccion, fechaNacimiento, estado, barrio);
				
			}else{
				dt = new DtRepartidor(nombre, email, "0000000", licencia);
				
			}
			
	        try {
	            this.icon.agregarUsuario(dt);
	            JOptionPane.showMessageDialog(this, "Usuario agregado con exito", "Agregar Usuario", JOptionPane.INFORMATION_MESSAGE);
	            setVisible(false);
	            limpiarFormulario();
	            } catch (UsuarioRepetidoExcepcion e) {
	                JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
	            }

            
		}   
     }
     
	private boolean ValidarEmail(String email) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
	
	 private void limpiarFormulario() {
	        txtNombre.setText("");
	        txtEmail.setText("");
	        txtDireccion.setText("");
	        txtLicencia.setText("");
	        dateChooser.setCalendar(null);
	        
	        
	 }
}
