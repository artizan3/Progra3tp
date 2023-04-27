package Domicilio;

public class Vivienda extends Domicilio {

	public Vivienda(String nombre) {
		super(nombre);
	}
	@Override
	public String getTipoDom() {
		return "Vivienda";
	}
    public Object clone() throws CloneNotSupportedException {
    	Vivienda clon=(Vivienda)super.clone();
		return clon;
	}
	@Override
	public double ValorBase() {
		return 8500;
	}
	@Override
	public double promoDorada() {
		return ValorBase()-1500;
	}
	@Override
	public double promoPlatino() {
		// TODO Auto-generated method stub
		return ValorBase()*0.7;
	}


}
