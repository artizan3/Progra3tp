package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import abonado.Abonado;
import abonado.Fisica;
import empresa.Empresa;
import empresa.MesaDeSolicitudDeTecnicos;
import excepciones.AbonadoInexistenteException;
import excepciones.FactoryInvalidoException;
import vista.IVista;
import vista.VentanaCrearAbonado;

public class ControladorEmpresa implements ActionListener, Observer {

    private Empresa empresa;
    private IVista vista;
    private VentanaCrearAbonado ventanaCrearAbonado;
    private MesaDeSolicitudDeTecnicos mesa;

    public ControladorEmpresa(Empresa empresa, IVista vista) {
        this.empresa = empresa;
        this.vista = vista;
        this.vista.setActionListener(this);
        

        // Actualizar la vista con la lista inicial de abonados
        vista.actualizarLista(empresa.getListaAbonado());
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
        vista.actualizarLista(empresa.getListaAbonado());
    }

    public void eliminarAbonado(Abonado abonado) throws AbonadoInexistenteException {
        empresa.quitaAbonado(abonado);
        vista.actualizarLista(empresa.getListaAbonado());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Abrir ventana crear abonado")) {
			ventanaCrearAbonado = new VentanaCrearAbonado(this);
			ventanaCrearAbonado.setModal(true);
			ventanaCrearAbonado.setVisible(true);
			ventanaCrearAbonado.setActionListener(this);
		}
		else if (e.getActionCommand().equals("Agregar abonado")) {
			Abonado abonado = new Fisica(this.ventanaCrearAbonado.getNombreAbonado(), Integer.parseInt(this.ventanaCrearAbonado.getDNI()));
			try {
				Empresa.getInstance().agregaAbonado(abonado, "Efectivo");
			} catch (FactoryInvalidoException e1) {
				e1.printStackTrace();
			}
			System.out.println(abonado);
		}
	}


}
