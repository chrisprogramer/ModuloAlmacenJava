/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.moduloalmacen;

/**
 *
 * @author AdminSrv
 */
public class DetalleDevPrestamos {
    private int iddevprestamo;
    private String codmaterial;
    private String nommaterial;
    private double cant;
    private double cantdev;
    private String devuelve;

    public void setiddevprestamo (int iddevprestamo){
       this.iddevprestamo = iddevprestamo;
    }
    
    public int getiddevprestamo() {
        return iddevprestamo;
    }
    
    public void setcodmaterial(String codmaterial) {
        this.codmaterial = codmaterial;
    }

    public String getcodmaterial() {
        return codmaterial;
    }
    
    public void setnommaterial(String nommaterial) {
        this.nommaterial = nommaterial;
    }

    public String getnommaterial() {
        return nommaterial;
    }
   
    public void setcant (double cant) {
        this.cant = cant;
    }

    public double getcant() {
        return cant;
    }
    
    public void setcantdev (double cantdev) {
        this.cantdev = cantdev;
    }

    public double getcantdev() {
        return cantdev;
    }
    
    public void setdevuelve(String devuelve) {
        this.devuelve = devuelve;
    }

    public String getdevuelve() {
        return devuelve;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();                                                                   
        sb.append("\niddevprestamo: ");
        sb.append(iddevprestamo);
        sb.append("\ncodmaterial: ");
        sb.append(codmaterial);
        sb.append("\nnommateria: ");
        sb.append(nommaterial);
        sb.append("\ncategoria: ");
        sb.append("\ncant: ");
        sb.append(cant);
        sb.append("\ncantdev: ");
        sb.append(cantdev);
        sb.append("\ndevuelve: ");
        sb.append(devuelve);
        return sb.toString();
    } 

}
