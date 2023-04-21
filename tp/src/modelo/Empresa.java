package modelo;

import java.util.ArrayList;

public class Empresa { //SINGLETON

	private static Empresa empresa = null; //declaro para singleton
	private String nombre;
	private ArrayList<Abonado> Abonados = new ArrayList <Abonado>();
	


	private Empresa () {
		
		nombre = "El rey de las alarmas";

	}
	
	public static Empresa getInstancia() {
		
		if (empresa == null)
			empresa = new Empresa();
		
		return empresa;
		
	}
	
	public void agregarAbonado(Abonado abonado) {
		
		this.Abonados.add(abonado);
	}
	
	public void eliminarAbonado (Abonado abonado) {
		
		this.Abonados.remove(abonado);
	}
	
}