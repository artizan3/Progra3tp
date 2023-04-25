package empresa;

import java.util.ArrayList;

import Domicilio.Domicilio;
import promo.Promo;
import servicio.Servicio;

public class Contrataciones implements Cloneable {
	protected Promo promo=null;
	private ArrayList <Servicio> listaServicio=new ArrayList <Servicio>();
	private Domicilio domicilio;
	public static int counter=000000;
	private int id;
	
	public Contrataciones(Domicilio domicilio) {
		this.domicilio=domicilio;
		counter++;
		this.id=counter;
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
        double suma=this.getValorBase(domicilio);
        for(i=0;i<listaServicio.size();i++) {
            suma+=this.listaServicio.get(i).costo();
        }
        return suma;
    }
	
	private double getValorBase(Domicilio domicilio) {
		double aux=0;
		if (domicilio.getTipoDom()=="Vivienda") {
			aux=8500;
			if (this.promo!=null)
				aux=this.promo.vivienda();
		}else
			if (domicilio.getTipoDom()=="Comercio") {
				aux=10000;
				if (this.promo!=null)
					aux=this.promo.comercio();
			}
		return aux;
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
	
	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	public String Descripcion() {
		String aux="";
		aux+="ID="+this.id+" \n";
		aux+=this.domicilio.toString()+"'|tipo: "+this.domicilio.getTipoDom()+"|promo: "+this.promo+"\n";
		aux+=this.ListadoDeSerivicios();
		aux+="Valor final del domicilio:"+this.getValorTotal()+"\n";
		return aux;
	}

	public int getId() {
		return id;
	}
	public Object clone() throws CloneNotSupportedException {
		Contrataciones clon=(Contrataciones)super.clone();
		clon.domicilio=(Domicilio)this.domicilio.clone();
		clon.promo=(Promo)this.promo.clone();
		clon.listaServicio=(ArrayList<Servicio>)this.listaServicio.clone();
		clon.listaServicio.clear();
		for (int i=0;i<this.listaServicio.size();i++) {
			clon.listaServicio.add((Servicio)this.listaServicio.get(i).clone());
		}
		return clon;
	}
}
