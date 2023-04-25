package metodosdepago;

import abonado.Abonado;

public class PagoCredito extends DecoratorPago {

	public PagoCredito(Abonado abonado) {
		super(abonado);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double ValorDeTipoPago(double suma) {
		return suma*1.05;
	}
	public Object clone() throws CloneNotSupportedException {
		PagoCredito clon=(PagoCredito)super.clone();
		return clon;
	}
	public String tipodepago() {
		return"Tarjeta de credito";
	}

}
