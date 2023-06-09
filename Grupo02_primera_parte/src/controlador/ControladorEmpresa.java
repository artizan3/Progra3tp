package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import Domicilio.Comercio;
import Domicilio.Domicilio;
import Domicilio.Vivienda;
import abonado.Abonado;
import abonado.Fisica;
import abonado.Juridica;
import empresa.Empresa;
import empresa.MesaDeSolicitudDeTecnicos;
import empresa.Tecnico;
import excepciones.AbonadoInexistenteException;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioExistenteException;
import excepciones.FactoryInvalidoException;
import excepciones.ReparacionYaSolicitadaException;
import persistencia.EmpresaDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.UtilPersistencia;
import vista.IVista;
import vista.VentanaCrearAbonado;
import vista.VentanaCrearContratacion;
import vista.VentanaCrearTecnico;

public class ControladorEmpresa implements ActionListener, Observer {

    private Empresa empresa;
    private IVista vista;
    private VentanaCrearAbonado ventanaCrearAbonado;
    private VentanaCrearTecnico ventanaCrearTecnico;
    private MesaDeSolicitudDeTecnicos mesa;
	private VentanaCrearContratacion ventanaCrearContratacion;

    public ControladorEmpresa(Empresa empresa, IVista vista,MesaDeSolicitudDeTecnicos mesa) {
        this.empresa = empresa;
        this.vista = vista;
        this.vista.setActionListener(this);
    	this.mesa = mesa;
    	mesa.addObserver(this);
        

        // Actualizar la vista con la lista inicial de abonados
        vista.actualizarListaAbonados(empresa.getListaAbonado());
    }
    
    public void addObservable (MesaDeSolicitudDeTecnicos mesa) {
    	this.mesa = mesa;
    	mesa.addObserver(this);
    }
	@Override
	public void update(Observable o, Object arg) throws IllegalArgumentException {

			if(o != mesa) {
				throw new IllegalArgumentException("El objeto no esta siendo observado por"+this);
			}
			else
			{
				String mensaje = (String) arg;
				this.vista.getTextArea_consola().append(mensaje+"\n");
			}
	}

    public void agregarAbonado(Abonado abonado) throws FactoryInvalidoException {
        empresa.agregaAbonado(abonado, "Efectivo");
        vista.actualizarListaAbonados(empresa.getListaAbonado());
    }

    public void eliminarAbonado(Abonado abonado) throws AbonadoInexistenteException {
        empresa.quitaAbonado(abonado);
        vista.actualizarListaAbonados(empresa.getListaAbonado());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Abrir ventana crear abonado")) {
			
			ventanaCrearAbonado = new VentanaCrearAbonado(this);
			ventanaCrearAbonado.setModal(true);
			ventanaCrearAbonado.setVisible(true);
			
		}
		else if (e.getActionCommand().equals("Agregar abonado")) {
			
			if((String)this.ventanaCrearAbonado.getComboBox_tipo_de_abonado().getSelectedItem() == "Físico") {
			Abonado abonado = new Fisica(this.ventanaCrearAbonado.getNombreAbonado(), Integer.parseInt(this.ventanaCrearAbonado.getDNI()),empresa.getMesaDeSolicitudDeTecnicos());
			try {
				Empresa.getInstance().agregaAbonado(abonado, (String)this.ventanaCrearAbonado.getComboBox_tipo_de_pago().getSelectedItem());
			} catch (FactoryInvalidoException e1) {
				e1.printStackTrace();
				}
			}
			else {
				Abonado abonado = new Juridica(this.ventanaCrearAbonado.getNombreAbonado(), Integer.parseInt(this.ventanaCrearAbonado.getDNI()),empresa.getMesaDeSolicitudDeTecnicos());
				try {
					Empresa.getInstance().agregaAbonado(abonado, (String)this.ventanaCrearAbonado.getComboBox_tipo_de_pago().getSelectedItem());
				} catch (FactoryInvalidoException e1) {
					e1.printStackTrace();
				}
				
			}
			this.vista.actualizarListaAbonados(empresa.getListaAbonado());	
		}
		
