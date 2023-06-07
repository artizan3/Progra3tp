package persistencia;

import empresa.Empresa;

public class UtilPersistencia {

	public static EmpresaDTO empresaDTOFromEmpresa (Empresa empresa) {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setListaAbonado(empresa.getListaAbonado());
		empresaDTO.setListaContrataciones(empresa.getListaContrataciones());
		empresaDTO.setListaFactura(empresa.getListaFactura());
		empresaDTO.setListaTecnico(empresa.getListaTecnico());
		
		return empresaDTO;
		
	}
		
	public static void empresaFromEmpresaDTO (EmpresaDTO empresaDTO) {

		Empresa.getInstance().setListaAbonado(empresaDTO.getListaAbonado());
		Empresa.getInstance().setListaContrataciones(empresaDTO.getListaContrataciones());
		Empresa.getInstance().setListaFactura(empresaDTO.getListaFactura());
		Empresa.getInstance().setListaTecnico(empresaDTO.getListaTecnico());
		
	}
	
	/*
	public static AbonadoDTO abonadoDTOfromAbonado (Abonado abonado) {
		AbonadoDTO abonadoDTO = new AbonadoDTO();		
		abonadoDTO.setDni(abonado.getDni());
		abonadoDTO.setNombre(abonado.getNombre());
		abonadoDTO.lista = new ArrayList<ContratacionDTO>();
		
		for (int i = 0 ; i < abonado.getLista().size(); i++) {
			abonadoDTO.getLista().add(UtilPersistencia.contratacionDTOFromContratacion(abonado.getLista().get(i)));
		}	
		return abonadoDTO;
	}

	public static ContratacionDTO contratacionDTOFromContratacion(Contratacion contratacion) {
		ContratacionDTO contratacionDTO = new ContratacionDTO();		
		contratacionDTO.setDomicilio(UtilPersistencia.domicilioDTOFromDomicilio(contratacion.getDomicilio()));
		contratacionDTO.setId(contratacion.getId());
		contratacionDTO.setPromo(UtilPersistencia.promoDTOFromPromo(contratacion.getPromo()));
		
		for (int i=0; i< contratacion.getListaServicio().size(); i++) {			
			contratacionDTO.addServicio(UtilPersistencia.servicioDTOFromServicio(contratacion.getListaServicio().get(i)));
		}		
		return contratacionDTO;
	}	
	
	public static DomicilioDTO domicilioDTOFromDomicilio(Domicilio domicilio) {
		DomicilioDTO domicilioDTO = new DomicilioDTO();
		
		domicilioDTO.setAgregado(domicilio.getAgregado());
		domicilioDTO.setNombre(domicilio.getNombre());
		
		return domicilioDTO;
				
	}
	
	public static ServicioDTO servicioDTOFromServicio(Servicio servicio) {
		ServicioDTO servicioDTO = new ServicioDTO();
		servicioDTO.setId(servicio.getId());
		servicioDTO.setValor(servicio.getValor());
		return servicioDTO;		
	}


	public static PromoDTO promoDTOFromPromo (Promo promo) {
		PromoDTO promoDTO = null;//new PromoDTO(); //como instancio ?
	
		return promoDTO;
	}
	
	*/
	
	
}