package servicio;

public class ServicioCamara extends Servicio {
	public double costo() {
		return 3000;
	}
	@Override
	public String getTipo() {
		return "Camara";
	}
	public Object clone() {
		ServicioCamara clon=(ServicioCamara)super.clone();
		return clon;
	}
}
