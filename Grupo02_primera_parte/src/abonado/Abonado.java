package abonado;

import java.io.Serializable;
import java.util.ArrayList;

import Domicilio.Domicilio;
import empresa.Contratacion;
import empresa.Factura;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioExistenteException;
import excepciones.DomicilioInexistenteException;
/*
 * la clase abonado, la cual tiene 2 variantes (fisica y juridica) es
 * respondable de encapsular sus respectivos domicilios y contrataciones
 * para que a la hora de generar la factura del abonado se poseea toda la informacion necesaria
 */
public abstract class Abonado implements Cloneable, iAbonado, Serializable {
	protected String nombre;
	protected int dni;
	protected ArrayList<Contratacion> listaDeContratos = new ArrayList<Contratacion>();
	protected ArrayList<Domicilio> listaDeDomicilios = new ArrayList<Domicilio>();
	protected ArrayList<Factura> listaDeFacturas = new ArrayList<Factura>();

	/**
	 * Constructor de la clase <br>
	 * <br>
	 * <b>Pre</b>: Se espera que nombre sea distinto de null y " ".DNI mayor a
	 * 0.<br>
	 * <b>Inv</b>: Nombre y dni.<br>
	 * <b>Post</b>: Se setean los valores de los atributos nombre y dni.<br>
	 */
	public Abonado(String nombre, int dni) {
		assert nombre != null : "El nombre no puede ser null";
		assert !nombre.equals("") : "El nombre no puede estar vacio";
		assert dni > 0 : "El DNI debe ser mayor a 0";
		this.dni = dni;
		this.nombre = nombre;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el tipo de abonado.<br>
	 */
	public abstract String tipoAbonado();

	/**
	 * Recibe un domicilio, chequea si ya estaba agregado y lo agrega. Si ya estaba,
	 * tira excepcion. <br>
	 * <br>
	 * <b>Pre</b>: Se espera que domicilio sea distinto de null.<br>
	 * <b>Inv</b>: Domicilio.<br>
	 * <b>Post</b>: Agrega el domicilio a la listaDeContratos de domicilios del abonado.<br>
	 */
	public void aniadirDomicilio(Domicilio domicilio) throws DomicilioExistenteException {
		assert domicilio != null : "El domicilo no puede ser null";
		if (domicilio.isAgregado() == false) {
			this.listaDeDomicilios.add(domicilio);
			domicilio.setAgregado(true);
		} else
			throw new DomicilioExistenteException("El domicilio ya estaba agregado a la listaDeContratos", domicilio);
	}

	/*
	 * Devuelve la listaDeContratos de contrataciones del abonado
	 */
	public ArrayList<Contratacion> getLista() {
		return listaDeContratos;
	}
	/**
	 * El metodo recibe un tipo abonado y devuelve la suma de los valores de las
	 * contrataciones netas, segun el tipo de abonado, sin descuentos de tipo metodo
	 * de pago.<br>
	 * <br>
	 *
	 * <b>Pre</b>: El abonado debe ser valido y distinto de null. <br>
	 * <b>Inv</b>: La listaDeContratos de servicios. <br>
	 * <b>Post</b>: Devuelve la sumatoria de los valores.<br>
	 * 
	 * @param abonado indica el tipo de abonado.
	 * @return suma es sumatoria de los valores.
	 */
	public abstract double valorTotal();

	/**
	 * Este metodo añade una contratacion a la listaDeContratos.<br>
	 * <br>
	 *
	 * <b>Pre</b>: La contratacion debe ser distinta de null.<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>:Se añade una contratacion a la listaDeContratos.<br>
	 * 
	 * @param contrato es la contratacion que aniadimos en la listaDeContratos.
	 */
	public void aniadirContratacion(Contratacion contrato) {
		assert contrato != null : "El contrato debe ser distinto de null";
		this.listaDeContratos.add(contrato);
	}

	/**
	 * <b>Pre</b>: Domicilio debe ser distinto null. <br>
	 * <b>Inv</b>: Domicilio.<br>
	 * <b>Post</b>: Se quita el domicilio de la listaDeContratos de domicilios.<br>
	 */
	public void quitarDomicilio(Domicilio domicilio) throws DomicilioInexistenteException {
		assert domicilio != null : "El domicilio debe ser distinto de null";
		if (existeDomicilio(domicilio) == true && domicilio.isAgregado() == true) {
			this.listaDeDomicilios.remove(domicilio);
			domicilio.setAgregado(false);
		} else if (existeDomicilio(domicilio) == false)
			throw new DomicilioInexistenteException("Domicilio inexistente en la listaDeContratos", domicilio);
	}

	@Override
	public String toString() {
		return "|nombre: " + nombre + "|dni: " + dni;
	}

	/**
	 * El metodo recibe un domicilio por parametro y verifica si existe o no,
	 * devolviendo un booleano. <br>
	 * <br>
	 * <b>Pre</b>: El domicilio debe ser distinto de null.<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Se verifica la existencia del domicilio.<br>
	 * 
	 */
	public boolean existeDomicilio(Domicilio domicilio) {
		assert domicilio != null : "El domicilio debe ser distinto de null";
		return this.listaDeDomicilios.contains(domicilio);
	}
	/**
	 * El metodo recibe un contrato por parametro y verifica si existe o no,
	 * devolviendo un booleano. <br>
	 * <br>
	 * <b>Pre</b>: El contrato debe ser distinto de null.<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Se verifica la existencia del contrato.<br>
	 * 
	 */
	public boolean existeContratacion(Contratacion contrato) {
		assert contrato != null : "El domicilio debe ser distinto de null";
		return this.listaDeContratos.contains(contrato);
	}
	
	
	public void eliminaContratacion(Contratacion contrato) throws ContratacionInvalidaException {
		assert contrato != null : "El contrato debe ser distinto de null";
		if (existeContratacion(contrato) == true) {
			this.listaDeContratos.remove(contrato);

		} 
		else 
		   if (existeContratacion(contrato) == false)
		      throw new ContratacionInvalidaException("Contrato inexistente en la listaDeContratos",null, this);   
	}
	
	
	/**
	 * El metodo clona el objeto de tipo abonado. <br>
	 * <br>
	 * <b>Pre</b><br>
	 * <b>Inv</b><br>
	 * <b>Post</b>: Se clona el objeto<br>
	 * @throws CloneNotSupportedException si el objeto no puede ser clonable
	 */
	public Object clone() throws CloneNotSupportedException {
		Abonado clon = null;
		clon = (Abonado) super.clone();
		clon.listaDeDomicilios = (ArrayList<Domicilio>) this.listaDeDomicilios.clone();
		clon.listaDeDomicilios.clear();
		for (int i = 0; i < this.listaDeDomicilios.size(); i++)
			clon.listaDeDomicilios.add((Domicilio) this.listaDeDomicilios.get(i).clone());
		
		clon.listaDeContratos = (ArrayList<Contratacion>) this.listaDeContratos.clone();
		clon.listaDeContratos.clear();
		for (int i = 0; i < this.listaDeContratos.size(); i++)
			clon.listaDeContratos.add((Contratacion) this.listaDeContratos.get(i).clone());
		
		clon.listaDeFacturas = (ArrayList<Factura>) this.listaDeFacturas.clone();
		clon.listaDeFacturas.clear();
		for (int i = 0; i < this.listaDeFacturas.size(); i++)
			clon.listaDeFacturas.add((Factura) this.listaDeFacturas.get(i).clone());
		return clon;
	}
	public int getDni() {
		// TODO Auto-generated method stub
		return this.dni;
	}
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
}
