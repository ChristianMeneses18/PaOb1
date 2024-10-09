package com.ayudamos.presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.datatypes.DtRepartidor;
import com.ayudamos.datatypes.DtUsuario;
import com.ayudamos.enums.EstadoBeneficiario;
import com.ayudamos.excepciones.UsuarioRepetidoExcepcion;
import com.ayudamos.interfaces.IControlador;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
	private IControlador icon;
	private JPanel contentPane;
	private JTable tablaUsuarios;
	private DefaultTableModel model;
	private ArrayList<DtUsuario> lista;
	private JButton btnListar;
	private JButton btnSeleccionar;
	private JButton btnModificar;
	private JButton btnAtras;
	private JButton btnCancelar;
	private JTextField txtEmail;
	private String emailSeleccionado;
	private DtUsuario usuarioSeleccionado = null;
	private DtBeneficiario beneficiarioSeleccionado = null;

	
	public ModificarUsuario(IControlador icon) {
		this.icon = icon;
		setBounds(100, 100, 583, 514);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 104, 515, 250);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Modificar Usuario");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 535, 47);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione un usuario: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 79, 244, 14);
		getContentPane().add(lblNewLabel_1);
		
		tablaUsuarios = new JTable();
		tablaUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model = new DefaultTableModel();
		tablaUsuarios.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Email");
		
		scrollPane.setViewportView(tablaUsuarios);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(20, 126, 100, 30);
		getContentPane().add(lblNombre);
		lblNombre.setVisible(false);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(20, 156, 100, 30);
		getContentPane().add(lblEmail);
		lblEmail.setVisible(false);
		
		JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEstado.setBounds(20, 186, 100, 30);
        getContentPane().add(lblEstado);
        lblEstado.setVisible(false);
		
		txtNombre = new JTextField();
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtNombre.setBounds(155, 126, 350, 30);
        getContentPane().add(txtNombre);
        txtNombre.setColumns(10);
        txtNombre.setVisible(false);
        
        txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(155, 156, 350, 30);
		getContentPane().add(txtEmail);
		txtEmail.setVisible(false);
		
		JComboBox<EstadoBeneficiario> comboBoxEstado = new JComboBox<>(EstadoBeneficiario.values());
        comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBoxEstado.setBounds(155, 186, 350, 30);
        getContentPane().add(comboBoxEstado);
        comboBoxEstado.setVisible(false);
		
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				
				lista = icon.listarUsuarios();
				
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(ModificarUsuario.this, "No existen Usuarios a listar", "Listar Usuario", JOptionPane.INFORMATION_MESSAGE);
				}else {
					for (DtUsuario u : lista) {
						Object[] fila = new Object[2];
						fila[0] = u.getNombre();
						fila[1] = u.getEmail();
							
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
				
				int selectedRow = tablaUsuarios.getSelectedRow();
		        
				if (selectedRow != -1) {
					
					emailSeleccionado = (String) model.getValueAt(selectedRow, 1);
					
					//DtUsuario usuarioSeleccionado = null;
					for (DtUsuario usuario : lista) {
					    if (usuario.getEmail().equals(emailSeleccionado)) {
					        usuarioSeleccionado = usuario;
					        break;
					    }
					}
					
					if (usuarioSeleccionado instanceof DtBeneficiario) {
						beneficiarioSeleccionado = (DtBeneficiario) usuarioSeleccionado;
						
			            comboBoxEstado.setSelectedItem(beneficiarioSeleccionado.getEstadoBeneficiario());
			            
			            btnSeleccionar.setVisible(false);
						lblNewLabel_1.setVisible(false);
						btnListar.setVisible(false);
						scrollPane.setVisible(false);
						
						txtNombre.setVisible(true);
						txtEmail.setVisible(true);
						comboBoxEstado.setVisible(true);
						lblNombre.setVisible(true);
						lblEmail.setVisible(true);
						lblEstado.setVisible(true);
						btnModificar.setVisible(true);
						btnAtras.setVisible(true);
					}else {
			        	
			            btnSeleccionar.setVisible(false);
						lblNewLabel_1.setVisible(false);
						btnListar.setVisible(false);
						scrollPane.setVisible(false);
						comboBoxEstado.setVisible(false);
						lblEstado.setVisible(false);
						
						txtNombre.setVisible(true);
						txtEmail.setVisible(true);
						lblNombre.setVisible(true);
						lblEmail.setVisible(true);
						btnModificar.setVisible(true);
						btnAtras.setVisible(true);
					}
					
					txtNombre.setText(usuarioSeleccionado.getNombre());
		            txtEmail.setText(usuarioSeleccionado.getEmail());
		            
				} else {
		            JOptionPane.showMessageDialog(null, "Por favor, selecciona un usuario de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
		btnSeleccionar.setBounds(450, 434, 107, 39);
		getContentPane().add(btnSeleccionar);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				if (ValidarEmail(txtEmail.getText()) == false || txtEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Verificar correo electronico");
				}else {
					try {
						if (usuarioSeleccionado instanceof DtBeneficiario) {
							EstadoBeneficiario estado = (EstadoBeneficiario) comboBoxEstado.getSelectedItem();
							DtBeneficiario datosBeneficiario = new DtBeneficiario(txtNombre.getText(), txtEmail.getText(), null, null, null, estado, null);
							
							icon.modificarBeneficiario(emailSeleccionado, datosBeneficiario);
							
						}else {
							DtUsuario datosUsr = new DtUsuario(txtNombre.getText(), txtEmail.getText(), null);
							icon.modificarUsuario(emailSeleccionado, datosUsr);
						}
						
						JOptionPane.showMessageDialog(ModificarUsuario.this, "Usuario modificado con exito", "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						limpiar();

						btnSeleccionar.setVisible(true);
						lblNewLabel_1.setVisible(true);
						btnListar.setVisible(true);
						scrollPane.setVisible(true);

						txtNombre.setVisible(false);
						txtEmail.setVisible(false);
						comboBoxEstado.setVisible(false);
						lblNombre.setVisible(false);
						lblEmail.setVisible(false);
						lblEstado.setVisible(false);
						btnModificar.setVisible(false);
						btnAtras.setVisible(false);

					} catch (UsuarioRepetidoExcepcion e) {
						JOptionPane.showMessageDialog(ModificarUsuario.this, e.getMessage(), "Modificar Usuario", JOptionPane.ERROR_MESSAGE);
					}
				}
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
				
				txtNombre.setVisible(false);
				txtEmail.setVisible(false);
				comboBoxEstado.setVisible(false);
				lblNombre.setVisible(false);
				lblEmail.setVisible(false);
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
        txtNombre.setText("");
        txtEmail.setText("");
        model.setRowCount(0);

	}
	
	private boolean ValidarEmail(String email) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
}
