package PracticaCorregida;

import java.util.ArrayList;

public class Agenda {

	ArrayList<Contacto> contactos;

	public Agenda() {

		contactos = new ArrayList<Contacto>();
	}

	public Agenda(ArrayList<Contacto> contactos) {

		this.contactos = contactos;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public String toString() {

		String cadena = "";
		int i;
		for (i = 0; i < contactos.size(); i++)
			cadena = cadena + contactos.get(i).toString() + "\n\n";
		cadena = cadena + "Contactos en la agenda: " + contactos.size() + "\n\n";
		return cadena;
	}

	public boolean Existe(String nombre) {

		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < contactos.size()) {
			if (contactos.get(i).getNombre().equals(nombre))
				encontrado = true;
			else
				i++;
		}

		return encontrado;
	}

	public int ExistePosicion(String nombre) {

		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < contactos.size()) {
			if (contactos.get(i).getNombre().equals(nombre))
				encontrado = true;
			else
				i++;
		}

		if (encontrado)
			return (i+1);
		else
			return -1;
	}

	public boolean agregarContacto(Contacto c) {

		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < contactos.size()) {
			if (contactos.get(i).getTlf() == c.getTlf())
				encontrado = true;
			else
				i++;
		}

		if (encontrado)
			return false;
		else {
			contactos.add(c);
			return true;
		}
	}

	public boolean eliminarContacto(String nombre) {
		int i;
		int pos = -1;

		for (i = 0; i < contactos.size(); i++)
			if (contactos.get(i).getNombre().equals(nombre))
				pos = i;

		if (pos == -1)
			return false;
		else {
			contactos.remove(pos);
			return true;
		}
	}
	
	public boolean eliminarContactobyAlex(String nombre) {
		
		int i = contactos.size() - 1;
		boolean encontrado = false;
		
		while (!encontrado && i >= 0 )
			if (contactos.get(i).getNombre().equals(nombre))
				encontrado = true;
			else 
				i--;

		if (encontrado){
			contactos.remove(i);
			return true;
		}
		else 	
			return false;
	}
	

}

