package abonado;

import java.io.Serializable;

public class ConContratacion implements IState, Serializable {

	private Fisica abonado;
	
	public ConContratacion(Fisica abonado) {
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura() {
		// TODO Auto-generated method stub

	}

	@Override
	public void contratarServicio() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bajarServicio() {
		// TODO Auto-generated method stub

	}

}
