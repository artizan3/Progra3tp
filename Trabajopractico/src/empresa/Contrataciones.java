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
	/**
     * este es el contructor de la clase el cual aumenta el id en 1 por cada instancia</br>
     * <br>pre:</br> el domicilio debe existir y ser !=null<br>
     * <br>inv:</br> <br>
     * <br>post:</br> se le asigna un valor al atributo<br>
     * @param domicilio es el valor que se le asignara al atributo
     */
	public Contrataciones(Domicilio domicilio) {
		this.domicilio=domicilio;
		counter++;
		this.id=counter;
	}
	/**
     * este metodo agregara un servicio a la lista</br>
     * <br>pre:</br> el servicio debe existir y ser !=null<br>
     * <br>inv:</br>la lista de servicios esta inicializada <br>
     * <br>post:</br> se aniade el servicio a la lista<br>
     * @param servicio es el objeto que se aniadira a la lista
     */
	public void agregarServicio(Servicio servicio) {
		assert servicio != null: "El servicio debe ser distinto de null";
		this.listaServicio.add(servicio);
	}
	/**
     * este metodo devolvera la suma de los valores de los servicios agregados 
     * junto con el valor base del domicilio y su valor alterado por una promo </br>
     * <br>pre:</br><br>
     * <br>inv:</br>la lista de servicios esta inicializada <br>
     * <br>post:</br> devuelve la sumatoria de los valores<br>
     * @return suma sumatoria de los valores
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
	/**
     * este metodo devolvera el valor base de un domicilio segun su tipo y su promo </br>
     * <br>pre:</br>el domicilio debe ser !=null y existir<br>
     * <br>inv:</br>los valores sin promo no varia <br>
     * <br>post:</br> devuelve el valor base del domicilio<br>
     * @param domicilio es el encargado de determinar que valor dara segun el tipo
     * @return aux valor base del domicilio
     */
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
     * este metodo crea la lista de servicios agregados vinculados al domicilio de la contratacion </br>
     * <br>pre:</br>la lista no debe ser nula<br>
     * <br>inv:</br>la lista de servicios esta inicializada <br>
     * <br>post:</br> devuelve la lista de servicios agregados<br>
     * @return aux lista de servicios agregados 
     */
	public String ListadoDeSerivicios() {
		assert !this.listaServicio.isEmpty(): "La lista de servicios no debe estar vacia";
		String aux="";
		for(int i=0;i<listaServicio.size();i++) {
            aux+=this.listaServicio.get(i).getTipo() + "\n";
        }
		return aux;
		
	}
	/**
	 * este metodo permite aniadir un tipo de promo a la contratacion
     * <br>pre:</br>la promo no debe ser nula y debe existir<br>
     * <br>inv:</br><br>
     * <br>post:</br> setea el atributo promo<br>
     * @param promo es el valor que se le dara al atributo
     */
	public void setPromo(Promo promo) {
		this.promo = promo;
	}
	
	/**
	 * el metodo generara la descripcion de la contratacion, brindando informacion como
	 * el tipo de abonado, su nombre y dni, el id de la contratacion, el domicilio, su tipo y promo
	 * y el valor total de la contratacion
     * <br>pre:</br><br>
     * <br>inv:</br><br>
     * <br>post:</br> devuelve un String con la descripcion<br>
     * @return aux descripcion
     */
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
	
	/**
	 *es el metodo encargado de la clonacion de la contratacion
     * <br>pre:</br><br>
     * <br>inv:</br><br>
     * <br>post:</br> devuelve un clon<br>
     * @throws CloneNotSupportedException si algun atributo de tipo objeto no fuera clonable
     * @return clon un clon de la contratacion
     */
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
