package servicio;

public class ServicioCamara extends Servicio {
		public double costo() {
			return 3000;
		}
		@Override
		public String getTipo() {
			return "Camara";
		}
}
