package Battleship;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Scanner;

import Battleship.Casilla;
import Battleship.Juego;

public class Partida {

	private int alto;
	private int ancho;
	private Casilla[][] tablero;
	private ArrayList<Barco> barcos;

	private int score;
	private int numDisparos;

	private String jugador;
	private ArrayList<Puntuacion> ranking;

	// RESERVAR MEMORIA PARA LA MATRIZ Y PARA TODOS LOS ARRAY LIST
	public Partida() {
		super();
		alto = 0;
		ancho = 0;
		barcos = new ArrayList<Barco>();
	}

	public Partida(int alto, int ancho, Casilla[][] tablero,
			ArrayList<Barco> barcos, int score, int numDisparos,
			String jugador, ArrayList<Puntuacion> ranking) {

		super();
		this.alto = alto;
		this.ancho = ancho;
		this.tablero = tablero;
		this.barcos = barcos;
		this.score = score;
		this.numDisparos = numDisparos;
		this.jugador = jugador;
		this.ranking = ranking;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}

	public ArrayList<Barco> getBarcos() {
		return barcos;
	}

	public void setBarcos(ArrayList<Barco> barcos) {
		this.barcos = barcos;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNumDisparos() {
		return numDisparos;
	}

	public void setNumDisparos(int numDisparos) {
		this.numDisparos = numDisparos;
	}

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	public ArrayList<Puntuacion> getRanking() {
		return ranking;
	}

	public void setRanking(ArrayList<Puntuacion> ranking) {
		this.ranking = ranking;
	}

	private boolean isBarco(Barco b) {

		int i = 0;
		boolean enc = false;

		while (!enc && i < barcos.size()) {
			if (b.getX() == barcos.get(i).getX()
					&& b.getY() == barcos.get(i).getY()) {
				enc = true;
			} else {
				i++;
			}
		}

		return enc;

	}

	private void colocarBarcos() {

		int numBarcos = alto * ancho / 2;
		int i;
		Barco barco = null;
		boolean esta;

		for (i = 1; i <= numBarcos; i++) {

			esta = false;
			while (!esta) {
				barco = new Barco("barco " + i, alto, ancho);
				if (!isBarco(barco))
					esta = true;
			}

			barcos.add(barco);
			tablero[barco.getX()][barco.getY()] = Casilla.barco;

		}
	}

	// CONTROLAR CON EXCEPCIONES
	// USAR IF
	private void pedirDimensiones(int nivel) {
		if (nivel == 1) { 
			alto = 3;
			ancho = 3;
		} else if (nivel == 2) {
			alto = 4;
			ancho = 4;
		} else if (nivel == 3) {
			alto = 5;
			ancho = 5;
		}
		
		//teclado.nextLine();
		//teclado.close();
	}

	private void calcularTiradas() {

		/*
		 * El número de tiradas que tiene el jugador es igual a la cantidad
		 * total de barcos más la mitad del número de casillas que no tienen
		 * barco. Por ejemplo, si hay 3 barcos en un juego con un océano de 16
		 * casillas (4x4), el número de tiradas es 9 (resultado de la siguiente
		 * operación: 3 + (16-3)/2.
		 */
		if (alto == 3) {
			numDisparos = 7;
		} else if(alto == 4){
			numDisparos = 11;
		} else {
			numDisparos = 15;
		}
	}

	private void inicializarMatriz() {

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				tablero[i][j] = Casilla.agua;
			}
		}
	}

	public void mostrarTablero() {
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				if (tablero[i][j] == Casilla.agua)
					System.out.print("O ");
				else
					System.out.print("B ");

			}
			System.out.println();
		}
	}

	private int isBarcoEnPosicion(int x, int y) {

		int i = 0;
		boolean enc = false;

		while (!enc && i < barcos.size()) {
			if (x == barcos.get(i).getX() && y == barcos.get(i).getY()
					&& !barcos.get(i).isHundido()) {
				enc = true;
			} else {
				i++;
			}
		}

		if (enc)
			return i;
		else
			return -1;
	}

	public void iniciar() {

		pedirDimensiones(3);
		tablero = new Casilla[alto][ancho];
		inicializarMatriz();
		colocarBarcos();
		calcularTiradas();
		// mostrarTablero();
	}

	public void procesarDisparo(int x, int y) {
		Barco b = new Barco();

		int pos = isBarcoEnPosicion(x, y);
		if (pos != -1) {
			barcos.get(pos).setHundido(true);
			tablero[x][y] = Casilla.agua;
			score = score + barcos.get(pos).getPuntos();
			System.out.println("¡¡¡¡ BARCO HUNDIDO !!!!");
			System.out.println("Puntos barco hundido: " + b.getPuntos());
			System.out.println();
		}

		else {
			System.out.println("¡¡¡¡ AGUA !!!!");
		}
		numDisparos--;
	}

	public int barcosRestantes() {

		int i, cont = 0;

		for (i = 0; i < barcos.size(); i++) {
			if (!barcos.get(i).isHundido()) {
				cont++;
			}
		}

		return cont;
	}

}
