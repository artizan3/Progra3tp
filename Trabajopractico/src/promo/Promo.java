package promo;

import Domicilio.Domicilio;

public interface Promo{
	public abstract double aplicarPromo(Domicilio domicilio);
	String toString();
	/**
	 * el metodo se dedica a crear un clon de una promocion<br>
	 * @return clon clon de la promocion
	 */
	Object clone() throws CloneNotSupportedException;
}
