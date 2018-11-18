/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author admin
 */
public class connection {
    Connection conn;
    
    public connection(){}
    
    public connection(Connection conector){
        this.conn = conector;
    }
    
    //Metodo para conectar con la base de datos
    public void Conectar() throws SQLException, ClassNotFoundException {

        String cadena = "jdbc:postgresql://127.0.0.1:58634/inventariodb";
        Connection conexion;
        
        DriverManager.registerDriver(new org.postgresql.Driver());
        Class.forName("org.postgresql.Driver");
        conexion=DriverManager.getConnection(cadena, "postgres", "diego1993");
    }
    
    public Connection getConexion(){
        return this.conn;
    }
}
