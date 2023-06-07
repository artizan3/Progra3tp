package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import Domicilio.Domicilio;
import empresa.Contratacion;

public class AbonadoDTO implements Serializable{
	protected String nombre;
	protected int dni;
	protected ArrayList<ContratacionDTO> lista = new ArrayList<ContratacionDTO>();
	protected ArrayList<DomicilioDTO> listaDeDomicilios = new ArrayList<DomicilioDTO>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public ArrayList<ContratacionDTO> getLista() {
		return lista;
	}
	public void setLista(ArrayList<ContratacionDTO> lista) {
		this.lista = lista;
	}
	public ArrayList<DomicilioDTO> getListaDeDomicilios() {
		return listaDeDomicilios;
	}
	public void setListaDeDomicilios(ArrayList<DomicilioDTO> listaDeDomicilios) {
		this.listaDeDomicilios = listaDeDomicilios;
	}

	
	
}
