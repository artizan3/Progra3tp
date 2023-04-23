package decorator;

import abonado.Abonado;

public class Vivienda extends DecoratorAbonado {

	public Vivienda(Decorable abonado) {
		super(abonado);
	}

	@Override
	public String toString() {
		return "Vivienda "+ this.abonado.toString();
	}

	@Override
	public double CalcularPrecio() {
		double retorno=0;
		for (int i=0;i<=this.ListaDeDomicilios.size();i++) {
			retorno+=this.ListaDeDomicilios.get(i).CalcularPrecioVivienda();
		}
		return retorno;
	}
}
