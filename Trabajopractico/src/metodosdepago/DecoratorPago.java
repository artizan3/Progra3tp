package metodosdepago;

import abonado.Abonado;

public abstract class DecoratorPago extends Abonado implements Cloneable {
	protected Abonado abonado;
	
	public DecoratorPago(Abonado abonado) {
		this.abonado=abonado;
	}
	
	public abstract double ValorDeTipoPago(double suma);
	public abstract String tipodepago();
	
	public Object clone() throws CloneNotSupportedException {
		DecoratorPago clon=(DecoratorPago)super.clone();
		return clon;
	}
	public String toString() {
		return this.abonado.toString();
	}
	public String tipoAbonado() {
		return this.abonado.tipoAbonado();
	}
}
