package metodosdepago;

import abonado.Abonado;

public class PagoCredito extends DecoratorPago {

	public PagoCredito(Abonado abonado) {
		super(abonado);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double valorDescuento() {
		return this.abonado.getValor()+this.abonado.getValor()*0.05;
	}
	public Object clone() throws CloneNotSupportedException {
		PagoCredito clon=(PagoCredito)super.clone();
		return clon;
	}
	public String tipodepago() {
		return" Tarjeta de credito";
	}

}
