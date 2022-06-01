/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.moduloalmacen;

/**
 *
 * @author AdminSrv
 */
public class DetallePrestamos {
    private int idprestamo;
    private String codmaterial;
    private String nommaterial;
    private double cant;
    private String motivo;
    private String responsable;

    public void setidprestamo (int idprestamo){
       this.idprestamo = idprestamo;
    }
    
    public int getidprestamo() {
        return idprestamo;
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

    public void setmotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getmotivo() {
        return motivo;
    }

    public void setresponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getresponsable() {
        return responsable;
    }
}
