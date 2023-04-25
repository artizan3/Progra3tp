package abonado;

public class Fisica extends Abonado  {

    /*
     * Pre: Se espera que nombre sea distinto de NULL y " ".DNI mayor a 0
     */
    public Fisica(String nombre, int dni) {
    	super(nombre, dni);
        assert nombre != null: "El nombre no puede ser NULL";
        assert nombre != "": "El nombre no puede estar vacio";
        assert dni > 0:"El DNI debe ser mayor a 0";
       
    }

    @Override
    public String toString() {
        return "Fisico "+super.toString();
    }

    /*
     * Pre:  La lista de Domicilios no debe estar vacia
     * Post: El metodo no puede devolver cero
     */
    public double getValor() {
        assert !this.ListaDeDomicilios.isEmpty():"La lista de domicilios no debe estar vacia"; 
        double aux=0;
        for(int i=0;i<this.ListaDeDomicilios.size();i++)
            aux+=ListaDeDomicilios.get(i).getValorTotal();
        return aux;
    }

    public Object clone() throws CloneNotSupportedException {
        Fisica clon=(Fisica)super.clone();
        return clon;
    }
}
