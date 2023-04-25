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
		aux+="ID="+this.id+" \n";
		aux+=this.domicilio.toString()+" "+this.domicilio.getTipoDom()+"\n";
		aux+=this.domicilio.ListadoDeSerivicios();
		aux+="Valor final del domicilio:"+this.domicilio.getValorTotal()+"\n";
		return aux;
	}

	public int getId() {
		return id;
	}
	public Object clone() throws CloneNotSupportedException {
		Contrataciones clon=(Contrataciones)super.clone();
		clon.domicilio=(Domicilio)this.domicilio.clone();
		return clon;
	}
}
