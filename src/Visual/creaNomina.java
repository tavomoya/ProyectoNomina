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

import Conexion.Conector;
import Data.Cargos;
import Data.Nominas;
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
import javax.swing.LayoutStyle.ComponentPlacement;

import visual2.creaCargo;
import visual2.nomina;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class creaNomina extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static ArrayList<Nominas> nominas;
	private static Conector con = new Conector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			creaNomina dialog = new creaNomina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public creaNomina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\din.jpg"));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.textHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNominas = new JLabel("NOMINAS");
		lblNominas.setFont(new Font("Courier New", Font.BOLD, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNueva = new JButton("Nueva");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nomina nomina = new nomina();
					nomina.setVisible(true);
					
					
				} catch (Exception e2) {
					System.out.println("error3");
				}
			}
		});
		
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNominas, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(330, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnNueva)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnCerrar))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNominas)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNueva)
						.addComponent(btnCerrar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		contentPanel.setLayout(gl_contentPanel);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
								"Codigo", "Nombre", "Objecte"
				}
			));
			scrollPane.setViewportView(table);
			contentPanel.setLayout(gl_contentPanel);
			table.removeColumn(table.getColumn("Objecte"));
			try {
				actualizaLista();
			} catch (Exception e) {
				System.out.println("error1"+ e.getMessage());
			}
	}
		
	public static void actualizaLista() throws SQLException{
		nominas = con.mostrarNominas();
		
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		while (modelo.getRowCount() > 0) modelo.removeRow(0);
		int numCols = modelo.getColumnCount();
		for (Nominas usr : nominas) {
			Object [] fila = new Object[numCols]; 
			
			fila[0] = usr.getid();
			fila[1] = usr.getNombre();
			fila[2] = usr;
			modelo.addRow(fila);
				
		}
	}
}
