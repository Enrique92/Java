package com.interfaces.tresenraya.vista;

public interface Observador {
	
	public String turnoJugador();
	
	public boolean cambiarJugador();
	
	public int turnoInicial();
	
	public boolean comprobarGanardor();
	
	public void bloquearCasillas();
	
	public void desbloquearCasillas();

	public void desbloquearPartida();
}
