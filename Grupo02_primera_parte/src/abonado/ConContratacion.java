package abonado;

import java.io.Serializable;
import java.time.LocalDate;

import empresa.Contratacion;
import empresa.Empresa;
import empresa.Factura;
import excepciones.ContratacionInvalidaException;
import excepciones.FacturaInexistenteException;

public class ConContratacion implements IState, Serializable {

private Fisica abonado;
	
	public ConContratacion(Fisica abonado) {
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura(Factura factura, LocalDate fechaDePago) throws FacturaInexistenteException { 
			
        int i = 0, j = 0;
		while (i < 2 && j < abonado.listaDeFacturas.size()) {
		   if (!abonado.listaDeFacturas.get(j).isPago())
			   i++;
		   j++; 		   
		}   
		this.abonado.cantidadFacturasImpagas--;
		if (i >= 2) {
			abonado.setEstado(new Moroso(abonado));
			abonado.setRecargo(1.3);
		}

	}

	@Override
	public void contratarServicio(Contratacion contrato) {
		abonado.aniadirContratacion(contrato);
		//No cambia de estado
	}

	@Override
	public void bajarServicio(Contratacion contrato) throws ContratacionInvalidaException {
		abonado.eliminaContratacion(contrato);
		if (abonado.listaDeContrataciones.size() == 0)
			abonado.setEstado(new SinContratacion(abonado));
	}
	@Override
	public void chequeaCambio() {
		if(abonado.cantidadFacturasImpagas>2)
			abonado.setEstado(new Moroso(abonado));
	}
}
