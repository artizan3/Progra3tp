package servicio;

public class ServicioBoton extends Servicio {
	public double costo() {
		return 2000;
	}

	@Override
	public String getTipo() {
		return "Boton";
	}

	/**
	 * Es el metodo encargado de la clonacion del ServicioBoton.<br>
	 * <br>
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Pre</b>: Devuelve un clon de tipo ServicioBoton.<br>
	 * 
	 * @throws CloneNotSupportedException si algun atributo de tipo objeto no fuera
	 *                                    clonable
	 */
	public Object clone() throws CloneNotSupportedException {
		ServicioBoton clon = null;
		clon = (ServicioBoton) super.clone();
		return clon;
	}
}