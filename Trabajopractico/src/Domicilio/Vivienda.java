package Domicilio;

public class Vivienda extends Domicilio {

	public Vivienda(String nombre) {
		super(nombre);
	}

	@Override
    public double getValorBase() {
        return 8500;
    }

	@Override
	public String getTipoDom() {
		return "Vivienda";
	}
    public Object clone() throws CloneNotSupportedException {
    	Vivienda clon=(Vivienda)super.clone();
		return clon;
	}

}
