package promo;

import Domicilio.Domicilio;

public class PromoDorada implements Promo,Cloneable {

	
	public String toString() {
		return "Dorada";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Promo clon=(Promo)super.clone();
		return clon;
	}
	@Override
	public double aplicarPromo(Domicilio domicilio) {
		return domicilio.promoDorada();
	}

}
