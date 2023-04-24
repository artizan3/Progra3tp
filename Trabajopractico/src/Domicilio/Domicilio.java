package Domicilio;

import java.util.ArrayList;

import servicio.Servicio;

public abstract class Domicilio implements Cloneable {
	private String nombre;
	private boolean agregado=false;
	private ArrayList <Servicio> listaServicio=new ArrayList <Servicio>();
	
	public Domicilio(String nombre) {
		this.nombre=nombre;
	}
	public void setAgregado(boolean type) {
		this.agregado = type;
	}
	public boolean isAgregado() {
		return agregado;
	}

	public void agregarServicio(Servicio servicio) {
		this.listaServicio.add(servicio);
	}
	public double getValorTotal() {
        int i;
        double suma=this.getValorBase();
        for(i=0;i<listaServicio.size();i++) {
            suma+=this.listaServicio.get(i).costo();
        }
        return suma;
    }
	public String ListadoDeSerivicios() {
		String aux="";
		for(int i=0;i<listaServicio.size();i++) {
            aux+=this.listaServicio.get(i).getTipo() + "\n";
        }
		return aux;
		
	}
    public abstract double getValorBase();
    public abstract String getTipoDom();
	
    @Override
	public String toString() {
		return "Domicilio [nombre=" + nombre + "]";
	}
    public Object clone() {
		return null;
	}
 
}
