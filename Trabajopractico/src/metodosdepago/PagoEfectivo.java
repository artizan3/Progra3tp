package metodosdepago;

import abonado.Abonado;

public class PagoEfectivo extends DecoratorPago {

	public PagoEfectivo(Abonado abonado) {
		super(abonado);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double ValorDeTipoPago() {
		return ValorSinTipoPago()*0.8;
	}
	public Object clone() throws CloneNotSupportedException {
		PagoEfectivo clon=(PagoEfectivo)super.clone();
		return clon;
	}
	public String tipodepago() {
		return"Efectivo";
	}

}
