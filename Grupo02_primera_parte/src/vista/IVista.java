package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;

import abonado.Abonado;

public interface IVista {

	void setActionListener(ActionListener ActionListener);

	void actualizarLista(ArrayList<Abonado> listaAbonado);

	JTextArea getTextArea_consola();

}
