package servicio;

import java.util.ArrayList;

public class Empresa {
	private static Empresa instancia=null;
	ArrayList<abonados> listaAbonados= new ArrayList<abonados>();
	public static Empresa getInstancia() {
		if(instancia==null)
			instancia=new Empresa();
		return instancia;
	}
	
}
