/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

/**
 *
 * @author Cardona
 */

import Entities.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoAD {
    Connection conexion;
    
    public ProductoAD() throws SQLException, ClassNotFoundException{
        connection conectar = new connection();
        conectar.Conectar();
        this.conexion= conectar.getConexion();
    }
    
    public void Insertar(producto p) throws SQLException, ClassNotFoundException{
        PreparedStatement prepararSentencia = null;
        try{
            String cadenaSql="INSERT INTO productos(nombreProducto,precioVenta,precioCompra,existencia) VALUES ('"+p.getNombreP()+"','"+
                    p.getPrecioV()+"','"+p.getPrecioC()+"','"+p.getExistencia()+"');";
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
        }
        catch(Exception e){}
    }
    
    public void Actualizar(){
        
    }
    
    public void Eliminar(){
        
    }
    
    public ArrayList<producto> Listar(){
       ArrayList<producto> list = new ArrayList();

    try{
        
        Statement stm = conexion.createStatement();
        ResultSet rs = stm.executeQuery("select codigoproducto, nombreproducto, precioVenta, precioCompra, existencia from productos");

        while(rs.next())
        {
            producto p = new producto(
                rs.getInt("codigoproducto"),
                rs.getString("nombreproducto"),
                rs.getDouble("precioVenta"),
                rs.getDouble("precioCompra"),
                rs.getInt("existencia")
                );
            list.add(p);
          
        }
    }
    catch(Exception e)
    {
        
    }
    return list;
    }
}

