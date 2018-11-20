/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author admin
 */
public class detalle {
    private int id;
    private int idTransaccion;
    private int idProducto;
    private double subtotal;
    private int cantidad;
    private String producto;
    private double subtotalCompra;

    public detalle(int id, int idTransaccion, int idProducto, double subtotal, int cantidad, String producto, double subtotalCompra) {
        this.id = id;
        this.idTransaccion = idTransaccion;
        this.idProducto = idProducto;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotalCompra = subtotalCompra;
    }
    
     public detalle(int idTransaccion, int idProducto, int cantidad) {
      
        this.idTransaccion = idTransaccion;
        this.idProducto = idProducto;
        this.cantidad = cantidad;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getSubtotalCompra() {
        return subtotalCompra;
    }

    public void setSubtotalCompra(double subtotalCompra) {
        this.subtotalCompra = subtotalCompra;
    }
    
    
    
}
