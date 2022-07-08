/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import Reportes.ReportesDB;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


public class SalidaManual extends javax.swing.JDialog {

    String error;
    String seleccion;
    String fechasalida;
    String valida;
    boolean nulo;
    Date fechahoy;
    Conexion con = new Conexion();
    DefaultTableModel modelo;
    TableColumnModel columnModel;
    JTextFieldDateEditor editor;
    String fechaformat = "dd/MM/yyyy";
    SimpleDateFormat dateformat = new SimpleDateFormat(fechaformat);
    ReportesDB reportesalmacen = new ReportesDB();
    
    DefaultTableModel modelobusqueda = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int filas, int columnas) {
        if (columnas == 2) {
            return true;
        } else {
            return false;
        }
    }
    };
    DefaultTableModel modelosalida = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int filas, int columnas) {
        if (columnas >= 5) {
            return true;
        } else {
            return false;
        }
    }
    };
     public void tamanocolumnasbuscar(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(400);
    }
    public void tamanocolumnassalidas(JTable table){
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(900);
        columnModel.getColumn(2).setPreferredWidth(500);
        columnModel.getColumn(3).setPreferredWidth(400);
        columnModel.getColumn(4).setPreferredWidth(400);
        columnModel.getColumn(5).setPreferredWidth(200);
        columnModel.getColumn(6).setPreferredWidth(900);
    } 
    
    public SalidaManual() {
        initComponents();
        modelobusqueda.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Codigo</h3></html>",
                                                        "<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>"});
        tamanocolumnasbuscar(tablebuscarmaterial); 
        modelobusqueda.setRowCount(0);
        tablebuscarmaterial.getColumnModel().getColumn(0).setResizable(true);
        tablebuscarmaterial.getColumnModel().getColumn(1).setResizable(false);
        tablebuscarmaterial.getTableHeader().setReorderingAllowed(false);
        modelosalida.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Codigo</h3></html>","<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>",
            "<html><h3 style=font-family:Verdana;>Categoria</h3></html>","<html><h3 style=font-family:Verdana;>Medida</h3></html>","<html><h3 style=font-family:Verdana;>Almacén</h3></html>",
            "<html><h3 style=font-family:Verdana;>Cant.</h3></html>","<html><h3 style=font-family:Verdana;>Descripción / Uso</h3></html>"});
        tamanocolumnassalidas(tablesalidas); 
        modelosalida.setRowCount(0);
        tablesalidas.getColumnModel().getColumn(0).setResizable(false);
        tablesalidas.getColumnModel().getColumn(1).setResizable(true);
        tablesalidas.getColumnModel().getColumn(2).setResizable(false);
        tablesalidas.getColumnModel().getColumn(3).setResizable(false);
        tablesalidas.getColumnModel().getColumn(4).setResizable(false);
        tablesalidas.getColumnModel().getColumn(5).setResizable(false);
        tablesalidas.getColumnModel().getColumn(6).setResizable(false);
        tablesalidas.getTableHeader().setReorderingAllowed(false);
        new CargarComponentes().llenarcombobox(jComboBoxdpto, "SELECT nom_departamento FROM Departamentos");
        fechahoy = new Date();
        this.date.setDateFormatString(fechaformat);
        this.date.setDate(fechahoy);
        editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEnabled(false);
        
        
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        labelbuscar = new javax.swing.JLabel();
        textfieldbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebuscarmaterial = new javax.swing.JTable();
        labelfecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        labeldepartamento = new javax.swing.JLabel();
        jComboBoxdpto = new javax.swing.JComboBox<>();
        labelid = new javax.swing.JLabel();
        labelnid = new javax.swing.JLabel();
        botonaceptar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tablesalidas = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1230, 579));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("SALIDA MANUAL");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 40));

        labelbuscar.setBackground(new java.awt.Color(255, 255, 255));
        labelbuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelbuscar.setText("Buscar Material");
        labelbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(labelbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        textfieldbuscar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfieldbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textfieldbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfieldbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(textfieldbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 490, 30));

        tablebuscarmaterial.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablebuscarmaterial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tablebuscarmaterial.setModel(modelobusqueda);
        tablebuscarmaterial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablebuscarmaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebuscarmaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebuscarmaterial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 490, 100));

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Solicitud");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 210, 30));

        labeldepartamento.setBackground(new java.awt.Color(255, 255, 255));
        labeldepartamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldepartamento.setText("Solicita");
        labeldepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labeldepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(labeldepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, -1));

        jComboBoxdpto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(jComboBoxdpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 260, 30));

        labelid.setBackground(new java.awt.Color(255, 255, 255));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Salida");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, -1, -1));

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        getContentPane().add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 70, 50, 40));

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/accept_allow_admit_okay_icon_141954.png"))); // NOI18N
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 508, 60, 60));

        tablesalidas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablesalidas.setModel(modelosalida);
        tablesalidas.setShowGrid(true);
        tablesalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablesalidasKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tablesalidas);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 1170, 290));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 540));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 1230, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

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
        double cantidad;
        modelo = (DefaultTableModel) tablebuscarmaterial.getModel();
        if (evt.getClickCount() == 2) {
            seleccion = String.valueOf(modelobusqueda.getValueAt(tablebuscarmaterial.getSelectedRow(), 0));
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatosmaterial ?");
                ps.setString(1, seleccion);
                rs = ps.executeQuery();
                while (rs.next()) {
                    modelosalida.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
                }
                ps.close();
            }catch (SQLException ex) {
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            }
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tablebuscarmaterialMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        int idsalida = 0;
        int contvalida = 0;
        int contvalidares = 0;
        String codmaterial;
        String nommaterial;
        String categoria;
        String medida;
        String almacen;
        String descripcion;
        double cant = 0;
        double restaexist = 0;
        double cantstock = 0;
        DetalleSalidas arraysal;
        ArrayList<DetalleSalidas> salida;
        salida = new ArrayList<>();
        salida.clear();

        Object[] textoOpciones = {"Si", "No"};
        int opc = JOptionPane.showOptionDialog(null, "<html><h3 style=font-family:Verdana New;>¿Esta Seguro que Desea Generar la Salida?</h3></html>",
            null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0) {
            int numregesal = this.tablesalidas.getRowCount();
            fechasalida = dateformat.format(this.date.getDate());
            if (numregesal > 0) {
                try {
                    for (int i = 0; i < numregesal; i++) {
                        int j = 1;
                        codmaterial = (String) modelosalida.getValueAt(i, 0);
                        try{
                            cant = Double.parseDouble((String) modelosalida.getValueAt(i, 5));
                            contvalida = contvalida + j;
                        }catch(NumberFormatException nfe){
                            nulo = true;
                        }    
                        PreparedStatement ps = null;
                        ResultSet rs = null;
                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_verificarestastock ?,?");
                        ps.setString(1, codmaterial);
                        ps.setDouble(2, cant);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            restaexist = rs.getFloat(1);
                            if (restaexist < 0){
                                try{
                                   ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornacantexistencia ?");
                                   ps.setString(1, codmaterial);
                                   rs = ps.executeQuery();
                                   while(rs.next()){
                                       cantstock = rs.getFloat(1);
                                   }
                                }catch(SQLException ex){
                                   error = ex.getMessage();
                                   JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                } 
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Código: " + codmaterial + " solo tiene " + cantstock + " en existencia </h3></html>",
                                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia); 
                            }else{
                                contvalidares = contvalidares + j;
                            }
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                }
                if (contvalida == numregesal && !nulo) { //arreglar esto contvalida
                    if(contvalidares == numregesal){
                        try{
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevasalida ?,?");
                            ps.setString(1, fechasalida);
                            ps.setString(2, (String) this.jComboBoxdpto.getSelectedItem());
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                try {
                                    this.labelnid.setText(rs.getString(1));
                                    for (int i = 0; i < numregesal; i++) {
                                        idsalida = Integer.parseInt(this.labelnid.getText());
                                        codmaterial = (String) modelosalida.getValueAt(i, 0);
                                        nommaterial = (String) modelosalida.getValueAt(i, 1);
                                        categoria = (String) modelosalida.getValueAt(i, 2);
                                        medida = (String) modelosalida.getValueAt(i, 3);
                                        almacen = (String) modelosalida.getValueAt(i, 4);
                                        cant = Double.parseDouble((String) modelosalida.getValueAt(i, 5));
                                        descripcion = (String) modelosalida.getValueAt(i, 6);
                                        arraysal = new DetalleSalidas();
                                        arraysal.setidsalida(idsalida);
                                        arraysal.setcodmaterial(codmaterial);
                                        arraysal.setnommaterial(nommaterial);
                                        arraysal.setcategoria(categoria);
                                        arraysal.setmedida(medida);
                                        arraysal.setalmacen(almacen);
                                        arraysal.setcant(cant);
                                        arraysal.setdescripcion(descripcion);
                                        salida.add(arraysal);
                                        }
                                        try {
                                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotasalida  ?,?,?");
                                            ps.setString(1, fechasalida);
                                            ps.setString(2, (String)this.jComboBoxdpto.getSelectedItem());
                                            ps.setInt(3, idsalida);
                                            rs = ps.executeQuery();
                                            while (rs.next()) {
                                                //       
                                            }
                                        } catch (java.sql.SQLException ex) {
                                            error = ex.getMessage();
                                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                        }
                                        for (int i = 0; i < salida.size(); i++) {
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetallessalida ?,?,?,?,?,?,?,?");
                                                ps.setInt(1, salida.get(i).getidsalida());
                                                ps.setString(2, salida.get(i).getcodmaterial());
                                                ps.setString(3, salida.get(i).getnommaterial());
                                                ps.setString(4, salida.get(i).getcategoria());
                                                ps.setString(5, salida.get(i).getmedida());
                                                ps.setString(6, salida.get(i).getalmacen());
                                                ps.setDouble(7, salida.get(i).getcant());
                                                ps.setString(8, salida.get(i).getdescripcion());
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                        }
                                        for (int i = 0; i < salida.size(); i++) {
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetallesnotadesalida ?,?,?,?,?,?");
                                                ps.setString(1, salida.get(i).getcodmaterial());
                                                ps.setString(2, salida.get(i).getcategoria());
                                                ps.setString(3, salida.get(i).getmedida());
                                                ps.setString(4, salida.get(i).getalmacen());
                                                ps.setDouble(5, salida.get(i).getcant());
                                                ps.setString(6, salida.get(i).getdescripcion());
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                        }
                                        for (int i = 0; i < salida.size(); i++) {
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_restaexistenciamaterial ?,?");
                                                ps.setString(1, salida.get(i).getcodmaterial());
                                                ps.setDouble(2, salida.get(i).getcant());
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //
                                                }
                                            } catch (SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                        }
                                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Salida Ejecutada con Exito </h3></html>",
                                                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                        modelosalida.setRowCount(0);
                                        this.labelnid.setText("");
                                        try {
                                            reportesalmacen.ReporteNotaSalida(idsalida, idsalida);
                                        } catch (JRException | IOException ex) {
                                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } catch (SQLException ex) {
                                        error = ex.getMessage();
                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                    }
                            }
                        }catch(SQLException ex){
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Ingrese una Cantidad Valida y Mayor a 0</h3></html>",
                                              null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                }  
            }else{
                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>", 
                                              null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
            }
        }
    }//GEN-LAST:event_botonaceptarActionPerformed

    private void tablesalidasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablesalidasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (tablesalidas.getSelectedRowCount() > 0) {
                modelosalida.removeRow(tablesalidas.getSelectedRow());
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Seleccionar un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
            }
        }
    }//GEN-LAST:event_tablesalidasKeyPressed

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
            java.util.logging.Logger.getLogger(SalidaManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalidaManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalidaManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalidaManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalidaManual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonaceptar;
    public com.toedter.calendar.JDateChooser date;
    public javax.swing.JComboBox<String> jComboBoxdpto;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelbuscar;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labeldepartamento;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JTable tablebuscarmaterial;
    public javax.swing.JTable tablesalidas;
    private javax.swing.JTextField textfieldbuscar;
    // End of variables declaration//GEN-END:variables
}
