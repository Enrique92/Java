package PracticaCorregida;

import java.util.InputMismatchException;
import java.util.Scanner;


public class PruebaAgenda {

	public static void main(String[] args) {
		
		Agenda agenda = new Agenda();
		Scanner sc = new Scanner(System.in);
		int opc, posicion;
		
		String nombre = null;
		
		
		do {
		
			System.out.println("1. Insertar un nuevo contacto");
			System.out.println("2. Borrar nuevo contacto");
			System.out.println("3. Consultar existencia de un contacto");
			System.out.println("4. Consultar la posición de un contacto");
			System.out.println("5. Mostrar");
			System.out.println("0. Salir");
			System.out.println("Introduce opción");
			
			try{
				opc = sc.nextInt();	
			}catch(InputMismatchException e){
				opc = -1;
			}
			sc.nextLine();
			
			switch(opc){
			
			case 1:
				Contacto contacto = new Contacto();
				System.out.println("Dame nombre del nuevo contacto");
				contacto.setNombre(sc.nextLine());
				System.out.println("Dame el e-mail del nuevo contacto");
				contacto.setEmail(sc.nextLine());
				System.out.println("Dame el teléfono del nuevo contacto");
				try{
					contacto.setTlf(sc.nextLong());
				
				}catch(InputMismatchException e){
					contacto.setTlf(0);
					System.out.println("El teléfono esta mal, se ha introducido como teléfono el 0");
				}
				sc.nextLine();
				if (agenda.agregarContacto(contacto))
					System.out.println("Contacto agregado correctamente");
				else System.out.println("No ha sido posible agregar el contacto");
				break;
			
			case 2:
				System.out.println("Dame nombre del contacto a eliminar");
				nombre = sc.nextLine();
				
				if (agenda.eliminarContacto(nombre))
					System.out.println("Contacto eliminado correctamente");
				else 
					System.out.println("No ha sido posible eliminar el contacto");
				break;
				
			case 3:
				System.out.println("Dame nombre del contacto a buscar");
				nombre = sc.nextLine();
				if (agenda.Existe(nombre))
					System.out.println("El contacto está en la agenda");
				else 
					System.out.println("El contacto no existe en la agenda");
				break;
				
			case 4:
				System.out.println("Dame nombre del contacto a buscar");
				nombre = sc.nextLine();
				posicion = agenda.ExistePosicion(nombre);
				if (posicion == -1)
					System.out.println("El contacto no está en la agenda");
				else 
					System.out.println("El contacto está en la posición " + posicion);
				break;
				
			case 5:
				if (agenda.getContactos().size() == 0)
					System.out.println("No hay contactos");
				System.out.println(agenda.toString());
				break;
				
			case 0: 
				System.out.println("Gracias por utilizar mi aplicación. Adios");
				break;
				
			default:
				System.out.println("Opción incorrecta");
			}
			
		} while(opc != 0);
		
	sc.close();
		
	}
	
}