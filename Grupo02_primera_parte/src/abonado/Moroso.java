package abonado;

import java.io.Serializable;

public class Moroso implements IState, Serializable {

	private Fisica abonado;
	
	public Moroso(Fisica abonado) {
		super();
		this.abonado = abonado;
	}

	@Override
	public void pagarFactura() {
		abonado.setEstado(new ConContratacion(abonado));
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
