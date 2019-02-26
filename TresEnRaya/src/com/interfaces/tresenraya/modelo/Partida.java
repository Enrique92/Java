package com.interfaces.tresenraya.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.interfaces.tresenraya.vista.Observador;

public class Partida {
	private boolean turno = true;
	private Tablero tablero;
	private String color;
	private ArrayList<Observador> obs;

	public Partida() {
		obs = new ArrayList<Observador>();
		tablero = new Tablero(this);
		tablero.iniciarTablero();
		turnoInicial();
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	
	// Nos dice el turno en la barra de estado
	public String saberTurno() {
		String jugador;
		if (turno == true) {
			jugador = "ROJO";
		} else {
			jugador = "AZUL";
		}
		return jugador;
	}

	// TRUE ROJO // FALSE AZUL
	public int turnoInicial() {
		Random rnd = new Random();
		int valor = rnd.nextInt(2) + 1;
		if (valor == 1) {
			turno = true;
			color = "rojo";
		} else if (valor == 2) {
			turno = false;
			color = "azul";
		}
		return valor;
	}

	// Metodo para cambiar de jugador ROJO = TRUE a AZUL = FALSE y viceversa
	public boolean cambiarJugador() {
		if (color == "rojo") {
			color = "azul";
			turno = true;
		} else {
			color = "rojo";
			turno = false;
		}
//        for (Observador observador : obs) {
//			observador.cambiarJugador();
//		}
		return turno;
	}
	
	/** CARGA EL FICHERO DE TEXTO DE COMO SE UTILIZA EN EL 3 EN RAYA*/
	public String mostrarAyudaTXT() {
		String nomFichero = "ayuda.txt";
		// Atributos para leer
		String texto = "", linea = "";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(nomFichero);
			br = new BufferedReader(fr);
			linea = br.readLine();
			while (linea != null) {
				texto = texto + linea + "\n";
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		return texto;
	}
	
	public void guardarPartida() {
		File fichero = new File("partida.txt");
		FileWriter writer;
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				try {
					writer = new FileWriter(fichero);
					writer.write(i + j + saberTurno());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void addObserver(Observador o) {
		obs.add(o);
	}
	
	public Tablero getTablero() {
		return tablero;
	}
}
