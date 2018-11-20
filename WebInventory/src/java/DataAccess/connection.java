/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void Conectar(){

        try {
            String cadena = "jdbc:postgresql://127.0.0.1:5432/inventariodb";
             // String cadena = "jdbc:postgresql://shefjekp:OyUnK8lQOcWme8VnR-eZubq-Ua4Lrf4h@baasu.db.elephantsql.com:5432/shefjekp";
            
            
            //DriverManager.registerDriver(new org.postgresql.Driver());
            Class.forName("org.postgresql.Driver").newInstance();
            this.conn = DriverManager.getConnection(cadena, "postgres", "diego1993");
            if(this.conn != null)
                System.out.println("conexion correcta");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion(){
        return this.conn;
    }
}
