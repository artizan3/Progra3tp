package Domicilio;

public class Comercio extends Domicilio {

	 /**
     * Pre: Se espera que el nombre no sea NULL y " "
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
    public Object clone() throws CloneNotSupportedException {
		Comercio clon=(Comercio)super.clone();
		return clon;
	}

}
