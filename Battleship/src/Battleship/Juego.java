package Battleship;

import java.util.Scanner;

public class Juego {

	private Partida partida;
	private int opcion;

	public Juego() {
		super();
		partida = new Partida();
	}

	public Juego(Partida partida) {
		super();
		this.partida = partida;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public void jugar() {

		Scanner teclado = new Scanner(System.in);
		int x, y;

		System.out.println("1-Facil");
		System.out.println("2-Normal");
		System.out.println("3-Dificil");
		System.out.print("Introduce una de las siguientes opciones: ");
		opcion = teclado.nextInt();
		System.out.println(getOpcion());

		partida.iniciar();
		partida.mostrarTablero();
		System.out.println("VAS A DISPONER DE " + partida.getNumDisparos() + " DISPAROS");

		do {

			do {
				System.out.print("Dame la coordenada X del disparo: ");
				x = teclado.nextInt();
				x--;
			} while (x < 0 || x >= partida.getAlto());

			do {
				System.out.print("Dame la coordenada Y del disparo: ");
				y = teclado.nextInt();
				y--;
				System.out.println();
			} while (y < 0 || y >= partida.getAncho());

			partida.procesarDisparo(x, y);
			partida.mostrarTablero();
			System.out.println("DISPAROS RESTANTES: " + partida.getNumDisparos());

		} while (partida.getNumDisparos() > 0 && partida.barcosRestantes() > 0);

		// FINALIZA LA PARTIDA

		if (partida.barcosRestantes() == 0) {
			System.out.println("　　 ENHORABUENA, HAS GANADO LA PARTIDA !!!!");
		}

		else {
			System.out.println("　　 HAS PERDIDO, ERES UN MANTA !!!!");
		}

		teclado.close();
	}
}
