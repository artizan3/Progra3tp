package servicio;

public class ServicioAcompaniamiento extends Servicio {

	
	public double costo() {
		return 7500;
	}
		
	@Override
	public String getTipo() {
		return "Acompaniamiento";
	}

	
	/**
	 *Es el metodo encargado de la clonacion del ServicioAcompaniamiento.<br><br>
     * <b>Pre</b>:<br>
     * <b>Inv</b>:<br>
     * <b>Post</b>: Devuelve un clon de tipo ServicioAcompaniamiento.<br>
     * @throws CloneNotSupportedException si algun atributo de tipo objeto no fuera clonable
     */
	public Object clone() throws CloneNotSupportedException {
		ServicioAcompaniamiento clon = null;
		clon=(ServicioAcompaniamiento)super.clone();
		return clon;
	}
	
}