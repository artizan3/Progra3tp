package abonado;

import java.io.Serializable;
import java.time.LocalDate;

import empresa.Contratacion;
import empresa.Empresa;
import empresa.Factura;
import excepciones.ContratacionInvalidaException;

public class Moroso implements IState, Serializable {

private Fisica abonado;
	
	public Moroso(Fisica abonado) {
		super();
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura(Factura factura, LocalDate fechaDePago) {
		
        int i = 0, j = 0;
		
		while (i < 2 && j < abonado.listaDeFacturas.size()) {
		   if (!abonado.listaDeFacturas.get(j).isPago())
			   i++;
		   j++;   
		}  
		//Paga la factura con un recargo del 30%
		i--; //porque pago una
		if (i < 2) {
			abonado.setEstado(new ConContratacion(abonado));
			abonado.setRecargo(1);
		}
		
	}

	@Override
	public void contratarServicio(Contratacion contrato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bajarServicio(Contratacion contrato) throws ContratacionInvalidaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequeaCambio() {
		if(abonado.cantidadFacturasImpagas<1)
			abonado.setEstado(new ConContratacion(abonado));
		
	}
	@Override
	public String toString() {
		return "Moroso";
	}
	
}
