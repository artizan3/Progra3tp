package empresa;

import java.util.Observable;
import java.util.Observer;

public class OjoTecnico implements Observer{

	private Observable observable;
	@Override
	
	
	public void update(Observable o, Object arg) {

		System.out.println((Tecnico) o +" "+ arg); //?
		
	}
	
	
	public void setObservable(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	
	
}
