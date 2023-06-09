package abonado;

import java.io.Serializable;

import empresa.Contratacion;
import empresa.Empresa;
import empresa.Factura;
import excepciones.FacturaInexistenteException;

public class ConContratacion implements IState, Serializable {

	private Fisica abonado;
	
	public ConContratacion(Fisica abonado) {
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura(Factura factura) throws FacturaInexistenteException { 
			Empresa.getInstance().EliminarFactura(factura);
	}

	@Override
	public void contratarServicio(Contratacion contrato) {
		abonado.aniadirContratacion(contrato);
		//No cambia de estado
	}

	@Override
	public void bajarServicio(Contratacion contrato) {
		abonado.eliminaContratacion(contrato);
		if (abonado.listaDeContratos.size() == 0)
			abonado.setEstado(new SinContratacion(abonado));
	}

}
