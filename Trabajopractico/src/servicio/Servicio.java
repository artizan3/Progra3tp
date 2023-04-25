package servicio;

public abstract class Servicio implements Cloneable{
	public String id;
	protected double valor;
	/*
	 * este metodo devuelve el valor constante del servicio especifico agregado
	 */
	public abstract double costo();
	/**
	 * el metodo devuelve el tipo del hijo servicio en forma de String
	 */
	public abstract String getTipo();
	/**
	 *es el metodo encargado de la clonacion del servicio
     * <br>pre:</br><br>
     * <br>inv:</br><br>
     * <br>post:</br> devuelve un clon de tipo servicio<br>
     * @throws CloneNotSupportedException si algun atributo de tipo objeto no fuera clonable
     */
	public Object clone() throws CloneNotSupportedException {
		Servicio clon=(Servicio)super.clone();
		return clon;
	}
}
