/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import Paneles.EntradaMaterial;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RequisicionesEntradas extends javax.swing.JDialog{
    
    String error;
    Conexion con = new Conexion();
    int seleccionrow;
    MovimientosAlmacen movimientos = new MovimientosAlmacen();
    PrincipalForm principal = new PrincipalForm();
    EntradaMaterial entradamaterial = new EntradaMaterial();
    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
    public static DefaultTableModel modelorequisicion = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 2){
                return false;
            }else return true;
        } 
    };

    public RequisicionesEntradas() {
        initComponents();
        modelorequisicion.setColumnIdentifiers(new Object[]{"","",""});
        if (tablerequisiciones.getColumnModel().getColumnCount() > 0) {
            tablerequisiciones.getColumnModel().getColumn(0).setHeaderValue("<html><h4 style=font-family:Verdana;>Id Requisicion</h4></html>");
            tablerequisiciones.getColumnModel().getColumn(0).setPreferredWidth(160);
            tablerequisiciones.getColumnModel().getColumn(0).setMaxWidth(160);
            tablerequisiciones.getColumnModel().getColumn(0).setResizable(false);
            tablerequisiciones.getColumnModel().getColumn(1).setHeaderValue("<html><center><h4 style=font-family:Verdana;>Fecha de Solicitud</h4></html>");
            tablerequisiciones.getColumnModel().getColumn(1).setPreferredWidth(200);
            tablerequisiciones.getColumnModel().getColumn(1).setMaxWidth(200);
            tablerequisiciones.getColumnModel().getColumn(1).setResizable(false);
            tablerequisiciones.getColumnModel().getColumn(2).setHeaderValue("<html><h4 style=font-family:Verdana;>Dpto. Solicitante</h4></html>");
            tablerequisiciones.getColumnModel().getColumn(2).setPreferredWidth(400);
            tablerequisiciones.getColumnModel().getColumn(2).setMaxWidth(400);
            tablerequisiciones.getColumnModel().getColumn(2).setResizable(false);
        }
        tablerequisiciones.getTableHeader().setReorderingAllowed(false);
        modelorequisicion.setRowCount(0);
        setLocationRelativeTo(null);
        this.setModal(true);

        try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatosrequisicionentrada");
            rs = ps.executeQuery();
            while(rs.next()){
                 modelorequisicion.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3)});
            }
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.tablerequisiciones.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltitulo = new javax.swing.JLabel();
        labelcerrar = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tablerequisiciones = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("REQUISICIONES");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 200, -1));

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 4, -1, -1));

        tablerequisiciones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tablerequisiciones.setModel(modelorequisicion);
        tablerequisiciones.setShowGrid(true);
        tablerequisiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablerequisicionesMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(tablerequisiciones);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 500, 290));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 340));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void tablerequisicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablerequisicionesMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (evt.getClickCount() == 2) {
            String codigo;
            String nommat;
            String categoria;
            String medida;
            String almacen;
            int cant;
            String dpto;
            String fecha;
            seleccionrow = tablerequisiciones.getSelectedRow();
            PrincipalForm.codreqent = (int) modelorequisicion.getValueAt(seleccionrow, 0);
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadetallerequisicion ?");
                ps.setInt(1, (int) modelorequisicion.getValueAt(seleccionrow, 0));
                rs = ps.executeQuery();
                while (rs.next()) {
                    codigo = rs.getString(1);
                    nommat = rs.getString(2);
                    categoria = rs.getString(3);
                    medida = rs.getString(4);
                    almacen = rs.getString(5);
                    cant = rs.getInt(6);
                    movimientos.entradaMaterial.modeloentrada.addRow(new Object[]{codigo, nommat, categoria, medida,almacen,String.valueOf(cant)});
                }
                ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornafechadptorequisiciones ?");
                ps.setInt(1, (int) modelorequisicion.getValueAt(seleccionrow, 0));
                rs = ps.executeQuery();
                while (rs.next()) {
                    dpto = rs.getString(1);
                    fecha = rs.getString(2);
                    movimientos.entradaMaterial.modelodptofecha.addRow(new Object[]{dpto, fecha});
                }
            } catch (SQLException ex) {
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            }
            this.dispose();
        }
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tablerequisicionesMouseClicked
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
            java.util.logging.Logger.getLogger(RequisicionesEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequisicionesEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequisicionesEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequisicionesEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequisicionesEntradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    public javax.swing.JTable tablerequisiciones;
    // End of variables declaration//GEN-END:variables
}
