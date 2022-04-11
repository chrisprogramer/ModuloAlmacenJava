package com.alimundo.moduloalmacen;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Christian Zerpa
 */

public class PrincipalForm extends javax.swing.JFrame {

    String letra = "Verdana";
    Image icono;
    Conexion con = new Conexion();
    String error;
    Menus BarMenu = new Menus();
    JMenuBar mainmenu;
    
    public PrincipalForm() {
        
        //this.BarMenu = new Menus();
        UIManager.put("Button.font", new Font("Verdana",Font.BOLD,14));
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        
        Reloj reloj = new Reloj(1775,960,140,20);
        reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloj.setFont(new java.awt.Font(letra,1,16));
        add(reloj);
        
        Fecha fecha = new Fecha(5,960,180,20);
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fecha.setFont(new java.awt.Font(letra,1,16));
        add(fecha);        

        initComponents();
        setTitle(" MODULO ALMACEN");
        setSize(1920,1038);
        setResizable(false);
        
        icono = new Parametros().getIconImagePrincipalForm();
        setIconImage(icono);
        
        /*mainmenu = BarMenu.CreaMenuPrincipal();
        mainmenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setJMenuBar(mainmenu);*/
        
        try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_verBD");
            rs = ps.executeQuery();
            while (rs.next()){
                this.labelnbd.setText(rs.getString(1));
            }ps.close();
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_nomempresa");
            rs = ps.executeQuery();
            while (rs.next()){
                this.labelnomempresa.setText(rs.getString(1));
            }ps.close();
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        verbd = new javax.swing.JLabel();
        labelnbd = new javax.swing.JLabel();
        labelempresa = new javax.swing.JLabel();
        labelnomempresa = new javax.swing.JLabel();
        panelmainmenu = new javax.swing.JPanel();
        botonsalir = new javax.swing.JButton();
        botonmovimientos = new javax.swing.JButton();
        botonentradamaterial = new javax.swing.JButton();
        botonreportes = new javax.swing.JButton();
        botonayuda = new javax.swing.JButton();
        labelsalir = new javax.swing.JLabel();
        labelmovimiento1 = new javax.swing.JLabel();
        labelmovimiento2 = new javax.swing.JLabel();
        labelingresamaterial = new javax.swing.JLabel();
        labelayuda = new javax.swing.JLabel();
        labelreportes1 = new javax.swing.JLabel();
        labellogo = new javax.swing.JLabel();
        panelopciones = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1920, 1038));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 950, 1920, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 990, 1920, 10));

        verbd.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        verbd.setText("Ver. Base de Datos:");
        getContentPane().add(verbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 960, -1, -1));

        labelnbd.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelnbd.setPreferredSize(new java.awt.Dimension(10, 10));
        getContentPane().add(labelnbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 960, 80, 20));
        labelnbd.getAccessibleContext().setAccessibleName("labelnverbd");

        labelempresa.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        labelempresa.setText("Empresa:");
        getContentPane().add(labelempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 960, -1, -1));

        labelnomempresa.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelnomempresa.setPreferredSize(new java.awt.Dimension(10, 10));
        getContentPane().add(labelnomempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 960, 140, 20));

        panelmainmenu.setOpaque(false);
        panelmainmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/exit.png"))); // NOI18N
        botonsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonsalirActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 80));

        botonmovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/warehouse.png"))); // NOI18N
        botonmovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmovimientosActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonmovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 80, 80));

        botonentradamaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/archive.png"))); // NOI18N
        botonentradamaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonentradamaterialActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonentradamaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 80, 80));

        botonreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/reporte.png"))); // NOI18N
        botonreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonreportesActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonreportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 80, 80));

        botonayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/questions.png"))); // NOI18N
        botonayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonayudaActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 80, 80));

        labelsalir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelsalir.setText("Salir ");
        panelmainmenu.add(labelsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        labelmovimiento1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelmovimiento1.setText("Movimientos");
        panelmainmenu.add(labelmovimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        labelmovimiento2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelmovimiento2.setText("de Almacén");
        labelmovimiento2.setToolTipText("");
        panelmainmenu.add(labelmovimiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        labelingresamaterial.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelingresamaterial.setText("Materiales");
        panelmainmenu.add(labelingresamaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 80, -1, -1));

        labelayuda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelayuda.setText("Acerca de");
        panelmainmenu.add(labelayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        labelreportes1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelreportes1.setText("Consultas");
        panelmainmenu.add(labelreportes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        getContentPane().add(panelmainmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 110));

        labellogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO ALIMUNDO PEQUE.png"))); // NOI18N
        getContentPane().add(labellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 790, 420, 100));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 1040));

        fondo.setBackground(new java.awt.Color(153, 204, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1930, 1040));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonsalirActionPerformed
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        Object[] textoOpciones = {"Si","No"};
        int opc = JOptionPane.showOptionDialog(this,"<html><h3 style=font-family:Verdana;>¿Desea salir del Modulo Almacén?</h3></html>",
            "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0)
            System.exit(0);
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonsalirActionPerformed

    private void botonmovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmovimientosActionPerformed
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        new Movimientos().setVisible(true);
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonmovimientosActionPerformed

    private void botonentradamaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonentradamaterialActionPerformed
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        new EntradaMaterial().setVisible(true);
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonentradamaterialActionPerformed

    private void botonreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonreportesActionPerformed
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        new Consultas().setVisible(true);
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonreportesActionPerformed

    private void botonayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonayudaActionPerformed
       this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
       new Ayuda().setVisible(true);
       this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonayudaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonayuda;
    private javax.swing.JButton botonentradamaterial;
    private javax.swing.JButton botonmovimientos;
    private javax.swing.JButton botonreportes;
    private javax.swing.JButton botonsalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelayuda;
    private javax.swing.JLabel labelempresa;
    private javax.swing.JLabel labelingresamaterial;
    private javax.swing.JLabel labellogo;
    private javax.swing.JLabel labelmovimiento1;
    private javax.swing.JLabel labelmovimiento2;
    private javax.swing.JLabel labelnbd;
    private javax.swing.JLabel labelnomempresa;
    private javax.swing.JLabel labelreportes1;
    private javax.swing.JLabel labelsalir;
    private javax.swing.JPanel panelmainmenu;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JLabel verbd;
    // End of variables declaration//GEN-END:variables
}
