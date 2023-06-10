package abonado;

import java.io.Serializable;
import java.time.LocalDate;

import empresa.Contratacion;
import empresa.Factura;
import excepciones.ContratacionInvalidaException;

public class SinContratacion implements IState, Serializable {


	private Fisica abonado;
	
	
	
	public SinContratacion(Fisica abonado) {
		super();
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura(Factura factura,LocalDate fechaDePago,String TipoPago) {
		//No puede pagar ya que no contrato nada
		//Mensaje a traves de la ventana
	}

	@Override
	public void contratarServicio(Contratacion contrato) {
		abonado.aniadirContratacion(contrato);
		abonado.setEstado(new ConContratacion(this.abonado));
	}

	@Override
	public void bajarServicio(Contratacion contrato) throws ContratacionInvalidaException {
		//No puede bajar servicio ya que no contrato nada
		//Mensaje a traves de la ventana
	}

	@Override
	public void chequeaCambio() {
		//nunca llega aca ya que ni bien se contrata el servicio ahi se cambia el estado a contratacion
	}
}
