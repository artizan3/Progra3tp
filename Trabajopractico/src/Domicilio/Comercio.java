package Domicilio;

public class Comercio extends Domicilio {

	/**
	 * <b>Pre</b>: Se espera que el nombre no sea null ni " ".<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>:<br>
	 */
	public Comercio(String nombre) {
		super(nombre);
		assert nombre != null : "El nombre no puede ser null";
		assert !nombre.equals("") : "El nombre no puede ser vacio";
	}

	@Override
	public String getTipoDom() {
		return "Comercio";
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: clona comercio.<br>
	 */
	public Object clone() throws CloneNotSupportedException {
		Comercio clon = (Comercio) super.clone();
		return clon;
	}

	@Override
	public double valorBase() {
		return 10000;
	}

	@Override
	public double promoDorada() {
		return valorBase() - 2500;
	}

	@Override
	public double promoPlatino() {
		// TODO Auto-generated method stub
		return valorBase() * 0.65;
	}

}