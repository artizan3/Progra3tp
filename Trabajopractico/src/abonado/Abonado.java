package abonado;

import java.util.ArrayList;

import Domicilio.Domicilio;
import empresa.Contrataciones;

public abstract class Abonado implements Cloneable{
	protected String nombre;
	protected int dni;
	protected ArrayList<Domicilio>ListaDeDomicilios=new ArrayList<Domicilio>();
	
	public Abonado(String nombre,int dni) {
		this.dni=dni;
		this.nombre=nombre;
	}
	
	public void AniadirDomicilio(Domicilio domicilio) {
		this.ListaDeDomicilios.add(domicilio);
		domicilio.setAgregado(true);
	}
	public void QuitarDomicilio(Domicilio domicilio) {
		if (ExisteDomicilio(domicilio)==true && domicilio.isAgregado()==true) {
			this.ListaDeDomicilios.remove(domicilio);
			domicilio.setAgregado(false);
		}
	}
	
	public abstract double getValor();

	@Override
	public String toString() {
		return "Abonado [nombre=" + nombre + ", dni=" + dni + "]";
	}
	public boolean ExisteDomicilio(Domicilio domicilio) {
		return this.ListaDeDomicilios.contains(domicilio);
	}
	public Object clone() {
		Abonado clon=(Abonado)super.clone();
		return clon;
	}
}
