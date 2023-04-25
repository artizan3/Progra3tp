package metodosdepago;

import abonado.Abonado;

public class FactoryPago {
	public DecoratorPago getMetodoDePago(Abonado abonado,String tipopago) {
		DecoratorPago aux=null;
		if (tipopago=="Tarjeta")
			aux=new PagoCredito(abonado);
		if (tipopago=="Efectivo")
			aux=new PagoEfectivo(abonado);
		if (tipopago=="Cheque")
			aux=new PagoCheque(abonado);
		return aux;
	}
}
