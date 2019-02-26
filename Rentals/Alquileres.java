package practica_entregar;

import java.util.ArrayList;
import java.util.Scanner;

public class Alquileres {
	static int opcionA;
	static Scanner Teclado = new Scanner(System.in);
	public static void alquiler() {
		do {
		System.out.println("*********************************\n"
						  + "*********MENU ALQUILERES********\n"
						  + "********************************\n"
						  + "*****1.Listado de alquiler******\n"
						  + "*****2.Listado de locales*******\n"
						  + "****3.Listado de inquilinos*****\n"
						  + "****4.Listado de inmuebles******\n"
						  + "***0.Volver al menu principal***\n"
						  + "********************************");
			System.out.println("Introduzca una de las opciones anteriores: ");
			opcionA = Teclado.nextInt();
			System.out.println();
			switch (opcionA) {
			case 1:
				Inquilinos.inquilino();
				break;
			case 2:
				Inmuebles.inmueble();
				break;
			case 3:
				Alquileres.alquiler();
				break;
			case 0:
				Principal.menu();
				break;
			default:
				System.out.println("Opcion incorrecta vuelve a introducir una nueva.\n");
				break;
			}
		} while (opcionA < 0 || opcionA > 3);
	}
	
	public static void main(String[] args){
		alquiler();
		ArrayList<String> lista_alquiler = new ArrayList<String>();
		ArrayList<String> lista_locales = new ArrayList<String>();
		ArrayList<String> lista_inquilinos = new ArrayList<String>();
		ArrayList<String> lista_inmuebles_inquilino = new ArrayList<String>();
	}
}
