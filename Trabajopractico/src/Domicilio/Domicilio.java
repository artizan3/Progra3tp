package Domicilio;

import java.util.ArrayList;

import promo.Promo;
import servicio.Servicio;

public abstract class Domicilio implements Cloneable {
	private String nombre;
	private boolean agregado=false;
	
	/**
	 * Pre: Se espera que el nombre no sea NULL y " "
	 */
	public Domicilio(String nombre) {
		this.nombre=nombre;
		assert nombre != null:"Elnombre no puede ser null";
		assert nombre != ""  :"El nombre no puede ser vacio";
	}
	public void setAgregado(boolean type) {
		this.agregado = type;
	}
	public boolean isAgregado() {
		return agregado;
	}
	
    public abstract String getTipoDom();
	
    @Override
	public String toString() {
		return "Domicilio '" + nombre;
	}
    public Object clone() throws CloneNotSupportedException {
		Domicilio clon=(Domicilio)super.clone();
		return clon;
	}

}
