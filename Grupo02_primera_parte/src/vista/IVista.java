package vista;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;

import abonado.Abonado;
import empresa.Contratacion;
import empresa.Factura;
import empresa.Tecnico;

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

	public ArrayList<Contratacion> getListaContrataciones();

	public ArrayList<Factura> getListaFacturas();

}
