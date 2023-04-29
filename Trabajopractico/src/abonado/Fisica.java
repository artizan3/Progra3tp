package abonado;

public class Fisica extends Abonado {

	/**
	 * Constructor de la clase <br>
	 * <br>
	 * <b>Pre</b>: Se espera que nombre sea distinto de null y " ".DNI mayor a
	 * 0.<br>
	 * <b>Inv</b>: Nombre y dni.<br>
	 * <b>Post</b>: Se crea la clase.<br>
	 */
	public Fisica(String nombre, int dni) {
		super(nombre, dni);
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: muestra el tipo de abonado mas el nombre y dni.<br>
	 */
	@Override
	public String toString() {
		return "tipoA: " + tipoAbonado() + super.toString();
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el tipo de abonado.<br>
	 */
	public String tipoAbonado() {
		return "Fisica";
	}

	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Clona el tipo fisico de abonado.<br>
	 */
	public Object clone() throws CloneNotSupportedException {
		Fisica clon = null;
		clon = (Fisica) super.clone();
		return clon;
	}

	@Override
	public double valorTotal() {
		double suma = 0;
		for (int i = 0; i < this.Lista.size(); i++) {
			suma += this.Lista.get(i).getValorTotal();
		}
		return suma;
	}
}
