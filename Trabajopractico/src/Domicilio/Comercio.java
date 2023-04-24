package Domicilio;

public class Comercio extends Domicilio {

	public Comercio(String nombre) {
		super(nombre);
	}
	@Override
    public double getValorBase() {
        return 10000;
    }
	@Override
	public String getTipoDom() {
		return "Comercio ";
	}

}
