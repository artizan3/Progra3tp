package abonado;

import java.io.Serializable;
import java.time.LocalDate;

import empresa.Factura;
import empresa.MesaDeSolicitudDeTecnicos;
import excepciones.FacturaInexistenteException;

public class Fisica extends Abonado {
	
	private IState estado;
	private double recargo = 1; //se inicializa sin recargo
	
	public IState getEstado() {
		return estado;
	}
	public void setEstado(IState estado) {
		this.estado = estado;
	}
	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}
	public Fisica(String nombre, int dni, MesaDeSolicitudDeTecnicos mesa) {
		super(nombre, dni, mesa);
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
		for (int i = 0; i < this.listaDeContrataciones.size(); i++) {
			suma += this.listaDeContrataciones.get(i).getValorTotal();
		}
		return suma*recargo;
	}
	public Object clone() throws CloneNotSupportedException {
		Fisica clon = null;
		clon = (Fisica) super.clone();
		return clon;
	}
	@Override
	public void cambiaEstado() {
		this.estado.chequeaCambio();
	}
	@Override
	public void PagoEstado(Factura factura, LocalDate fechaDePago) {
		try {
			estado.pagarFactura(factura, fechaDePago);
		} catch (FacturaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


}
