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
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class TransferenciaAlmacen extends javax.swing.JPanel {

     DefaultTableModel modelotransferencia = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 2){
                return false;
            }else return true;
        } 
    };
      DefaultTableModel modelobusqueda = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 4) {
                return true;
            } else {
                return false;
            }
        }
    };
    
    DefaultTableModel modelo;
    Conexion con = new Conexion();
    String error;
    String seleccion;
    Date fechahoy;
    String fechaformat = "dd/MM/yyyy";
    JTextFieldDateEditor editor;
    
    public TransferenciaAlmacen() {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        
        initComponents();
        modelobusqueda.setColumnIdentifiers(new Object[]{"", ""});
        if (tablebuscarmaterial.getColumnModel().getColumnCount() > 0) {
            tablebuscarmaterial.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Codigo</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(0).setPreferredWidth(150);
            tablebuscarmaterial.getColumnModel().getColumn(0).setMaxWidth(150);
            tablebuscarmaterial.getColumnModel().getColumn(0).setResizable(false);
            tablebuscarmaterial.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablebuscarmaterial.getColumnModel().getColumn(1).setMaxWidth(400);
            tablebuscarmaterial.getColumnModel().getColumn(1).setResizable(false);
        }
        tablebuscarmaterial.getTableHeader().setReorderingAllowed(false);

        modelotransferencia.setColumnIdentifiers(new Object[]{"","","","",""});
            if (tablatransferencia.getColumnModel().getColumnCount() > 0) {
                tablatransferencia.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Cod.</h3></html>");
                tablatransferencia.getColumnModel().getColumn(0).setPreferredWidth(150);
                tablatransferencia.getColumnModel().getColumn(0).setMaxWidth(150);
                tablatransferencia.getColumnModel().getColumn(0).setResizable(false);
                tablatransferencia.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>");
                tablatransferencia.getColumnModel().getColumn(1).setPreferredWidth(500);
                tablatransferencia.getColumnModel().getColumn(1).setMaxWidth(500);
                tablatransferencia.getColumnModel().getColumn(1).setResizable(false);
                tablatransferencia.getColumnModel().getColumn(2).setHeaderValue("<html><h3 style=font-family:Verdana;>Origen</h3></html>");
                tablatransferencia.getColumnModel().getColumn(2).setPreferredWidth(350);
                tablatransferencia.getColumnModel().getColumn(2).setMaxWidth(350);
                tablatransferencia.getColumnModel().getColumn(2).setResizable(false);
                tablatransferencia.getColumnModel().getColumn(3).setHeaderValue("<html><h3 style=font-family:Verdana;>Destino</h3></html>");
                tablatransferencia.getColumnModel().getColumn(3).setPreferredWidth(350);
                tablatransferencia.getColumnModel().getColumn(3).setMaxWidth(350);
                tablatransferencia.getColumnModel().getColumn(3).setResizable(false);
                tablatransferencia.getColumnModel().getColumn(4).setHeaderValue("<html><h3 style=font-family:Verdana;>Motivo</h3></html>");
                tablatransferencia.getColumnModel().getColumn(4).setPreferredWidth(500);
                tablatransferencia.getColumnModel().getColumn(4).setMaxWidth(500);
                tablatransferencia.getColumnModel().getColumn(4).setResizable(false);
                tablatransferencia.getTableHeader().setReorderingAllowed(false);
            }    
            new CargarComponentes().addComboBox(3, tablatransferencia, "SELECT nom_almacen FROM Almacen");
            fechahoy = new Date();
            this.date.setDateFormatString(fechaformat);
            this.date.setDate(fechahoy);
            editor = (JTextFieldDateEditor) date.getDateEditor();
            editor.setEnabled(false);
            this.textfieldbuscar.requestFocus();
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
        labelbuscar = new javax.swing.JLabel();
        textfieldbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebuscarmaterial = new javax.swing.JTable();
        labelfondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1189, 419));
        setMinimumSize(new java.awt.Dimension(1189, 419));
        setPreferredSize(new java.awt.Dimension(1189, 419));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("TRANSFERENCIAS DE MATERIALES");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 400, -1));

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
        tablatransferencia.setShowGrid(true);
        tablatransferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablatransferenciaKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tablatransferencia);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 750, 290));

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Transferencia");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 210, 30));

        labelbuscar.setBackground(new java.awt.Color(255, 255, 255));
        labelbuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelbuscar.setText("Buscar Material");
        labelbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labelbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        textfieldbuscar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfieldbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textfieldbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfieldbuscarKeyReleased(evt);
            }
        });
        add(textfieldbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 360, 30));

        tablebuscarmaterial.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablebuscarmaterial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablebuscarmaterial.setModel(modelobusqueda);
        tablebuscarmaterial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablebuscarmaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebuscarmaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebuscarmaterial);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 360, 290));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 420));
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

    private void textfieldbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldbuscarKeyReleased
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        String valor = this.textfieldbuscar.getText();
        try {
            modelobusqueda.setRowCount(0);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultamaterial ?");
            ps.setString(1, valor);
            rs = ps.executeQuery();
            while (rs.next()) {
                modelobusqueda.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }
            ps.close();
        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_textfieldbuscarKeyReleased

    private void tablebuscarmaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebuscarmaterialMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (evt.getClickCount() == 2) {
            modelo = (DefaultTableModel) tablebuscarmaterial.getModel();
            modelotransferencia = (DefaultTableModel) tablatransferencia.getModel();
            seleccion = String.valueOf(modelo.getValueAt(tablebuscarmaterial.getSelectedRow(), 0));
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatosmaterial ?");
                ps.setString(1, seleccion);
                rs = ps.executeQuery();
                while (rs.next()) {
                    modelotransferencia.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(5)});
                }
            ps.close();    
            }catch (SQLException ex) {
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            }
            tablatransferencia.getSelectionModel().setSelectionInterval(1, 1);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tablebuscarmaterialMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser date;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelbuscar;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltitulo;
    public javax.swing.JTable tablatransferencia;
    private javax.swing.JTable tablebuscarmaterial;
    private javax.swing.JTextField textfieldbuscar;
    // End of variables declaration//GEN-END:variables
}
