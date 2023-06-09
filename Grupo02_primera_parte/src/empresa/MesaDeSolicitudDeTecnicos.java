package empresa;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

import abonado.Abonado;
import excepciones.ReparacionYaSolicitadaException;

public class MesaDeSolicitudDeTecnicos extends Observable implements Serializable{

	private Queue<Abonado> listaDeAbonados = new LinkedList<Abonado>();
	private String mensaje;
	private int cantidadDeTecnicosDisponibles=0;
	
	
	public void solicitarReparacion (Abonado abonado) throws ReparacionYaSolicitadaException{
		
		if (this.listaDeAbonados.contains(abonado))
			throw new ReparacionYaSolicitadaException("El abonado ya se encuentra esperando una reparación", abonado);
		else {
			this.listaDeAbonados.add(abonado);
			notify();
			if (this.cantidadDeTecnicosDisponibles==0)
				notifyObservers("El abonado " + abonado.getNombre() +" ha solicitado reparación, pero no hay tecnicos disponibles, se agrega a listaDeContratos de espera");
			else {
				notifyObservers("El abonado " + abonado.getNombre() +" ha solicitado reparación, intentando asignar un tecnico...");
			}
		}
	}


	public Abonado getAbonado (Tecnico tecnico) {
		
		this.cantidadDeTecnicosDisponibles++;
		
		while(this.listaDeAbonados.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notifyObservers("El tecnico " +tecnico.getNombre()+ " está esperando para reparar");
		}
		Abonado respuesta = this.listaDeAbonados.poll();
		notifyObservers("El tecnico " + tecnico.getNombre() +" ha comenzado a trabajar en la reparación solicitada por " + respuesta.getNombre());
		this.cantidadDeTecnicosDisponibles--;
		
		return respuesta;
	}

	public void informarFinDeTrabajo (Tecnico tecnico) {
		
		notifyObservers("El tecnico " + tecnico.getNombre() +" ha terminado a trabajar en la reparación solicitada por " + tecnico.getAbonado().getNombre());
		
	}

	
	/*Para el informe:
	
	
	La mesa de reparaciones es un recurso compartido por los tecnicos (que son los que utilizan concurrencia) en la cual entran a ver en la listaDeContratos de abonados
	a ver si hay alguien esperando reparación. En caso que no haya nadie, el tecnico queda en espera hasta que algun abonado solicite reparacion.
	
	Cuando un abonado pide reparacion, llama al metodo solicitarReparacion, que se agrega a si mismo a la cola de espera, y notifica a los tecnicos.
	Utiliza notify() porque no es necesario informar a todos los tecnicos, ya que cualquiera puede empezar la reparación.
	
	La mesa utiliza el patrón observer-observable para poder notificar a la vista cuando un abonado solicita reparación, o cuando un tecnico empieza o termina una.
	
	Cuando un tecnico empieza una reparacion, se pone en modo dormido para simular cierto tiempo de trabajo. Luego de ese tiempo, vuelve a informar a la mesa
	que el trabajo esta realizado, de esa manera la mesa puede informar a su observer que el tenico termino de trabajar.
	
	
	*/
}
