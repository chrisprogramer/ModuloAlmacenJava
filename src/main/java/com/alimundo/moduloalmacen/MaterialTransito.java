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

public class MaterialTransito extends javax.swing.JDialog {
    
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
    
    DefaultTableModel modeloprestamo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas <= 3) {
                return false;
            } else {
                return true;
            }
        }
    };
   
    public final void tamanocolumnasprestamo(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(600);
        columnModel.getColumn(3).setPreferredWidth(600);
        columnModel.getColumn(4).setPreferredWidth(150);
    }
    
    public MaterialTransito() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        modeloprestamo.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Id</h3></html>","<html><h3 style=font-family:Verdana;>Codigo</h3></html>","<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>",
                                                         "<html><h3 style=font-family:Verdana;>Responsable</h3></html>","<html><h3 style=font-family:Verdana;>Total</h3></html>"});
        this.tamanocolumnasprestamo(tableprestamo);
        modeloprestamo.setRowCount(0);
        tableprestamo.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
        tableprestamo.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
        tableprestamo.getTableHeader().getColumnModel().getColumn(2).setResizable(true);
        tableprestamo.getTableHeader().getColumnModel().getColumn(3).setResizable(false);
        tableprestamo.getTableHeader().getColumnModel().getColumn(4).setResizable(false);
        tableprestamo.getTableHeader().setReorderingAllowed(false);
        
        this.botonaceptar.setEnabled(false);
        /*try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornamaterialenprestamo");
            rs = ps.executeQuery();
            while(rs.next()){
                 modeloprestamo.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4)});
            }
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttongroupestado = new javax.swing.ButtonGroup();
        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        labelestado = new javax.swing.JLabel();
        radiobuttonabierto = new javax.swing.JRadioButton();
        radiobuttoncerrado = new javax.swing.JRadioButton();
        jScrollPane = new javax.swing.JScrollPane();
        tableprestamo = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        botonaceptar = new javax.swing.JButton();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(745, 387));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("MATERIAL EN PRESTAMO ");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 745, 40));

        labelestado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelestado.setText("Consultar:");
        getContentPane().add(labelestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 48, -1, -1));

        buttongroupestado.add(radiobuttonabierto);
        radiobuttonabierto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radiobuttonabierto.setText("Abiertos");
        radiobuttonabierto.setOpaque(false);
        radiobuttonabierto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radiobuttonabiertoMouseClicked(evt);
            }
        });
        getContentPane().add(radiobuttonabierto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 47, -1, -1));

        buttongroupestado.add(radiobuttoncerrado);
        radiobuttoncerrado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radiobuttoncerrado.setText("Cerrados");
        radiobuttoncerrado.setOpaque(false);
        radiobuttoncerrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radiobuttoncerradoMouseClicked(evt);
            }
        });
        getContentPane().add(radiobuttoncerrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 77, -1, -1));

        tableprestamo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableprestamo.setModel(modeloprestamo);
        tableprestamo.setShowGrid(true);
        jScrollPane.setViewportView(tableprestamo);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 740, 260));

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
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 60, 60));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelfondo.setMaximumSize(new java.awt.Dimension(501, 302));
        labelfondo.setMinimumSize(new java.awt.Dimension(501, 302));
        labelfondo.setPreferredSize(new java.awt.Dimension(501, 302));
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 745, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        seleccionfila = this.tableprestamo.getSelectedRow();
        seleccionid = Integer.parseInt(String.valueOf(modeloprestamo.getValueAt(seleccionfila, 0)));
        seleccioncod = (String) modeloprestamo.getValueAt(seleccionfila, 1);
       
        try {
              reportesalmacen.ReporteHistorialDevoluciones(seleccionid,seleccioncod);
            } catch (JRException | IOException ex) {
                Logger.getLogger(MaterialTransito.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonaceptarActionPerformed

    private void radiobuttonabiertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radiobuttonabiertoMouseClicked
        modeloprestamo.setRowCount(0);
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornamaterialenprestamo ?");
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                modeloprestamo.addRow(new Object[]{rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)});
            }
            if(modeloprestamo.getRowCount() > 0){
                this.botonaceptar.setEnabled(true);
            }
        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }//GEN-LAST:event_radiobuttonabiertoMouseClicked

    private void radiobuttoncerradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radiobuttoncerradoMouseClicked
        modeloprestamo.setRowCount(0);
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornamaterialenprestamo ?");
            ps.setInt(1, 0);
            rs = ps.executeQuery();
            while (rs.next()) {
                modeloprestamo.addRow(new Object[]{rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)});
            }
            if (modeloprestamo.getRowCount() > 0) {
                this.botonaceptar.setEnabled(true);
            }
        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }//GEN-LAST:event_radiobuttoncerradoMouseClicked

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
            java.util.logging.Logger.getLogger(MaterialTransito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaterialTransito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaterialTransito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaterialTransito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaterialTransito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonaceptar;
    private javax.swing.ButtonGroup buttongroupestado;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelestado;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JRadioButton radiobuttonabierto;
    private javax.swing.JRadioButton radiobuttoncerrado;
    public javax.swing.JTable tableprestamo;
    // End of variables declaration//GEN-END:variables
}
