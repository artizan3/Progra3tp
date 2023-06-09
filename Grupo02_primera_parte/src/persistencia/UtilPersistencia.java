package persistencia;

import java.time.LocalDate;

import empresa.Empresa;
import metodosdepago.FactoryPago;

public class UtilPersistencia {

	public static EmpresaDTO empresaDTOFromEmpresa (Empresa empresa) {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setListaAbonado(empresa.getListaAbonado());
		empresaDTO.setListaContrataciones(empresa.getListaContrataciones());
		empresaDTO.setListaFactura(empresa.getListaFactura());
		empresaDTO.setListaTecnico(empresa.getListaTecnico());
		empresaDTO.setFechaAnio(empresa.getFecha().getYear());
		empresaDTO.setFechaMes(empresa.getFecha().getMonthValue());
		empresaDTO.setFechaDia(empresa.getFecha().getDayOfMonth());
		
		return empresaDTO;
		
	}
		
	public static void empresaFromEmpresaDTO (EmpresaDTO empresaDTO) {

		Empresa.getInstance().setListaAbonado(empresaDTO.getListaAbonado());
		Empresa.getInstance().setListaContrataciones(empresaDTO.getListaContrataciones());
		Empresa.getInstance().setListaFactura(empresaDTO.getListaFactura());
		Empresa.getInstance().setListaTecnico(empresaDTO.getListaTecnico());
		Empresa.getInstance().setCreacion(new FactoryPago());
		LocalDate fecha = LocalDate.of(empresaDTO.getFechaAnio(),empresaDTO.getFechaMes(),empresaDTO.getFechaDia());
		
		Empresa.getInstance().setFecha(fecha);
		
	}

	
	
}