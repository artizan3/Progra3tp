package abonado;

import java.util.ArrayList;

import Domicilio.Domicilio;
import empresa.Contrataciones;
import excepciones.DomicilioExistenteException;
import excepciones.DomicilioInexistenteExeption;
import excepciones.DomicilioVinculadoException;

public abstract class Abonado implements Cloneable,iAbonado{
	protected String nombre;
	protected int dni;
	protected ArrayList<Contrataciones>Lista=new ArrayList<Contrataciones>();
	protected ArrayList<Domicilio>ListaDeDomicilios=new ArrayList<Domicilio>();
	
	public Abonado() {}
    /**
    * <b>Pre</b>: Se espera que nombre sea distinto de NULL y " ".DNI mayor a 0.<br>
    * <b>Inv</b>:<br> 
    * <b>Post</b>:<br>
    */
  	public Abonado(String nombre,int dni) {
       assert nombre != null: "El nombre no puede ser NULL";
       assert nombre != "": "El nombre no puede estar vacio";
       assert dni > 0:"El DNI debe ser mayor a 0";
       this.dni=dni;
       this.nombre=nombre;
   	}
	
 
  	
    /**
     * <b>Pre</b>: Se espera que domicilio sea distinto de NULL.<br>
     * <b>Inv</b>:<br> 
     * <b>Post</b>:<br>
     */
   	public void AniadirDomicilio(Domicilio domicilio) throws DomicilioExistenteException {
   		
      if (domicilio.isAgregado() == false) {
	     this.ListaDeDomicilios.add(domicilio);
         domicilio.setAgregado(true);
  	   }
      else
  		throw new DomicilioExistenteException("El domicilio ya estaba agregado a la lista",domicilio);  
  	}
   	
	public ArrayList<Contrataciones> getLista() {
		return Lista;
	}
	/**
   * El metodo recibe un tipo abonado y devuelve la suma de los valores de las contrataciones netas,
   * segun el tipo de abonado.sin descuentos de tipo metodo de pago.<br><br>
   * <b>Pre</b>: el abonado debe ser valido y distinto de null. <br>
   * <b>Inv</b>: la lista de servicios. <br>
   * <b>Post</b>: devuelve la sumatoria de los valores.<br>
   * @param abonado indica el tipo de abonado.
   * @return suma es sumatoria de los valores.
   */
	public abstract double ValorTotal();
	/**
     * Este metodo añade una contratacion a la lista<br><br>
     * <b>Pre</b>: la contratacion debe ser valida y disntinta de null.<br>
     * <b>Inv</b>:<br> 
     * <b>Post</b>:se aniade una contratacion a la lista.<br>
     * @param contrato es la contratacion que aniadimos en la lista.
     */
	public void aniadirContratacion(Contrataciones contrato) {
		this.Lista.add(contrato);
	}
  /**
   * <b>Pre</b>:domicilio debe ser distinto NULL <br>
   * <b>Inv</b>:<br>
   * <b>Post</b>:se quita el domicilio de la lista de domicilios<br>
   */
	public void QuitarDomicilio(Domicilio domicilio) throws DomicilioInexistenteExeption {
      assert domicilio != null:"El domicilio debe ser distinto de NULL";
      if (ExisteDomicilio(domicilio)==true && domicilio.isAgregado()==true) {
          this.ListaDeDomicilios.remove(domicilio);
          domicilio.setAgregado(false);
      }else
    	  if (ExisteDomicilio(domicilio)==false)
    		  throw new DomicilioInexistenteExeption();
  	}
	@Override
	public String toString() {
		return "|nombre: " + nombre + "|dni: " + dni ;
	}
	public abstract String tipoAbonado();
	/**
	 * <b>Pre</b>:el domicilio debe ser distinto de null. <br>
     * <b>Inv</b>:<br> 
     * <b>Post</b>:se verifica la existencia del domicilio.<br>
	 * 
	 */
    public boolean ExisteDomicilio(Domicilio domicilio){
        assert domicilio != null: "El domicilio debe ser distinto de null";
        return this.ListaDeDomicilios.contains(domicilio);
    }
    
	public Object clone() throws CloneNotSupportedException {
		Abonado clon=(Abonado)super.clone();
		clon.ListaDeDomicilios=(ArrayList<Domicilio>)this.ListaDeDomicilios.clone();
		clon.ListaDeDomicilios.clear();
		for (int i=0;i<this.ListaDeDomicilios.size();i++) 
			clon.ListaDeDomicilios.add((Domicilio)this.ListaDeDomicilios.get(i).clone());
		clon.Lista=(ArrayList<Contrataciones>)this.Lista.clone();
		clon.Lista.clear();
		for (int i=0;i<this.Lista.size();i++)
			clon.Lista.add((Contrataciones)this.Lista.get(i).clone());
		return clon;
	}
}
