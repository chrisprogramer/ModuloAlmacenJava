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
    public static int codreqent;
       
    public PrincipalForm() {
        //this.BarMenu = new Menus();
        UIManager.put("Button.font", new Font("Verdana",Font.BOLD,14));
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        
        Reloj reloj = new Reloj(1400,630,140,20);
        reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloj.setFont(new java.awt.Font(letra,1,16));
        add(reloj);
        
        Fecha fecha = new Fecha(5,630,180,20);
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fecha.setFont(new java.awt.Font(letra,1,16));
        add(fecha);        

        initComponents();
        setSize(1511, 665);
        setResizable(false);
        setLocationRelativeTo(null);
        
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
        labelreportes2 = new javax.swing.JLabel();
        labellogo = new javax.swing.JLabel();
        panelopciones = new javax.swing.JPanel();
        labelicono = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1511, 665));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1920, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 1920, 10));

        verbd.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        verbd.setText("Ver. Base de Datos:");
        getContentPane().add(verbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, -1, -1));

        labelnbd.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelnbd.setPreferredSize(new java.awt.Dimension(10, 10));
        getContentPane().add(labelnbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 630, 80, 20));
        labelnbd.getAccessibleContext().setAccessibleName("labelnverbd");

        labelempresa.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        labelempresa.setText("Empresa:");
        getContentPane().add(labelempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 630, -1, -1));

        labelnomempresa.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelnomempresa.setPreferredSize(new java.awt.Dimension(10, 10));
        getContentPane().add(labelnomempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 630, 140, 20));

        panelmainmenu.setBackground(new java.awt.Color(255, 255, 255));
        panelmainmenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelmainmenu.setDoubleBuffered(false);
        panelmainmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/power_on_off_switch_exit_icon_141963.png"))); // NOI18N
        botonsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonsalirActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        botonmovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/trolley3_122342.png"))); // NOI18N
        botonmovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmovimientosActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonmovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 60, 60));

        botonentradamaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/diagram-60_24457.png"))); // NOI18N
        botonentradamaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonentradamaterialActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonentradamaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 60, 60));

        botonreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/file_pdf_icon_188248.png"))); // NOI18N
        botonreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonreportesActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonreportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 60, 60));

        botonayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/Help_icon-icons.com_55891.png"))); // NOI18N
        botonayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonayudaActionPerformed(evt);
            }
        });
        panelmainmenu.add(botonayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 60, 60));

        labelsalir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelsalir.setText("Salir ");
        panelmainmenu.add(labelsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        labelmovimiento1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelmovimiento1.setText("Movimientos");
        panelmainmenu.add(labelmovimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 60, -1, -1));

        labelmovimiento2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelmovimiento2.setText("de Almacén");
        labelmovimiento2.setToolTipText("");
        panelmainmenu.add(labelmovimiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        labelingresamaterial.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelingresamaterial.setText("Materiales");
        panelmainmenu.add(labelingresamaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 60, -1, -1));

        labelayuda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelayuda.setText("Acerca de");
        panelmainmenu.add(labelayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 60, -1, -1));

        labelreportes1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelreportes1.setText("Consultas");
        panelmainmenu.add(labelreportes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 60, -1, -1));

        labelreportes2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelreportes2.setText("y Reportes");
        panelmainmenu.add(labelreportes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 70, -1, 20));

        getContentPane().add(panelmainmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1480, 90));

        labellogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO ALIMUNDO PEQUE.png"))); // NOI18N
        getContentPane().add(labellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 475, 420, 100));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 1000));

        labelicono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/Palet-Boxes_35544.png"))); // NOI18N
        getContentPane().add(labelicono, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 0, 50, 40));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("MODULO MANEJO DE ALMACEN");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1511, 40));

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
        new MovimientosAlmacen().setVisible(true);
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonmovimientosActionPerformed

    private void botonentradamaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonentradamaterialActionPerformed
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        new NuevoMaterial().setVisible(true);
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
    private javax.swing.JLabel labelicono;
    private javax.swing.JLabel labelingresamaterial;
    private javax.swing.JLabel labellogo;
    private javax.swing.JLabel labelmovimiento1;
    private javax.swing.JLabel labelmovimiento2;
    private javax.swing.JLabel labelnbd;
    private javax.swing.JLabel labelnomempresa;
    private javax.swing.JLabel labelreportes1;
    private javax.swing.JLabel labelreportes2;
    private javax.swing.JLabel labelsalir;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelmainmenu;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JLabel verbd;
    // End of variables declaration//GEN-END:variables
}
