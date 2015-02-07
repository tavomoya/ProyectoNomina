/**
 * 
 */
package Data;

import java.sql.Timestamp;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class Nomz {
	
	private int nom_id;
	private int emp_id;
	private float salario;
	private int accion;
	private String fecha;
	private float prestamo;
	private float seguro;
	
	public Nomz(int nom_id, int emp_id, float salario, int accion, String fecha, float prestamo, float seguro){
		
		this.nom_id = nom_id;
		this.emp_id = emp_id;
		this.salario = salario;
		this.accion = accion;
		this.fecha = fecha;
		this.prestamo = prestamo;
		this.seguro = seguro;
	}
	
	public int getnom_id() {
		return nom_id;
	}
	public void setnom_id(int nom_id) {
		this.nom_id = nom_id;
	}
	public int getemp_id() {
		return emp_id;
	}
	public void setemp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	public float getsalario() {
		return salario;
	}
	public void setsalario(float salario) {
		this.salario = salario;
	}
	public int getaccion() {
		return accion;
	}
	public void setaccion(int accion) {
		this.accion = accion;
	}
	
	public String getfecha() {
		return fecha;
	}
	public void setfecha(String fecha) {
		this.fecha = fecha;
	}
	public float getprestamo() {
		return prestamo;
	}
	public void setprestamo(float prestamo) {
		this.prestamo = prestamo;
	}
	
	public float getseguro() {
		return seguro;
	}
	public void setseguro(float seguro) {
		this.seguro = seguro;
	}

}

