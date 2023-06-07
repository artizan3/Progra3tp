package empresa;

import java.io.Serializable;
import java.util.Observable;

public class Tecnico extends Observable implements Runnable, Serializable {

	private String nombre;

	public Tecnico(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void run() {	
		
		this.notifyObservers("revisando un domicilio");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.notifyObservers("terminó de revisar un domicilio");
		
	}

}
