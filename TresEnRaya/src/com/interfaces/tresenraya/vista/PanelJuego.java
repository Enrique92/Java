package com.interfaces.tresenraya.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.interfaces.tresenraya.controlador.Controlador;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener {
	private static final int DIM = 3;
	private JButton[][] tablero;
	Controlador controlador;
	private PanelMensajes mensajes;

	public PanelJuego(Controlador controlador) {
		this.controlador = controlador;
		mensajes = new PanelMensajes(controlador, controlador.getPartida());
		controlador.turnoInicial();
		this.tablero = new JButton[DIM][DIM];
		this.añadirComponentes();
//		bloquearTablero();
	}

	public void añadirComponentes() {
		this.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new JButton();
				this.add(tablero[i][j]);
				tablero[i][j].addActionListener(this);
			}
		}
	}
	
	/**
	 * Limpia el tablero despues de finalizar la partida
	 */
	public void limpiarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new JButton();
				this.add(tablero[i][j]);
				tablero[i][j].addActionListener(this);
			}
		}
	}
	
	/**
	 * Bloquea el tablero si no se inicio la partida
	 */
	public void bloquearTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j].removeActionListener(this);
//				System.out.println("BLOQUEO");
			}
		}
	}
	
	/**
	 * Desbloquea el tablero si se inicio la partida
	 */
	public void desbloquearTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j].addActionListener(this);
//				System.out.println("DESBLOQUEO");
			}
		}
		JOptionPane.showMessageDialog(null, "¡Se ha comenzado la partida!", "¡PARTIDA COMENZADA!", JOptionPane.INFORMATION_MESSAGE);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!controlador.comprobarGanardor()) {
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					if (e.getSource() == tablero[i][j]) {
						if(controlador.cambiarJugador()) {
							if (controlador.casillaLibre(i, j)) {
								tablero[i][j].setIcon(new ImageIcon("rojo.png"));
								controlador.ponerFicha(i, j);
//								System.out.println("SOY ROJO");
								mensajes.mostrarMensajes();
								if(controlador.comprobarEmpate()) {
									JOptionPane.showMessageDialog(null, "¡Se ha empatado la partida!", "¡EMPATE!", JOptionPane.INFORMATION_MESSAGE);
									bloquearTablero();
								}
							} else {
								JOptionPane.showMessageDialog(this, "¡Casilla ocupada!");
							}
						} else {
							if (controlador.casillaLibre(i, j)) {
								tablero[i][j].setIcon(new ImageIcon("azul.png"));
								controlador.ponerFicha(i, j);
//								System.out.println("SOY AZUL");
								mensajes.mostrarMensajes();
								if(controlador.comprobarEmpate()) {
									JOptionPane.showMessageDialog(null, "¡Se ha empatado la partida!", "¡EMPATE!", JOptionPane.INFORMATION_MESSAGE);
									bloquearTablero();
								}
							}  else {
								JOptionPane.showMessageDialog(this, "¡Casilla ocupada!");
							}
						}
					}
				}
			}
		} else {
			bloquearTablero();
		}
	}
}
