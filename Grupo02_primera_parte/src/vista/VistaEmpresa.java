package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import abonado.Abonado;
import empresa.Contratacion;
import empresa.Factura;
import empresa.Tecnico;
import servicio.Servicio;

public class VistaEmpresa extends JFrame implements KeyListener, IVista, MouseListener {

	private ActionListener actionListener;
    private ArrayList<Abonado> listaAbonados = new ArrayList<Abonado>();
	private ArrayList<Tecnico> listaTecnicos = new ArrayList<Tecnico>();
	private ArrayList<Contratacion> listaContrataciones = new ArrayList<Contratacion>();
	private ArrayList<Servicio> listaServicios = new ArrayList<Servicio>();
	
	private ArrayList<Factura> listaFacturas = new ArrayList<Factura>();

    private JTable table_abonado;
	private JButton btn_abonado_nuevo;
	private JButton btn_abonado_eliminar;
	private JScrollPane scrollPane_abonado;
	private JButton btn_domicilio_nuevo;
	private JButton btn_servicio_nuevo;
	private JButton btn_servicio_eliminar;
	private JButton btn_domicilio_eliminar;
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
	private JTable table_tecnico;	
	private JTable table_factura;
	private JTable table_servicio;
	private JButton btn_calendario_simular_fecha;
	private JButton btn_guardar;
	private JButton btn_cargar;
	private JButton btnNewButton;
	private JScrollPane scrollPane_consola;
	private JTextArea textArea_consola;
	private JTable table_contrataciones;
	private JButton btn_factura_pagar_factura;
	private JButton btn_abonado_solicitarReparacion;
	
    public JTextArea getTextArea_consola() {
		return textArea_consola;
	}

