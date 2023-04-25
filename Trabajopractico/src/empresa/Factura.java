package empresa;

import java.util.ArrayList;

import abonado.Abonado;
import metodosdepago.DecoratorPago;

public class Factura implements Cloneable{
	private ArrayList<Contrataciones>Lista=new ArrayList<Contrataciones>();
	private DecoratorPago abonado;
	public Factura(DecoratorPago abonado) {
		this.abonado=abonado;
	}
	public void aniadirContratacion(Contrataciones contrato) {
		this.Lista.add(contrato);
	}
	public Abonado getAbonado() {
		return abonado;
	}
	public void ImprimeFactura() {
		System.out.println(this.abonado.toString()+this.abonado.tipodepago()+"\n");
		for (int i=0;i<this.Lista.size();i++){
			System.out.println(this.Lista.get(i).Descripcion());
		}
		System.out.println("Precio neto(sin metodo de pago):"+this.abonado.valorSinDescuento());
		System.out.println("Precio con metodo de pago:"+this.abonado.valorDescuento());
	}
	public double getValorTotal() {
		return this.abonado.valorSinDescuento();
	}
	public Object clone() throws CloneNotSupportedException {
		Factura clon=(Factura)super.clone();
		clon.abonado=(DecoratorPago)this.abonado.clone();
		clon.Lista=(ArrayList<Contrataciones>)this.Lista.clone();
		for (int i=0;i<this.Lista.size();i++)
			clon.Lista.add((Contrataciones)this.Lista.get(i).clone());
		return clon;
	}
}
