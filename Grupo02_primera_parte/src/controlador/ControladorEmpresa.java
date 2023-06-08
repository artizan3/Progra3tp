package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abonado.Abonado;
import empresa.Empresa;
import excepciones.AbonadoInexistenteException;
import excepciones.FactoryInvalidoException;
import vista.IVista;

public class ControladorEmpresa implements ActionListener {

    private Empresa empresa;
    private IVista vista;

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
		System.out.println("se agrega un abonado");
		if (e.getActionCommand().equals("1")) {
			System.out.println("se agrega un abonado");
		}
		
	}
}
