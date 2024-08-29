package com.ayudamos.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.ayudamos.datatypes.DtBeneficiario;
import com.ayudamos.interfaces.IControlador;

import java.awt.Component;

public class ModificarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JPanel contentPane;
	private JTable tablaUsuarios;
	private DefaultTableModel model;
	private ArrayList<DtUsuario> lista;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuario frame = new ModificarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public ModificarUsuario(IControlador icon) {
		this.icon = icon;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel_1 = new JLabel("Que usuario desea modificar?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 79, 244, 14);
		getContentPane().add(lblNewLabel_1);
		
		tablaUsuarios = new JTable();
		tablaUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		model = new DefaultTableModel();
		tablaUsuarios.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Email");
		model.addColumn("Tipo");
		
		scrollPane.setViewportView(tablaUsuarios);
		
		lista = icon.listarUsuarios();
		
		for (DtUsuario u : lista) {
			Object[] fila = new Object[3];
			fila[0] = u.getNombre();
			fila[1] = u.getEmail();
			//fila[2] = u.getBarrio().toString();  buscar lo de como saber que hijo es dado en clase
			
			model.addRow(fila);
		
		}
}
