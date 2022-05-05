/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.moduloalmacen;

/**
 *
 * @author AdminSrv
 */
public class DetalleSalidas {
        
    private int idsalida;
    private String codmaterial;
    private String nommaterial;
    private String categoria;
    private String medida;
    private String almacen;
    private int cant;
    private String descripcion;
    
    public void setidsalida (int idsalida){
       this.idsalida = idsalida;
    }
    
    public int getidsalida() {
        return idsalida;
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
    
    public void setcategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getcategoria() {
        return categoria;
    }
    
    public void setmedida(String medida) {
        this.medida = medida;
    }

    public String getmedida() {
        return medida;
    }
    
    public void setalmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getalmacen() {
        return almacen;
    }
    
    public void setcant (int cant) {
        this.cant = cant;
    }

    public int getcant() {
        return cant;
    }
    
    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getdescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();                                                                   
        sb.append("\nidsalida: ");
        sb.append(idsalida);
        sb.append("\ncodmaterial: ");
        sb.append(codmaterial);
        sb.append("\nnommateria: ");
        sb.append(nommaterial);
        sb.append("\ncategoria: ");
        sb.append(categoria);
        sb.append("\nmedida: ");
        sb.append(medida);
        sb.append("\nalmacen: ");
        sb.append(almacen);
        sb.append("\ncant: ");
        sb.append(cant);
        sb.append("\ndescripcion: ");
        sb.append(descripcion);
        return sb.toString();
    } 
}
