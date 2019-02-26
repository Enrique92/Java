package com.interfaces.tresenraya.main;

import com.interfaces.tresenraya.controlador.Controlador;
import com.interfaces.tresenraya.modelo.Partida;
import com.interfaces.tresenraya.modelo.Tablero;
import com.interfaces.tresenraya.vista.VentanaPrincipal;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/**
		 * El modelo puede estar compuesto por diferentes clases, pero una de
		 * ellas debe hacer de nexo con las demás.
		 */
		Partida partida = new Partida();
		/** El controlador recibe el modelo para poder utilizarlo. */
		Controlador controlador = new Controlador(partida);
		/** La vista recibe el controlador */
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
	}
}
