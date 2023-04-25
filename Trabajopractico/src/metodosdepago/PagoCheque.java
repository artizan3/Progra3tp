package metodosdepago;

import abonado.Abonado;

public class PagoCheque extends DecoratorPago {

	public PagoCheque(Abonado abonado) {
		super(abonado);
	}
	@Override
	public double valorDescuento() {
		return this.abonado.getValor()+this.abonado.getValor()*0.1;
	}
	public Object clone() throws CloneNotSupportedException {
		PagoCheque clon=(PagoCheque)super.clone();
		return clon;
	}
	public String tipodepago() {
		return" Cheque";
	}

}
