/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import Reportes.ReportesDB;
import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;


public class MovimientosAlmacen1 extends javax.swing.JDialog{

    DefaultTableModel modelo;
    String error;
    String seleccion;
    int tabbedfocus;
    Conexion con = new Conexion();
    ReportesDB reportesalmacen = new ReportesDB();
    String fechaformat = "dd/MM/yyyy";
    SimpleDateFormat dateformat = new SimpleDateFormat(fechaformat);
    
    DefaultTableModel modeloentrada = new DefaultTableModel();
    DefaultTableModel modelosalida = new DefaultTableModel();
    DefaultTableModel modelotransferencia = new DefaultTableModel();
    DefaultTableModel modelobusqueda = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas == 2){
                return true;
            }else return false;
        } 
    };

    public MovimientosAlmacen1() {
            
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
    
        initComponents();
        setTitle("MOVIMIENTOS DE ALMACÉN");
        setSize(1230, 589);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        modelobusqueda.setColumnIdentifiers(new Object[]{"",""});
        this.setModal(true);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelopciones = new javax.swing.JPanel();
        labelaceptar = new javax.swing.JLabel();
        labelcerrar = new javax.swing.JLabel();
        botonaceptar = new javax.swing.JButton();
        TabbedPaneMovimientos = new javax.swing.JTabbedPane();
        salidas1 = new Paneles.Salidas();
        transferenciaalmacen = new Paneles.TransferenciaAlmacen();
        //jPanel1 = new javax.swing.JPanel();
        entradas = new Paneles.Entradas();
        labeltitulo = new javax.swing.JLabel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1230, 589));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(null);

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones);
        panelopciones.setBounds(0, 0, 30, 878);

        labelaceptar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelaceptar.setText("Aceptar");
        getContentPane().add(labelaceptar);
        labelaceptar.setBounds(1140, 570, 60, 16);

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar);
        labelcerrar.setBounds(1180, 10, 32, 40);

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/verificar.png"))); // NOI18N
        botonaceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonaceptar.setOpaque(false);
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar);
        botonaceptar.setBounds(1130, 490, 80, 80);

        TabbedPaneMovimientos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TabbedPaneMovimientos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        TabbedPaneMovimientos.setMaximumSize(new java.awt.Dimension(919, 633));
        TabbedPaneMovimientos.setMinimumSize(new java.awt.Dimension(919, 633));
        TabbedPaneMovimientos.addTab("Salidas", salidas1);
        TabbedPaneMovimientos.addTab("Transferencias de Almacen", transferenciaalmacen);

        //jPanel1.add(entradas);

        //TabbedPaneMovimientos.addTab("Entradas", jPanel1);

        getContentPane().add(TabbedPaneMovimientos);
        TabbedPaneMovimientos.setBounds(35, 40, 1190, 450);

        labeltitulo.setBackground(new java.awt.Color(0, 153, 204));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("Movimientos de Almacén");
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo);
        labeltitulo.setBounds(480, 10, 280, 26);

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo);
        labelfondo.setBounds(30, 0, 1200, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        DetalleEntradas arrayent; 
        ArrayList<DetalleEntradas> entrada;
        entrada = new ArrayList<>();
        entrada.clear();
        DetalleSalidas arraysal;
        ArrayList<DetalleSalidas> salidas;
        salidas = new ArrayList<>();
        salidas.clear();
        DetalleTransferencias arraytrans;
        ArrayList<DetalleTransferencias> transferencias;
        transferencias = new ArrayList<>();
        transferencias.clear();
        String fechaentrada;
        String fechasalida;
        String fechatransferencia;
        int identrada;
        int idsalida;
        String codmaterial;
        String nommaterial;
        String categoria;
        String medida;
        String almacen;
        int cant;
        double precio;
        String descripcion;
        String nfactura;
        int idtransferencia;
        String almacenori;
        String almacendes;
        String motivo;
        String valida;
        int contvalida = 0;
        
        fechaentrada = dateformat.format(entradas.date.getDate());
        fechasalida = dateformat.format(salidas1.date.getDate());
        fechatransferencia = dateformat.format(transferenciaalmacen.date.getDate());
        int numregent = entradas.tableentradas.getRowCount();
        int numregsal = salidas1.tablesalidas.getRowCount();
        int numregtrans = transferenciaalmacen.tablatransferencia.getRowCount();
        modeloentrada = (DefaultTableModel) entradas.tableentradas.getModel();
        modelosalida = (DefaultTableModel) salidas1.tablesalidas.getModel();
        tabbedfocus = this.TabbedPaneMovimientos.getSelectedIndex();
        Object[] textoOpciones = {"Si","No"};
        int opc = JOptionPane.showOptionDialog(null,"<html><h3 style=font-family:Verdana New;>¿Esta Seguro que Desea Guardar el movimiento?</h3></html>",
            null,JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0){
            //if (tabbedfocus == 0){
            switch (tabbedfocus){    
                case 0: if (numregent > 0) {
                            for (int i = 0; i < numregent; i++) {
                                int j = 1;
                                valida = (String) modeloentrada.getValueAt(i, 5);
                                if (ValidarDatos.isNumeric(valida)) {
                                    contvalida = contvalida + j;
                                }
                            }
                            if (contvalida == numregent) {
                                try {
                                    PreparedStatement ps = null;
                                    ResultSet rs = null;
                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevaentrada ?,?");
                                    ps.setString(1, fechaentrada);
                                    ps.setString(2, (String) entradas.jComboBoxdpto.getSelectedItem());
                                    rs = ps.executeQuery();
                                    if (rs.next()) {
                                        try {
                                            entradas.labelnid.setText(rs.getString(1));
                                            for (int i = 0; i < numregent; i++) {
                                                identrada = Integer.parseInt(entradas.labelnid.getText());
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
                                                ps.setString(1, fechaentrada);
                                                ps.setString(2, (String) entradas.jComboBoxdpto.getSelectedItem());
                                                ps.setInt(3, Integer.parseInt(entradas.labelnid.getText()));
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
                                                    ps = con.EstablecerConexion().prepareStatement("spu_guardadetallesnotaentrega ?,?,?,?,?,?,?");
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
                                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Entrada Guardada con Exito </h3></html>",
                                                    null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                            try {
                                                reportesalmacen.ReporteNotaEntrega(Integer.parseInt(entradas.labelnid.getText()), Integer.parseInt(entradas.labelnid.getText()));
                                            } catch (JRException | IOException ex) {
                                                Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } catch (SQLException ex) {
                                            error = ex.getMessage();
                                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                        }ps.close();
                                    }
                                } catch (SQLException ex) {
                                    error = ex.getMessage();
                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                }
                                modeloentrada.setRowCount(0);
                                entradas.labelnid.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Ingrese una Cantidad Valida y Mayor a 0</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                        }
                        break;
                        
            //}else{
                //codigo salida inicio
                case 1: if (numregsal > 0) {
                            for (int i = 0; i < numregsal; i++) {
                                int j = 1;
                                valida = (String) modelosalida.getValueAt(i, 5);
                                if (ValidarDatos.isNumeric(valida)) {
                                    contvalida = contvalida + j;
                                }
                            }
                            if (contvalida == numregsal){
                                try {
                                    PreparedStatement ps = null;
                                    ResultSet rs = null;
                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevasalida ?,?");
                                    ps.setString(1, fechasalida);
                                    ps.setString(2, (String) salidas1.jComboBoxdpto.getSelectedItem());
                                    rs = ps.executeQuery();
                                    if (rs.next()) {
                                        try {
                                            salidas1.labelnid.setText(rs.getString(1));
                                            for (int i = 0; i < numregsal; i++) {
                                                idsalida = Integer.parseInt(salidas1.labelnid.getText());
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
                                                salidas.add(arraysal);
                                            }
                                            try {
                                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotasalida ?,?,?");
                                                ps.setString(1, fechasalida);
                                                ps.setString(2, (String) salidas1.jComboBoxdpto.getSelectedItem());
                                                ps.setInt(3, Integer.parseInt(salidas1.labelnid.getText()));
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    //       
                                                }
                                            } catch (java.sql.SQLException ex) {
                                                error = ex.getMessage();
                                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                            }
                                            for (int i = 0; i < salidas.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("spu_guardadetallessalida ?,?,?,?,?,?,?,?");
                                                    ps.setInt(1, salidas.get(i).getidentrada());
                                                    ps.setString(2, salidas.get(i).getcodmaterial());
                                                    ps.setString(3, salidas.get(i).getnommaterial());
                                                    ps.setString(4, salidas.get(i).getcategoria());
                                                    ps.setString(5, salidas.get(i).getmedida());
                                                    ps.setString(6, salidas.get(i).getalmacen());
                                                    ps.setInt(7, salidas.get(i).getcant());
                                                    ps.setString(8, salidas.get(i).getdescripcion());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                            //       
                                                    }
                                                } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            for (int i = 0; i < salidas.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("spu_guardadetallesnotadesalida ?,?,?,?,?,?");
                                                    ps.setString(1, salidas.get(i).getcodmaterial());
                                                    ps.setString(2, salidas.get(i).getcategoria());
                                                    ps.setString(3, salidas.get(i).getmedida());
                                                    ps.setString(4, salidas.get(i).getalmacen());
                                                    ps.setInt(5, salidas.get(i).getcant());
                                                    ps.setString(6, salidas.get(i).getdescripcion());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //       
                                                    }
                                                } catch (java.sql.SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            for (int i = 0; i < salidas.size(); i++) {
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_restaexistenciamaterial ?,?");
                                                    ps.setString(1, salidas.get(i).getcodmaterial());
                                                    ps.setInt(2, salidas.get(i).getcant());
                                                    rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        //
                                                    }
                                               } catch (SQLException ex) {
                                                    error = ex.getMessage();
                                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                                }
                                            }
                                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Salida Guardada con Exito </h3></html>",
                                                     null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                            try {
                                                reportesalmacen.ReporteNotaSalida(Integer.parseInt(salidas1.labelnid.getText()), Integer.parseInt(salidas1.labelnid.getText()));
                                            } catch (JRException | IOException ex) {
                                                Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } catch (SQLException ex) {
                                            error = ex.getMessage();
                                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                        }ps.close();
                                    }
                                } catch (SQLException ex) {
                                    error = ex.getMessage();
                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                }
                                modelosalida.setRowCount(0);
                                salidas1.labelnid.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Ingrese una Cantidad Valida y Mayor a 0</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                            }   
                        }else {
                            JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
                            //fin codigo salidas...
                        }
                        break;
                //inicio codigo transferencia
                case 2: if (numregtrans > 0){
                            for (int i = 0; i < numregtrans; i++) {
                                int j = 1;
                                valida = (String) modelotransferencia.getValueAt(i, 4);
                                    if (new ValidarDatos().vacio(valida)) {
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
                                            transferenciaalmacen.labelnid.setText(rs.getString(1));
                                                for (int i = 0; i < numregtrans; i++) {
                                                    idtransferencia = Integer.parseInt(transferenciaalmacen.labelnid.getText());
                                                    codmaterial = (String) modelotransferencia.getValueAt(i, 0);
                                                    nommaterial = (String) modelotransferencia.getValueAt(i, 1);
                                                    medida = (String) modelotransferencia.getValueAt(i, 2);
                                                    almacenori = (String) modelotransferencia.getValueAt(i, 3);
                                                    almacendes = (String) modelotransferencia.getValueAt(i, 4);
                                                    motivo = (String) modelotransferencia.getValueAt(i, 5);
                                                    arraytrans = new DetalleTransferencias();
                                                    arraytrans.setidtransferencia(idtransferencia);
                                                    arraytrans.setcodmaterial(codmaterial);
                                                    arraytrans.setnommaterial(nommaterial);
                                                    arraytrans.setmedida(medida);
                                                    arraytrans.setalmacenori(almacenori);
                                                    arraytrans.setalmacendes(almacendes);
                                                    arraytrans.setmotivo(motivo);
                                                    transferencias.add(arraytrans);
                                                }
                                                try {
                                                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotatransferencia ?,?");
                                                    ps.setString(1, fechatransferencia);
                                                    ps.setInt(2, Integer.parseInt(transferenciaalmacen.labelnid.getText()));
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
                                                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetalletransferencia ?,?,?,?,?,?,?");
                                                        ps.setInt(1, transferencias.get(i).getidtransferencia());
                                                        ps.setString(2, transferencias.get(i).getcodmaterial());
                                                        ps.setString(3, transferencias.get(i).getnommaterial());
                                                        ps.setString(4, transferencias.get(i).getmedida());
                                                        ps.setString(5, transferencias.get(i).getalmacenori());
                                                        ps.setString(6, transferencias.get(i).getalmacendes());
                                                        ps.setString(7, transferencias.get(i).getmotivo());
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
                                                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetallesnotatransferencia ?,?,?,?,?");
                                                        ps.setString(1, transferencias.get(i).getcodmaterial());
                                                        ps.setString(2, transferencias.get(i).getmedida());
                                                        ps.setString(3, transferencias.get(i).getalmacenori());
                                                        ps.setString(4, transferencias.get(i).getalmacendes());
                                                        ps.setString(5, transferencias.get(i).getmotivo());
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
                                                    reportesalmacen.ReporteNotaTransferencia(Integer.parseInt(transferenciaalmacen.labelnid.getText()));
                                                } catch (JRException | IOException ex) {
                                                    Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
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
                                transferenciaalmacen.labelnid.setText("");
                            }else{
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Indique el Almacén de Destino</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                            }    
                        } else {
                            JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
                        }    
            }
        }        
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
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
            java.util.logging.Logger.getLogger(MovimientosAlmacen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosAlmacen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosAlmacen1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane TabbedPaneMovimientos;
    private javax.swing.JButton botonaceptar;
    private Paneles.Entradas entradas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelaceptar;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    private Paneles.Salidas salidas1;
    private Paneles.TransferenciaAlmacen transferenciaalmacen;
    // End of variables declaration//GEN-END:variables
}
