package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abonado.Abonado;
import abonado.Fisica;
import empresa.Empresa;
import excepciones.AbonadoInexistenteException;
import excepciones.FactoryInvalidoException;
import vista.IVista;
import vista.VentanaCrearAbonado;

public class ControladorEmpresa implements ActionListener {

    private Empresa empresa;
    private IVista vista;
    private VentanaCrearAbonado ventanaCrearAbonado;

    public ControladorEmpresa(Empresa empresa, IVista vista) {
        this.empresa = empresa;
        this.vista = vista;
        this.vista.setActionListener(this);
        

        // Actualizar la vista con la lista inicial de abonados
        vista.actualizarLista(empresa.getListaAbonado());
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
			Abonado abonado = new Fisica(this.ventanaCrearAbonado.getName(), Integer.parseInt(this.ventanaCrearAbonado.getDNI()));
			try {
				Empresa.getInstance().agregaAbonado(abonado, "Efectivo");
			} catch (FactoryInvalidoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
