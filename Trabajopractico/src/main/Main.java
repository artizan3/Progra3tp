package main;

import Domicilio.Comercio;
import Domicilio.Domicilio;
import Domicilio.Vivienda;
import abonado.Abonado;
import abonado.Fisica;
import empresa.Contrataciones;
import empresa.Factura;
import servicio.Servicio;
import servicio.ServicioBoton;
import servicio.ServicioCamara;

public class Main {

	public static void main(String[] args) {
		Servicio s1=new ServicioCamara();
		Servicio s2=new ServicioCamara();
		Servicio s3=new ServicioBoton();
		
		Abonado a1=new Fisica("bruno",123);
		
		Domicilio d1=new Comercio("dom1");
		Domicilio d2=new Vivienda("dom2");
		d1.agregarServicio(s1);
		d1.agregarServicio(s2);
		d1.agregarServicio(s3);
		d2.agregarServicio(s1);
		
		a1.AniadirDomicilio(d1);
		a1.AniadirDomicilio(d2);
		
		Contrataciones contrato=new Contrataciones(d1);
		Contrataciones contrato2=new Contrataciones(d2);
		
		Factura fac=new Factura(a1);
		fac.aniadirContratacion(contrato);
		fac.aniadirContratacion(contrato2);
		
		fac.ImprimeFactura();
		
	}

}
