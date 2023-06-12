package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import empresa.Factura;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class VentanaPagarFactura extends JDialog {
	private ActionListener actionListener;
	private JLabel lbl_Monto_texto;
	private JLabel lbl_metododepago;
	private JComboBox comboBox_tipo_de_pago;
	private JButton btn_aceptar;
	private ArrayList<Factura> factura;
	private JLabel lbl_monto_valor_final;
	private JLabel lbl_Monto_texto_2;
	private JLabel lbl_monto_valor;
	
	
	public VentanaPagarFactura(ActionListener actionListener, ArrayList<Factura> facturas) {
		this.actionListener=actionListener;
		this.factura=facturas;
		
		setSize(341, 294);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lbl_Monto_texto = new JLabel("Monto:");
		lbl_Monto_texto.setBounds(90, 40, 46, 14);
		getContentPane().add(lbl_Monto_texto);
		
		lbl_metododepago = new JLabel("Metodo de pago:");
		lbl_metododepago.setBounds(23, 119, 125, 14);
		getContentPane().add(lbl_metododepago);
		
		comboBox_tipo_de_pago = new JComboBox();
		comboBox_tipo_de_pago.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ActionEvent actionEvent = new ActionEvent(this,ActionEvent.ACTION_PERFORMED,"Cambio metodo de pago");
				actionListener.actionPerformed(actionEvent);
				double monto_final=0; 
				for (Factura facturaAux : facturas) {
					monto_final+=facturaAux.getAbonado().valorDeTipoPago();
				}
				
				lbl_monto_valor_final.setText(Double.toString(monto_final));	
				}
		});
		comboBox_tipo_de_pago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta", "Cheque"}));
		comboBox_tipo_de_pago.setBounds(126, 115, 125, 22);
		getContentPane().add(comboBox_tipo_de_pago);
		
		btn_aceptar = new JButton("Pagar");
		btn_aceptar.setActionCommand("Pagar factura");
		btn_aceptar.setBounds(106, 221, 89, 23);
		btn_aceptar.addActionListener(actionListener);
		getContentPane().add(btn_aceptar);
		
		double monto_final=0; 
		for (Factura facturaAux : facturas) {
			monto_final+=facturaAux.getMonto();
		}
			
		lbl_monto_valor = new JLabel(Double.toString(monto_final));
		lbl_monto_valor.setBounds(149, 40, 46, 14);
		getContentPane().add(lbl_monto_valor);
		
		lbl_Monto_texto_2 = new JLabel("Monto final:");
		lbl_Monto_texto_2.setBounds(78, 171, 69, 14);
		getContentPane().add(lbl_Monto_texto_2);
		
		lbl_monto_valor_final = new JLabel("");
		lbl_monto_valor_final.setBounds(149, 171, 46, 14);
		getContentPane().add(lbl_monto_valor_final);
	}

	public void setActionListener(ActionListener actionListener) {
		this.actionListener=actionListener;
		btn_aceptar.addActionListener(actionListener);
		
	}
	
	public ActionListener getActionListener() {
		return actionListener;
	}

	public JComboBox getComboBox_tipo_de_pago() {
		return comboBox_tipo_de_pago;
	}

	public JButton getBtn_aceptar() {
		return btn_aceptar;
	}


}
