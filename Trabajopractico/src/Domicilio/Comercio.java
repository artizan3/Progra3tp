package Domicilio;

public class Comercio extends Domicilio {

	 /**
     * <b>Pre</b>: se espera que el nombre no sea NULL y " ".<br>
     * <b>Inv</b>:<br>
     * <b>Post</b>:<br>
     */
    public Comercio(String nombre) {
        super(nombre);
        assert nombre != null:"Elnombre no puede ser null";
        assert nombre != ""  :"El nombre no puede ser vacio";
    }

	@Override
	public String getTipoDom() {
		return "Comercio";
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br> 
	 * <b>Post</b>: clona comercio.<br>
	 */
    public Object clone() throws CloneNotSupportedException {
		Comercio clon=(Comercio)super.clone();
		return clon;
	}
	@Override
	public double ValorBase() {
		return 10000;
	}
	@Override
	public double promoDorada() {
		return ValorBase()-2500;
	}
	@Override
	public double promoPlatino() {
		// TODO Auto-generated method stub
		return ValorBase()*0.65;
	}

}
