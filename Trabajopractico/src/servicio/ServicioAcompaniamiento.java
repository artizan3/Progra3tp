package servicio;

public class ServicioAcompaniamiento extends Servicio {
	public double costo() {
		return 7500;
	}

	@Override
	public String getTipo() {
		return "Acompaniamiento";
	}
	
}
