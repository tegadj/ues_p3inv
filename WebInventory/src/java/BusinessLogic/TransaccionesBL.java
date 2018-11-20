/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.TransactionAD;
import Entities.detalle;
import Entities.transaccion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class TransaccionesBL {
    private TransactionAD tran;
    public TransaccionesBL()
    {
        try {
            tran = new TransactionAD();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionesBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransaccionesBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<transaccion> getCompras()
    {
        return tran.ListarCompras();
    }
    
     public ArrayList<transaccion> getVentas()
    {
        return tran.ListarVentas();
    }
    
    public ArrayList<detalle> getDetails(String id)
    {
        return tran.getDetails(id);
    }
    
    public void insert(transaccion o)
    {
        try {
            tran.Insertar(o);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TransaccionesBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addDetail(detalle d)
    {
        try {
            tran.AddDetails(d);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TransaccionesBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
