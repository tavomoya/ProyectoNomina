/**
 * 
 */
package Data;

import java.sql.Date;
/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class Empleado {

	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String mail;
	private int departamento;
	private int cargo;
	private Date fechaIng;
	private float TotalIng;
	private String estatus;
	
	public Empleado(int id, String nombre, String direccion, String telefono, String mail, int departamento, int cargo, Date date, float TotalIng, String estatus){
		super();
		
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.mail = mail;
		this.departamento = departamento;
		this.cargo = cargo;
		this.fechaIng = date;
		this.TotalIng = TotalIng;
		this.estatus = estatus;
		
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion(){
		return direccion;
	}
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	public String getTelefono(){
		return telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public Date getFecha() {
		return fechaIng;
	}
	public void setFecha(String fecha) {
		this.fechaIng = fechaIng;
	}
	public float getTotalIng() {
		return TotalIng;
	}
	public void setTotalIng(float TotalIng) {
		this.TotalIng = TotalIng;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
