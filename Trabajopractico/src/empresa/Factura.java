package empresa;

import java.util.ArrayList;

import abonado.Abonado;
import excepciones.FactoryinvalidoException;
import metodosdepago.DecoratorPago;

public class Factura implements Cloneable{
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
	
	public DecoratorPago getAbonado() {
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
		for (int i=0;i<this.abonado.getLista().size();i++){
			aux+=this.abonado.getLista().get(i).Descripcion()+"\n";
		}
		aux+="Precio neto(sin metodo de pago):"+this.abonado.ValorSinTipoPago()+"\n";
		aux+="Precio con metodo de pago:"+this.abonado.ValorDeTipoPago()+"\n";
		return aux;
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
		return clon;
	}
}
