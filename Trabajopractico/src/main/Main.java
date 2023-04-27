package main;

import Domicilio.Comercio;
import Domicilio.Domicilio;
import Domicilio.Vivienda;
import abonado.Abonado;
import abonado.Fisica;
import abonado.Juridica;
import empresa.Contrataciones;
import empresa.Empresa;
import empresa.Factura;
import excepciones.DomicilioVinculadoException;
import metodosdepago.DecoratorPago;
import metodosdepago.FactoryPago;
import metodosdepago.PagoCheque;
import metodosdepago.PagoCredito;
import metodosdepago.PagoEfectivo;
import promo.Promo;
import promo.PromoDorada;
import promo.PromoPlatino;
import servicio.Servicio;
import servicio.ServicioAcompaniamiento;
import servicio.ServicioBoton;
import servicio.ServicioCamara;

public class Main {

	public static void main(String[] args) throws DomicilioVinculadoException, CloneNotSupportedException {
		Domicilio d1=new Vivienda("dom1");
		Domicilio d2=new Comercio("dom2");
		Domicilio d3=new Vivienda("dom3");
		
		Servicio s1=new ServicioCamara();
		Servicio s2=new ServicioBoton();
		Servicio s3=new ServicioAcompaniamiento();
		
		Abonado a1=new Fisica("abonado1",123);
		Abonado a2=new Juridica("abonado2",456);
		
		Promo p1=new PromoDorada();
		Promo p2=new PromoPlatino();
		
		//a1.AniadirDomicilio(d1);
		//a1.AniadirDomicilio(d2);
		
		Contrataciones c1=new Contrataciones(d1);
		c1.agregarServicio(s1);
		c1.agregarServicio(s1);
		c1.agregarServicio(s2);
		c1.setPromo(p1);
		Contrataciones c2=new Contrataciones(d2);
		c2.agregarServicio(s1);
		c2.agregarServicio(s2);
		c2.agregarServicio(s3);
		c2.setPromo(p2);
		Contrataciones c3=new Contrataciones(d3);
		//c3.agregarServicio(s1);
		//c3.agregarServicio(s1);
		//c3.agregarServicio(s1);
		
		//a1.aniadirContratacion(c1);
		//a1.aniadirContratacion(c2);
		
		//DecoratorPago ap1=new PagoCredito(a1);
		
		//Factura f1=new Factura(ap1);
		//System.out.println(f1.ImprimeFactura());
		
		//Factura f1clon=(Factura)f1.clone();
		
		a2.AniadirDomicilio(d1);
		a2.AniadirDomicilio(d2);
		a2.AniadirDomicilio(d3);
		
		a2.aniadirContratacion(c1);
		a2.aniadirContratacion(c2);
		a2.aniadirContratacion(c3);
		
		DecoratorPago ap2=new PagoEfectivo(a2);
		Factura f2=new Factura(ap2);
		System.out.println(f2.ImprimeFactura());
		
		
	}

}
