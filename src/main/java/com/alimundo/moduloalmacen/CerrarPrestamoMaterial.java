/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import Reportes.ReportesDB;
import static com.sun.tools.javac.tree.TreeInfo.types;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author AdminSrv
 */
public class CerrarPrestamoMaterial extends javax.swing.JDialog {

    TableColumnModel columnModel;
    static Class[] types = new Class [] {java.lang.String.class, java.lang.String.class,java.lang.Integer.class,java.lang.Integer.class,java.lang.Object.class};
    public static DefaultTableModel modeloprestamo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <=2){
                return false;
            }else return true;
        }
        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        };
    };
    
    public void tamanocolumnasprestamo(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(500);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(500);
    }
    
    int numregdev;
    double resta;
    String error;
    String fechadevpreststr;
    String fechaformat = "dd/MM/yyyy";
    String seleccion;
    String valida;
    boolean bandera = false;
    Date fechahoy;
    Date fechadevprest;
    Conexion con = new Conexion();
    SimpleDateFormat dateformat = new SimpleDateFormat(fechaformat);
    JTextFieldDateEditor editor;
    DefaultTableModel modelo;
    ReportesDB reportesalmacen = new ReportesDB();
    CargarComponentes componentes = new CargarComponentes();
    
    public CerrarPrestamoMaterial(){
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        modeloprestamo.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Codigo</h3></html>","<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>",
                                            "<html><h3 style=font-family:Verdana;>Cant.</h3></html>","<html><h3 style=font-family:Verdana;>Cant. Ret.</h3></html>",
                                            "<html><h3 style=font-family:Verdana;>Devuelve</h3></html>"});
        
        tamanocolumnasprestamo(tabledevolucionprestamo); 
        modeloprestamo.setRowCount(0);
        tabledevolucionprestamo.getColumnModel().getColumn(0).setResizable(false);
        tabledevolucionprestamo.getColumnModel().getColumn(1).setResizable(true);
        tabledevolucionprestamo.getColumnModel().getColumn(2).setResizable(false);
        tabledevolucionprestamo.getColumnModel().getColumn(3).setResizable(false);
        tabledevolucionprestamo.getColumnModel().getColumn(4).setResizable(false);
        tabledevolucionprestamo.getTableHeader().setReorderingAllowed(false);

        componentes.addComboBox(4, tabledevolucionprestamo, "SELECT nom_responsable FROM ResponsablesPrestamos ORDER BY nom_responsable");
        fechahoy = new Date();
        this.date.setDateFormatString(fechaformat);
        this.date.setDate(fechahoy);
        editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEnabled(false);
        
         try{
           PreparedStatement ps = null;
           ResultSet rs = null;
           ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatosencabezadoprestamomaterial ?");
           ps.setInt(1,PrincipalForm.idprest);
           rs = ps.executeQuery();
           while(rs.next()){
                this.labelnid.setText(rs.getString(1));
                this.textfieldpto.setText(rs.getString(2));
            }
           ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadetallesprestamomaterial ?");
           ps.setInt(1,PrincipalForm.idprest);
           rs = ps.executeQuery();
           while(rs.next()){
                this.modeloprestamo.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3)});
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
        labeltitulo1 = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        labeldepartamento = new javax.swing.JLabel();
        textfieldpto = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        labelid = new javax.swing.JLabel();
        labelnid = new javax.swing.JLabel();
        botonaceptar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tabledevolucionprestamo = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 477));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 4, -1, -1));

        labeltitulo1.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo1.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo1.setText("CERRAR PRESTAMO DE MATERIAL");
        labeltitulo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo1.setOpaque(true);
        getContentPane().add(labeltitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 40));

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Devolución");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        labeldepartamento.setBackground(new java.awt.Color(255, 255, 255));
        labeldepartamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldepartamento.setText("Departamento");
        labeldepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labeldepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(labeldepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        textfieldpto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfieldpto.setEnabled(false);
        getContentPane().add(textfieldpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 210, 30));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 30));

        labelid.setBackground(new java.awt.Color(255, 255, 255));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Prestamo");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        getContentPane().add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 50, 40));

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/accept_allow_admit_okay_icon_141954.png"))); // NOI18N
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 403, 60, 60));

        tabledevolucionprestamo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabledevolucionprestamo.setModel(modeloprestamo);
        tabledevolucionprestamo.setShowGrid(true);
        jScrollPane.setViewportView(tabledevolucionprestamo);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 700, 260));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 440));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 477));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        double cant;
        double cantdev;
        int iddevp;
        int idnotadevprest = 0;
        String codmaterial;
        String nommaterial;
        String devuelve;
        numregdev = this.tabledevolucionprestamo.getRowCount();
        fechadevprest = this.date.getDate();
        fechadevpreststr = dateformat.format(fechadevprest);
        DetalleDevPrestamos arraydevprestamos; 
        ArrayList<DetalleDevPrestamos> devprestamos;
        devprestamos = new ArrayList<>();
        devprestamos.clear();
        
        for (int i = 0; i < devprestamos.size(); i++) {
            cant = Integer.parseInt(String.valueOf(modeloprestamo.getValueAt(i, 2)));
            cantdev = Integer.parseInt(String.valueOf(modeloprestamo.getValueAt(i, 3)));
            resta = cant-cantdev;
            if (resta < 0) {
                bandera = true;
            }
        }
        
        if (bandera == false){
            try{
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevodevprestamomaterial ?,?");
                ps.setString(1, fechadevpreststr);
                ps.setString(2, this.textfieldpto.getText());
                rs = ps.executeQuery();
                if(rs.next()){
                    iddevp = rs.getInt(1);
                    for (int i = 0; i < numregdev; i++) {
                        codmaterial = (String) modeloprestamo.getValueAt(i,0);
                        nommaterial = (String) modeloprestamo.getValueAt(i, 1);
                        cant = Integer.parseInt(String.valueOf(modeloprestamo.getValueAt(i, 2)));
                        cantdev = Integer.parseInt(String.valueOf(modeloprestamo.getValueAt(i, 3)));
                        devuelve = modeloprestamo.getValueAt(i, 4).toString();
                        arraydevprestamos = new DetalleDevPrestamos() ;
                        arraydevprestamos.setiddevprestamo(iddevp);
                        arraydevprestamos.setcodmaterial(codmaterial);
                        arraydevprestamos.setnommaterial(nommaterial);
                        arraydevprestamos.setcant(cant);
                        arraydevprestamos.setcantdev(cant);
                        arraydevprestamos.setdevuelve(devuelve);
                        devprestamos.add(arraydevprestamos);
                    }
                    try {
                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotadevprestamo ?,?,?,?");
                        ps.setString(1, fechadevpreststr);
                        ps.setString(2, this.textfieldpto.getText());
                        ps.setInt(3, iddevp);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            idnotadevprest = rs.getInt(1);
                        }
                    } catch (java.sql.SQLException ex) {
                        error = ex.getMessage();
                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                    }
                    for (int i = 0; i < devprestamos.size(); i++) {
                        try {
                            ps = con.EstablecerConexion().prepareStatement("spu_guardadetalledevprestamomaterial ?,?,?,?,?,?");
                            ps.setInt(1, devprestamos.get(i).getiddevprestamo());
                            ps.setString(2, devprestamos.get(i).getcodmaterial());
                            ps.setString(3, devprestamos.get(i).getnommaterial());
                            ps.setDouble(4, devprestamos.get(i).getcant());
                            ps.setDouble(5, devprestamos.get(i).getcantdev());
                            ps.setString(6, devprestamos.get(i).getdevuelve());
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                //       
                            }
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                    }
                    for (int i = 0; i < devprestamos.size(); i++) {
                        try {
                            ps = con.EstablecerConexion().prepareStatement("spu_guardadetallesnotadevprestamo ?,?,?,?");
                            ps.setString(1, devprestamos.get(i).getcodmaterial());
                            ps.setDouble(2, devprestamos.get(i).getcant());
                            ps.setDouble(3, devprestamos.get(i).getcantdev());
                            ps.setString(4, devprestamos.get(i).getdevuelve());
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                //       
                            }
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                    }
                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_cierraprestamomaterial ?");
                    ps.setInt(1,Integer.parseInt(this.labelnid.getText()));
                    rs = ps.executeQuery();
                    while(rs.next()){
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Prestamo Cerrado con Exito </h3></html>",
                                null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                    }
                }
            }catch(SQLException ex){
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            }
            try {
                reportesalmacen.ReporteNotaDevPrestamo(idnotadevprest , idnotadevprest);
            } catch (JRException | IOException ex) {
                Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CerrarPrestamoMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>La Cantidad Retornada no Puede ser mayor a la Cantidad Prestada </h3></html>",
                                null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
        }
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
            java.util.logging.Logger.getLogger(CerrarPrestamoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CerrarPrestamoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CerrarPrestamoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CerrarPrestamoMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CerrarPrestamoMaterial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonaceptar;
    public com.toedter.calendar.JDateChooser date;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labeldepartamento;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltitulo1;
    private javax.swing.JPanel panelopciones;
    public javax.swing.JTable tabledevolucionprestamo;
    private javax.swing.JTextField textfieldpto;
    // End of variables declaration//GEN-END:variables
}
