package promo;

public class PromoDorada implements Promo,Cloneable {

	@Override
	public double comercio() {
		return 10000-2500;
	}

	@Override
	public double vivienda() {
		return 8500-1500;
	}
	public String toString() {
		return "Dorada";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Promo clon=(Promo)super.clone();
		return clon;
	}

}
