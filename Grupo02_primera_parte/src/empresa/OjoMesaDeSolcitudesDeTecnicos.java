package empresa;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class OjoMesaDeSolcitudesDeTecnicos implements Observer, Serializable{

	private Observable observable;
	
	
	public OjoMesaDeSolcitudesDeTecnicos (Observable o) {
		
		this.observable=o;
		o.addObserver(this);
	}
	
	public void update(Observable o, Object arg) {

		System.out.println((String) arg);
		
	}
	
		public void setObservable(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	
	
}
