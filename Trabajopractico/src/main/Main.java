package main;

import Domicilio.Comercio;
import Domicilio.Domicilio;
import Domicilio.Vivienda;
import abonado.Abonado;
import abonado.Fisica;
import empresa.Contrataciones;
import empresa.Empresa;
import empresa.Factura;
import metodosdepago.DecoratorPago;
import metodosdepago.FactoryPago;
import promo.Promo;
import promo.PromoDorada;
import promo.PromoPlatino;
import servicio.Servicio;
import servicio.ServicioBoton;
import servicio.ServicioCamara;

public class Main {

	public static void main(String[] args) {
		Promo p1=new PromoDorada();
		Promo p2=new PromoPlatino();
		FactoryPago factory=new FactoryPago();
		Servicio s1=new ServicioCamara();
		Servicio s2=new ServicioCamara();
		Servicio s3=new ServicioBoton();
		
		Abonado a1=new Fisica("bruno",123);
		
		Domicilio d1=new Comercio("dom1");
		Domicilio d2=new Vivienda("dom2");
		Contrataciones contrato=new Contrataciones(d1);
		Contrataciones contrato2=new Contrataciones(d2);
		
		contrato.agregarServicio(s1);
		contrato.agregarServicio(s2);
		contrato.agregarServicio(s3);
		contrato.setPromo(p1);
		
		contrato2.agregarServicio(s1);
		contrato2.setPromo(p2);
		
		a1.AniadirDomicilio(d1);
		a1.AniadirDomicilio(d2);
		
		
		DecoratorPago a1pag=factory.getMetodoDePago(a1, "Efectivo");
		Factura fac=new Factura(a1pag);
		Factura factclon=null;
		fac.aniadirContratacion(contrato);
		fac.aniadirContratacion(contrato2);
		
		System.out.println(fac.ImprimeFactura());
		
		try {
			factclon=(Factura)Empresa.getInstance().ClonarFactura(fac);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		
	}

}
