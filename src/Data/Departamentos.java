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
public class Departamentos {

	private int id;
	private String descripcion;
	
	public Departamentos(int id, String descripcion){
		
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getNombre() {
		return descripcion;
	}
	public void setNombre(String nombre) {
		this.descripcion = nombre;
	}
	
}