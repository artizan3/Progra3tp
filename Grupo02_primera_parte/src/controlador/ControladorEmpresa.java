package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abonado.Abonado;
import empresa.Empresa;
import excepciones.AbonadoInexistenteException;
import excepciones.FactoryInvalidoException;
import vista.IVista;
import vista.VistaEmpresa;

public class ControladorEmpresa implements ActionListener {

    private Empresa empresa;
    private IVista vista;

    public ControladorEmpresa(Empresa empresa, IVista vista2) {
        this.empresa = empresa;
        this.vista = vista2;

        // Actualizar la vista con la lista inicial de abonados
        vista2.actualizarLista(empresa.getListaAbonado());
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
		// TODO Auto-generated method stub
		
	}
}
