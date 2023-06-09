package empresa;

import java.io.Serializable;

import abonado.Abonado;

public class Tecnico extends Thread implements Serializable {

	private String nombre;
	private int dni;
	private Abonado abonado;
	public Abonado getAbonado() {
		return abonado;
	}
	
	public Tecnico(String nombre, int dni, MesaDeSolicitudDeTecnicos mesa ) {
		super();
		this.mesa = mesa;
		this.dni= dni;
		this.nombre = nombre;
	}

	public void setAbonado(Abonado abonado) {
		this.abonado = abonado;
	}

	public MesaDeSolicitudDeTecnicos getMesa() {
		return mesa;
	}

	public void setMesa(MesaDeSolicitudDeTecnicos mesa) {
		this.mesa = mesa;
	}

	private MesaDeSolicitudDeTecnicos mesa;



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void run() {	
		
		while (true) {
			
			abonado=this.mesa.getAbonado(this);
			try {
				sleep(20000); //tiempo simulado que tarda en reparar
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mesa.informarFinDeTrabajo(this);
			this.abonado=null;
		}
		
	}

	public int getDni() {
		return dni;
	}

}
