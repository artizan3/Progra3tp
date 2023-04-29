package abonado;

public class Juridica extends Abonado {

	/**
	 * Constructor de la clase <br>
	 * <br>
	 * <b>Pre</b>: Se espera que nombre sea distinto de null ni " ". DNI mayor a
	 * 0.<br>
	 * <b>Inv</b>: Nombre y dni.<br>
	 * <b>Post</b>: Se crea la clase.<br>
	 */
	public Juridica(String nombre, int dni) {
		super(nombre, dni);
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Muestra el tipo de abonado mas el nombre y dni.<br>
	 */
	@Override
	public String toString() {
		return "tipoA: " + tipoAbonado() + super.toString();
	}

	/**
	 * Devuelve el tipo de abonado<br>
	 * <br>
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el tipo de abonado.<br>
	 */
	public String tipoAbonado() {
		return "Juridica";
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>:<br>
	 */

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("la clase abonado juridico no puede ser clonado");
	}

	@Override
	public double valorTotal() {
		double suma = 0;
		int i = 0;
		for (i = 0; i < this.Lista.size(); i++) {
			if (i >= 2) {
				suma += this.Lista.get(i).getValorTotal() * 0.5;
			} else
				suma += this.Lista.get(i).getValorTotal();
		}
		return suma;
	}

}
