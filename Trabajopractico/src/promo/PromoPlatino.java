package promo;

import Domicilio.Domicilio;

public class PromoPlatino implements Promo, Cloneable {

	public String toString() {
		return "Platino";
	}

	/**
	 * <b>Pre</b>: El domicilio debe ser distinto de null.<br>
	 * <b>Inv</b>: Domicilio.<br>
	 * <b>Post</b>: Se aplica la promo al correspondiente domicilio.<br>
	 */
	@Override
	public double aplicarPromo(Domicilio domicilio) {
		assert domicilio != null : "Domicilio null";
		return domicilio.promoPlatino();
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Clona el tipo de promo.<br>
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Promo clon = null;
		clon = (Promo) super.clone();
		return clon;
	}
}