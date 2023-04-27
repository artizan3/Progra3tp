package metodosdepago;

import java.util.ArrayList;

import abonado.Abonado;
import abonado.iAbonado;
import empresa.Contrataciones;

public abstract class DecoratorPago implements Cloneable,iAbonado {
	protected Abonado abonado;
	
	public DecoratorPago(Abonado abonado) {
		this.abonado=abonado;
	}
	public abstract double ValorDeTipoPago();
	public double ValorSinTipoPago() {
		return this.abonado.ValorTotal();
	}
	public ArrayList<Contrataciones> getLista() {
		return this.abonado.getLista();
	}
	public abstract String tipodepago();
	
	public Object clone() throws CloneNotSupportedException {
		DecoratorPago clon=(DecoratorPago)super.clone();
		return clon;
	}
	public String toString() {
		return this.abonado.toString();
	}
}
