package empresa;

import Domicilio.Domicilio;

public class Contrataciones implements Cloneable {
	private Domicilio domicilio;
	public static int counter=000000;
	private int id;
	
	public Contrataciones(Domicilio domicilio) {
		this.domicilio=domicilio;
		counter++;
		this.id=counter;
	}

	public String Descripcion() {
		String aux="";
		aux+=this.domicilio.toString()+" "+this.domicilio.getTipoDom()+"\n";
		aux+=this.domicilio.ListadoDeSerivicios()+"\n";
		aux+=this.domicilio.getValorTotal();
		return aux;
	}

	public int getId() {
		return id;
	}
	public Object clone() {
		return null;
	}
}
