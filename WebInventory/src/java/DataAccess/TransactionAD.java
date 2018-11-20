/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.detalle;
import Entities.producto;
import Entities.transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TransactionAD {
     Connection conexion;
    
    public TransactionAD() throws SQLException, ClassNotFoundException{
        connection conectar = new connection();
        conectar.Conectar();
        this.conexion= conectar.getConexion();
    }
    
    public int Insertar(transaccion p) throws SQLException, ClassNotFoundException{
        PreparedStatement prepararSentencia = null;
        try{
            String cadenaSql="insert into transacciones (nombre, fecha, numerofac, tipo) "
                    + " values ('"+p.getNombre() + "', "
                    + "now(), "
                    + "'"+p.getFactura()+"', "
                    + "'venta');";
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
            
            //Devolver el ultimo registro
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("select max(idtransaccion) id"
                + "from transacciones " +
                  " where nombre = '" + p.getNombre() + "'");

            int id = 0;
            while(rs.next())
            {
               id = rs.getInt("id");

            }
            return id;
        }
        catch(Exception e){}
        return 0;
    }
    
     public void AddDetails(detalle p) throws SQLException, ClassNotFoundException{
        PreparedStatement prepararSentencia = null;
        try{
            String cadenaSql="insert into \"public\".\"detalleTran\" "
                    + "(idtransaccion, idproducto, cantidad) "
                    + "values ("+p.getIdTransaccion()+", "+p.getIdProducto()+", "+p.getCantidad()+");";
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
        }
        catch(Exception e){}
    }
    
   public ArrayList<detalle> getDetails(String id)
   {
    ArrayList<detalle> list = new ArrayList();

    try{
        
        Statement stm = conexion.createStatement();
        ResultSet rs = stm.executeQuery("select idtransaccion, "
                + "idproducto, "
                + "cantidad from \"public\".\"detalleTran\" " +
                  " where idtransaccion = " + id);

        ProductoAD pAD = new ProductoAD();
        while(rs.next())
        {
            producto p = pAD.getById(rs.getString("idproducto") );
            detalle d = new detalle( 0,
                rs.getInt("idtransaccion"),
                rs.getInt("idproducto"),
                p.getPrecioV() * rs.getInt("cantidad"),
                rs.getInt("cantidad"),
                p.getNombreP()
                );
            list.add(d);
          
        }
    }
    catch(Exception e)
    {
        
    }
    return list;
   }
     
    public void Actualizar(){
        
    }
    
    public void Eliminar(){
        
    }
    
    public ArrayList<transaccion> ListarVentas(){
       ArrayList<transaccion> list = new ArrayList();

    try{
        
        Statement stm = conexion.createStatement();
        ResultSet rs = stm.executeQuery("select idtransaccion, "
                + "nombre, "
                + "fecha, "
                + "numerofac, "
                + "tipo "
                + "from transacciones " +
                  " where tipo = 'venta'");

        while(rs.next())
        {
            transaccion p = new transaccion(
                rs.getInt("idtransaccion"),
                rs.getString("nombre"),
                rs.getDate("fecha"),
                rs.getString("numerofac"),
                rs.getString("tipo")
                );
            list.add(p);
          
        }
    }
    catch(Exception e)
    {
        
    }
    return list;
    }
    
    public ArrayList<transaccion> ListarCompras(){
       ArrayList<transaccion> list = new ArrayList();

    try{
        
        Statement stm = conexion.createStatement();
        ResultSet rs = stm.executeQuery("select idtransaccion, "
                + "nombre, "
                + "fecha, "
                + "numerofac, "
                + "tipo "
                + "from transacciones " +
                  " where tipo = 'venta'");

        while(rs.next())
        {
            transaccion p = new transaccion(
                rs.getInt("idtransaccion"),
                rs.getString("nombre"),
                rs.getDate("fecha"),
                rs.getString("numerofac"),
                rs.getString("tipo")
                );
            list.add(p);
          
        }
    }
    catch(Exception e)
    {
        
    }
    return list;
    }
    
    public transaccion getById(String id){
       ArrayList<transaccion> list = new ArrayList();

    try{
        
        Statement stm = conexion.createStatement();
        ResultSet rs = stm.executeQuery("select idtransaccion, "
                + "nombre, "
                + "fecha, "
                + "numerofac, "
                + "tipo "
                + "from transacciones " +
                  " where idtransaccion = "+id);

        while(rs.next())
        {
            transaccion p = new transaccion(
                rs.getInt("idtransaccion"),
                rs.getString("nombre"),
                rs.getDate("fecha"),
                rs.getString("numerofac"),
                rs.getString("tipo")
                );
            list.add(p);
          
        }
    }
    catch(Exception e)
    {
        
    }
    return list.get(0);
    }
}
