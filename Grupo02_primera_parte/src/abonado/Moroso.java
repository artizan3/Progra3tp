package abonado;

import java.io.Serializable;

import empresa.Contratacion;
import empresa.Factura;

public class Moroso implements IState, Serializable {

	private Fisica abonado;
	
	public Moroso(Fisica abonado) {
		super();
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura(Factura factura) {
		///////////////////////////////
		abonado.setEstado(new ConContratacion(abonado));
	}

	@Override
	public void contratarServicio(Contratacion contrato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bajarServicio(Contratacion contrato) {
		// TODO Auto-generated method stub
		
	}
	
	
}
