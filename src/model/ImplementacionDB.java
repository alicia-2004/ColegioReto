/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 *
 * @author acer
 */
public class ImplementacionDB implements ClaseDAO{
    private Connection con;
    private PreparedStatement stmt;

    // Los siguientes atributos se utilizan para recoger los valores del fich de
    // configuracion
    private ResourceBundle configFile;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;

	//Sentencias SQL
    
    final String SQLMOSTRARENUNCIADOS = "SELECT DESCRIPTION_S FROM STATEMENT";
    final String SQLAÑADIRUNIDADDIDACTICA ="SELECT INTO TEACHINGUNIT VALUES(?,?,?,?,?)";

    private void openConnection() {
	try {
            con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
	} catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
            e.printStackTrace();
	} catch (Exception e) {
            e.printStackTrace();
	}
    }

    public ImplementacionDB() {
	this.configFile = ResourceBundle.getBundle("modelo.configClase");
	this.driverBD = this.configFile.getString("Driver");
	this.urlBD = this.configFile.getString("Conn");
	this.userBD = this.configFile.getString("DBUser");
	this.passwordBD = this.configFile.getString("DBPass");
    }
    
    @Override
    public Map <String,Enunciado> mostrarEnunciados (){
	ResultSet rs = null;
	Map<String,Enunciado> equipos = new TreeMap<>();
	Enunciado e;
		
	this.openConnection();
		
	try {
            stmt = con.prepareStatement(SQLMOSTRARENUNCIADOS);
            rs = stmt.executeQuery();
			
            while (rs.next()) {
		e = new Enunciado ();
		e.setDescripcion(rs.getString("DESCRIPTION_S"));
		equipos.put(e.getDescripcion(), e);
            }
            rs.close();
            stmt.close();
            con.close();
            } catch (SQLException e) {
			System.out.println("Error al obtener los enunciados: " + e.getMessage());
            }
            return equipos;
    }
    
    @Override
    public boolean insertarUnidad (int id,String acronimo,String calificacion,String evaluacion,String descripcion) {
	boolean realizado=false;
		
	this.openConnection();

	try {
            stmt = con.prepareStatement(SQLAÑADIRUNIDADDIDACTICA);
            stmt.setInt(1, id);
            stmt.setString(2, acronimo);
            stmt.setString(3, calificacion);
            stmt.setString(4, evaluacion);
            stmt.setString(5, descripcion);

			
            if (stmt.executeUpdate() > 0) {
		realizado = true;
            }

            stmt.close();
            con.close();
            } catch (SQLException e) {
			System.out.println("Error al añadir unidad: " + e.getMessage());
            }
		
            return realizado;
    }    
}
