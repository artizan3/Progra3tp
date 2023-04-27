package abonado;

public class Fisica extends Abonado  {

    /*
     * Pre: Se espera que nombre sea distinto de NULL y " ".DNI mayor a 0
     */
    public Fisica(String nombre, int dni) {
    	super(nombre, dni);
    }

    @Override
    public String toString() {
        return "tipoA: "+tipoAbonado()+super.toString();
    }
    public String tipoAbonado() {
    	return "Fisica";
    }

    public Object clone() throws CloneNotSupportedException {
        Fisica clon=(Fisica)super.clone();
        return clon;
    }

	@Override
	public double ValorTotal() {
		double suma=0;
		for (int i=0;i<this.Lista.size();i++){
			suma+=this.Lista.get(i).getValorTotal();
		}
		return suma;
	}
}
