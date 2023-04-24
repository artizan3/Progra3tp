package abonado;


public class Juridica extends Abonado{

	public Juridica(String nombre, int dni) {
		super(nombre, dni);
	}

	@Override
	public String toString() {
		return "Juridica "+super.toString();
	}
	public double getValor() {
		double aux=0;
		for(int i=0;i<this.ListaDeDomicilios.size();i++){
			if (i<2)
				aux+=ListaDeDomicilios.get(i).getValorTotal();
			else
				aux+=ListaDeDomicilios.get(i).getValorTotal()*0.5;
		}
		return aux;
	}
	public Object clone() {
		return null;
	}

}
