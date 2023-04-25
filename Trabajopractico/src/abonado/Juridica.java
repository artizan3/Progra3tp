package abonado;


public class Juridica extends Abonado{
	
	 /*
     * Pre: Se espera que nombre sea distinto de NULL y " ".DNI mayor a 0
     */
	public Juridica(String nombre, int dni) {
		super(nombre, dni);
		assert nombre != null: "El nombre no puede ser NULL";
	    assert nombre != "": "El nombre no puede estar vacio";
	    assert dni > 0:"El DNI debe ser mayor a 0";
	}

	@Override
	public String toString() {
		return "Juridica "+super.toString();
	}
	 /*
     * Pre: La lista de Domicilios no debe estar vacia
     */
	public double getValor() {
        assert !this.ListaDeDomicilios.isEmpty():"La lista de domicilios no debe estar vacia"; 
		double aux=0;
		for(int i=0;i<this.ListaDeDomicilios.size();i++){
			if (i<2)
				aux+=ListaDeDomicilios.get(i).getValorTotal();
			else
				aux+=ListaDeDomicilios.get(i).getValorTotal()*0.5;
		}
		return aux;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
