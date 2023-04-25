package metodosdepago;

import abonado.Abonado;
import excepciones.FactoryinvalidoException;

public class FactoryPago {
	public DecoratorPago getMetodoDePago(Abonado abonado,String tipopago) throws FactoryinvalidoException {
		DecoratorPago aux=null;
		if (tipopago=="Tarjeta")
			aux=new PagoCredito(abonado);
		else
			if (tipopago=="Efectivo")
				aux=new PagoEfectivo(abonado);
			else
				if (tipopago=="Cheque")
					aux=new PagoCheque(abonado);
				else
					throw new FactoryinvalidoException();
		return aux;
	}
}
