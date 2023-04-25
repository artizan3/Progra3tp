package promo;

public interface Promo{
	/**
	 * este metodo se dedica a devolver el valor base de un domicilio de tipo comercio aplicando una determinada promocion<br>
	 * @return constant
	 */
	double comercio();
	/**
	 * este metodo se dedica a devolver el valor base de un domicilio de tipo vivienda aplicando una determinada promocion<br>
	 * @return constant
	 */
	double vivienda();
	/**
	 * este metodo devuelve el tipo de promocion<br>
	 * @return constant
	 */
	String toString();
	/**
	 * el metodo se dedica a crear un clon de una promocion<br>
	 * @return clon clon de la promocion
	 */
	Object clone() throws CloneNotSupportedException;
}
