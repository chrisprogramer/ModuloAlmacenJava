/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.moduloalmacen;


public class DetalleTransferencias {
    
    private int idtransferencia;
    private String codmaterial;
    private String nommaterial;
    private String medida;
    private String almacenori;
    private String almacendes;
    private String motivo;
    
     public void setidtransferencia (int idtransferencia){
       this.idtransferencia = idtransferencia;
    }
    
    public int getidtransferencia() {
        return idtransferencia;
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
    
    public void setmedida(String medida) {
        this.medida = medida;
    }

    public String getmedida() {
        return medida;
    }
    
    public void setalmacenori(String almacenori) {
        this.almacenori = almacenori;
    }

    public String getalmacenori() {
        return almacenori;
    }
    
    public void setalmacendes(String almacendes) {
        this.almacendes = almacendes;
    }

    public String getalmacendes() {
        return almacendes;
    }
    
    public void setmotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getmotivo() {
        return motivo;
    }
}
