package promo;

import Domicilio.Domicilio;
import empresa.Contrataciones;

public class PromoPlatino implements Promo,Cloneable {

	public String toString() {
		return "Platino";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Promo clon=(Promo)super.clone();
		return clon;
	}
	@Override
	public double aplicarPromo(Domicilio domicilio) {
		return domicilio.promoPlatino();
	}
	
}
