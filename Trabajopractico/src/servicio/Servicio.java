package servicio;

public abstract class Servicio implements Cloneable{
	public String id;
	protected double valor;
	public abstract double costo();
	public abstract String getTipo();
	
	public Object clone() {
		return null;
	}
}
