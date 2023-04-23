package abonado;

import decorator.Decorable;

public class Fisica extends Abonado implements Decorable {

	public Fisica(String nombre, int dni) {
		super(nombre, dni);
	}
	@Override
	public String toString() {
		return "Fisica [getNombre()=" + getNombre() + ", getDni()=" + getDni() + "]";
	}


}
