package com.interfaces.tresenraya.modelo;

import java.util.ArrayList;

import com.interfaces.tresenraya.enu.Casilla;
import com.interfaces.tresenraya.enu.Ficha;
import com.interfaces.tresenraya.vista.Observador;
import com.interfaces.tresenraya.vista.PanelJuego;

public class Tablero {
	private static final int DIM = 3;
	private Casilla[][] tablero;
	private Partida partida;
	private ArrayList<Observador> obs;
	
	public Casilla[][] getTablero() {
		return tablero;
	}

	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}

	/**
	 * Constructor. Vacía el tablero.
	 */
	public Tablero(Partida partida) {
		// Inicializamos el tablero a vacio
		obs = new ArrayList<Observador>();
		this.tablero = new Casilla[DIM][DIM];
		this.partida = partida;
	}
	
	public void iniciarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = Casilla.VACIA;
			}
		}
	}

	public void cambiarEstado(int x, int y, Casilla c) {
		tablero[x][y] = c;
	}
	
	/**
	 * Comprueba si la casilla dada está libre o no. 
	 * Si devuelve TRUE esta vacia. 
	 * Si devuelve FALSE esta ocuapda.
	 */
	public boolean casillaLibre(int y, int x) {
		return (tablero[y][x] == Casilla.VACIA);
	}
	
	/**
	 * Coloca una ficha en la posición según las coordenadas dadas. 
	 * Y Posición en el eje vertical.
	 * X Posición en el eje horizontal.
	 */
	public void ponerFicha(int y, int x) {
		if (partida.isTurno()) {
			cambiarEstado(x, y, Casilla.ROJO);
		} else {
			cambiarEstado(x, y, Casilla.AZUL);
		}
	}

	// TRUE si hay 3 en raya
	public boolean ComprobarGanador() {
		boolean tresenraya = false;
		/* Diagonales */
		if (tablero[0][0] != Casilla.VACIA && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
			tresenraya = true;
		}
		if (tablero[0][2] != Casilla.VACIA && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
			tresenraya = true;
		}
		/* Horizontales y verticales */
		for (int i = 0; i < tablero.length; i++) {
			/* Horizontales */
			if (tablero[i][0] != Casilla.VACIA && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
				tresenraya = true;
			}
			/* Verticales */
			if (tablero[0][i] != Casilla.VACIA && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
				tresenraya = true;
			}
		}
		return tresenraya;
	}

	// TRUE si hay empate
	public boolean ComprobarEmpate() {
		// Si no quedan huecos donde mover, es empate
		boolean algunHueco = false;
		for (int i = 0; i < tablero.length; i++)
			for (int j = 0; j < tablero[i].length; j++)
				if (tablero[i][j] == Casilla.VACIA)
					algunHueco = true;
		return !algunHueco;
	}
	
	public void addObserver(Observador o) {
		obs.add(o);
	}
}





