/**
 * 
 */
package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Data.Cargos;
import Data.Empleado;
import Data.Nominas;
import Conexion.Conector;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import visual2.crear2;
import visual2.Depart;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class interfaz extends JDialog {

	private JPanel contentPane;
	private static JTable table1;
	private static ArrayList<Empleado> empleados;
	private static Conector mc = new Conector();
	private static int tipoNom;
	private static Empleado empSelect;
	private static JTextField salario;
	private static JTextField prestamo;
	private static float total;
	private static float seguro;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfaz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\din.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 847, 308);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crear2 ce = new crear2(true, null);
					ce.setVisible(true);
					//
					actualizaLista();
				} catch (Exception e2) {
					System.out.println("error3"+ tipoNom+ e2.getMessage());
				}
			}
		});
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					elimina();
				} catch (Exception e2) {
					System.out.println("error2"+ e2.getMessage());
				}
			}
		});
		
		JLabel lblEmpleados = new JLabel("EMPLEADOS");
		lblEmpleados.setFont(new Font("Century Gothic", Font.BOLD, 17));
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		final JButton btnAgregarANomina = new JButton("Agregar a Nomina");
		btnAgregarANomina.setEnabled(false);
		btnAgregarANomina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Nominas> nominas;
				try {
					nominas = mc.mostrarNominas();
					JComboBox jcb = new JComboBox();
					for (Nominas usr : nominas) {
						jcb.addItem(usr.getNombre());
											
					}
					
					 salario = new JTextField(10);
					 prestamo = new JTextField(10);
					 
				      JPanel myPanel = new JPanel();
				      myPanel.add(new JLabel("Nomina:"));
				      myPanel.add(jcb);
				      myPanel.add(Box.createHorizontalStrut(15));
				      myPanel.add(new JLabel("Salario:"));
				      myPanel.add(salario);
				      myPanel.add(new JLabel("Prestamo:"));
				      myPanel.add(prestamo);
				      JOptionPane op = new JOptionPane();
				      
				      
				      
			op.showMessageDialog( null, myPanel, "Selecciona la Nomina", JOptionPane.QUESTION_MESSAGE);
			
			//System.out.println(salario.getText());
			
			tipoNom = nominas.get(jcb.getSelectedIndex()).getid();
			
			empSelect = (Empleado)table1.getModel().getValueAt(table1.getSelectedRow(), 10);
			seguro = (float) (0.0519 * Float.parseFloat(salario.getText()));
			mc.DatosNomina(tipoNom, empSelect.getid(), Float.parseFloat(salario.getText()), Float.parseFloat(prestamo.getText()), seguro);
			total = mc.totalIngreso(empSelect.getid());
			//JOptionPane.showMessageDialog(null, sueldoNeto(total));
			
			actualizaLista();
			
				} catch (Exception e1) {
					e1.getMessage();//
				}

			}
			
		});
	
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mc.editaEmpleado(empSelect.getid(), sueldoNeto(total));
					actualizaLista();
					JOptionPane.showMessageDialog(null, sueldoNeto(total));
				} catch (Exception e2) {
					System.out.println("error: \n"+ e2.getMessage());
				}
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAgregar)
							.addGap(18)
							.addComponent(btnEliminar)
							.addGap(18)
							.addComponent(btnAgregarANomina)
							.addGap(18)
							.addComponent(btnActualizar)
							.addPreferredGap(ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
							.addComponent(btnCerrar))
						.addComponent(lblEmpleados, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblEmpleados)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnEliminar)
						.addComponent(btnCerrar)
						.addComponent(btnAgregarANomina)
						.addComponent(btnActualizar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				btnAgregarANomina.setEnabled(true);
				
			}
		});
		table1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Nombre", "Direccion", "Telefono", "Email", "Departamento", "Cargo", "Fecha de Ingreso", "Total de Ingresos", "Estatus",  "Objecte"
				}
			));
			scrollPane.setViewportView(table1);
			contentPane.setLayout(gl_contentPane);
			table1.removeColumn(table1.getColumn("Objecte"));
			try {
				actualizaLista();
			} catch (Exception e) {
				System.out.println("error1");
			}
			
		
		
	}
	public static void actualizaLista() throws SQLException{
		empleados =mc.mostrarEmpleados();
		
		DefaultTableModel modelo = (DefaultTableModel)table1.getModel();
		while (modelo.getRowCount() > 0) modelo.removeRow(0);
		int numCols = modelo.getColumnCount();
		for (Empleado usr : empleados) {
			Object [] fila = new Object[numCols]; 
			
			fila[0] = usr.getid();
			fila[1] = usr.getNombre();
			fila[2] = usr.getDireccion();
			fila[3] = usr.getTelefono();
			fila[4] = usr.getMail();
			fila[5] = usr.getDepartamento();
			fila[6] = usr.getCargo();
			fila[7] = usr.getFecha();
			fila[8] = usr.getTotalIng();
			fila[9] = usr.getEstatus();
			fila[10] = usr;
			modelo.addRow(fila);
				
		}
	}
	
	void elimina() throws SQLException{
		int resposta = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			Empleado user = (Empleado)table1.getModel().getValueAt(table1.getSelectedRow(), 10);
			mc.eliminaEmpleado(user.getid());
			mc.eliminaNomina(user.getid());
		}
		actualizaLista();
	}
	
	public static float sueldoNeto(float total){
		
		double desc;
		double tdesc;
		float neto;
		double isr = 0;
		double isrmensual = 0;
		if(total >= 30000){
			desc = (total * 0.10);
		}else{
			desc = (total * 0.08);
		}
		tdesc = desc + Float.parseFloat(prestamo.getText()) + CalculoImpuesto(total, isr, isrmensual) + seguro(seguro, total);
		neto = (float) (total - tdesc);
		
		return neto;
	}
	
public static double CalculoImpuesto(float total, double isr, double isrmensual){
		
		total *= 12;
		
		if (total <= 399923.00){
			System.out.println("\t\t ***** Esta Excento de Impuesto! ***** \n");
			isrmensual = 0;
		}
		if (total >= 399923.01 && total <= 599844.00){
			isr = (total - 399923.01) * 0.15;
			isrmensual = isr / 12;
		}
		if (total >= 599844.01 && total <= 833171.00){
			isr = ((total - 599844.01) * 0.20) + 29994.00;
			isrmensual = isr / 12;
		}
		if (total > 833171.01){
			isr = ((total - 833171.01) * 0.25) + 76652.00;
			isrmensual = isr / 12;
		}
		
		return isrmensual;
	}

public static float seguro(float seguro, float total){
	
	seguro = (float) 0.0591;
	seguro = total * seguro;
	
	return seguro;
	
	
}

}
