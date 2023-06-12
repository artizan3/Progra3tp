package empresa;

import java.io.Serializable;
import java.time.LocalDate;

import abonado.Abonado;
import metodosdepago.DecoratorPago;
/*
 * esta clase es la encargada de recopilar todas las contrataciones de un determinado abonado
 * y operarlas de forma tal que nos devuelva informacion valiosa, en este caso, lo que debera pagar
 * el abonado
 */
public class Factura implements Cloneable, Serializable, IFactura {
	private Abonado abonado;
	private LocalDate fechaDeEmision;
	private LocalDate fechaDePago;

	private double monto;
	
	
	public Factura(Abonado abonado) {
		this.abonado = abonado;
		this.fechaDeEmision= Empresa.getInstance().getFecha();
		this.fechaDePago=null;
		this.monto=calcularMonto();
	}
	
	private double calcularMonto() {	
		
		return this.abonado.valorTotal();
	}
	
	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public LocalDate getFechaDeEmision() {
		return fechaDeEmision;
	}
	public boolean isPago() {
		return this.fechaDePago!=null;
	}
	/**
	 * Constructor de la clase <br>
	 * <br>
	 * <b>Pre</b>: Se espera que abonado sea distinto de null y exista ".<br>
	 * <b>Inv</b>: abonado.<br>
	 * <b>Post</b>: Se setea el valor del atributo abonado<br>
	 */


	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post<b>: Retorna el abonado. <br>
	 */
	public Abonado getAbonado() {
		return abonado;
	}



	/**
	 * Este metodo se dedica a crear y devolver un clon de clase factura</br>
	 * </br>
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Devuelve un clon de la factura en caso de ser posible. <br>
	 * 
	 * @throws CloneNotSupportedException solamente si algun atriburo de tipo objeto
	 *                                    no fuera clonable
	 * @return clon un clon de la factura
	 */
	public Object clone() throws CloneNotSupportedException {
		Factura clon = null;
		clon = (Factura) super.clone();
		clon.abonado = (Abonado) this.abonado.clone();
		return clon;
	}

	public boolean isAbonadoMoroso() {
		return this.getAbonado().getEstado().toString().equals("Moroso");
	}
	public double getMonto() {
		if (isAbonadoMoroso())
			return monto*1.3;
		else return monto;
	}
	
	public IFactura getFactura() {
		return this;
	}

	@Override
	public double getMontoSinTipoDePago() {
			if (isAbonadoMoroso())
				return monto*1.3;
			else
				return monto;
	}
}
