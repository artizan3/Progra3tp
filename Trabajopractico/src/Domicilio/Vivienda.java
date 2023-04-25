package Domicilio;

public class Vivienda extends Domicilio {

	public Vivienda(String nombre) {
		super(nombre);
	}

	@Override
    public double getValorBase() {
		double aux;
		if (this.promo==null)
			aux=8500;
		else
			aux=promo.vivienda();
		return aux;
    }

	@Override
	public String getTipoDom() {
		return "tipo: Vivienda";
	}
    public Object clone() throws CloneNotSupportedException {
    	Vivienda clon=(Vivienda)super.clone();
		return clon;
	}

}
