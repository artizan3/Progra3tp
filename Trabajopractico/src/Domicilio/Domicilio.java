package Domicilio;

import java.util.ArrayList;

import servicio.Servicio;

public abstract class Domicilio implements Cloneable {
	private String nombre;
	private boolean agregado=false;
	private ArrayList <Servicio> listaServicio=new ArrayList <Servicio>();
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
	/**
	 * Pre: Servicio debe ser distinto de NULL
	 */
	public void agregarServicio(Servicio servicio) {
		assert servicio != null: "El servicio debe ser distinto de null";
		this.listaServicio.add(servicio);
	}
	/**
	 *  Pre:  Lista de servicio no debe estar vacia
	 *  Post: Se espera que el metodo devuelva la sumatoria 
	 *  de los agregados
	 */
	public double getValorTotal() {
		assert !this.listaServicio.isEmpty(): "La lista de servicios no debe estar vacia";
		int i;
        double suma=this.getValorBase();
        for(i=0;i<listaServicio.size();i++) {
            suma+=this.listaServicio.get(i).costo();
        }
        return suma;
    }
	/**
	 * Pre: se espera que la Lista de Servicios no sea nula
	 */
	public String ListadoDeSerivicios() {
		assert !this.listaServicio.isEmpty(): "La lista de servicios no debe estar vacia";
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
    public Object clone() throws CloneNotSupportedException {
		Domicilio clon=(Domicilio)super.clone();
		clon.listaServicio=(ArrayList<Servicio>)this.listaServicio.clone();
		clon.listaServicio.clear();
		for (int i=0;i<this.listaServicio.size();i++) {
			clon.listaServicio.add((Servicio)this.listaServicio.get(i).clone());
		}
		return clon;
	}
 
}
