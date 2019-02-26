package com.interfaces.tresenraya.controlador;

import com.interfaces.tresenraya.enu.Casilla;
import com.interfaces.tresenraya.modelo.Partida;
import com.interfaces.tresenraya.modelo.Tablero;

public class Controlador {
	private Tablero tablero;
	private Partida partida;

	public Controlador(Partida partida) {
		super();
		this.partida = partida;
		this.tablero = partida.getTablero();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public String turnoJugador() {
		return partida.saberTurno();
	}

	public int turnoInicial() {
		return partida.turnoInicial();
	}

	public boolean cambiarJugador() {
		return partida.cambiarJugador();
	}

	public void cambiarEstado(int x, int y, Casilla c) {
		tablero.cambiarEstado(x, y, c);
	}

	public boolean ganaPartida() {
		return tablero.ComprobarGanador();
	}

	public boolean casillaLibre(int x, int y) {
		return tablero.casillaLibre(x, y);
	}

	public void ponerFicha(int x, int y) {
		tablero.ponerFicha(y, x);
	}

	public boolean comprobarEmpate() {
		return tablero.ComprobarEmpate();
	}

	public String mostrarAyudaTXT() {
		return partida.mostrarAyudaTXT();
	}

	public void iniciarTablero() {
		tablero.iniciarTablero();
	}

	public void guardarPartida() {
		partida.guardarPartida();;
	}

	public boolean comprobarGanardor() {
		return tablero.ComprobarGanador();
	}
}
