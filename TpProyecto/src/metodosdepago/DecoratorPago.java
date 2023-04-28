package metodosdepago;

import java.util.ArrayList;

import abonado.Abonado;
import abonado.iAbonado;
import empresa.Contrataciones;

public abstract class DecoratorPago implements Cloneable,iAbonado {
	protected Abonado abonado;
	/**
	 * <b>Pre</b>: Abonado debe ser distinto de null.<br>
	 * <b>Inv</b>:<br>
	 *  <b>Post</b>: Encapsula el abonado.<br>
	 */
	public DecoratorPago(Abonado abonado) {
		this.abonado=abonado;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el valor total con el tipo de pago asignado.<br>
	 */
	public abstract double ValorDeTipoPago();
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post:</b>: Retorna el valor total sin el tipo de pago.<br>
	 */
	public double ValorSinTipoPago() {
		return this.abonado.ValorTotal();
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna lista de contrataciones de cada abonado.<br>
	 */
	public ArrayList<Contrataciones> getLista() {
		return this.abonado.getLista();
	}
	/**<b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el tipo de pago que realiza el abonado.<br>
	 */
	public abstract String tipodepago();
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Clona el DecoratorPago.<br>
	 */
	public Object clone() throws CloneNotSupportedException {
		DecoratorPago clon = null;
		clon=(DecoratorPago)super.clone();
		return clon;
	}

	public String toString() {
		return this.abonado.toString();
	}
}