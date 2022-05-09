/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static Paneles.Salidas.modelosalida;
import com.alimundo.moduloalmacen.CargarComponentes;
import com.alimundo.moduloalmacen.Conexion;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class PrestamoMaterial extends javax.swing.JPanel {
    TableColumnModel columnModel;
    
    public static DefaultTableModel modeloprestamo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 2){
                return false;
            }else return true;
        }
    };
    public void tamanocolumnassalidas(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(400);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(400);
        columnModel.getColumn(4).setPreferredWidth(400);
    } 
    
    Conexion con = new Conexion();
    String error;
    Date fechahoy;
    String fechaformat = "dd/MM/yyyy";
    JTextFieldDateEditor editor;
    
    public PrestamoMaterial() {
        initComponents();
        modelosalida.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Codigo</h3></html>","<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>",
            "<html><h3 style=font-family:Verdana;>Cant.</h3></html>","<html><h3 style=font-family:Verdana;>Motivo</h3></html>",
            "<html><h3 style=font-family:Verdana;>Responsable</h3></html>"});
        tamanocolumnassalidas(tableprestamo); 
        modelosalida.setRowCount(0);
        tableprestamo.getTableHeader().setResizingAllowed(false);
        tableprestamo.getTableHeader().setReorderingAllowed(false);
        new CargarComponentes().llenarcombobox(jComboBoxdpto, "SELECT nom_departamento FROM Departamentos");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltitulo = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        labelnid = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        labeldepartamento = new javax.swing.JLabel();
        jComboBoxdpto = new javax.swing.JComboBox<>();
        botonbuscarmaterial = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tableprestamo = new javax.swing.JTable();
        labelfondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("PRESTAMO DE MATERIAL");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 300, -1));

        labelid.setBackground(new java.awt.Color(255, 255, 255));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Prestamo");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, -1, -1));

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 44, 50, 40));

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Solicitud");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 210, 30));

        labeldepartamento.setBackground(new java.awt.Color(255, 255, 255));
        labeldepartamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldepartamento.setText("Solicita");
        labeldepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labeldepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(labeldepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        jComboBoxdpto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        add(jComboBoxdpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 260, 30));

        botonbuscarmaterial.setBackground(new java.awt.Color(0, 0, 0));
        botonbuscarmaterial.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonbuscarmaterial.setForeground(new java.awt.Color(255, 255, 255));
        botonbuscarmaterial.setText("Buscar Material");
        botonbuscarmaterial.setBorder(null);
        botonbuscarmaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarmaterialActionPerformed(evt);
            }
        });
        add(botonbuscarmaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 40));

        tableprestamo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableprestamo.setModel(modelosalida);
        tableprestamo.setShowGrid(true);
        tableprestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableprestamoKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tableprestamo);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 610, 290));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -6, 1220, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void botonbuscarmaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarmaterialActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new RequisicionesSalidas().setVisible(true);
        tamanocolumnassalidas(tableprestamo);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonbuscarmaterialActionPerformed

    private void tableprestamoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableprestamoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (tableprestamo.getSelectedRowCount() > 0) {
                modelosalida.removeRow(tableprestamo.getSelectedRow());
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Seleccionar un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
            }
        }
    }//GEN-LAST:event_tableprestamoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonbuscarmaterial;
    public com.toedter.calendar.JDateChooser date;
    public javax.swing.JComboBox<String> jComboBoxdpto;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labeldepartamento;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltitulo;
    public javax.swing.JTable tableprestamo;
    // End of variables declaration//GEN-END:variables
}
