/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Cardona
 */
public class producto {
    Integer codigoP;
    String nombreP;
    double precioV;
    double precioC;
    int existencia;
    
    public producto(){}
    
    public producto(Integer codigoP, String nombreP, double precioV, double precioC,int existencia){
        this.codigoP=codigoP;
        this.nombreP= nombreP;
        this.precioV = precioV;
        this.precioC = precioC;
        this.existencia = existencia;
    }

    public Integer getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(Integer codigoP) {
        this.codigoP = codigoP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double precioC) {
        this.precioC = precioC;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    @Override
    public String toString(){
        return this.nombreP;
    }
}
