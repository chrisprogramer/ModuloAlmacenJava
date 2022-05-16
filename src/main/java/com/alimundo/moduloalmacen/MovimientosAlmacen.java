/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import Reportes.ReportesDB;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author AdminSrv
 */
public class MovimientosAlmacen extends javax.swing.JDialog{
    
    String error;
    String seleccion;
    String fechaprestamo;
    Conexion con = new Conexion();
    ReportesDB reportesalmacen = new ReportesDB();
    String fechaformat = "dd/MM/yyyy";
    SimpleDateFormat dateformat = new SimpleDateFormat(fechaformat);
    int tabbedfocus;
    int cantreg;
    DefaultTableModel modeloentrada = new DefaultTableModel();
    DefaultTableModel modelosalida = new DefaultTableModel();
    DefaultTableModel modelotransferencia = new DefaultTableModel();
    DefaultTableModel modeloprestamo = new DefaultTableModel();
    DefaultTableModel modelodptofechaentrada = new DefaultTableModel();
    DefaultTableModel modelodptofechasalida = new DefaultTableModel();
    
    public MovimientosAlmacen() {
        initComponents();
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        this.botoncerrarprestamo.setVisible(false);
        this.setModal(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        botonaceptar = new javax.swing.JButton();
        botoncerrarprestamo = new javax.swing.JButton();
        botonconsultar = new javax.swing.JButton();
        TabbedPaneMovimientos = new javax.swing.JTabbedPane();
        entradaMaterial = new Paneles.EntradaMaterial();
        salidas = new Paneles.Salidas();
        transferenciaAlmacen = new Paneles.TransferenciaAlmacen();
        PrestamoMaterial = new Paneles.PrestamoMaterial();
        panelopciones = new javax.swing.JPanel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1242, 549));
        setMinimumSize(new java.awt.Dimension(1242, 549));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setName("dialog()"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1242, 549));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("MOVIMIENTOS DE ALMACÉN");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1242, 40));

        botonaceptar.setBackground(new java.awt.Color(255, 255, 255));
        botonaceptar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonaceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/accept_allow_admit_okay_icon_141954.png"))); // NOI18N
        botonaceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonaceptar.setOpaque(false);
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 487, 60, 60));

        botoncerrarprestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/refresh_paper_load_update_icon_141966.png"))); // NOI18N
        botoncerrarprestamo.setOpaque(false);
        botoncerrarprestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncerrarprestamoActionPerformed(evt);
            }
        });
        getContentPane().add(botoncerrarprestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 487, 60, 60));

        botonconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/analytics_report_analysis_document_data_study_icon_143867.png"))); // NOI18N
        botonconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonconsultarActionPerformed(evt);
            }
        });
        getContentPane().add(botonconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 487, 60, 60));

        TabbedPaneMovimientos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TabbedPaneMovimientos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        TabbedPaneMovimientos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabbedPaneMovimientosStateChanged(evt);
            }
        });

        entradaMaterial.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        TabbedPaneMovimientos.addTab("Entradas", entradaMaterial);
        TabbedPaneMovimientos.addTab("Salidas", salidas);
        TabbedPaneMovimientos.addTab("Transferencia de Almacén", transferenciaAlmacen);
        TabbedPaneMovimientos.addTab("Prestamo de Material", PrestamoMaterial);

        getContentPane().add(TabbedPaneMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1200, -1));
        TabbedPaneMovimientos.getAccessibleContext().setAccessibleName("");

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 530));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 1240, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        int identrada;
        int idsalida;
        int idtransferencia;
        int idprestamo;
        int contvalida = 0;
        String valida;
        String codmaterial;
        String nommaterial;
        String categoria;
        String medida;
        String almacen;
        String fechareq;
        String fechatransferencia;
        String descripcion;
        String nfactura;
        String motivo;
        String responsable;
        String almacenori;
        String almacendes;
        int cant;
        double precio;
        DetalleEntradas arrayent; 
        ArrayList<DetalleEntradas> entrada;
        entrada = new ArrayList<>();
        entrada.clear();
        DetalleSalidas arraysal;
        ArrayList<DetalleSalidas> salida;
        salida = new ArrayList<>();
        salida.clear();
        DetalleTransferencias arraytrans;
        ArrayList<DetalleTransferencias> transferencias;
        transferencias = new ArrayList<>();
        transferencias.clear();
        DetallePrestamos arrayprestamos;
        ArrayList <DetallePrestamos> prestamos;
        prestamos = new ArrayList<>();
        prestamos.clear();
        int numregent = entradaMaterial.tableentradas.getRowCount();
        int numregsal = salidas.tablesalidas.getRowCount();
        int numregtrans = transferenciaAlmacen.tablatransferencia.getRowCount();
        int numregpres = PrestamoMaterial.tableprestamo.getRowCount();
        fechatransferencia = dateformat.format(transferenciaAlmacen.date.getDate());
        modeloentrada = (DefaultTableModel) entradaMaterial.tableentradas.getModel();
        modelosalida = (DefaultTableModel) salidas.tablesalidas.getModel();
        modelotransferencia = (DefaultTableModel) transferenciaAlmacen.tablatransferencia.getModel();
        modeloprestamo = (DefaultTableModel) PrestamoMaterial.tableprestamo.getModel();
        modelodptofechaentrada = (DefaultTableModel) entradaMaterial.tabledptofecha.getModel();
        modelodptofechasalida = (DefaultTableModel) salidas.tabledptofecha.getModel();
        tabbedfocus = this.TabbedPaneMovimientos.getSelectedIndex();
        Object[] textoOpciones = {"Si","No"};
        int opc = JOptionPane.showOptionDialog(null,"<html><h3 style=font-family:Verdana New;>¿Desea Procesar el Movimiento?</h3></html>",
            null,JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0){
            switch (tabbedfocus){
                case 0:  if (numregent > 0) {
                            fechareq = (String)modelodptofechaentrada.getValueAt(0, 1);
                            try {
                                PreparedStatement ps = null;
                                ResultSet rs = null;
                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevaentrada ?,?");
                                ps.setString(1, fechareq);
                                ps.setString(2, (String)modelodptofechaentrada.getValueAt(0, 0));
                                rs = ps.executeQuery();
                                if (rs.next()) {
                                    try {
                                        entradaMaterial.labelnid.setText(rs.getString(1));
                                        for (int i = 0; i < numregent; i++) {
                                            identrada = Integer.parseInt(entradaMaterial.labelnid.getText());
                                            codmaterial = (String) modeloentrada.getValueAt(i, 0);
                                            nommaterial = (String) modeloentrada.getValueAt(i, 1);
                                            categoria = (String) modeloentrada.getValueAt(i, 2);
                                            medida = (String) modeloentrada.getValueAt(i, 3);
                                            almacen = (String) modeloentrada.getValueAt(i, 4);
                                            cant = Integer.parseInt((String) modeloentrada.getValueAt(i, 5));
                                            try {
                                                precio = Double.parseDouble((String) modeloentrada.getValueAt(i, 6));
                                            } catch (NullPointerException ex) {
                                                precio = 0.00;
                                            }
                                            descripcion = (String) modeloentrada.getValueAt(i, 7);
                                            nfactura = (String) modeloentrada.getValueAt(i, 8);
                                            arrayent = new DetalleEntradas();
                                            arrayent.setidentrada(identrada);
                                            arrayent.setcodmaterial(codmaterial);
                                            arrayent.setnommaterial(nommaterial);
                                            arrayent.setcategoria(categoria);
                                            arrayent.setmedida(medida);
                                            arrayent.setalmacen(almacen);
                                            arrayent.setcant(cant);
                                            arrayent.setprecio(precio);
                                            arrayent.setdescripcion(descripcion);
                                            arrayent.setnumfactura(nfactura);
                                            entrada.add(arrayent);
                                        }
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotaentrada ?,?,?");
                                                ps.setString(1, (String)modelodptofechaentrada.getValueAt(0, 1));
                                                ps.setString(2, (String)modelodptofechaentrada.getValueAt(0, 0));
                                                ps.setInt(3, Integer.parseInt(entradaMaterial.labelnid.getText()));
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                            for (int i = 0; i < entrada.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("spu_guardadetalleentrada ?,?,?,?,?,?,?,?,?,?");
                                                    ps.setInt(1, entrada.get(i).getidentrada());
                                                    ps.setString(2, entrada.get(i).getcodmaterial());
                                                    ps.setString(3, entrada.get(i).getnommaterial());
                                                    ps.setString(4, entrada.get(i).getcategoria());
                                                    ps.setString(5, entrada.get(i).getmedida());
                                                    ps.setString(6, entrada.get(i).getalmacen());
                                                    ps.setInt(7, entrada.get(i).getcant());
                                                    ps.setDouble(8, entrada.get(i).getprecio());
                                                    ps.setString(9, entrada.get(i).getdescripcion());
                                                    ps.setString(10, entrada.get(i).getnumfactura());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            for (int i = 0; i < entrada.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("spu_guardadetallesnotaentrada ?,?,?,?,?,?,?");
                                                    ps.setString(1, entrada.get(i).getcodmaterial());
                                                    ps.setString(2, entrada.get(i).getcategoria());
                                                    ps.setString(3, entrada.get(i).getmedida());
                                                    ps.setString(4, entrada.get(i).getalmacen());
                                                    ps.setInt(5, entrada.get(i).getcant());
                                                    ps.setDouble(6, entrada.get(i).getprecio());
                                                    ps.setString(7, entrada.get(i).getdescripcion());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            for (int i = 0; i < entrada.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_sumaexistenciamaterial ?,?");
                                                    ps.setString(1, entrada.get(i).getcodmaterial());
                                                    ps.setInt(2, entrada.get(i).getcant());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //
                                                    }
                                                } catch (SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("spu_ejecutarequisicion ?");
                                                ps.setInt(1, PrincipalForm.codreqent);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Entrada Ejecutada con Exito </h3></html>",
                                                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                                try {
                                                    reportesalmacen.ReporteNotaEntrega(Integer.parseInt(entradaMaterial.labelnid.getText()), Integer.parseInt(entradaMaterial.labelnid.getText()));
                                                } catch (JRException | IOException ex) {
                                                    Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                    } catch (SQLException ex) {
                                        error = ex.getMessage();
                                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                    }        
                                }
                            }catch (SQLException ex) {
                                error = ex.getMessage();
                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                            }
                            modeloentrada.setRowCount(0);
                            modelodptofechaentrada.setRowCount(0);
                            entradaMaterial.labelnid.setText("");
                    }else {
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                    }
                    break;
                case 1: if (numregsal > 0) {
                            fechareq = (String)modelodptofechasalida.getValueAt(0, 1);
                            try {
                                PreparedStatement ps = null;
                                ResultSet rs = null;
                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevasalida ?,?");
                                ps.setString(1, fechareq);
                                ps.setString(2, (String)modelodptofechasalida.getValueAt(0, 0));
                                rs = ps.executeQuery();
                                if (rs.next()) {
                                    try {
                                        salidas.labelnid.setText(rs.getString(1));
                                        for (int i = 0; i < numregsal; i++) {
                                            idsalida = Integer.parseInt(salidas.labelnid.getText());
                                            codmaterial = (String) modelosalida.getValueAt(i, 0);
                                            nommaterial = (String) modelosalida.getValueAt(i, 1);
                                            categoria = (String) modelosalida.getValueAt(i, 2);
                                            medida = (String) modelosalida.getValueAt(i, 3);
                                            almacen = (String) modelosalida.getValueAt(i, 4);
                                            cant = Integer.parseInt((String) modelosalida.getValueAt(i, 5));
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
                                                ps.setString(1, (String)modelodptofechasalida.getValueAt(0, 1));
                                                ps.setString(2, (String)modelodptofechasalida.getValueAt(0, 0));
                                                ps.setInt(3, Integer.parseInt(salidas.labelnid.getText()));
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
                                                    ps.setInt(7, salida.get(i).getcant());
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
                                                    ps.setInt(5, salida.get(i).getcant());
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
                                                    ps.setInt(2, salida.get(i).getcant());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //
                                                    }
                                                } catch (SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_ejecutarequisicion ?");
                                                ps.setInt(1, PrincipalForm.codreqent);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Salida Ejecutada con Exito </h3></html>",
                                                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                                try {
                                                    reportesalmacen.ReporteNotaSalida(Integer.parseInt(salidas.labelnid.getText()), Integer.parseInt(salidas.labelnid.getText()));
                                                } catch (JRException | IOException ex) {
                                                    Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                    } catch (SQLException ex) {
                                        error = ex.getMessage();
                                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                    }        
                                }
                            }catch (SQLException ex) {
                                error = ex.getMessage();
                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                            }
                            modelosalida.setRowCount(0);
                            modelodptofechasalida.setRowCount(0);
                            salidas.labelnid.setText("");
                    }else {
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                    }
                    break;
                case 2: if (numregtrans > 0){
                            for (int i = 0; i < numregtrans; i++){
                                int j = 1;
                                valida = (String) modelotransferencia.getValueAt(i, 3);
                                if(new ValidarDatos().vacio(valida)){
                                    contvalida = contvalida + j;
                                }
                            }
                            if (contvalida == numregtrans){
                                try {
                                    PreparedStatement ps = null;
                                    ResultSet rs = null;
                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevatransferencia ?");
                                    ps.setString(1,fechatransferencia);
                                    rs = ps.executeQuery();
                                    if (rs.next()) {
                                        try{
                                            transferenciaAlmacen.labelnid.setText(rs.getString(1));
                                                for (int i = 0; i < numregtrans; i++) {
                                                    idtransferencia = Integer.parseInt(transferenciaAlmacen.labelnid.getText());
                                                    codmaterial = (String) modelotransferencia.getValueAt(i, 0);
                                                    nommaterial = (String) modelotransferencia.getValueAt(i, 1);
                                                    almacenori = (String) modelotransferencia.getValueAt(i, 2);
                                                    almacendes = (String) modelotransferencia.getValueAt(i, 3);
                                                    motivo = (String) modelotransferencia.getValueAt(i, 4);
                                                    arraytrans = new DetalleTransferencias();
                                                    arraytrans.setidtransferencia(idtransferencia);
                                                    arraytrans.setcodmaterial(codmaterial);
                                                    arraytrans.setnommaterial(nommaterial);
                                                    arraytrans.setalmacenori(almacenori);
                                                    arraytrans.setalmacendes(almacendes);
                                                    arraytrans.setmotivo(motivo);
                                                    transferencias.add(arraytrans);
                                                }
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotatransferencia ?,?");
                                                    ps.setString(1, fechatransferencia);
                                                    ps.setInt(2, Integer.parseInt(transferenciaAlmacen.labelnid.getText()));
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                                for (int i = 0; i < transferencias.size(); i++) {
                                                    try {
                                                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetalletransferencia ?,?,?,?,?,?");
                                                        ps.setInt(1, transferencias.get(i).getidtransferencia());
                                                        ps.setString(2, transferencias.get(i).getcodmaterial());
                                                        ps.setString(3, transferencias.get(i).getnommaterial());
                                                        ps.setString(4, transferencias.get(i).getalmacenori());
                                                        ps.setString(5, transferencias.get(i).getalmacendes());
                                                        ps.setString(6, transferencias.get(i).getmotivo());
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            //       
                                                        }
                                                    } catch (SQLException ex) {
                                                        error = ex.getMessage();
                                                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                    }
                                                }
                                                for (int i = 0; i < transferencias.size(); i++) {
                                                    try {
                                                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetallesnotatransferencia ?,?,?,?");
                                                        ps.setString(1, transferencias.get(i).getcodmaterial());
                                                        ps.setString(2, transferencias.get(i).getalmacenori());
                                                        ps.setString(3, transferencias.get(i).getalmacendes());
                                                        ps.setString(4, transferencias.get(i).getmotivo());
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            //       
                                                        }
                                                    } catch (java.sql.SQLException ex) {
                                                        error = ex.getMessage();
                                                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                    }
                                                }
                                                for (int i = 0; i < transferencias.size(); i++) {
                                                    try {
                                                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_transferenciamaterial ?,?");
                                                        ps.setString(1, transferencias.get(i).getcodmaterial());
                                                        ps.setString(2, transferencias.get(i).getalmacendes());
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            //
                                                        }
                                                    } catch (SQLException ex) {
                                                        error = ex.getMessage();
                                                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                    }
                                                }
                                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Transfrencia Ejecutada con Exito </h3></html>",
                                                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                                try {
                                                    reportesalmacen.ReporteNotaTransferencia(Integer.parseInt(transferenciaAlmacen.labelnid.getText()));
                                                } catch (JRException | IOException ex) {
                                                    Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                        }catch (SQLException ex) {
                                            error = ex.getMessage();
                                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                        }ps.close();    
                                    }
                                }catch (SQLException ex) {
                                    error = ex.getMessage();
                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);    
                                }
                                modelotransferencia.setRowCount(0);
                                transferenciaAlmacen.labelnid.setText("");
                            }else{
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Indique el Almacén de Destino</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                            }    
                        } else {
                            JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
                        }    
                        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
                        break;
                        
                case 3: if (numregpres > 0) {
                            for (int i = 0; i < numregpres; i++) {
                                int j = 1;
                                valida = (String) modeloprestamo.getValueAt(i, 2);
                                if (ValidarDatos.isNumeric(valida)) {
                                    contvalida = contvalida + j;
                                }
                            }
                            if(contvalida == numregpres){
                                fechaprestamo = dateformat.format(PrestamoMaterial.date.getDate());
                                try {
                                    PreparedStatement ps = null;
                                    ResultSet rs = null;
                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevoprestamomaterial ?,?");
                                    ps.setString(1, fechaprestamo);
                                    ps.setString(2, (String) PrestamoMaterial.jComboBoxdpto.getSelectedItem());
                                    rs = ps.executeQuery();
                                    while(rs.next()){
                                        try{
                                            PrestamoMaterial.labelnid.setText(rs.getString(1));
                                            for (int i = 0; i < numregpres; i++) {
                                                idprestamo = Integer.parseInt(PrestamoMaterial.labelnid.getText());
                                                codmaterial = (String) modeloprestamo.getValueAt(i, 0);
                                                nommaterial = (String) modeloprestamo.getValueAt(i, 1);
                                                cant = Integer.parseInt((String) modeloprestamo.getValueAt(i, 2));
                                                motivo = (String) modeloprestamo.getValueAt(i, 3);
                                                responsable = (String) modeloprestamo.getValueAt(i, 4);
                                                arrayprestamos = new DetallePrestamos();
                                                arrayprestamos.setidprestamo(idprestamo);
                                                arrayprestamos.setcodmaterial(codmaterial);
                                                arrayprestamos.setnommaterial(nommaterial);
                                                arrayprestamos.setcant(cant);
                                                arrayprestamos.setmotivo(motivo);
                                                arrayprestamos.setresponsable(responsable);
                                                prestamos.add(arrayprestamos);
                                            }
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotaprestamo ?,?,?");
                                                ps.setString(1, fechaprestamo );
                                                ps.setString(2, (String) PrestamoMaterial.jComboBoxdpto.getSelectedItem());
                                                ps.setInt(3, Integer.parseInt(PrestamoMaterial.labelnid.getText()));
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                            for (int i = 0; i < prestamos.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetalleprestamomaterial ?,?,?,?,?,?");
                                                    ps.setInt(1, prestamos.get(i).getidprestamo());
                                                    ps.setString(2, prestamos.get(i).getcodmaterial());
                                                    ps.setString(3, prestamos.get(i).getnommaterial());
                                                    ps.setInt(4, prestamos.get(i).getcant());
                                                    ps.setString(5, prestamos.get(i).getmotivo());
                                                    ps.setString(6, prestamos.get(i).getresponsable());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            for (int i = 0; i < prestamos.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetallesnotaprestamo ?,?,?,?");
                                                    ps.setString(1, prestamos.get(i).getcodmaterial());
                                                    ps.setInt(2, prestamos.get(i).getcant());
                                                    ps.setString(3, prestamos.get(i).getmotivo());
                                                    ps.setString(4, prestamos.get(i).getresponsable());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Prestamo Ejecutado con Exito </h3></html>",
                                                            null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                            try {
                                                reportesalmacen.ReporteNotaPrestamo(Integer.parseInt(PrestamoMaterial.labelnid.getText()), Integer.parseInt(PrestamoMaterial.labelnid.getText()));
                                            } catch (JRException | IOException ex) {
                                                Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            
                                        }catch(SQLException ex){
                                            error = ex.getMessage();
                                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror); 
                                        }    
                                    }      
                                }catch(SQLException ex){
                                    error = ex.getMessage();
                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror); 
                                }
                                modeloprestamo.setRowCount(0);
                                PrestamoMaterial.labelnid.setText("");
                            }else{
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Ingrese una Cantidad Valida y Mayor a 0</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                            }
                        }else {
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                        break;
                }
            }    
        }        
    }//GEN-LAST:event_botonaceptarActionPerformed

    private void botoncerrarprestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncerrarprestamoActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new EditarPrestamo().setVisible(true);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botoncerrarprestamoActionPerformed

    private void TabbedPaneMovimientosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabbedPaneMovimientosStateChanged
       tabbedfocus = this.TabbedPaneMovimientos.getSelectedIndex();
       if(tabbedfocus >=0 && tabbedfocus <3){
           this.botoncerrarprestamo.setVisible(false);
           this.botonconsultar.setVisible(false);
       }else{
           this.botoncerrarprestamo.setVisible(true);
           this.botonconsultar.setVisible(true);
       }
    }//GEN-LAST:event_TabbedPaneMovimientosStateChanged

    private void botonconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonconsultarActionPerformed
       this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
       new MaterialTransito().setVisible(true);
       this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonconsultarActionPerformed

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
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosAlmacen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Paneles.PrestamoMaterial PrestamoMaterial;
    public javax.swing.JTabbedPane TabbedPaneMovimientos;
    public javax.swing.JButton botonaceptar;
    private javax.swing.JButton botoncerrarprestamo;
    private javax.swing.JButton botonconsultar;
    public Paneles.EntradaMaterial entradaMaterial;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    public Paneles.Salidas salidas;
    private Paneles.TransferenciaAlmacen transferenciaAlmacen;
    // End of variables declaration//GEN-END:variables
}
