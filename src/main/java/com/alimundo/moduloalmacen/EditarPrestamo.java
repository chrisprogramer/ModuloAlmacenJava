/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import java.awt.Cursor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class EditarPrestamo extends javax.swing.JDialog {
    TableColumnModel columnModel;
    Conexion con = new Conexion();
    String error;
    int cantregreq;
    int seleccion;
    
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
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(250);
        columnModel.getColumn(2).setPreferredWidth(500);
    }
    
    public EditarPrestamo() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        modeloprestamo.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Id.</h3></html>","<html><h3 style=font-family:Verdana;>Fecha</h3></html>",
                                            "<html><h3 style=font-family:Verdana;>Departamento</h3></html>"});
        this.tamanocolumnasprestamo(tableprestamo);
        modeloprestamo.setRowCount(0);
        tableprestamo.getTableHeader().setReorderingAllowed(false);
        tableprestamo.getTableHeader().setResizingAllowed(false);
        
         try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatosprestamos");
            rs = ps.executeQuery();
            while(rs.next()){
                 modeloprestamo.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3)});
            }
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tableprestamo = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        botonaceptar = new javax.swing.JButton();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(501, 250));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText(" SELECCIONAR PRESTAMO");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, 40));

        tableprestamo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableprestamo.setModel(modeloprestamo);
        jScrollPane.setViewportView(tableprestamo);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 190));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 270));

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/accept_allow_admit_okay_icon_141954.png"))); // NOI18N
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 243, 60, 60));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelfondo.setMaximumSize(new java.awt.Dimension(501, 302));
        labelfondo.setMinimumSize(new java.awt.Dimension(501, 302));
        labelfondo.setPreferredSize(new java.awt.Dimension(501, 302));
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        seleccion = this.tableprestamo.getSelectedRow();
        PrincipalForm.idprest = (int) modeloprestamo.getValueAt(seleccion, 0);
        new CerrarPrestamoMaterial().setVisible(true);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.dispose();
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
            java.util.logging.Logger.getLogger(EditarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonaceptar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    public javax.swing.JTable tableprestamo;
    // End of variables declaration//GEN-END:variables
}
