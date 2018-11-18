/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.ProductoAD;
import Entities.producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ProductosBL {
    private ProductoAD product;
    public ProductosBL()
    {
        //try {
            //product = new ProductoAD();
        //} catch (SQLException | ClassNotFoundException ex) {
        //    Logger.getLogger(ProductosBL.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    
    public ArrayList<producto> get() throws SQLException, ClassNotFoundException
    {
        if(product == null)
            product = new ProductoAD();
        return product.Listar();
    }
    
    public void add(producto p)
    {
        try {
            product.Insertar(p);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductosBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 }
