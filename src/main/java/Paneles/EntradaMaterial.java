/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import com.alimundo.moduloalmacen.CargarComponentes;
import com.alimundo.moduloalmacen.Conexion;
import com.alimundo.moduloalmacen.Parametros;
import com.alimundo.moduloalmacen.Requisiciones;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AdminSrv
 */
public class EntradaMaterial extends javax.swing.JPanel {

    DefaultTableModel modeloentrada = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 4){
                return false;
            }else return true;
        } 
    };
    
    Conexion con = new Conexion();
    String error;
    Date fechahoy;
    String fechaformat = "dd/MM/yyyy";
    JTextFieldDateEditor editor;
    
    public EntradaMaterial() {
        initComponents();
        modeloentrada.setColumnIdentifiers(new Object[]{"","","","","","","","",""});

        if (tableentradas.getColumnModel().getColumnCount() > 0) {

            tableentradas.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Codigo</h3></html>");
            tableentradas.getColumnModel().getColumn(0).setPreferredWidth(250);
            tableentradas.getColumnModel().getColumn(0).setMaxWidth(250);
            tableentradas.getColumnModel().getColumn(0).setResizable(false);
            tableentradas.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>");
            tableentradas.getColumnModel().getColumn(1).setPreferredWidth(900);
            tableentradas.getColumnModel().getColumn(1).setMaxWidth(900);
            tableentradas.getColumnModel().getColumn(1).setResizable(false);
            tableentradas.getColumnModel().getColumn(2).setHeaderValue("<html><h3 style=font-family:Verdana;>Categoria</h3></html>");
            tableentradas.getColumnModel().getColumn(2).setPreferredWidth(500);
            tableentradas.getColumnModel().getColumn(2).setMaxWidth(500);
            tableentradas.getColumnModel().getColumn(2).setResizable(false);
            tableentradas.getColumnModel().getColumn(3).setHeaderValue("<html><h3 style=font-family:Verdana;>Medida</h3></html>");
            tableentradas.getColumnModel().getColumn(3).setPreferredWidth(400);
            tableentradas.getColumnModel().getColumn(3).setMaxWidth(400);
            tableentradas.getColumnModel().getColumn(3).setResizable(false);
            tableentradas.getColumnModel().getColumn(4).setHeaderValue("<html><h3 style=font-family:Verdana;>Almacén</h3></html>");
            tableentradas.getColumnModel().getColumn(4).setPreferredWidth(400);
            tableentradas.getColumnModel().getColumn(4).setMaxWidth(400);
            tableentradas.getColumnModel().getColumn(4).setResizable(false);
            tableentradas.getColumnModel().getColumn(5).setHeaderValue("<html><h3 style=font-family:Verdana;>Cant.</h3></html>");
            tableentradas.getColumnModel().getColumn(5).setPreferredWidth(200);
            tableentradas.getColumnModel().getColumn(5).setMaxWidth(200);
            tableentradas.getColumnModel().getColumn(5).setResizable(false);
            tableentradas.getColumnModel().getColumn(6).setHeaderValue("<html><h3 style=font-family:Verdana;>Precio</h3></html>");
            tableentradas.getColumnModel().getColumn(6).setPreferredWidth(400);
            tableentradas.getColumnModel().getColumn(6).setMaxWidth(400);
            tableentradas.getColumnModel().getColumn(6).setResizable(false);
            tableentradas.getColumnModel().getColumn(7).setHeaderValue("<html><h3 style=font-family:Verdana;>Descripción</h3></html>");
            tableentradas.getColumnModel().getColumn(7).setPreferredWidth(900);
            tableentradas.getColumnModel().getColumn(7).setMaxWidth(900);
            tableentradas.getColumnModel().getColumn(7).setResizable(false);
            tableentradas.getColumnModel().getColumn(8).setHeaderValue("<html><h3 style=font-family:Verdana;>N° Factura</h3></html>");
            tableentradas.getColumnModel().getColumn(8).setPreferredWidth(400);
            tableentradas.getColumnModel().getColumn(8).setMaxWidth(400);
            tableentradas.getColumnModel().getColumn(8).setResizable(false);
        }
        new CargarComponentes().llenarcombobox(jComboBoxdpto, "SELECT nom_departamento FROM Departamentos");
        tableentradas.getTableHeader().setReorderingAllowed(false);
        fechahoy = new Date();
        this.date.setDateFormatString(fechaformat);
        this.date.setDate(fechahoy);
        editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEnabled(false);
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
        labeldepartamento = new javax.swing.JLabel();
        labeltextbotonreq = new javax.swing.JLabel();
        labeltextbotonreq1 = new javax.swing.JLabel();
        labeltextbotonreq2 = new javax.swing.JLabel();
        jComboBoxdpto = new javax.swing.JComboBox<>();
        labelfecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        botoncargareq = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tableentradas = new javax.swing.JTable();
        labelfondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1189, 419));
        setMinimumSize(new java.awt.Dimension(1189, 419));
        setPreferredSize(new java.awt.Dimension(1189, 419));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("ENTRADAS AL ALMACÉN");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 290, -1));

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

        labeldepartamento.setBackground(new java.awt.Color(255, 255, 255));
        labeldepartamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldepartamento.setText("Entrega:");
        labeldepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labeldepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(labeldepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 46, -1, -1));

        labeltextbotonreq.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeltextbotonreq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltextbotonreq.setText("(F2)");
        add(labeltextbotonreq, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 30));

        labeltextbotonreq1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeltextbotonreq1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltextbotonreq1.setText("Cargar");
        add(labeltextbotonreq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 30, 70, 30));

        labeltextbotonreq2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeltextbotonreq2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltextbotonreq2.setText("Requisición");
        add(labeltextbotonreq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        jComboBoxdpto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        add(jComboBoxdpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 260, 30));

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Entrada:");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 46, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 210, 30));

        botoncargareq.setBackground(new java.awt.Color(255, 255, 255));
        botoncargareq.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botoncargareq.setBorder(null);
        botoncargareq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncargareqActionPerformed(evt);
            }
        });
        add(botoncargareq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 70));

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

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 420));
    }// </editor-fold>//GEN-END:initComponents

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

    private void botoncargareqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncargareqActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new Requisiciones().setVisible(true);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botoncargareqActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncargareq;
    public com.toedter.calendar.JDateChooser date;
    public javax.swing.JComboBox<String> jComboBoxdpto;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labeldepartamento;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltextbotonreq;
    private javax.swing.JLabel labeltextbotonreq1;
    private javax.swing.JLabel labeltextbotonreq2;
    private javax.swing.JLabel labeltitulo;
    public javax.swing.JTable tableentradas;
    // End of variables declaration//GEN-END:variables
}
