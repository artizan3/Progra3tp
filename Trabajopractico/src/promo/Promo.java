package promo;

import Domicilio.Domicilio;

public interface Promo {
	public abstract double aplicarPromo(Domicilio domicilio);

	String toString();

	/**
	 * El metodo se dedica a crear un clon de una promocion<br>
	 * 
	 * @return clon de la promocion
	 */
	Object clone() throws CloneNotSupportedException;
}