package abonado;

public class Fisica extends Abonado  {

    /**
     * <b>Pre</b>: se espera que nombre sea distinto de null y " ".DNI mayor a 0<br>
     * <b>Inv</b>:<br>
     * <b>Post</b>:<br>
     */
    public Fisica(String nombre, int dni) {
    	super(nombre, dni);
    }
    /**
     * <b>Pre</b>:<br>
     * <b>Inv</b>:<br>
     * <b>Post</b>: muestra el tipo de abonado mas el nombre y dni.<br>
     */
    @Override
    public String toString() {
        return "tipoA: "+tipoAbonado()+super.toString();
    }
    /**
     * <b>Pre</b>:<br> 
     * <b>Inv</b>:<br> 
     * <b>Post</b>: retorna el tipo de abonado.<br>
     */
    public String tipoAbonado() {
    	return "Fisica";
    }
    /**
     * <b>Pre</b>:<br>
     * <b>Inv</b>:<br>
     * <b>Post</b>: clona el tipo fisico de abonado.<br>
     */
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
