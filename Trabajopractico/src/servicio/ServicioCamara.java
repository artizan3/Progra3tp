package servicio;

public class ServicioCamara extends Servicio {
	public double costo() {
		return 3000;
	}

	@Override
	public String getTipo() {
		return "Camara";
	}

	/**
	 * Es el metodo encargado de la clonacion del ServicioCamara. <br>
	 * <br>
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Devuelve un clon de tipo ServicioCamara.<br>
	 */
	public Object clone() throws CloneNotSupportedException {
		ServicioCamara clon = null;
		clon = (ServicioCamara) super.clone();
		return clon;
	}
}