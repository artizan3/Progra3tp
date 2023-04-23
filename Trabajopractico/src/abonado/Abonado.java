package abonado;

public abstract class Abonado {
	protected String nombre;
	protected int dni;
	
	public Abonado() {		
	}
	
	public Abonado(String nombre,int dni) {
		this.dni=dni;
		this.nombre=nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getDni() {
		return this.dni;
	}
	public abstract String toString();

}
