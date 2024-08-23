package com.ayudamos.presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private AgregarUsuario agregarUsuarioInternalFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Principal() {
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 504, 28);
        contentPane.add(menuBar);

        JMenu mnAltas = new JMenu("Altas");
        menuBar.add(mnAltas);

        JMenuItem mntmUsuario = new JMenuItem("Alta Usuario");
        mntmUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                agregarUsuarioInternalFrame.setVisible(true);
            }
        });

        mnAltas.add(mntmUsuario);
        
        JMenu mnListar = new JMenu("Listar");
        menuBar.add(mnListar);

        agregarUsuarioInternalFrame = new AgregarUsuario();
        agregarUsuarioInternalFrame.setEnabled(false);
        
        
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = agregarUsuarioInternalFrame.getSize();
        agregarUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        this.getContentPane().add(agregarUsuarioInternalFrame);
    }
}
