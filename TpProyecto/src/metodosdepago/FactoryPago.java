package metodosdepago;

import abonado.Abonado;
import excepciones.FactoryinvalidoException;

public class FactoryPago {
	/**
	 * <b>Pre</b>: Abonado y tipopago deben ser distinto de null.<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna la instancia del tipo de pago.<br>
	 */
	public DecoratorPago getMetodoDePago(Abonado abonado,String tipopago) throws FactoryinvalidoException {
		DecoratorPago aux=null;
		
		if (tipopago.equals("Tarjeta"))
			aux=new PagoCredito(abonado);
		
		else if (tipopago.equals("Efectivo"))
			aux=new PagoEfectivo(abonado);
		
		else if (tipopago.equals("Cheque"))
			aux=new PagoCheque(abonado);
		
		else 
			throw new FactoryinvalidoException();
		
		return aux;
	}
}