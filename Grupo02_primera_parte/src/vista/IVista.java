package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

import abonado.Abonado;
import empresa.Contratacion;
import empresa.Factura;
import empresa.Tecnico;
import servicio.Servicio;

public interface IVista {

	void setActionListener(ActionListener ActionListener);

	void actualizarListaAbonados(ArrayList<Abonado> listaAbonado);
	
	void actualizarListaTecnicos(ArrayList<Tecnico> listaTecnico);
	
	 JTable getTable_tecnico();

	 JTable getTable_factura();
	
	 JTable getTable_servicio();
	
	JTable getTable_abonado();

	JTextArea getTextArea_consola();

     ArrayList<Abonado> getListaAbonados();

	 ArrayList<Tecnico> getListaTecnicos();

	void actualizaListaContrataciones(ArrayList<Contratacion> listaDeContrataciones);

	JTable getTable_contratacion();

	ArrayList<Contratacion> getListaContrataciones();

	ArrayList<Factura> getListaFacturas();

	JButton getBtn_contratacion_nuevo();
	
	JButton getBtn_abonado_eliminar();

	JButton getBtn_abonado_solicitarReparacion();
	JButton getBtn_servicio_nuevo();

	JButton getBtn_servicio_eliminar();
	 
	JButton getBtn_contratacion_eliminar();

	void actualizaListaServicios(ArrayList<Servicio> listaDeServicios);

}
