/**
 * 
 */
package Conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Cargos;
import Data.Empleado;
import Data.Departamentos;
import Data.Nominas;
import Data.Nomz;

/**
 * @author Gregorio Moya
 *
 * created first in project Final_1
 */
public class Conector {
	
	private Connection con;
	
	public Conector(){
		
		realizarConexion();
	}
	
	public void realizarConexion(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
   		 con = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "tavo", "meredith10");
			
		}catch(Exception e){
			System.out.println("ERROR DE CONEXION: \n"+e.getMessage());
		}
		
	}

	public void cerrarConexion() throws SQLException{
		try {
			
			con.close();
			
		} catch (Exception e) {
			System.out.println("ERROR ");
		}
		
				
	}
	
	public ArrayList<Empleado> mostrarEmpleados() throws SQLException{
		
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM empleado");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Empleado a = new Empleado(rs.getInt("codigoEmpleado"), rs.getString("nombreEmpleado"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("email"), rs.getInt("cod_depto"), rs.getInt("cod_cargo"), rs.getDate("fechaIngr"), rs.getFloat("TotalIngr"), rs.getString("estatus"));
			lista.add(a);
			
		}
		
		rs.close();
		return lista;
		
	}
	
	public void insertarEmpleados(int id, String nombre, String direccion, String telefono, String mail, int depnumber, int cargonumber, Date fecha, float TotalIng, String string) throws SQLException{
		
		String seleccion = "INSERT INTO `empleado` (`codigoEmpleado`, `nombreEmpleado`, `direccion`, `telefono`, `email`, `cod_depto`, `cod_cargo`, `fechaIngr`, `TotalIngr`, `estatus`)"+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(seleccion);
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, direccion);
		ps.setString(4, telefono);
		ps.setString(5, mail);
		ps.setInt(6, depnumber);
		ps.setInt(7, cargonumber);
		ps.setDate(8, fecha);
		ps.setFloat(9, TotalIng);
		ps.setString(10, string);
		ps.executeUpdate();
		
	}
	
	public void insertarDepartamentos(int id, String descripcion) throws SQLException{
		
		String selecciona = "INSERT INTO `departamento` (`codigo_depto`, `descripcion`)" + "VALUES (?, ?)";
		PreparedStatement prep = con.prepareStatement(selecciona);
		prep.setInt(1, id);
		prep.setString(2, descripcion);
		prep.executeUpdate();
		
	}
	
	public void editaEmpleado(int id, float salario){
		
		try{
		String seleccio = "UPDATE empleado SET TotalIngr = ? WHERE codigoEmpleado = ?";//MIENTRAS AUN NO TENGO EL CALCULO LE PASO EL SALARIO QUE ES LO QUE ME INTERESA PA VER SI PUEDO PONERLO EN EL INGRESO, L
		PreparedStatement ps = con.prepareStatement(seleccio);
		ps.setFloat(1, salario); 
		ps.setInt(2, id);
		ps.executeUpdate();
		
		}catch(SQLException e){
		System.out.println(e.getMessage());
		}
	}

	/**
	 * @param getid
	 * @throws SQLException 
	 */
	public void eliminaEmpleado(int id) throws SQLException {
			String seleccion = "DELETE FROM `empleado` WHERE `codigoEmpleado` = ?";
			PreparedStatement ps = con.prepareStatement(seleccion);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	
public ArrayList<Departamentos> mostrarDepartamentos() throws SQLException{
		
		ArrayList<Departamentos> lista = new ArrayList<Departamentos>();
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM departamento");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Departamentos a = new Departamentos(rs.getInt("codigo_depto"), rs.getString("descripcion"));
			lista.add(a);
			
		}
		
		rs.close();
		return lista;
		
	}

public void insertarCargos(int id, String descripcion) throws SQLException{
	
	String selecciona = "INSERT INTO `cargos` (`codigo_cargo`, `descripcion`)" + "VALUES (?, ?)";
	PreparedStatement prep = con.prepareStatement(selecciona);
	prep.setInt(1, id);
	prep.setString(2, descripcion);
	prep.executeUpdate();
	
}

