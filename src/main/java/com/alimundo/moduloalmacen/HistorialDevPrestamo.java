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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;

public class HistorialDevPrestamo extends javax.swing.JDialog {
    
    String error;
    String seleccionradio;
    int cantregprest;
    int seleccionfila;
    int seleccionid;
    String seleccioncod;
    TableColumnModel columnModel;
    Conexion con = new Conexion();
    ReportesDB reportesalmacen = new ReportesDB();
    ValidarDatos validardatos = new ValidarDatos();
    
    DefaultTableModel modelohistorial = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas <= 5) {
                return false;
            } else {
                return true;
            }
        }
    };
   
    public final void tamanocolumnashistorial(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(300);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(600);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(600);
    }
    
    public HistorialDevPrestamo(int idprestamo, String codmaterial) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        modelohistorial.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Fecha Dev.</h3></html>","<html><h3 style=font-family:Verdana;>Codigo</h3></html>",
                                                          "<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>","<html><h3 style=font-family:Verdana;>Cant.</h3></html>",
                                                          "<html><h3 style=font-family:Verdana;>Cant. Dev.</h3></html>","<html><h3 style=font-family:Verdana;>Devuelve</h3></html>"});
        this.tamanocolumnashistorial(tablehistorial);
        modelohistorial.setRowCount(0);
        tablehistorial.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
        tablehistorial.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
        tablehistorial.getTableHeader().getColumnModel().getColumn(2).setResizable(true);
        tablehistorial.getTableHeader().getColumnModel().getColumn(3).setResizable(false);
        tablehistorial.getTableHeader().getColumnModel().getColumn(4).setResizable(false);
        tablehistorial.getTableHeader().getColumnModel().getColumn(5).setResizable(false);
        tablehistorial.getTableHeader().setReorderingAllowed(false);
        
        this.botonaceptar.setEnabled(false);
        
         try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_historialdevprestamo ?,?");
            ps.setInt(1, idprestamo);
            ps.setString(2, codmaterial);
            rs = ps.executeQuery();
            while (rs.next()) {
                modelohistorial.addRow(new Object[]{rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6)});
            }
            if(modelohistorial.getRowCount() > 0){
                this.botonaceptar.setEnabled(true);
            }
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornaresponsable ?");
            ps.setInt(1, idprestamo);
            rs = ps.executeQuery();
            while (rs.next()) {
                this.textfieldresponsable.setText(rs.getString(1));
            }
        }catch(SQLException ex){
           error = ex.getMessage();
           JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }catch(java.lang.ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Dede Seleccionar un Registro</h3></html>",
                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttongroupestado = new javax.swing.ButtonGroup();
        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        labelresponsable = new javax.swing.JLabel();
        textfieldresponsable = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        tablehistorial = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        botonaceptar = new javax.swing.JButton();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(951, 451));
        setMinimumSize(new java.awt.Dimension(951, 451));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(951, 451));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("HISTORIAL DE DEVOLUCIONES");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        labelresponsable.setBackground(new java.awt.Color(255, 255, 255));
        labelresponsable.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelresponsable.setText("Responsable");
        labelresponsable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelresponsable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(labelresponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        textfieldresponsable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfieldresponsable.setEnabled(false);
        getContentPane().add(textfieldresponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 210, 30));

        tablehistorial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablehistorial.setModel(modelohistorial);
        tablehistorial.setShowGrid(true);
        jScrollPane.setViewportView(tablehistorial);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 910, 260));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 410));

        botonaceptar.setBackground(new java.awt.Color(255, 255, 255));
        botonaceptar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonaceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/file_pdf_icon_188248.png"))); // NOI18N
        botonaceptar.setToolTipText("");
        botonaceptar.setBorder(null);
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, 60, 60));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelfondo.setMaximumSize(new java.awt.Dimension(501, 302));
        labelfondo.setMinimumSize(new java.awt.Dimension(501, 302));
        labelfondo.setPreferredSize(new java.awt.Dimension(501, 302));
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try{
            try {
                reportesalmacen.ReporteHistorialDevoluciones(PrincipalForm.idprestamostc,PrincipalForm.codmaterialstc);
            } catch (JRException | IOException ex) {
                Logger.getLogger(HistorialDevPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            } 

        }catch(java.lang.ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Dede Seleccionar un Registro</h3></html>",
                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
            java.util.logging.Logger.getLogger(HistorialDevPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialDevPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialDevPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialDevPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialDevPrestamo(PrincipalForm.idprestamostc,PrincipalForm.codmaterialstc).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonaceptar;
    private javax.swing.ButtonGroup buttongroupestado;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelresponsable;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    public javax.swing.JTable tablehistorial;
    private javax.swing.JTextField textfieldresponsable;
    // End of variables declaration//GEN-END:variables
}
