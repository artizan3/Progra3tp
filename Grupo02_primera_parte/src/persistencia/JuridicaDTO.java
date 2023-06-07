package persistencia;

import java.util.ArrayList;

import Domicilio.Domicilio;
import empresa.Contratacion;

public class JuridicaDTO extends AbonadoDTO {

		@Override
		public String getNombre() {
			// TODO Auto-generated method stub
			return super.getNombre();
		}

		@Override
		public void setNombre(String nombre) {
			// TODO Auto-generated method stub
			super.setNombre(nombre);
		}

		@Override
		public int getDni() {
			// TODO Auto-generated method stub
			return super.getDni();
		}

		@Override
		public void setDni(int dni) {
			// TODO Auto-generated method stub
			super.setDni(dni);
		}

		@Override
		public ArrayList<ContratacionDTO> getLista() {
			// TODO Auto-generated method stub
			return super.getLista();
		}

		@Override
		public void setLista(ArrayList<ContratacionDTO> lista) {
			// TODO Auto-generated method stub
			super.setLista(lista);
		}

		@Override
		public ArrayList<DomicilioDTO> getListaDeDomicilios() {
			// TODO Auto-generated method stub
			return super.getListaDeDomicilios();
		}

		@Override
		public void setListaDeDomicilios(ArrayList<DomicilioDTO> listaDeDomicilios) {
			// TODO Auto-generated method stub
			super.setListaDeDomicilios(listaDeDomicilios);
		}

	}
