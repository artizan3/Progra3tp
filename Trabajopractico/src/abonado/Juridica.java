package abonado;

import decorator.Decorable;

public class Juridica extends Abonado implements Decorable{

	public Juridica(String nombre, int dni) {
		super(nombre, dni);
	}

	@Override
	public String toString() {
		return "Juridica [getNombre()=" + getNombre() + ", getDni()=" + getDni() + "]";
	}


	

}
