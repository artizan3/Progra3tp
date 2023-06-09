package abonado;

import empresa.Contratacion;
import empresa.Factura;
import excepciones.FacturaInexistenteException;

public interface IState {

		void pagarFactura(Factura factura) throws FacturaInexistenteException;
		void contratarServicio(Contratacion contrato);
		void bajarServicio(Contratacion contrato);
}
