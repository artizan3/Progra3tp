package excepciones;

import Domicilio.Domicilio;
import abonado.Abonado;

@SuppressWarnings("serial")
public class ContratacionInvalidaException extends Exception {
	private Domicilio domicilio;
	private Abonado abonado;

	public ContratacionInvalidaException(String mensaje, Domicilio domicilio, Abonado abonado) {
		super(mensaje);
		this.abonado = abonado;
		this.domicilio = domicilio;
	}

	public String Informar() {
		return "Error:" + this.getAbonado() + " " + this.getDomicilio();
	}

	public String getDomicilio() {
		return domicilio.toString();
	}

	public String getAbonado() {
		return abonado.toString();
	}
}