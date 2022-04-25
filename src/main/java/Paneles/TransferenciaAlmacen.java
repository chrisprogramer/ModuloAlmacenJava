/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import com.alimundo.moduloalmacen.CargarComponentes;
import com.alimundo.moduloalmacen.Conexion;
import com.alimundo.moduloalmacen.Parametros;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class TransferenciaAlmacen extends javax.swing.JPanel {

     DefaultTableModel modelotransferencia = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 3){
                return false;
            }else return true;
        } 
    };
    Conexion con = new Conexion();
    String error;
    Date fechahoy;
    String fechaformat = "dd/MM/yyyy";
    JTextFieldDateEditor editor;
    
    public TransferenciaAlmacen() {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        
        initComponents();
        modelotransferencia.setColumnIdentifiers(new Object[]{"","","","","",""});
        
        if (tablatransferencia.getColumnModel().getColumnCount() > 0) {

            tablatransferencia.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Codigo</h3></html>");
            tablatransferencia.getColumnModel().getColumn(0).setPreferredWidth(250);
            tablatransferencia.getColumnModel().getColumn(0).setMaxWidth(250);
            tablatransferencia.getColumnModel().getColumn(0).setResizable(false);
            tablatransferencia.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>");
            tablatransferencia.getColumnModel().getColumn(1).setPreferredWidth(900);
            tablatransferencia.getColumnModel().getColumn(1).setMaxWidth(900);
            tablatransferencia.getColumnModel().getColumn(1).setResizable(false);
            tablatransferencia.getColumnModel().getColumn(2).setHeaderValue("<html><h3 style=font-family:Verdana;>Medida</h3></html>");
            tablatransferencia.getColumnModel().getColumn(2).setPreferredWidth(400);
            tablatransferencia.getColumnModel().getColumn(2).setMaxWidth(400);
            tablatransferencia.getColumnModel().getColumn(2).setResizable(false);
            tablatransferencia.getColumnModel().getColumn(3).setHeaderValue("<html><h3 style=font-family:Verdana;>Almacén Origen</h3></html>");
            tablatransferencia.getColumnModel().getColumn(3).setPreferredWidth(400);
            tablatransferencia.getColumnModel().getColumn(3).setMaxWidth(400);
            tablatransferencia.getColumnModel().getColumn(3).setResizable(false);
            tablatransferencia.getColumnModel().getColumn(4).setHeaderValue("<html><h3 style=font-family:Verdana;>Almacén Destino</h3></html>");
            tablatransferencia.getColumnModel().getColumn(4).setPreferredWidth(400);
            tablatransferencia.getColumnModel().getColumn(4).setMaxWidth(400);
            tablatransferencia.getColumnModel().getColumn(4).setResizable(false);
            tablatransferencia.getColumnModel().getColumn(5).setHeaderValue("<html><h3 style=font-family:Verdana;>Motivo</h3></html>");
            tablatransferencia.getColumnModel().getColumn(5).setPreferredWidth(900);
            tablatransferencia.getColumnModel().getColumn(5).setMaxWidth(900);
            tablatransferencia.getColumnModel().getColumn(5).setResizable(false);
            tablatransferencia.getTableHeader().setReorderingAllowed(false);
            new CargarComponentes().addComboBox(4, tablatransferencia, "SELECT nom_almacen FROM Almacen");
            fechahoy = new Date();
            this.date.setDateFormatString(fechaformat);
            this.date.setDate(fechahoy);
            editor = (JTextFieldDateEditor) date.getDateEditor();
            editor.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltitulo = new javax.swing.JLabel();
        labelnid = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tablatransferencia = new javax.swing.JTable();
        labelfecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        botoncargatrans = new javax.swing.JButton();
        labelfondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1189, 419));
        setMinimumSize(new java.awt.Dimension(1189, 419));
        setPreferredSize(new java.awt.Dimension(1189, 419));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("Transferencia de Almacén");
        add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 300, -1));

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 44, 50, 40));

        labelid.setBackground(new java.awt.Color(0, 153, 204));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Transferencia");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelid.setOpaque(true);
        add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, -1, -1));

        tablatransferencia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablatransferencia.setModel(modelotransferencia);
        tablatransferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablatransferenciaKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tablatransferencia);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1170, 290));

        labelfecha.setBackground(new java.awt.Color(0, 153, 204));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Transferencia");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelfecha.setOpaque(true);
        add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 210, 30));

        botoncargatrans.setBackground(new java.awt.Color(255, 255, 255));
        botoncargatrans.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botoncargatrans.setText("Cargar Transferencia");
        botoncargatrans.setBorder(null);
        add(botoncargatrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 40));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void tablatransferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablatransferenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (tablatransferencia.getSelectedRowCount() > 0) {
                modelotransferencia.removeRow(tablatransferencia.getSelectedRow());
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Seleccionar un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
            }
        }
    }//GEN-LAST:event_tablatransferenciaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncargatrans;
    public com.toedter.calendar.JDateChooser date;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltitulo;
    public javax.swing.JTable tablatransferencia;
    // End of variables declaration//GEN-END:variables
}
