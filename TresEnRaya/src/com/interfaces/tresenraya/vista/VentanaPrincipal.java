package com.interfaces.tresenraya.vista;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.interfaces.tresenraya.controlador.Controlador;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	private Menu menu;
	private PanelJuego tablero;
	private BarraEstado turno;
	
	public VentanaPrincipal(Controlador controlador) {
		menu = new Menu(controlador);
		tablero = new PanelJuego(controlador);
		turno = new BarraEstado(controlador);
		añadirComponentes();
		cerrar();
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("TRES EN RAYA");
		this.setVisible(true);
	}
	
	public void añadirComponentes() {
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);		
		this.add(tablero, BorderLayout.CENTER);
		this.add(turno, BorderLayout.SOUTH);
	}
	
	/** Metodo para confirmar el cierre de la AGENDA*/
	public void cerrar() {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				confirmarSalida();
			}
		});
		this.setVisible(true);
	}

	protected void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this, "¿Desea salir del Juego?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(valor == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}
	
}
