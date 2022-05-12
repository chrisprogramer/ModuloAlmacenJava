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
    private int cant;

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
   
    public void setcant (int cant) {
        this.cant = cant;
    }

    public int getcant() {
        return cant;
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
        return sb.toString();
    } 

}
