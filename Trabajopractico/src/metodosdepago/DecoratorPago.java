package metodosdepago;

import abonado.Abonado;

public abstract class DecoratorPago extends Abonado implements Cloneable {
	protected Abonado abonado;
	
	public DecoratorPago(Abonado abonado) {
		this.abonado=abonado;
	}
	@Override
	public double getValor() {
		return 0;
	}
	
	public double valorSinDescuento() {
		return this.abonado.getValor();
	}
	
	public abstract double valorDescuento();
	public abstract String tipodepago();
	
	public Object clone() throws CloneNotSupportedException {
		DecoratorPago clon=(DecoratorPago)super.clone();
		return clon;
	}
	public String toString() {
		return this.abonado.toString();
	}
}
