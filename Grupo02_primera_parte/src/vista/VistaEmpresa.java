package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import abonado.Abonado;

public class VistaEmpresa extends JFrame implements KeyListener, IVista, MouseListener {

	private ActionListener actionListener;
    private JList<Abonado> jList;
    private DefaultListModel<Abonado> listModel;
	
    public VistaEmpresa() {
        listModel = new DefaultListModel<Abonado>();
        jList = new JList<>(listModel);
        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = jList.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        Abonado abonadoSeleccionado = listModel.getElementAt(index);
                        // Hacer algo con el abonado seleccionado
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(jList);
        scrollPane.setPreferredSize(new Dimension(300, 200)); // Establece el tamaño deseado del JScrollPane

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.NORTH); // Agrega el JScrollPane al norte del panel
        add(panel); // Agrega el panel a la ventana principal

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actualizarLista(ArrayList<Abonado> nuevaLista) {
        listModel.clear();
        for (Abonado abonado : nuevaLista) {
            listModel.addElement(abonado);
        }
    }

 	
	@Override
	public void setActionListener(ActionListener ActionListener) {
		// TODO Auto-generated method stub
		
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
