package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCrearAbonado extends JDialog {
	private ActionListener actionListener;
	private JTextField textField_nombre;
	private JTextField textField_DNI;
	private JLabel lbl_Nombre;
	private JLabel lbl_DNI;
	private JLabel lbl_metododepago;
	private JComboBox comboBox;
	private JButton btn_aceptar;
	
	public VentanaCrearAbonado(ActionListener actionListener) {
		this.actionListener=actionListener;
		
		setSize(425, 305);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setBounds(10, 11, 46, 14);
		getContentPane().add(lbl_Nombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(10, 36, 359, 20);
		getContentPane().add(textField_nombre);
		textField_nombre.setColumns(10);
		
		lbl_DNI = new JLabel("DNI");
		lbl_DNI.setBounds(10, 67, 46, 14);
		getContentPane().add(lbl_DNI);
		
		textField_DNI = new JTextField();
		textField_DNI.setBounds(10, 92, 359, 20);
		getContentPane().add(textField_DNI);
		textField_DNI.setColumns(10);
		
		lbl_metododepago = new JLabel("Metodo de pago:");
		lbl_metododepago.setBounds(10, 124, 349, 14);
		getContentPane().add(lbl_metododepago);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta de credito", "Cheque"}));
		comboBox.setBounds(10, 149, 140, 22);
		getContentPane().add(comboBox);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setActionCommand("Agregar abonado");
		btn_aceptar.setBounds(280, 211, 89, 23);
		btn_aceptar.addActionListener(actionListener);
		getContentPane().add(btn_aceptar);
	}

	public void setActionListener(ActionListener actionListener) {
		this.actionListener=actionListener;
		btn_aceptar.addActionListener(actionListener);
		
	}
	
	public String getNombreAbonado() {
		return this.textField_nombre.getText();
	}
	
	public String getDNI() {
		return this.textField_DNI.getText();
	}
	
}
