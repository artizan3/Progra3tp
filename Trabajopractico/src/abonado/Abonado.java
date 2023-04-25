package abonado;

import java.util.ArrayList;

import Domicilio.Domicilio;
import empresa.Contrataciones;

public abstract class Abonado implements Cloneable{
	protected String nombre;
	protected int dni;
	protected ArrayList<Domicilio>ListaDeDomicilios=new ArrayList<Domicilio>();
	
	public Abonado() {
		
	}
	
    /*
    * Pre: Se espera que nombre sea distinto de NULL y " ".DNI mayor a 0
    */
   public Abonado(String nombre,int dni) {
       assert nombre != null: "El nombre no puede ser NULL";
       assert nombre != "": "El nombre no puede estar vacio";
       assert dni > 0:"El DNI debe ser mayor a 0";
       this.dni=dni;
       this.nombre=nombre;
   }

	
   /*
   * Pre: Domicilio debe ser distinto de NULL
   */
  public void AniadirDomicilio(Domicilio domicilio) {
      assert domicilio != null:"El domicilio debe ser distinto de NULL";
      this.ListaDeDomicilios.add(domicilio);
      domicilio.setAgregado(true);
  }
  
  /*
   * Pre: Domicilio debe ser distinto de NULL
   */
  public void QuitarDomicilio(Domicilio domicilio) {
      assert domicilio != null:"El domicilio debe ser distinto de NULL";
      if (ExisteDomicilio(domicilio)==true && domicilio.isAgregado()==true) {
          this.ListaDeDomicilios.remove(domicilio);
          domicilio.setAgregado(false);
      }
  }
	
	public abstract double getValor();

	@Override
	public String toString() {
		return "Abonado nombre= " + nombre + ", dni= " + dni ;
	}
	 /*
     * Pre: Domicilio debe ser distinto de NULL
     */
    public boolean ExisteDomicilio(Domicilio domicilio) {
        assert domicilio != null: "El domicilio debe ser distinto de null";
        return this.ListaDeDomicilios.contains(domicilio);
    }
	public Object clone() throws CloneNotSupportedException {
		Abonado clon=(Abonado)super.clone();
		clon.ListaDeDomicilios=(ArrayList<Domicilio>)this.ListaDeDomicilios.clone();
		clon.ListaDeDomicilios.clear();
		for (int i=0;i<this.ListaDeDomicilios.size();i++) 
			clon.ListaDeDomicilios.add((Domicilio)this.ListaDeDomicilios.get(i).clone());
		return clon;
	}
}
