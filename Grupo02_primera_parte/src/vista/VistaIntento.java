package vista;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import abonado.Abonado;
import javax.swing.JTree;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

public class VistaIntento extends JFrame implements KeyListener, IVista, MouseListener {

	private ActionListener actionListener;
    private DefaultListModel<Abonado> listModel;
    private JTable table_abonado;
	private JButton btn_abonado_nuevo;
	private JButton btn_abonado_eliminar;
	private JScrollPane scrollPane_abonado;
	private JButton btn_domicilio_nuevo;
	private JButton btn_servicio_nuevo;
	private JButton btn_servicio_eliminar;
	private JButton btn_domicilio_eliminar;
	private JPanel panel_consola;
	private JTextPane txtpn_consola;
	private JLabel lbl_abonado;
	private JLabel lbl_domicilio;
	private JLabel lbl_servicio;
	private JLabel lbl_factura;
	private JLabel lbl_tecnicos;
	private JScrollPane scrollPane_domicilio;
	private JScrollPane scrollPane_servicio;
	private JScrollPane scrollPane_factura;
	private JScrollPane scrollPane_Tecnico;
	private JButton btn_tecnico_nuevo;
	private JButton btn_tecnico_eliminar;
	private JPanel panel_calendario;
	private JLabel lbl_calendario;
	private JButton btn_calendario_retroceder;
	private JTable table_tecnico;
	private JTable table_factura;
	private JTable table_servicio;
	private JButton btn_calendario_retroceder_1;
	private JButton btn_guardar;
	private JButton btn_cargar;
	private JList list_domicilio;
	private JButton btnNewButton;
	
