package Battleship;

public class Barco {

	private String nombre;
	private int x;
	private int y;
	private int puntos;
	private boolean hundido;
	
	private static final int MAX_FACIL = 5;
	private static final int MAX = 9;

	
	public Barco(){
		
		this.nombre = "";
		this.x = 0;
		this.y = 0;
		asignarPuntos();
		this.hundido = false;
	}
	
	public Barco(String nombre, int altura, int anchura){
		
		this.nombre = nombre;
		asignarXAleatorio(altura);
		asignarYAleatorio(anchura);
		asignarPuntos();
		this.hundido = false;
		
	}

	public Barco(String nombre, int x, int y, int puntos, boolean hundido) {
		super();
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.puntos = puntos;
		this.hundido = hundido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public boolean isHundido() {
		return hundido;
	}

	public void setHundido(boolean hundido) {
		this.hundido = hundido;
	}

	public static int getMax() {
		return MAX;
	}

	public static int getMaxFacil() {
		return MAX_FACIL;
	}

	private void asignarPuntos(){
		
		//this.puntos = (int) Math.random() * MAX + 1;
		setPuntos((int) (Math.random() * MAX + 1));
	}
	
	private void asignarPuntosFacil(){
		
		//this.puntos = (int) Math.random() * MAX + 1;
		setPuntos((int) (Math.random() * MAX_FACIL + 1));
	}
	

	private void asignarXAleatorio(int altura){
		
		setX((int) (Math.random() * altura));
		
	}
	
	private void asignarYAleatorio(int anchura){
		
		setY((int) (Math.random() * anchura));
		
	}
	
}