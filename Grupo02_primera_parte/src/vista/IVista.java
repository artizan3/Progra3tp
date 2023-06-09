package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;

import abonado.Abonado;
import empresa.Tecnico;

public interface IVista {

	void setActionListener(ActionListener ActionListener);

	void actualizarListaAbonados(ArrayList<Abonado> listaAbonado);
	
	void actualizarListaTecnicos(ArrayList<Tecnico> listaTecnico);

	JTextArea getTextArea_consola();

	void refrescarGUI();

}
