package PracticaCorregida;


public class Contacto {

	private String nombre;
	private String email;
	private long tlf;
	
	public Contacto(){	
		this.nombre = null;
		this.email = null;
		this.tlf = 0;
	}
	
	public Contacto(String nombre,String email,long tlf){
		this.nombre = nombre;
		this.email = email;
		this.tlf = tlf;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTlf() {
		return tlf;
	}

	public void setTlf(long tlf) {
		this.tlf = tlf;
	}
	
	public String toString(){
		
		String cadena = "";
		cadena = cadena + "Nombre: " + this.nombre + "\n";
		cadena = cadena + "E-mail: " + this.email + "\n";
		cadena = cadena + "Teléfono: " + this.tlf + "\n";
		return cadena;
	}
	
	
}
