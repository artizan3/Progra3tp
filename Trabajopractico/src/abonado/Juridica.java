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
	@Override
	public double ValorTotal() {
		double suma=0;
		int i=0;
		for (i=0;i<this.Lista.size();i++){
			if (i>=2) {
				suma+=this.Lista.get(i).getValorTotal()*0.5;
			}else 
				suma+=this.Lista.get(i).getValorTotal();
		}
		return suma;
	}

}
