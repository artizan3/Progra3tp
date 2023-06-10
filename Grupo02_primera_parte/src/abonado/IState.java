package abonado;

import java.time.LocalDate;

import empresa.Contratacion;
import empresa.Factura;
import excepciones.ContratacionInvalidaException;
import excepciones.FacturaInexistenteException;

public interface IState {

	void pagarFactura(Factura factura, LocalDate fechaDatePago,String TipoPago) throws FacturaInexistenteException;
	void contratarServicio(Contratacion contrato);
	void bajarServicio(Contratacion contrato)throws ContratacionInvalidaException;
	void chequeaCambio();
}
