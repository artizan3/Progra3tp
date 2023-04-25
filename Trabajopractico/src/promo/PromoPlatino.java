package promo;

public class PromoPlatino implements Promo,Cloneable {

	@Override
	public double comercio() {
		return 10000-10000*0.35;
	}

	@Override
	public double vivienda() {
		return 8500-8500*0.35;
	}
	public String toString() {
		return "Platino";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Promo clon=(Promo)super.clone();
		return clon;
	}
	
}
