package abonado;

public class SinContratacion implements IState {

	private Fisica abonado;
	
	
	
	public SinContratacion(Fisica abonado) {
		super();
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