	@SuppressWarnings("serial")
	public VistaEmpresa() {

    	setTitle("MainFrame");

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
        	new String[][] {
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
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        
        table_abonado.getColumnModel().getColumn(0).setResizable(false);
        table_abonado.getColumnModel().getColumn(1).setResizable(false);
        scrollPane_abonado.setViewportView(table_abonado);
        
        table_abonado.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	ActionEvent event = new ActionEvent(table_abonado,ActionEvent.ACTION_PERFORMED,"Clic en tabla de abonados");
        	actionListener.actionPerformed(event);
        	}
        });
        
        btn_abonado_nuevo = new JButton("Agregar");
        this.btn_abonado_nuevo.setActionCommand("Abrir ventana crear abonado");
        
        
        btn_abonado_nuevo.setBounds(50, 485, 89, 23);
        getContentPane().add(btn_abonado_nuevo);
        
        btn_abonado_eliminar = new JButton("Eliminar");
        btn_abonado_eliminar.setActionCommand("Eliminar abonado");
        btn_abonado_eliminar.setBounds(166, 485, 89, 23);
        getContentPane().add(btn_abonado_eliminar);
        
        btn_domicilio_nuevo = new JButton("Agregar");
        btn_domicilio_nuevo.setActionCommand("Abrir ventana crear contratacion");
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
        
        lbl_abonado = new JLabel("Abonados");
        lbl_abonado.setBounds(103, 41, 114, 14);
        getContentPane().add(lbl_abonado);
        
        lbl_domicilio = new JLabel("Contrataciones");
        lbl_domicilio.setBounds(342, 41, 114, 14);
        getContentPane().add(lbl_domicilio);
        
        lbl_servicio = new JLabel("Servicios contratados");
        lbl_servicio.setBounds(314, 272, 114, 14);
        getContentPane().add(lbl_servicio);
        
        lbl_factura = new JLabel("Facturas");
        lbl_factura.setBounds(572, 41, 114, 14);
        getContentPane().add(lbl_factura);
        
        lbl_tecnicos = new JLabel("Tecnicos");
        lbl_tecnicos.setBounds(867, 41, 114, 14);
        getContentPane().add(lbl_tecnicos);
        
        scrollPane_domicilio = new JScrollPane();
        scrollPane_domicilio.setBounds(275, 66, 199, 146);
        getContentPane().add(scrollPane_domicilio);
        
        table_contrataciones = new JTable();
        table_contrataciones.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null},
        		{null},
        		{null},
        		{null},
        		{null},
        		{null},
        		{null},
        		{null},
        		{null},
        		{null},
        	},
        	new String[] {
        		"Domicilio"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table_contrataciones.getColumnModel().getColumn(0).setResizable(false);
        scrollPane_domicilio.setViewportView(table_contrataciones);
               
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
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table_servicio.getColumnModel().getColumn(0).setResizable(false);
        table_servicio.getColumnModel().getColumn(1).setResizable(false);
        scrollPane_servicio.setViewportView(table_servicio);
        
        scrollPane_factura = new JScrollPane();
        scrollPane_factura.setBounds(484, 66, 246, 408);
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
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table_factura.getColumnModel().getColumn(0).setResizable(false);
        table_factura.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_factura.getColumnModel().getColumn(1).setResizable(false);
        table_factura.getColumnModel().getColumn(2).setResizable(false);
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
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table_tecnico.getColumnModel().getColumn(0).setResizable(false);
        table_tecnico.getColumnModel().getColumn(1).setResizable(false);
        table_tecnico.getColumnModel().getColumn(2).setResizable(false);
        scrollPane_Tecnico.setViewportView(table_tecnico);
        

        
        btn_tecnico_nuevo = new JButton("Agregar");
        btn_tecnico_nuevo.setActionCommand("Abrir ventana para crear tecnicos");
        btn_tecnico_nuevo.setBounds(795, 223, 89, 23);
        getContentPane().add(btn_tecnico_nuevo);
        
        btn_tecnico_eliminar = new JButton("Eliminar");
        btn_tecnico_eliminar.setActionCommand("Eliminar tecnico");
        btn_tecnico_eliminar.setBounds(909, 223, 89, 23);
        getContentPane().add(btn_tecnico_eliminar);
        
        panel_calendario = new JPanel();
        panel_calendario.setBounds(752, 288, 246, 186);
        getContentPane().add(panel_calendario);
        
        JCalendar calendar = new JCalendar();
        panel_calendario.add(calendar);
        
        lbl_calendario = new JLabel("Calendario");
        lbl_calendario.setBounds(867, 272, 84, 14);
        getContentPane().add(lbl_calendario);
        
        btn_calendario_simular_fecha = new JButton("Simular fecha");
        btn_calendario_simular_fecha.setBounds(802, 485, 147, 23);
        getContentPane().add(btn_calendario_simular_fecha);
        
        btn_guardar = new JButton("Guardar");
        btn_guardar.setActionCommand("Persistir");
        btn_guardar.setBounds(806, 0, 89, 23);
        getContentPane().add(btn_guardar);
        
        btn_cargar = new JButton("Cargar");
        btn_cargar.setActionCommand("Despersistir");
        btn_cargar.setBounds(909, 0, 89, 23);
        getContentPane().add(btn_cargar);
        
        scrollPane_consola = new JScrollPane();
        scrollPane_consola.setBounds(10, 548, 988, 160);
        getContentPane().add(scrollPane_consola);
        
        textArea_consola = new JTextArea();
        textArea_consola.setEditable(false);
        scrollPane_consola.setViewportView(textArea_consola);
        textArea_consola.setColumns(10);
        
        btn_abonado_solicitarReparacion = new JButton("Solicitar Reparación");
        btn_abonado_solicitarReparacion.setActionCommand("Solicitar Reparación");
        btn_abonado_solicitarReparacion.setBounds(50, 514, 205, 23);
        getContentPane().add(btn_abonado_solicitarReparacion);
        
        btn_factura_pagar_factura = new JButton("Pagar factura");
        btn_factura_pagar_factura.setActionCommand("Abrir ventana crear abonado");
        btn_factura_pagar_factura.setBounds(507, 485, 205, 23);
        getContentPane().add(btn_factura_pagar_factura);
        
        setVisible(true);
        
    }

    
	@Override
	public void actualizarListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos.clear();
        for (Tecnico tecnico : listaTecnicos) {
            this.listaTecnicos.add(tecnico);
        }
        actualizarTablaDeTecnicos();	
	}

	@SuppressWarnings("serial")
	private void actualizarTablaDeTecnicos() {
		
		DefaultTableModel tablaTecnicosNueva = new DefaultTableModel(
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
	        ) 
		
		{
	        	boolean[] columnEditables = new boolean[] {
	        		false, false, false
	        	};
	        	public boolean isCellEditable(int row, int column) {
	        		return columnEditables[column];
	        	}
	        };
	    int i=0;
	    for (Tecnico tecnico : this.listaTecnicos) {
	    tablaTecnicosNueva.setValueAt(tecnico.getNombre(), i, 0);
	    tablaTecnicosNueva.setValueAt(tecnico.getDni(), i, 1);
	    if (tecnico.getAbonado()!=null)
	    	tablaTecnicosNueva.setValueAt("Reparando", i, 2);
	    else
	    	tablaTecnicosNueva.setValueAt("Disponible", i, 2);  
		
		i++;
	    }
	    table_tecnico.setModel(tablaTecnicosNueva);
	};
 	
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener=actionListener;
		this.btn_abonado_nuevo.addActionListener(actionListener);
		this.btn_tecnico_nuevo.addActionListener(actionListener);
		this.btn_guardar.addActionListener(actionListener);
		this.btn_cargar.addActionListener(actionListener);
		this.btn_tecnico_eliminar.addActionListener(actionListener);
		this.btn_abonado_eliminar.addActionListener(actionListener);
		this.btn_domicilio_nuevo.addActionListener(actionListener);
		this.btn_abonado_solicitarReparacion.addActionListener(actionListener);
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

    public ArrayList<Abonado> getListaAbonados() {
		return listaAbonados;
	}

	public ArrayList<Tecnico> getListaTecnicos() {
		return listaTecnicos;
	}

	public JTable getTable_tecnico() {
		return table_tecnico;
	}

	public JTable getTable_factura() {
		return table_factura;
	}

	public JTable getTable_servicio() {
		return table_servicio;
	}
	public JTable getTable_abonado() {
		return table_abonado;
	}

	@Override
	public void actualizaListaContrataciones(ArrayList<Contratacion> listaDeContrataciones) {
        this.listaContrataciones.clear();
        for (Contratacion contratacion : listaDeContrataciones) {
            this.listaContrataciones.add(contratacion);
        }
        actualizarTablaDeContrataciones();	
	}

	
	@SuppressWarnings("serial")
	private void actualizarTablaDeContrataciones() {
		
		DefaultTableModel tablaContratacionesNueva = new DefaultTableModel(
	        	new Object[][] {
	        		{null},
	        		{null},
	        		{null},
	        		{null},
	        		{null},
	        		{null},
	        		{null},
	        		{null},
	        		{null},
	        		{null},
	        	},
	        	new String[] {
	        		"Domicilio"
	        	}
	        )
		
		{
	        	boolean[] columnEditables = new boolean[] {
	        		false, false, false
	        	};
	        	public boolean isCellEditable(int row, int column) {
	        		return columnEditables[column];
	        	}
	        };
	    int i=0;
	    for (Contratacion contratacion : this.listaContrataciones) {
	    	tablaContratacionesNueva.setValueAt(contratacion.getDomicilio().getNombre(), i,0);
	
		i++;
	    }
	    table_contrataciones.setModel(tablaContratacionesNueva);
	}
    
	public void actualizarListaAbonados(ArrayList<Abonado> listaAbonados) {
        this.listaAbonados.clear();
        for (Abonado abonado : listaAbonados) {
            this.listaAbonados.add(abonado);
        }
        actualizarTablaDeAbonados();
    }
	
	
	private void actualizarTablaDeAbonados() {
		
		@SuppressWarnings("serial")
		DefaultTableModel tablaAbonadosNueva = new DefaultTableModel(
	        	new String[][] {
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
	        ) {
	        	boolean[] columnEditables = new boolean[] {
	        		false, false
	        	};
	        	public boolean isCellEditable(int row, int column) {
	        		return columnEditables[column];
	        	}
	        };
	    int i=0;
	    for (Abonado abonado : this.listaAbonados) {
	    	tablaAbonadosNueva.setValueAt(abonado.getNombre(), i,0);
	    	tablaAbonadosNueva.setValueAt(abonado.getDni(), i,1);	
		i++;
	    }
	    table_abonado.setModel(tablaAbonadosNueva);
	}
}
