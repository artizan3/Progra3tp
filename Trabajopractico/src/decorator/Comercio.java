package decorator;

import abonado.Abonado;

public class Comercio extends DecoratorAbonado {
	
	public Comercio(Decorable abonado) {
		super(abonado);
	}

	@Override
	public String toString() {
		return "Comercio "+ this.abonado.toString();
	}

	@Override
	public double CalcularPrecio() {
		double retorno=0;
		for (int i=0;i<=this.ListaDeDomicilios.size();i++) {
			retorno+=this.ListaDeDomicilios.get(i).CalcularPrecioComercio();
		}
		return retorno;
	}
}
