/**
 * 
 */
package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Conexion.Conector;
import Data.Departamentos;
import Data.Empleado;
import Data.Nomz;
import Visual.cargO;
import visual2.Depart;
import visual2.crear2;
import Visual.Dep;
import Visual.interfaz;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.SystemColor;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class principal extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\din.jpg"));
		setForeground(new Color(169, 169, 169));
		setTitle("NOM APP\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 383);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomSystem = new JLabel("NOM SYSTEM");
		lblNomSystem.setFont(new Font("Courier New", Font.BOLD, 30));
		lblNomSystem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBackground(new Color(169, 169, 169));
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					interfaz emp = new interfaz();
					emp.setVisible(true);
					
				} catch (Exception e2) {
					System.out.println("error3");
				}
			}
		});
		
		JButton btnDepartamentos = new JButton("Departamentos");
		btnDepartamentos.setBackground(new Color(169, 169, 169));
		btnDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Dep depto = new Dep();
					depto.setVisible(true);
					
				} catch (Exception e2) {
					System.out.println("error3");
				}
			}
		});
		
		JButton btnNominas = new JButton("NOM's");
		btnNominas.setBackground(new Color(169, 169, 169));
		btnNominas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					creaNomina nom = new creaNomina();
					nom.setVisible(true);
					
				} catch (Exception e2) {
					System.out.println("error3");
				}
			}
		});
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBackground(new Color(169, 169, 169));
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Noms nominax = new Noms();
					nominax.setVisible(true);
					
				} catch (Exception e2) {
					System.out.println("error3"+ e2.getMessage());
				}
			}
		});
		
		JButton btnCargos = new JButton("Cargos");
		btnCargos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargO carg = new cargO();
					carg.setVisible(true);
					
				} catch (Exception e2) {
					System.out.println("error3");
				}
			}
		});
		
		
		btnCargos.setBackground(new Color(169, 169, 169));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCargos))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(83)
								.addComponent(lblNomSystem, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnEmpleados)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnDepartamentos)
										.addGap(146)))
								.addGap(79)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNominas))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnConsultas)))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNomSystem)
					.addGap(25)
					.addComponent(btnEmpleados)
					.addGap(18)
					.addComponent(btnDepartamentos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCargos)
					.addGap(18)
					.addComponent(btnNominas)
					.addGap(18)
					.addComponent(btnConsultas)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
