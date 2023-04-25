package empresa;

import java.util.ArrayList;

import abonado.Abonado;
import excepciones.FactoryinvalidoException;
import metodosdepago.DecoratorPago;

public class Factura implements Cloneable{
	private ArrayList<Contrataciones>Lista=new ArrayList<Contrataciones>();
	private DecoratorPago abonado;
	
	public Factura(DecoratorPago abonado) {//aca asumimos que si o si ya viene con el tipo de pago
		this.abonado=abonado;
	}
	/**
     * este metodo le asigna una instancia de abonado al atributo abonado</br>
     * <br>pre:</br> El abonado debe ser !=null y debe existir<br>
     * <br>inv:</br> <br>
     * <br>post:</br> Se asigna el atributo abonado<br>
     * @param abonado es el abonado que se le asigna al atributo
     */
	public void setAbonado(DecoratorPago abonado) {
		this.abonado = abonado;
	}
	/**
     * este metodo aniade una contratacion a la lista</br>
     * <br>pre:</br> la contratacion debe ser valida y !=null<br>
     * <br>inv:</br> <br>
     * <br>post:</br> Se aniade una contratacion a la lista<br>
     * @param contrato es la contratacion que aniadimos en la lista
     */
	public void aniadirContratacion(Contrataciones contrato) {
		this.Lista.add(contrato);
	}
	
	public Abonado getAbonado() {
		return abonado;
	}
	/**
     * este metodo da todas las caracteristicas de la facura, tanto abonado como domicilios,
     *  contrataciones y servicios junto con los respectivos valores</br>
     * <br>pre:</br> <br>
     * <br>inv:</br> <br>
     * <br>post:</br> devuelve un tipo String con toda la informacion<br>
     * @return auc  toda la informacion de la factura
     */
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
	/**
     * el metodo recibe un tipo abonado y devuelve la suma de los valores de las contrataciones netas,
     *  segun el tipo de abonado.sin descuentos de tipo metodo de pago
     * <br>pre:</br>el abonado debe ser valido y !=null <br>
     * <br>inv:</br>la lista de servicios <br>
     * <br>post:</br> devuelve la sumatoria de los valores<br>
     * @param abonado es el que indica el tipo de abonado
     * @return suma sumatoria de los valores
     */
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
	/**
     * este metodo se dedica a crear y devolver un clon de clase factura</br>
     * <br>pre:</br> <br>
     * <br>inv:</br> <br>
     * <br>post:</br> devuelve un clon de la factura en caso de ser posible<br>
     * @throws CloneNotSupportedException solamente si algun atriburo de tipo objeto no fuera clonable
     * @return clon un clon de la factura
     */
	public Object clone() throws CloneNotSupportedException {
		Factura clon=(Factura)super.clone();
		clon.abonado=(DecoratorPago)this.abonado.clone();
		clon.Lista=(ArrayList<Contrataciones>)this.Lista.clone();
		clon.Lista.clear();
		for (int i=0;i<this.Lista.size();i++)
			clon.Lista.add((Contrataciones)this.Lista.get(i).clone());
		return clon;
	}
}
