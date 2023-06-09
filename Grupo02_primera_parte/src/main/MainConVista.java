package main;


import abonado.Abonado;
import abonado.Fisica;
import abonado.Juridica;
import controlador.ControladorEmpresa;
import empresa.Empresa;
import excepciones.FactoryInvalidoException;
import vista.IVista;
import vista.VistaEmpresa;

public class MainConVista {

	public static void main(String[] args) throws FactoryInvalidoException {
		
		Empresa empresa = new Empresa();
		IVista vista = new VistaEmpresa();
		ControladorEmpresa controlador= new ControladorEmpresa(empresa, vista);

        Abonado abonado1 = new Fisica("Juan", 37550930);
        Abonado abonado2 = new Juridica("Alan", 456);
        controlador.agregarAbonado(abonado2);
        controlador.agregarAbonado(abonado1);
	}

}
