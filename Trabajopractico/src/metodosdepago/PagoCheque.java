package metodosdepago;

import abonado.Abonado;

public class PagoCheque extends DecoratorPago {

	public PagoCheque(Abonado abonado) {
		super(abonado);
	}
	
	@Override
	public double ValorDeTipoPago() {
		return ValorSinTipoPago()*1.1;
	}
	/**<b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post:</b>: Clona el PagoCheque.<br>
	 */
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		PagoCheque clon = null;
		clon=(PagoCheque)super.clone();
		return clon;
	}
	public String tipodepago() {
		return"Cheque";
	}

}