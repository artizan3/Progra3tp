package empresa;

import java.util.ArrayList;

import abonado.Abonado;
import metodosdepago.DecoratorPago;

public class Factura implements Cloneable{
	private ArrayList<Contrataciones>Lista=new ArrayList<Contrataciones>();
	private DecoratorPago abonado;
	
	public Factura(DecoratorPago abonado) {//aca asumimos que si o si ya viene con el tipo de pago
		this.abonado=abonado;
	}
	public void setAbonado(DecoratorPago abonado) {
		this.abonado = abonado;
	}
	public void aniadirContratacion(Contrataciones contrato) {
		this.Lista.add(contrato);
	}
	
	public Abonado getAbonado() {
		return abonado;
	}
	
	public String ImprimeFactura() {
		String aux="";
		aux+=this.abonado.toString()+"|tipo de pago: "+this.abonado.tipodepago()+"\n";
		for (int i=0;i<this.Lista.size();i++){
			aux+=this.Lista.get(i).Descripcion()+"\n";
		}
		aux+="Precio neto(sin metodo de pago):"+ValorTotal(abonado)+"\n";
		aux+="Precio con metodo de pago:"+this.abonado.ValorDeTipoPago(ValorTotal(abonado))+"\n";
		return aux;
	}
	public double ValorTotal(Abonado abonado) {
		double suma=0;
		if (abonado.tipoAbonado()=="Fisica") {
			for (int i=0;i<this.Lista.size();i++){
				suma+=this.Lista.get(i).getValorTotal();
			}
		}
		if (abonado.tipoAbonado()=="Juridica") {
			for (int i=0;i<this.Lista.size();i++){
				if (i<2)
					suma+=this.Lista.get(i).getValorTotal();
				else
					suma+=this.Lista.get(i).getValorTotal()*0.5;
			}
		}
		return suma;
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
