package com.interfaces.tresenraya.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.interfaces.tresenraya.controlador.Controlador;
import com.interfaces.tresenraya.modelo.Partida;

@SuppressWarnings("serial")
public class BarraEstado extends JPanel /*implements Observador*/ {
	private JLabel turno;
	Controlador controlador;
//	Partida partida;

	public BarraEstado(Controlador controlador) {
		this.controlador = controlador;
//		partida = new Partida();
//		this.partida = partida;
		turno = new JLabel("Turno de " + controlador.turnoJugador(), SwingConstants.CENTER);
		añadirComponentes();
	}
	
	public void añadirComponentes() {
		this.add(turno);
		if(controlador.turnoJugador() == "AZUL") {
			turno.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
			turno.setForeground(Color.BLUE);
		} else {
			turno.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
			turno.setForeground(Color.RED);
		}
	}
}
