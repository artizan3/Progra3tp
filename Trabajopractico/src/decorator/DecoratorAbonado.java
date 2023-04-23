package decorator;

import java.util.ArrayList;

import Domicilio.Domicilio;
import abonado.Abonado;

public abstract class DecoratorAbonado extends Abonado {
	protected Decorable abonado;
	protected ArrayList<Domicilio>ListaDeDomicilios=new ArrayList<Domicilio>();
	public DecoratorAbonado(Decorable abonado) {
		this.abonado=abonado;
	}
	
	//public void AniadirDomicilio(Domicilio domicilio) {
		//ListaDeDomicilios.add(domicilio);
	//	}
	
	//public void QuitarDomicilio(Domicilio domicilio)) {
		//ListaDeDomicilios.remove(domicilio);
	//	}

	@Override
	public abstract String toString();

	public abstract double CalcularPrecio();

}
