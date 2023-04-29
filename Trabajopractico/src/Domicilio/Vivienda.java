package Domicilio;

public class Vivienda extends Domicilio {

	public Vivienda(String nombre) {
		super(nombre);
	}

	@Override
	public String getTipoDom() {
		return "Vivienda";
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: clona vivienda.<br>
	 */
	public Object clone() throws CloneNotSupportedException {
		Vivienda clon = null;
		clon = (Vivienda) super.clone();
		return clon;
	}

	@Override
	public double valorBase() {
		return 8500;
	}

	@Override
	public double promoDorada() {
		return valorBase() - 1500;
	}

	@Override
	public double promoPlatino() {
		// TODO Auto-generated method stub
		return valorBase() * 0.7;
	}

}