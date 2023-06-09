package main;


import abonado.Abonado;
import abonado.Fisica;
import abonado.Juridica;
import controlador.ControladorEmpresa;
import empresa.Empresa;
import empresa.MesaDeSolicitudDeTecnicos;
import excepciones.FactoryInvalidoException;
import vista.IVista;
import vista.VistaEmpresa;

public class MainConVista {

	public static void main(String[] args) throws FactoryInvalidoException {
		
		Empresa empresa = Empresa.getInstance();
		IVista vista = new VistaEmpresa();
		ControladorEmpresa controlador= new ControladorEmpresa(empresa, vista);
		MesaDeSolicitudDeTecnicos mesa = new MesaDeSolicitudDeTecnicos();
		Empresa.getInstance().setMesaDeSolicitudDeTecnicos(mesa);

	}

}
