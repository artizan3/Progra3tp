package abonado;

import empresa.Contratacion;
import empresa.Factura;

public class SinContratacion implements IState {

	private Fisica abonado;
	
	
	
	public SinContratacion(Fisica abonado) {
		super();
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura(Factura factura) {
		//No puede pagar ya que no contrato nada

	}

	@Override
	public void contratarServicio(Contratacion contrato) {
		abonado.aniadirContratacion(contrato);
		abonado.setEstado(new ConContratacion(this.abonado));
	}

	@Override
	public void bajarServicio(Contratacion contrato) {
		//No puede bajar servicio ya que no contrato nada
	}

}
