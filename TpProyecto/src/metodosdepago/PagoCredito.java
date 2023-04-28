package metodosdepago;

import abonado.Abonado;

public class PagoCredito extends DecoratorPago {

	public PagoCredito(Abonado abonado) {
		super(abonado);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double ValorDeTipoPago() {
		return ValorSinTipoPago()*1.05;
	}
	/**<b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post:</b>: Clona el PagoCredito.<br>
	 */
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		PagoCredito clon = null;
		clon=(PagoCredito)super.clone();
		return clon;
	}
	public String tipodepago() {
		return"Tarjeta de credito";
	}

}