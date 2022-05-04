/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import Reportes.ReportesDB;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author AdminSrv
 */
public class MovimientosAlmacen extends javax.swing.JDialog{
    
    String error;
    String seleccion;
    Conexion con = new Conexion();
    ReportesDB reportesalmacen = new ReportesDB();
    String fechaformat = "dd/MM/yyyy";
    SimpleDateFormat dateformat = new SimpleDateFormat(fechaformat);
    int tabbedfocus;
    int cantreg;
    DefaultTableModel modeloentrada = new DefaultTableModel();
    DefaultTableModel modelosalida = new DefaultTableModel();
    DefaultTableModel modelodptofechaentrada = new DefaultTableModel();
    DefaultTableModel modelodptofechasalida = new DefaultTableModel();
    
    public MovimientosAlmacen() {
        initComponents();
        setTitle("MOVIMIENTOS DE ALMACÉN");
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        this.setModal(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPaneMovimientos = new javax.swing.JTabbedPane();
        entradaMaterial = new Paneles.EntradaMaterial();
        salidas = new Paneles.Salidas();
        transferenciaAlmacen = new Paneles.TransferenciaAlmacen();
        botonaceptar = new javax.swing.JButton();
        labelcerrar = new javax.swing.JLabel();
        panelopciones = new javax.swing.JPanel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1230, 530));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setName("dialog()"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1230, 530));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabbedPaneMovimientos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TabbedPaneMovimientos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        entradaMaterial.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        TabbedPaneMovimientos.addTab("Entradas", entradaMaterial);
        TabbedPaneMovimientos.addTab("Salidas", salidas);
        TabbedPaneMovimientos.addTab("Transferencias de Material", transferenciaAlmacen);

        getContentPane().add(TabbedPaneMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 1200, -1));
        TabbedPaneMovimientos.getAccessibleContext().setAccessibleName("");

        botonaceptar.setBackground(new java.awt.Color(0, 0, 0));
        botonaceptar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonaceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonaceptar.setText("Aceptar");
        botonaceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 480, 80, 40));

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, -1, -1));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 570));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 1229, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        int identrada;
        int idsalida;
        String codmaterial;
        String nommaterial;
        String categoria;
        String medida;
        String almacen;
        String fechareq;
        int cant;
        double precio;
        String descripcion;
        String nfactura;
        DetalleEntradas arrayent; 
        ArrayList<DetalleEntradas> entrada;
        entrada = new ArrayList<>();
        entrada.clear();
        DetalleSalidas arraysal;
        ArrayList<DetalleSalidas> salida;
        salida = new ArrayList<>();
        salida.clear();
        int numregent = entradaMaterial.tableentradas.getRowCount();
        int numregsal = salidas.tablesalidas.getRowCount();
        modeloentrada = (DefaultTableModel) entradaMaterial.tableentradas.getModel();
        modelosalida = (DefaultTableModel) salidas.tablesalidas.getModel();
        modelodptofechaentrada = (DefaultTableModel) entradaMaterial.tabledptofecha.getModel();
        modelodptofechasalida = (DefaultTableModel) salidas.tabledptofecha.getModel();
        tabbedfocus = this.TabbedPaneMovimientos.getSelectedIndex();
        fechareq = (String)modelodptofechaentrada.getValueAt(0, 1);
        Object[] textoOpciones = {"Si","No"};
        int opc = JOptionPane.showOptionDialog(null,"<html><h3 style=font-family:Verdana New;>¿Desea Procesar la Entrada?</h3></html>",
            null,JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0){
            switch (tabbedfocus){
                case 0:  if (numregent > 0) {
                            try {
                                PreparedStatement ps = null;
                                ResultSet rs = null;
                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevaentrada ?,?");
                                ps.setString(1, fechareq);
                                ps.setString(2, (String)modelodptofechaentrada.getValueAt(0, 0));
                                rs = ps.executeQuery();
                                if (rs.next()) {
                                    try {
                                        entradaMaterial.labelnid.setText(rs.getString(1));
                                        for (int i = 0; i < numregent; i++) {
                                            identrada = Integer.parseInt(entradaMaterial.labelnid.getText());
                                            codmaterial = (String) modeloentrada.getValueAt(i, 0);
                                            nommaterial = (String) modeloentrada.getValueAt(i, 1);
                                            categoria = (String) modeloentrada.getValueAt(i, 2);
                                            medida = (String) modeloentrada.getValueAt(i, 3);
                                            almacen = (String) modeloentrada.getValueAt(i, 4);
                                            cant = Integer.parseInt((String) modeloentrada.getValueAt(i, 5));
                                            try {
                                                precio = Double.parseDouble((String) modeloentrada.getValueAt(i, 6));
                                            } catch (NullPointerException ex) {
                                                precio = 0.00;
                                            }
                                            descripcion = (String) modeloentrada.getValueAt(i, 7);
                                            nfactura = (String) modeloentrada.getValueAt(i, 8);
                                            arrayent = new DetalleEntradas();
                                            arrayent.setidentrada(identrada);
                                            arrayent.setcodmaterial(codmaterial);
                                            arrayent.setnommaterial(nommaterial);
                                            arrayent.setcategoria(categoria);
                                            arrayent.setmedida(medida);
                                            arrayent.setalmacen(almacen);
                                            arrayent.setcant(cant);
                                            arrayent.setprecio(precio);
                                            arrayent.setdescripcion(descripcion);
                                            arrayent.setnumfactura(nfactura);
                                            entrada.add(arrayent);
                                            }
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotaentrada ?,?,?");
                                                ps.setString(1, (String)modelodptofechaentrada.getValueAt(0, 1));
                                                ps.setString(2, (String)modelodptofechaentrada.getValueAt(0, 0));
                                                ps.setInt(3, Integer.parseInt(entradaMaterial.labelnid.getText()));
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                            for (int i = 0; i < entrada.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("spu_guardadetalleentrada ?,?,?,?,?,?,?,?,?,?");
                                                    ps.setInt(1, entrada.get(i).getidentrada());
                                                    ps.setString(2, entrada.get(i).getcodmaterial());
                                                    ps.setString(3, entrada.get(i).getnommaterial());
                                                    ps.setString(4, entrada.get(i).getcategoria());
                                                    ps.setString(5, entrada.get(i).getmedida());
                                                    ps.setString(6, entrada.get(i).getalmacen());
                                                    ps.setInt(7, entrada.get(i).getcant());
                                                    ps.setDouble(8, entrada.get(i).getprecio());
                                                    ps.setString(9, entrada.get(i).getdescripcion());
                                                    ps.setString(10, entrada.get(i).getnumfactura());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            for (int i = 0; i < entrada.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("spu_guardadetallesnotaentrada ?,?,?,?,?,?,?");
                                                    ps.setString(1, entrada.get(i).getcodmaterial());
                                                    ps.setString(2, entrada.get(i).getcategoria());
                                                    ps.setString(3, entrada.get(i).getmedida());
                                                    ps.setString(4, entrada.get(i).getalmacen());
                                                    ps.setInt(5, entrada.get(i).getcant());
                                                    ps.setDouble(6, entrada.get(i).getprecio());
                                                    ps.setString(7, entrada.get(i).getdescripcion());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            for (int i = 0; i < entrada.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_sumaexistenciamaterial ?,?");
                                                    ps.setString(1, entrada.get(i).getcodmaterial());
                                                    ps.setInt(2, entrada.get(i).getcant());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //
                                                    }
                                                } catch (SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("spu_ejecutarequisicion ?");
                                                ps.setInt(1, PrincipalForm.codreqent);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Entrada Guardada con Exito </h3></html>",
                                                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                                try {
                                                    reportesalmacen.ReporteNotaEntrega(Integer.parseInt(entradaMaterial.labelnid.getText()), Integer.parseInt(entradaMaterial.labelnid.getText()));
                                                } catch (JRException | IOException ex) {
                                                    Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                    } catch (SQLException ex) {
                                        error = ex.getMessage();
                                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                    }        
                                }
                            }catch (SQLException ex) {
                                error = ex.getMessage();
                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                            }
                            modeloentrada.setRowCount(0);
                            modelodptofechaentrada.setRowCount(0);
                            entradaMaterial.labelnid.setText("");
                    }else {
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                    }        
                }    
            }        
    }//GEN-LAST:event_botonaceptarActionPerformed

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
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosAlmacen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane TabbedPaneMovimientos;
    public javax.swing.JButton botonaceptar;
    public Paneles.EntradaMaterial entradaMaterial;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JPanel panelopciones;
    public Paneles.Salidas salidas;
    private Paneles.TransferenciaAlmacen transferenciaAlmacen;
    // End of variables declaration//GEN-END:variables
}