    public VistaIntento() {

    	setTitle("MainFrame");
        listModel = new DefaultListModel<Abonado>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setSize(1024, 768);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        scrollPane_abonado = new JScrollPane();
        scrollPane_abonado.setBounds(50, 66, 205, 408);
        getContentPane().add(scrollPane_abonado);
        
        table_abonado = new JTable();
        table_abonado.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        	},
        	new String[] {
        		"Nombre", "Dni"
        	}
        ));
        scrollPane_abonado.setViewportView(table_abonado);
        
        btn_abonado_nuevo = new JButton("Agregar");
        this.btn_abonado_nuevo.setActionCommand("Abrir ventana crear abonado");
        
        
        btn_abonado_nuevo.setBounds(50, 485, 89, 23);
        getContentPane().add(btn_abonado_nuevo);
        
        btn_abonado_eliminar = new JButton("Eliminar");
        btn_abonado_eliminar.setBounds(166, 485, 89, 23);
        getContentPane().add(btn_abonado_eliminar);
        
        btn_domicilio_nuevo = new JButton("Agregar");
        btn_domicilio_nuevo.setBounds(275, 238, 89, 23);
        getContentPane().add(btn_domicilio_nuevo);
        
        btn_servicio_nuevo = new JButton("Agregar");
        btn_servicio_nuevo.setBounds(275, 485, 89, 23);
        getContentPane().add(btn_servicio_nuevo);
        
        btn_servicio_eliminar = new JButton("Eliminar");

        btn_servicio_eliminar.setBounds(385, 485, 89, 23);
        getContentPane().add(btn_servicio_eliminar);
        
        btn_domicilio_eliminar = new JButton("Eliminar");
        btn_domicilio_eliminar.setBounds(385, 238, 89, 23);
        getContentPane().add(btn_domicilio_eliminar);
        
        panel_consola = new JPanel();
        panel_consola.setBounds(10, 514, 988, 204);
        getContentPane().add(panel_consola);
        
        txtpn_consola = new JTextPane();
        txtpn_consola.setText("asd");
        panel_consola.add(txtpn_consola);
        
        lbl_abonado = new JLabel("Abonados");
        lbl_abonado.setBounds(103, 41, 114, 14);
        getContentPane().add(lbl_abonado);
        
        lbl_domicilio = new JLabel("Domcilios");
        lbl_domicilio.setBounds(342, 41, 114, 14);
        getContentPane().add(lbl_domicilio);
        
        lbl_servicio = new JLabel("Servicios contratados");
        lbl_servicio.setBounds(314, 272, 114, 14);
        getContentPane().add(lbl_servicio);
        
        lbl_factura = new JLabel("Facturas");
        lbl_factura.setBounds(622, 41, 114, 14);
        getContentPane().add(lbl_factura);
        
        lbl_tecnicos = new JLabel("Tecnicos");
        lbl_tecnicos.setBounds(867, 41, 114, 14);
        getContentPane().add(lbl_tecnicos);
        
        scrollPane_domicilio = new JScrollPane();
        scrollPane_domicilio.setBounds(275, 66, 199, 146);
        getContentPane().add(scrollPane_domicilio);
        
        list_domicilio = new JList();
        scrollPane_domicilio.setViewportView(list_domicilio);
               
        scrollPane_servicio = new JScrollPane();
        scrollPane_servicio.setBounds(275, 297, 199, 177);
        getContentPane().add(scrollPane_servicio);
        
        table_servicio = new JTable();
        table_servicio.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        		{null, null},
        	},
        	new String[] {
        		"Servicio", "Cantidad"
        	}
        ));
        scrollPane_servicio.setViewportView(table_servicio);
        
        scrollPane_factura = new JScrollPane();
        scrollPane_factura.setBounds(484, 61, 246, 427);
        getContentPane().add(scrollPane_factura);
        
        table_factura = new JTable();
        table_factura.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Fecha emision", "Monto", "Estado"
        	}
        ));
        table_factura.getColumnModel().getColumn(0).setPreferredWidth(80);
        scrollPane_factura.setViewportView(table_factura);
        
        scrollPane_Tecnico = new JScrollPane();
        scrollPane_Tecnico.setBounds(795, 66, 203, 146);
        getContentPane().add(scrollPane_Tecnico);
        
        table_tecnico = new JTable();
        table_tecnico.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Nombre", "Dni", "Disponiblidad"
        	}
        ));
        scrollPane_Tecnico.setViewportView(table_tecnico);
        
        btn_tecnico_nuevo = new JButton("Agregar");
        btn_tecnico_nuevo.setBounds(795, 223, 89, 23);
        getContentPane().add(btn_tecnico_nuevo);
        
        btn_tecnico_eliminar = new JButton("Eliminar");
        btn_tecnico_eliminar.setBounds(909, 223, 89, 23);
        getContentPane().add(btn_tecnico_eliminar);
        
        panel_calendario = new JPanel();
        panel_calendario.setBounds(787, 314, 194, 160);
        getContentPane().add(panel_calendario);
        
        JCalendar calendar = new JCalendar();
        panel_calendario.add(calendar);
        
        lbl_calendario = new JLabel("Calendario");
        lbl_calendario.setBounds(865, 289, 84, 14);
        getContentPane().add(lbl_calendario);
        
        btn_calendario_retroceder = new JButton("<<");

        btn_calendario_retroceder.setBounds(795, 485, 89, 23);
        getContentPane().add(btn_calendario_retroceder);
        
        btn_calendario_retroceder_1 = new JButton(">>");
        btn_calendario_retroceder_1.setBounds(909, 485, 89, 23);
        getContentPane().add(btn_calendario_retroceder_1);
        
        btn_guardar = new JButton("Guardar");
        btn_guardar.setBounds(806, 0, 89, 23);
        getContentPane().add(btn_guardar);
        
        btn_cargar = new JButton("Cargar");
        btn_cargar.setBounds(909, 0, 89, 23);
        getContentPane().add(btn_cargar);
        setVisible(true);
    }

    public void actualizarLista(ArrayList<Abonado> nuevaLista) {
        listModel.clear();
        for (Abonado abonado : nuevaLista) {
            listModel.addElement(abonado);
        }
    }

 	
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener=actionListener;
		this.btn_abonado_nuevo.addActionListener(actionListener);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
