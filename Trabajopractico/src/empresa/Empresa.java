package empresa;

import java.util.ArrayList;

import Domicilio.Domicilio;
import abonado.Abonado;


public class Empresa {
    private Empresa instance=null;
    private ArrayList<Abonado> listaEmpresa=new ArrayList<Abonado>();
    private ArrayList<Contrataciones> listaContrataciones=new ArrayList<Contrataciones>();
    private ArrayList<Factura> listaFactura=new ArrayList<Factura>();

    public Empresa getInstance() {
        if(instance==null)
            instance= new Empresa();
        return instance;
    }
    
    public void agregaAbonado(Abonado abonado) {
        if(!listaEmpresa.contains(abonado)) {
            listaEmpresa.add(abonado);
            Factura factura=new Factura(abonado);
            AniadirFactura(factura);
        }
    }
    public void agregaDom(Domicilio domicilio,Abonado abonado) {
        if(this.listaEmpresa.contains(abonado)) {
        	if (abonado.ExisteDomicilio(domicilio)==false && domicilio.isAgregado()==false) {
        		abonado.AniadirDomicilio(domicilio);
        		Contrataciones contrato=new Contrataciones(domicilio);
        		AniadirContratacion(contrato);
        		BuscaFactura(contrato,abonado);
        	}
        }
    }
    public void QuitarDom(Domicilio domicilio,Abonado abonado) {
        if(this.listaEmpresa.contains(abonado)) {
            abonado.QuitarDomicilio(domicilio);;
        }
    }
    public void quitaAbonado(Abonado abonado) {
        listaEmpresa.remove(abonado);
    }
    private void AniadirContratacion(Contrataciones contrato) {
    	this.listaContrataciones.add(contrato);
    }
    private void AniadirFactura(Factura factura) {
    	this.listaFactura.add(factura);
    }
    private void BuscaFactura(Contrataciones contrato,Abonado abonado) {
    	Abonado aux;
    	int i=0;
    	while (this.listaFactura.get(i).getAbonado()!=abonado) {
    		i++;
    	}
    	this.listaFactura.get(i).aniadirContratacion(contrato);
    }
    
}
