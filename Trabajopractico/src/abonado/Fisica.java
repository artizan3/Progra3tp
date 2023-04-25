package abonado;

public class Fisica extends Abonado  {

	public Fisica(String nombre, int dni) {
		super(nombre, dni);
	}
	@Override
	public String toString() {
		return "Fisico "+super.toString();
	}
	
	public double getValor() {
		double aux=0;
		for(int i=0;i<this.ListaDeDomicilios.size();i++)
			aux+=ListaDeDomicilios.get(i).getValorTotal();
		return aux;
	}
	public Object clone() {
		Fisica clon=(Fisica)super.clone();
		return clon;
	}

	
}
