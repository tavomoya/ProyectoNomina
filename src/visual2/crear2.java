/**
 * 
 */
package visual2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.Conector;
import Data.Cargos;
import Data.Departamentos;
import Data.Empleado;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import Conexion.Conector;
import javax.swing.JComboBox;

import Visual.interfaz;
import java.awt.Font;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.util.JDatePickerUtil;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class crear2 extends JDialog {

	private JPanel contentPane;
	private Conector mc = new Conector();
	static boolean crea;
	static Empleado emp;
	static int depnumber;
	static int cargonumber;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFormattedTextField textField_7;
	static String estado = "A";
	static float ingr = 0;
	ArrayList<Cargos>cargos;
	ArrayList<Departamentos>departamentos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crear2 frame = new crear2(crea, emp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public crear2(final boolean crea, Empleado emp) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\din.jpg"));
		setModal(true);
		this.crea = crea;
		this.emp = emp;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 405);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNuevoEmpleado = new JLabel("Nuevo Empleado");
		lblNuevoEmpleado.setFont(new Font("Courier New", Font.BOLD, 17));
		
		JLabel lblId = new JLabel("Id:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		
		JLabel lblIdDelCargoo = new JLabel("Cargo");
		
		JLabel lblNewLabel = new JLabel("Fecha de Ingreso");
		
		textField_7 = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		textField_7.setValue(new java.util.Date());
		textField_7.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		final JComboBox comboBox = new JComboBox();
			departamentos = mc.mostrarDepartamentos();
			
			for (Departamentos usr : departamentos) {
				comboBox.addItem(usr.getNombre());					
			}
			
			
			
		final JComboBox comboBox_1 = new JComboBox();
		cargos = mc.mostrarCargos();
		
		for (Cargos usr : cargos) {
			comboBox_1.addItem(usr.getNombre());
			
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depnumber = departamentos.get(comboBox.getSelectedIndex()).getid();
				cargonumber = cargos.get(comboBox_1.getSelectedIndex()).getid();
				
				try {
					if(crea) 
						crearE();
					interfaz.actualizaLista();
					
					dispose();
				} catch (SQLException e2) {
					System.out.println("ERROR: "+depnumber+cargonumber+ e2.getMessage());
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDepartamento)
								.addComponent(lblNombre)
								.addComponent(lblId)
								.addComponent(lblDireccion)
								.addComponent(lblTelefono)
								.addComponent(lblEmail)
								.addComponent(lblIdDelCargoo)
								.addComponent(lblNewLabel))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_4)
									.addComponent(textField_3)
									.addComponent(textField_2)
									.addComponent(textField_1)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
									.addComponent(textField_7))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBox_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox, Alignment.LEADING, 0, 150, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAgregar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar))
						.addComponent(lblNuevoEmpleado, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNuevoEmpleado, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDepartamento)
							.addGap(18)
							.addComponent(lblIdDelCargoo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAgregar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	/**
	 * @param b
	 */	
	/**
	 * 
	 */


	@SuppressWarnings("deprecation")
	void crearE() throws NumberFormatException, SQLException{
		mc.insertarEmpleados(Integer.parseInt(textField.getText()), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), depnumber, cargonumber, Date.valueOf(textField_7.getText()), ingr, estado);
	}
}
