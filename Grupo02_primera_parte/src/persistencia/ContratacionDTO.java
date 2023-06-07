package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import servicio.Servicio;

public class ContratacionDTO implements Serializable {
	protected PromoDTO promo;
	private ArrayList<ServicioDTO> listaServicio = new ArrayList<ServicioDTO>();
	private DomicilioDTO domicilio;
	private int id;
	public PromoDTO getPromo() {
		return promo;
	}
	public void setPromo(PromoDTO promo) {
		this.promo = promo;
	}
	public ArrayList<ServicioDTO> getListaServicio() {
		return listaServicio;
	}
	public void setListaServicio(ArrayList<ServicioDTO> listaServicio) {
		this.listaServicio = listaServicio;
	}
	public DomicilioDTO getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void addServicio(ServicioDTO servicioDTO) {
		this.listaServicio.add(servicioDTO);
	}
	
	
}
