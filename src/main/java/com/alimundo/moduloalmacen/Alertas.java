/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import static Paneles.PrestamoMaterial.modeloprestamo;
import Reportes.ReportesDB;
import java.awt.Color;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;

public class Alertas extends javax.swing.JDialog {
    
    String error;
    int cantregprest;
    int seleccion;
    TableColumnModel columnModel;
    Conexion con = new Conexion();
    ReportesDB reportesalmacen = new ReportesDB();
    DefaultTableCellRenderer colorletra = new DefaultTableCellRenderer();
    FormatoTablas formatotablas = new FormatoTablas();
    DefaultTableModel modeloalerta = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas <= 4) {
                return false;
            } else {
                return true;
            }
        }
    };
   
    public final void tamanocolumnasalertas(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(500);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(150);
    }
    
    public Alertas() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        modeloalerta.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Codigo</h3></html>","<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>",
                                                         "<html><h3 style=font-family:Verdana;>Tope Minimo</h3></html>","<html><h3 style=font-family:Verdana;>En Stock</h3></html>"});
        this.tamanocolumnasalertas(tablealertas);
        modeloalerta.setRowCount(0);
        tablealertas.getTableHeader().setReorderingAllowed(false);
        tablealertas.getTableHeader().setResizingAllowed(false);
        
         try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornaalertasmateriales");
            rs = ps.executeQuery();
            while(rs.next()){
                 modeloalerta.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)});
            }
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        colorletra.setForeground(Color.RED);
         /*(DefaultTableCellRenderer) tablealertas.getColumn(3).getCsetCellRenderer(colorletra); 
        getTableHeader().getDefaultRenderer())
                       .setHorizontalAlignment(SwingConstants.CENTER); */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tablealertas = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        botonaceptar = new javax.swing.JButton();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(501, 307));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("ALERTAS DE MATERIALES");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 562, 40));

        tablealertas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablealertas.setModel(modeloalerta);
        tablealertas.setShowGrid(true);
        jScrollPane.setViewportView(tablealertas);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 560, 190));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 270));

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
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 243, 60, 60));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelfondo.setMaximumSize(new java.awt.Dimension(501, 302));
        labelfondo.setMinimumSize(new java.awt.Dimension(501, 302));
        labelfondo.setPreferredSize(new java.awt.Dimension(501, 302));
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 563, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
          try {
              reportesalmacen.ReporteAlertaMaterial();
            } catch (JRException | IOException ex) {
                Logger.getLogger(Alertas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonaceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alertas().setVisible(true);
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
    public javax.swing.JTable tablealertas;
    // End of variables declaration//GEN-END:variables
}
