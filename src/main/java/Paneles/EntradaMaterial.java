/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import com.alimundo.moduloalmacen.Conexion;
import com.alimundo.moduloalmacen.EntradaManual;
import com.alimundo.moduloalmacen.Parametros;
import com.alimundo.moduloalmacen.RequisicionesEntradas;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author AdminSrv
 */
public class EntradaMaterial extends javax.swing.JPanel {
    
    public static DefaultTableModel modelodptofecha = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 2){
                return false;
            }else return true;
        }
    };
    public static DefaultTableModel modeloentrada = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 5){
                return false;
            }else return true;
        }
    };
    TableColumnModel columnModel;
    Conexion con = new Conexion();
    String error;
    Date fechahoy;
    String fechaformat = "dd/MM/yyyy";
    JTextFieldDateEditor editor;
   
    public final void tamanocolumnasentradas(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(900);
        columnModel.getColumn(2).setPreferredWidth(500);
        columnModel.getColumn(3).setPreferredWidth(400);
        columnModel.getColumn(4).setPreferredWidth(400);
        columnModel.getColumn(5).setPreferredWidth(200);
        columnModel.getColumn(6).setPreferredWidth(400);
        columnModel.getColumn(7).setPreferredWidth(900);
        columnModel.getColumn(8).setPreferredWidth(400);
    }
    
        public final void tamanocolumnasdptofecha(JTable table){
            columnModel = table.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(900);
            columnModel.getColumn(1).setPreferredWidth(600);
            
        }
    public EntradaMaterial() {
        initComponents();
         modeloentrada.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Codigo</h3></html>","<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>",
                                            "<html><h3 style=font-family:Verdana;>Categoria</h3></html>","<html><h3 style=font-family:Verdana;>Medida</h3></html>",
                                            "<html><h3 style=font-family:Verdana;>Almacén</h3></html>","<html><h3 style=font-family:Verdana;>Cant.</h3></html>",
                                            "<html><h3 style=font-family:Verdana;>Precio</h3></html>","<html><h3 style=font-family:Verdana;>Descripción</h3></html>"
                                            ,"<html><h3 style=font-family:Verdana;>N° Factura</h3></html>"});
        this.tamanocolumnasentradas(tableentradas);
        modeloentrada.setRowCount(0);
        tableentradas.getTableHeader().setReorderingAllowed(false);
        tableentradas.getTableHeader().setResizingAllowed(false);
        
        modelodptofecha.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Entrega Departamento</h3></html>",
                                                "<html><h3 style=font-family:Verdana;>Fecha Requisición</h3></html>"});
        this.tamanocolumnasdptofecha(tabledptofecha);
        modelodptofecha.setRowCount(0);
        tabledptofecha.getTableHeader().setReorderingAllowed(false);
        tabledptofecha.getTableHeader().setResizingAllowed(false);
        ((DefaultTableCellRenderer) tabledptofecha.getTableHeader().getDefaultRenderer())
                       .setHorizontalAlignment(SwingConstants.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltitulo = new javax.swing.JLabel();
        labelnid = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        botoncargareq = new javax.swing.JButton();
        botonentradamanual = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tableentradas = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledptofecha = new javax.swing.JTable();
        labelfondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1189, 419));
        setMinimumSize(new java.awt.Dimension(1189, 419));
        setPreferredSize(new java.awt.Dimension(1189, 419));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("ENTRADAS AL ALMACÉN");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 290, -1));

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 44, 50, 40));

        labelid.setBackground(new java.awt.Color(255, 255, 255));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Entrada");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1086, 20, -1, -1));

        botoncargareq.setBackground(new java.awt.Color(0, 0, 0));
        botoncargareq.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botoncargareq.setForeground(new java.awt.Color(255, 255, 255));
        botoncargareq.setText("Cargar Requisición");
        botoncargareq.setBorder(null);
        botoncargareq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncargareqActionPerformed(evt);
            }
        });
        add(botoncargareq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 40));

        botonentradamanual.setBackground(new java.awt.Color(0, 0, 0));
        botonentradamanual.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonentradamanual.setForeground(new java.awt.Color(255, 255, 255));
        botonentradamanual.setText("Entrada Manual");
        botonentradamanual.setBorder(null);
        botonentradamanual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonentradamanualActionPerformed(evt);
            }
        });
        add(botonentradamanual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 40));

        tableentradas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableentradas.setModel(modeloentrada);
        tableentradas.setShowGrid(true);
        tableentradas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableentradasKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tableentradas);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1170, 290));

        tabledptofecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tabledptofecha.setModel(modelodptofecha);
        jScrollPane1.setViewportView(tabledptofecha);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 400, 70));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 420));
    }// </editor-fold>//GEN-END:initComponents
    
    private void botoncargareqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncargareqActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new RequisicionesEntradas().setVisible(true);
        tamanocolumnasentradas(tableentradas);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botoncargareqActionPerformed

    private void tableentradasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableentradasKeyPressed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (tableentradas.getSelectedRowCount() > 0) {
                modeloentrada.removeRow(tableentradas.getSelectedRow());
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Seleccionar un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
            }
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tableentradasKeyPressed

    private void botonentradamanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonentradamanualActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new EntradaManual().setVisible(true);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonentradamanualActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncargareq;
    private javax.swing.JButton botonentradamanual;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltitulo;
    public javax.swing.JTable tabledptofecha;
    public javax.swing.JTable tableentradas;
    // End of variables declaration//GEN-END:variables
}
