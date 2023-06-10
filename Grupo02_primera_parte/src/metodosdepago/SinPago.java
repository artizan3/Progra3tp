package metodosdepago;

import abonado.Abonado;

public class SinPago extends DecoratorPago {

	public SinPago(Abonado abonado) {
		super(abonado);
	}

	@Override
	public double valorDeTipoPago() {
		return valorSinTipoPago();
	}

	@Override
	public String tipoDePago() {
		return "Impago";
	}

}
