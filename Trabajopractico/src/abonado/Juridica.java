package abonado;


public class Juridica extends Abonado{
	
	 /**
     * <b>Pre</b>:<br> se espera que nombre sea distinto de null y " ".DNI mayor a 0.<br>
     * <b>Inv</b>:<br> 
     * <b>Post</b>:<br>
     */
	public Juridica(String nombre, int dni) {
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
    	return "Juridica";
    }
    /**
     * <b>Pre</b>:<br> 
     * <b>Inv</b>:<br> 
     * <b>Post</b>: clona el tipo juridico de abonado.<br>
     */
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
