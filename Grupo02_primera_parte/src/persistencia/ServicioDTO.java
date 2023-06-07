package persistencia;

import java.io.Serializable;

public class ServicioDTO implements Serializable {
	public String id;
	protected double valor;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