		else if(e.getActionCommand().equals("Eliminar abonado")) {
			
			if (vista.getTable_abonado().getSelectedRow()!= -1 && vista.getTable_abonado().getSelectedRow() < vista.getListaAbonados().size() ){
				Abonado abonado = (vista.getListaAbonados().get(vista.getTable_abonado().getSelectedRow()));
				try {
					empresa.quitaAbonado(abonado);
				} catch (AbonadoInexistenteException e1) {
					e1.printStackTrace();
				}
				vista.actualizarListaAbonados(empresa.getListaAbonado());
			}
			
			
		}		
		else if(e.getActionCommand().equals("Abrir ventana para crear tecnicos")) {
			this.ventanaCrearTecnico = new VentanaCrearTecnico(this);
			ventanaCrearTecnico.setModal(true);
			ventanaCrearTecnico.setVisible(true);
		}
		else if(e.getActionCommand().equals("Agregar tecnico")) {
			Tecnico tecnico = new Tecnico(this.ventanaCrearTecnico.getNombreTecnico(), Integer.parseInt(this.ventanaCrearTecnico.getDNI()), empresa.getMesaDeSolicitudDeTecnicos());
			empresa.addTecnico(tecnico);
			vista.actualizarListaTecnicos(empresa.getListaTecnico());
			this.ventanaCrearTecnico.dispose();
		}
		else if(e.getActionCommand().equals("Eliminar tecnico")) {
			
			if (vista.getTable_tecnico().getSelectedRow()!= -1 && vista.getTable_tecnico().getSelectedRow() < vista.getListaTecnicos().size() ){
				Tecnico tecnico = (vista.getListaTecnicos().get(vista.getTable_tecnico().getSelectedRow()));
				empresa.removeTecnico(tecnico);
				vista.actualizarListaTecnicos(empresa.getListaTecnico());
			}
		}
		else if(e.getActionCommand().equals("Persistir")) {
			IPersistencia persistencia = new PersistenciaBIN();
			try
	        {
	        
	        	persistencia.abrirOutput("Empresa.bin");
	            System.out.println("Crea archivo escritura");
	            persistencia.escribir(UtilPersistencia.empresaDTOFromEmpresa(empresa));
	            System.out.println("Empresa grabada exitosamente");
	            persistencia.cerrarOutput();
	            System.out.println("Archivo cerrado");
	        
	        } catch (IOException e2)
	        {
	            // TODO Auto-generated catch block
	            System.out.println(e2.getLocalizedMessage());
	        }	
		}
		else if (e.getActionCommand().equals("Despersistir")){
			IPersistencia persistencia = new PersistenciaBIN();
	        try
	        {
	            persistencia.abrirInput("Empresa.bin");
	            System.out.println("Archivo abierto");
	            EmpresaDTO empresaDTO = (EmpresaDTO) persistencia.leer();
	            UtilPersistencia.empresaFromEmpresaDTO(empresaDTO);
	            System.out.println("Empresa recuperada");
	            persistencia.cerrarInput();
	            System.out.println("Archivo cerrado");
	            
	            refrescarVista();
	        } catch (IOException e3)
	        {
	            // TODO Auto-generated catch block
	            System.out.println(e3.getMessage());
	        } catch (ClassNotFoundException e4)
	        {
	            // TODO Auto-generated catch block
	            System.out.println(e4.getMessage());
	        }
		}
		else if (e.getActionCommand().equals("Clic en tabla de abonados")) {
			if(vista.getTable_abonado().getSelectedRow() < vista.getListaAbonados().size() ) {
				vista.actualizaListaContrataciones(vista.getListaAbonados().get(vista.getTable_abonado().getSelectedRow()).getListaDeContrataciones());
			}
		}
		else if(e.getActionCommand().equals("Abrir ventana crear contratacion")){
			ventanaCrearContratacion = new VentanaCrearContratacion(this);
			this.ventanaCrearContratacion.setVisible(true);
			this.ventanaCrearContratacion.setModal(true);
		}
		else if (e.getActionCommand().equals("Agregar contratacion")) {
			Domicilio domicilio = null;
			if (this.ventanaCrearContratacion.getComboBox_domicilio_tipo().getSelectedItem() == "Vivienda") {
				 domicilio = new Vivienda(this.ventanaCrearContratacion.getNombreDomicilio());
			}
			else {
				 domicilio = new Comercio(this.ventanaCrearContratacion.getNombreDomicilio());
			}
			try {
				Abonado abonadoSeleccionado = empresa.getListaAbonado().get((this.vista.getTable_abonado().getSelectedRow()));
				try {
					abonadoSeleccionado.aniadirDomicilio(domicilio);
				} catch (DomicilioExistenteException e1) {
					e1.printStackTrace();
				}
				this.empresa.CrearContratacion(domicilio, abonadoSeleccionado);
			} catch (ContratacionInvalidaException e1) {
				e1.printStackTrace();
			}
		
			this.ventanaCrearContratacion.dispose();
			this.vista.actualizaListaContrataciones(empresa.getListaAbonado().get((this.vista.getTable_abonado().getSelectedRow())).getListaDeContrataciones());
		}
		else if (e.getActionCommand().equals("Solicitar Reparación")) {
			Abonado abonadoSeleccionado = empresa.getListaAbonado().get((this.vista.getTable_abonado().getSelectedRow()));
			abonadoSeleccionado.start();
		}

	}
	private void refrescarVista() {
		vista.actualizarListaTecnicos(empresa.getListaTecnico());
		vista.actualizarListaAbonados(empresa.getListaAbonado());
	}

}
