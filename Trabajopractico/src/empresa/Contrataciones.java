package empresa;

import java.util.ArrayList;

import Domicilio.Domicilio;
import promo.Promo;
import servicio.Servicio;

public class Contrataciones implements Cloneable {
	protected Promo promo=null;
	private Domicilio domicilio;
	public static int counter=000000;
	private int id;
	private ArrayList <Servicio> listaServicio=new ArrayList <Servicio>();
	
	public void agregarServicio(Servicio servicio) {
		assert servicio != null: "El servicio debe ser distinto de null";
		this.listaServicio.add(servicio);
	}
	public double getValorTotal() {
		assert !this.listaServicio.isEmpty(): "La lista de servicios no debe estar vacia";
		int i;
        double suma=this.domicilio.getValorBase();//retorna el valor base sin aplicar promo
        //corregirlo!!!
        for(i=0;i<listaServicio.size();i++) {
            suma+=this.listaServicio.get(i).costo();
        }
        return suma;
    }
	public String ListadoDeSerivicios() {
		assert !this.listaServicio.isEmpty(): "La lista de servicios no debe estar vacia";
		String aux="";
		for(int i=0;i<listaServicio.size();i++) {
            aux+=this.listaServicio.get(i).getTipo() + "\n";
        }
		return aux;
		
	}
	
	public Contrataciones(Domicilio domicilio) {
		this.domicilio=domicilio;
		counter++;
		this.id=counter;
	}

	public String Descripcion() {
		String aux="";
		aux+="ID="+this.id+" \n";
		aux+=this.domicilio.toString()+" "+this.domicilio.getTipoDom()+" promo: "+this.promo+"\n";
		aux+=this.ListadoDeSerivicios();
		aux+="Valor final del domicilio:"+this.getValorTotal()+"\n";
		return aux;
	}

	public int getId() {
		return id;
	}
	public void setPromo(Promo promo) {
		this.promo = promo;
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
