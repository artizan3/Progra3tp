package persistencia;

import java.io.Serializable;

public class DomicilioDTO implements Serializable{
	private String nombre;
	private boolean agregado;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isAgregado() {
		return agregado;
	}
	public void setAgregado(boolean agregado) {
		this.agregado = agregado;
	}
	
	
}
