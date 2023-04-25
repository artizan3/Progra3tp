package abonado;


public class Juridica extends Abonado{
	
	 /*
     * Pre: Se espera que nombre sea distinto de NULL y " ".DNI mayor a 0
     */
	public Juridica(String nombre, int dni) {
		super(nombre, dni);
	}

    @Override
    public String toString() {
        return "tipoA: "+tipoAbonado()+super.toString();
    }
    public String tipoAbonado() {
    	return "Juridica";
    }
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
