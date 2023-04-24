package empresa;

import java.util.ArrayList;

import abonado.Abonado;

public class Factura implements Cloneable{
	private ArrayList<Contrataciones>Lista=new ArrayList<Contrataciones>();
	private Abonado abonado;
	public Factura(Abonado abonado) {
		this.abonado=abonado;
	}
	public void aniadirContratacion(Contrataciones contrato) {
		this.Lista.add(contrato);
	}
	public Abonado getAbonado() {
		return abonado;
	}
	public void ImprimeFactura() {
		System.out.println(this.abonado);
		for (int i=0;i<this.Lista.size();i++){
			System.out.println(this.Lista.get(i).Descripcion());
		}
		System.out.println(this.abonado.getValor());
	}
	public Object clone() {
		return null;
	}
	
}
