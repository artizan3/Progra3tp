package empresa;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

import abonado.Abonado;
import excepciones.ReparacionYaSolicitadaException;

public class MesaDeSolicitudDeTecnicos extends Observable implements Serializable{

	private Abonado abonadoEsperando = null;
	
	
	public synchronized void  solicitarReparacion (Abonado abonado){
		
	
		this.setChanged();
		notifyObservers("El abonado " + abonado.getNombre() +" ha solicitado reparación, se agrega a lista de espera");
		
		while (abonadoEsperando!=null)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		this.abonadoEsperando = abonado;	
		notifyAll();
	}

	public synchronized Abonado getAbonado (Tecnico tecnico) {
		
		this.setChanged();
		notifyObservers("El tecnico " +tecnico.getNombre()+ " está esperando para reparar");
		
		while(this.abonadoEsperando==null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		Abonado respuesta = this.abonadoEsperando;
		this.abonadoEsperando=null;
		notifyAll();
		this.setChanged();
		notifyObservers("El tecnico " + tecnico.getNombre() +" ha comenzado a trabajar en la reparación solicitada por " + respuesta.getNombre());		
		return respuesta;
	}

	public void informarFinDeTrabajo (Tecnico tecnico) {
		tecnico.getAbonado().setNecesitaReparacion(false);
		this.setChanged();
		notifyObservers("El tecnico " + tecnico.getNombre() +" ha terminado a trabajar en la reparación solicitada por " + tecnico.getAbonado().getNombre());
		
	}
}
