/**
 * 
 */
package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

import Conexion.Conector;
import Data.*;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class Noms extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static JTable table_1;
	private static ArrayList<Nomz> nomina;
	private static Conector con = new Conector();
	private static ArrayList<Nominas> noms;
	static int clasiNomina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Noms dialog = new Noms();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public Noms() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\din.jpg"));
		setBounds(100, 100, 557, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.textHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNominas = new JLabel("NOMINAS");
		lblNominas.setFont(new Font("Courier New", Font.BOLD, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		
		final JComboBox comboBox = new JComboBox();
		noms = con.mostrarNominas();
		
		for (Nominas usr : noms) {
			comboBox.addItem(usr.getNombre());
			
		}
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
								"Tipo Nomina", "Codigo Empleado", "Salario", "No. Accion", "Fecha Accion", "Prestamo", "Seguro", "Objecte"
				}
			));
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clasiNomina = noms.get(comboBox.getSelectedIndex()).getid();
					
					try {
						
						actualizaNomina();
						
					} catch (SQLException e2) {
						System.out.println("ERROR: "+ e2.getMessage());
					}
				}
			});
			
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblNominas, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNominas)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(1)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton))))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
			);
			contentPanel.setLayout(gl_contentPanel);
			table.removeColumn(table.getColumn("Objecte"));
			try {
				actualizaLista();
			} catch (Exception e) {
				System.out.println("error1"+ e.getMessage());
			}
		
	}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		
	}
	public static void actualizaLista() throws SQLException{
		nomina = con.mostrarTotalNomina();
		
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		while (modelo.getRowCount() > 0) modelo.removeRow(0);
		int numCols = modelo.getColumnCount();
		for (Nomz usr : nomina) {
			Object [] fila = new Object[numCols]; 
			
			fila[0] = usr.getnom_id();
			fila[1] = usr.getemp_id();
			fila[2] = usr.getsalario();
			fila[3] = usr.getaccion();
			fila[4] = usr.getfecha();
			fila[5] = usr.getprestamo();
			fila[6] = usr.getseguro();
			fila[7] = usr;
			modelo.addRow(fila);
				
		}
	}
	
	void actualizaNomina() throws SQLException{
		
		nomina = con.mostrarTotalNominas(clasiNomina);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		while (model.getRowCount() > 0) model.removeRow(0);
		int numCols = model.getColumnCount();
		for (Nomz usr : nomina) {
			Object [] fila = new Object[numCols]; 
			
			fila[0] = usr.getnom_id();
			fila[1] = usr.getemp_id();
			fila[2] = usr.getsalario();
			fila[3] = usr.getaccion();
			fila[4] = usr.getfecha();
			fila[5] = usr.getprestamo();
			fila[6] = usr.getseguro();
			fila[7] = usr;
			model.addRow(fila);
		}
}
	
}