public ArrayList<Cargos> mostrarCargos() throws SQLException{
	
	ArrayList<Cargos> lista = new ArrayList<Cargos>();
	
	PreparedStatement ps = con.prepareStatement("SELECT * FROM cargos");
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		Cargos a = new Cargos(rs.getInt("codigo_cargo"), rs.getString("descripcion"));
		lista.add(a);
		
	}
	
	rs.close();
	return lista;
	
}

public ArrayList<Nominas> mostrarNominas() throws SQLException{
	
	ArrayList<Nominas> lista = new ArrayList<Nominas>();
	
	PreparedStatement ps = con.prepareStatement("SELECT * FROM tiponomina");
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		Nominas a = new Nominas(rs.getInt("codigo_tipo"), rs.getString("descripcion"));
		lista.add(a);
		
	}
	
	rs.close();
	return lista;
	
}

public void insertarNomina(int id, String descripcion) throws SQLException{
	
	String selecciona = "INSERT INTO `tiponomina` (`codigo_tipo`, `descripcion`)" + "VALUES (?, ?)";
	PreparedStatement prep = con.prepareStatement(selecciona);
	prep.setInt(1, id);
	prep.setString(2, descripcion);
	prep.executeUpdate();
	
}

public void DatosNomina(int id, int empleado, float salario, float prestamo, float seguro) throws SQLException{
	
	String selecciona = "INSERT INTO `nomina`.`nominas` (`tipo_nom`, `codigo_emp`, `salario`, `num_accion`, `fecha_accion`, `prestamo`, `seguroMedico`)"+ 
	"VALUES (?, ?, ?, NULL, CURRENT_TIMESTAMP, ?, ?)";
	
	PreparedStatement prep = con.prepareStatement(selecciona);
	prep.setInt(1, id);
	prep.setInt(2, empleado);
	prep.setFloat(3, salario);
	prep.setFloat(4, prestamo);
	prep.setFloat(5, seguro);
	prep.executeUpdate();
	
}

public float totalIngreso(int id) throws SQLException{
	float total = 0;
	PreparedStatement ps = con.prepareStatement("SELECT salario FROM nominas n WHERE num_accion = (SELECT max(num_accion) FROM nominas n2 WHERE n2.tipo_nom = n.tipo_nom AND n2.codigo_emp = ?) GROUP BY tipo_nom;");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		 total += rs.getFloat("salario");		
	}
	return total;

}

public ArrayList<Nomz> mostrarTotalNomina() throws SQLException{
	
	ArrayList<Nomz> lista = new ArrayList<Nomz>();
	
	PreparedStatement ps = con.prepareStatement("SELECT * FROM nominas");
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		Nomz a = new Nomz(rs.getInt("tipo_nom"), rs.getInt("codigo_emp"), rs.getFloat("salario"), rs.getInt("num_accion"), rs.getString("fecha_accion"), rs.getFloat("prestamo"), rs.getFloat("seguroMedico"));
		lista.add(a);
		
	}
	
	rs.close();
	return lista;
	
}

public ArrayList<Nomz> mostrarTotalNominas(int nomid) throws SQLException{
	
	ArrayList<Nomz> lista = new ArrayList<Nomz>();
	
	PreparedStatement ps = con.prepareStatement("SELECT * FROM nominas WHERE `tipo_nom` = ?");
	ps.setInt(1, nomid);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		Nomz a = new Nomz(rs.getInt("tipo_nom"), rs.getInt("codigo_emp"), rs.getFloat("salario"), rs.getInt("num_accion"), rs.getString("fecha_accion"), rs.getFloat("prestamo"), rs.getFloat("seguroMedico"));
		lista.add(a);
		
	}
	
	rs.close();
	return lista;
	
}

public void eliminaNomina(int id) throws SQLException {
	String seleccion = "DELETE FROM `nominas` WHERE `codigo_emp` = ?";
	PreparedStatement ps = con.prepareStatement(seleccion);
	ps.setInt(1, id);
	ps.executeUpdate();
}

}
