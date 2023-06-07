package abonado;

import java.io.Serializable;

public class Fisica extends Abonado {
	
	private IState estado;

	public IState getEstado() {
		return estado;
	}
	public void setEstado(IState estado) {
		this.estado = estado;
	}
	public Fisica(String nombre, int dni) {
		super(nombre, dni);
		this.estado = new SinContratacion(this);
	}
	@Override
	public String toString() {
		return "tipoA: " + tipoAbonado() + super.toString();
	}
	public String tipoAbonado() {
		return "Fisica";
	}
	@Override
	public double valorTotal() {
		double suma = 0;
		for (int i = 0; i < this.lista.size(); i++) {
			suma += this.lista.get(i).getValorTotal();
		}
		return suma;
	}
	public Object clone() throws CloneNotSupportedException {
		Fisica clon = null;
		clon = (Fisica) super.clone();
		return clon;
	}
}
