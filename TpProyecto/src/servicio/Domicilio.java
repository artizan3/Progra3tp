package servicio;

import java.util.ArrayList;

public class Domicilio {
	ArrayList <Servicio> listaServicio=new ArrayList<Servicio>();
	
	public void agregaServicio(Servicio servicio) {
		listaServicio.add(servicio);
	}
	public double CalcularPrecioVivienda() {
		double calculo;
		calculo=8500+Calcular();
		return calculo;
	}
	public double CalcularPrecioComercio() {
		double calculo;
		calculo=10000+Calcular();
		return calculo;
	}
	public double Calcular() {
		int i;
		int suma=0;
		for(i=1;i<listaServicio.size();i++) {
			suma+=this.listaServicio.get(i).costo();
		}
		return suma;
	}
	
}
