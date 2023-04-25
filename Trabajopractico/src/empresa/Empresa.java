package empresa;

import java.util.ArrayList;

import Domicilio.Domicilio;
import abonado.Abonado;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioExistenteException;
import excepciones.DomicilioInexistenteExeption;
import excepciones.DomicilioVinculadoException;
import excepciones.FactoryinvalidoException;
import metodosdepago.DecoratorPago;
import metodosdepago.FactoryPago;
/**
 * 
 * @author bruno trinitario,Alan Juares,Juan Basualdo,Juan Olave
 *
 */

public class Empresa {
    private static Empresa instance=null;
    private ArrayList<Abonado> listaEmpresa=new ArrayList<Abonado>();
    private ArrayList<Contrataciones> listaContrataciones=new ArrayList<Contrataciones>();
    private ArrayList<Factura> listaFactura=new ArrayList<Factura>();
    private FactoryPago creacion=new FactoryPago();
    /**
     * este metodo garantiza que solo exista una instancia de la clase empresa</br>
     */
    public static Empresa getInstance() {
        if(instance==null)
            instance= new Empresa();
        return instance;
    }
    /**
     * este metodo agrega un abonado a la lista de abonados</br>
     * <br>pre:</br> El abonado debe ser !=null al igual que el tipodepago.<br>
     * <br>inv:</br> El abonado a agregar no esta en la lista<br>
     * <br>post:</br> Se aniade un abonado a la lista y se crea una factura para el mismo<br>
     * @param abonado es el abonado a agregar
     * @param tipodepago va a ser la cadena que indicara el metodo de pago
     * @throws FactoryinvalidoException si el tipo de pago fue incorrecto o no existente 
     */
    public void agregaAbonado(Abonado abonado,String tipodepago) throws FactoryinvalidoException {
    	listaEmpresa.add(abonado);
        crearFactura(abonado,tipodepago);
    }
    /**
     * este metodo crea y agrega una factura a la lista de facturas</br>
     * <br>pre:</br> El abonado debe ser !=null al igual que el tipodepago.<br>
     * <br>inv:</br> La factura a agregar no esta en la lista<br>
     * <br>post:</br>Se crea una factura para el abonado con su tipo de pago y se aniade a la lista<br>
     * @param abonado es el abonado para el cual se crea la factura
     * @param tipodepago es el String que indica que metodo de pago va a tener la factura
     * @throws FactoryinvalidoException si el tipo de pago fue incorrecto o no existente 
     */
    private void crearFactura(Abonado abonado,String tipodepago) throws FactoryinvalidoException {
    	try {
    		DecoratorPago aux=creacion.getMetodoDePago(abonado, tipodepago);
    		Factura factura=new Factura(aux);
    		AniadirFactura(factura);
    	}finally {}
    }
    /**
     * este metodo cambia el metodo de pago de un abonado</br>
     * <br>pre:</br> La factura debe ser !=null. El abonado debe ser !=null al igual que el tipodepago.<br>
     * <br>inv:</br> La factura y el abonado estan en las listas<br>
     * <br>post:</br>Se actualiza el metodo de pago de la factura del abonado<br>
     * @param factura es la factura que cambiara su metodo de pago
     * @param abonado es el abonado de la factura
     * @param tipodepago el metodo de pago nuevo para la factura
     * @throws FactoryinvalidoException si el tipo de pago fue incorrecto o no existente 
     */
    public void CambiarMetodoPago(Factura factura,Abonado abonado,String tipodepago) throws FactoryinvalidoException {
    	try{
    		DecoratorPago aux=creacion.getMetodoDePago(abonado, tipodepago);
    		factura.setAbonado(aux);
    	}finally {}
    }
    /**
     * este metodo agrega domicilio un abonado</br>
     * <br>pre:</br> el Domicilio y el abonado deben existir y ser !=null<br>
     * <br>inv:</br> El abonado esta en la lista<br>
     * <br>post:</br>Se aniade un domicilio al abonado<br>
     * @param domicilio es el domicilio que vamos a agregar
     * @param abonado indica el abonado que recibe el domicilio nuevo
     * @throws DomicilioVinculadoException si el domicilio ya esta previamente vinculado 
     * @throws DomicilioExistenteException si el domicilio si el abonado ya posee ese domicilio
     */
    public void agregaDom(Domicilio domicilio,Abonado abonado) throws DomicilioVinculadoException,DomicilioExistenteException {
        try{
        	if (abonado.ExisteDomicilio(domicilio)==false)
        		abonado.AniadirDomicilio(domicilio);
        	else
        		throw new DomicilioExistenteException();
        }finally {}
    }
    /**
     * este metodo quita domicilio de un abonado</br>
     * <br>pre:</br> el Domicilio y el abonado deben existir y ser !=null<br>
     * <br>inv:</br> El abonado esta en la lista<br>
     * <br>post:</br>Se quita el domicilio al abonado<br>
     * @param domicilio es el domicilio que queremos eliminar
     * @param abonado es el abonado el cual eliminamos el domicilio
     * @throws DomicilioInexistenteExeption si el domicilio no existe para ese abonado
     */
    public void QuitarDom(Domicilio domicilio,Abonado abonado) throws DomicilioInexistenteExeption {
    	abonado.QuitarDomicilio(domicilio);
    }
    /**
     * este metodo quita un abonado de la lista</br>
     * <br>pre:</br> el abonado debe existir y ser !=null<br>
     * <br>inv:</br> El abonado esta en la lista<br>
     * <br>post:</br>Se quita el abonado de la lista<br>
     * @param abonado es el abonado que queremos quitar del sistema
     */
    public void quitaAbonado(Abonado abonado) {
        this.listaEmpresa.remove(abonado);
    }
    /**
     * este metodo quita una factura de la lista</br>
     * <br>pre:</br> la factura debe existir y ser !=null<br>
     * <br>inv:</br> la factura esta en la lista<br>
     * <br>post:</br>Se quita la factura de la lista<br>
     * @param factura es la factura que queremos quitar del sistema
     */
    public void EliminarFactura(Factura factura) {
    	this.listaFactura.remove(factura);
    }
    /**
     * este metodo crea una contratacion la anide a la lista y a la facutra correspondiente</br>
     * <br>pre:</br> el Domicilio y el abonado deben existir y ser !=null<br>
     * <br>inv:</br> el abonado esta en la lista, y el domicilio esta vinculado al abonado <br>
     * <br>post:</br>Se crea una contratacion la anide a la lista y a la facutra correspondiente<br>
     * @param domicilio es el domicilio que pertenecera a la contratacion
     * @param abonado este indicara para que factura sera agregada la contratacion
     * @throws ContratacionInvalidaException si el abonado no poseia el domicilio y/o el domicilio no estaba vinculado
     */
    public void CrearContratacion(Domicilio domicilio,Abonado abonado) throws ContratacionInvalidaException {
    	if (abonado.ExisteDomicilio(domicilio)==true && domicilio.isAgregado()==true) {
    		Contrataciones contrato=new Contrataciones(domicilio);
    		AniadirContratacionFactura(contrato,abonado);
    	}else
    		throw new ContratacionInvalidaException();
    }
    /**
     * este metodo agrega una factura a la lista de abonados</br>
     * <br>pre:</br> la factura debe ser !=null<br>
     * <br>inv:</br> la factura a agregar no esta en la lista<br>
     * <br>post:</br> Se aniade una factura a la lista<br>
     * @param factura es la factura nueva que vamos a aniadir
     */
    private void AniadirFactura(Factura factura) {
    	this.listaFactura.add(factura);
    }
    /**
     * este metodo busca y agrega una contratacion a una determinada factura</br>
     * <br>pre:</br> el contrato y el abonado deben existir y ser !=null<br>
     * <br>inv:</br> el contrato y el abonado estan en las listas<br>
     * <br>post:</br> Se aniade una agrega una contratacion a una determinada factura<br>
     * @param contrato es el contrato que vamos a aniadir a la factura
     * @param abonado es el que indica que factura tomar
     */
    private void AniadirContratacionFactura(Contrataciones contrato,Abonado abonado) {
    	Abonado aux;
    	int i=0;
    	while (this.listaFactura.get(i).getAbonado()!=abonado) {
    		i++;
    	}
    	this.listaFactura.get(i).aniadirContratacion(contrato);
    }
    /**
     * este metodo clona una determinada factura</br>
     * <br>pre:</br> la factura deben existi y ser !=null<br>
     * <br>inv:</br> la factura esta en la lista<br>
     * <br>post:</br> Se clona una determinada factura<br>
     * @param factura es la factura que vamos a clonar
     * @throws CloneNotSupportedException no se pudo clonar la factura
     * @return clon determinada factura
     */
    public Object ClonarFactura(Factura factura) throws CloneNotSupportedException {
    	Factura clon=(Factura)factura.clone();
    	return clon;
    }
}
