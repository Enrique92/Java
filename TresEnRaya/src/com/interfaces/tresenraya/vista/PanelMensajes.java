package com.interfaces.tresenraya.vista;

import javax.swing.JOptionPane;

import com.interfaces.tresenraya.controlador.Controlador;
import com.interfaces.tresenraya.modelo.Partida;

public class PanelMensajes {
	private Partida partida;
	private Controlador controlador;
	
	public PanelMensajes(Controlador controlador, Partida partida) {
		this.controlador = controlador;
		this.partida = partida;
	}
	
	public void mostrarMensajes() {
		if(partida.isTurno()) {
			if(controlador.ganaPartida()) {
				JOptionPane.showMessageDialog(null, "¡El Rojo ha ganado la partida!", "¡Ganador!", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			if(controlador.ganaPartida()) {
				JOptionPane.showMessageDialog(null, "¡El Azul ha ganado la partida!", "¡Ganador!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
