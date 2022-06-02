/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.moduloalmacen;

/**
 *
 * @author AdminSrv
 */
public class DetalleEntradas {
    
    private int identrada;
    private String codmaterial;
    private String nommaterial;
    private String categoria;
    private String medida;
    private String almacen;
    private double cant;
    private double precio;
    private String descripcion;
    private String numfactura;
    private String container;
    
    public void setidentrada (int identrada){
       this.identrada = identrada;
    }
    
    public int getidentrada() {
        return identrada;
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
    
    public void setcant (double cant) {
        this.cant = cant;
    }

    public double getcant() {
        return cant;
    }
    
    public void setprecio (double precio) {
        this.precio = precio;
    }

    public double getprecio() {
        return precio;
    }
    
    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getdescripcion() {
        return descripcion;
    }
    
    public void setnumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public String getnumfactura() {
        return numfactura;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();                                                                   
        sb.append("\nidentrada: ");
        sb.append(identrada);
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
        sb.append("\nnumfactura: ");
        sb.append(numfactura);
        return sb.toString();
    }   
}