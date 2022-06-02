/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.moduloalmacen;

import Reportes.ReportesDB;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

public class Consultas extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel();
    Conexion con = new Conexion();
    String seleccion;
    String seleccionrpt;
    String selecciondpto;
    ReportesDB reportesalmacen = new ReportesDB();
    ValidarDatos validardatos = new ValidarDatos();
    String error;
    Date fechahoy;
    String fechadesde;
    String fechahasta;
    String seleccionradio;
    String fechaformat = "dd/MM/yyyy";
    SimpleDateFormat dateformat = new SimpleDateFormat(fechaformat);
    JTextFieldDateEditor editor;
    String selecciontiporpt;
    DefaultTableModel modelobusqueda = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 5) {
                return true;
            } else {
                return false;
            }
        }
    };
    DefaultTableModel modelomovimientos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 6) {
                return true;
            } else {
                return false;
            }
        }
    };

    public Consultas() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        fechahoy = new Date();

        this.datedesde.setDateFormatString(fechaformat);
        this.datedesde.setDate(fechahoy);
        this.datehasta.setDateFormatString(fechaformat);
        this.datehasta.setDate(fechahoy);
        editor = (JTextFieldDateEditor) datedesde.getDateEditor();
        editor.setEnabled(false);
        editor = (JTextFieldDateEditor) datehasta.getDateEditor();
        editor.setEnabled(false);
        this.choicetiporpt.setEnabled(false);
        this.choicecategorias.setEnabled(false);
        this.choicedepartamentos.setEnabled(false);
        this.textfieldbuscar.setEnabled(false);
        this.botonaceptar.setEnabled(false);
        this.botonbuscar.setEnabled(false);
        this.botonxmaterial.setEnabled(false);
        this.botongastos.setEnabled(false);
        selecciontiporpt = this.choicetiporpt.getSelectedItem();
        //new CargarComponentes().llenarchoice(choicetiporpt, "SELECT nom_opcreporte FROM OpcionRpt");
        new CargarComponentes().llenarchoice(choicedepartamentos, "SELECT nom_departamento FROM Departamentos");
        modelobusqueda.setColumnIdentifiers(new Object[]{"", "", "", "", ""});
        modelomovimientos.setColumnIdentifiers(new Object[]{"", "", "", "", "", ""});

        if (tablebuscarmaterial.getColumnModel().getColumnCount() > 0) {
            tablebuscarmaterial.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Cod.</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(0).setPreferredWidth(250);
            tablebuscarmaterial.getColumnModel().getColumn(0).setMaxWidth(250);
            tablebuscarmaterial.getColumnModel().getColumn(0).setResizable(false);
            tablebuscarmaterial.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Material</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(1).setPreferredWidth(900);
            tablebuscarmaterial.getColumnModel().getColumn(1).setMaxWidth(900);
            tablebuscarmaterial.getColumnModel().getColumn(1).setResizable(false);
            tablebuscarmaterial.getColumnModel().getColumn(2).setHeaderValue("<html><h3 style=font-family:Medida;>Medida</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(2).setPreferredWidth(300);
            tablebuscarmaterial.getColumnModel().getColumn(2).setMaxWidth(300);
            tablebuscarmaterial.getColumnModel().getColumn(2).setResizable(false);
            tablebuscarmaterial.getColumnModel().getColumn(3).setHeaderValue("<html><h3 style=font-family:Verdana;>Cant.</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablebuscarmaterial.getColumnModel().getColumn(3).setMaxWidth(150);
            tablebuscarmaterial.getColumnModel().getColumn(3).setResizable(false);
            tablebuscarmaterial.getColumnModel().getColumn(4).setHeaderValue("<html><h3 style=font-family:Verdana;>Precio</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(4).setPreferredWidth(200);
            tablebuscarmaterial.getColumnModel().getColumn(4).setMaxWidth(200);
            tablebuscarmaterial.getColumnModel().getColumn(4).setResizable(false);
        }
        tablebuscarmaterial.getTableHeader().setReorderingAllowed(false);
        this.tablebuscarmaterial.setEnabled(false);

        if (tablemovimientos.getColumnModel().getColumnCount() > 0) {
            tablemovimientos.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Nota</h3></html>");
            tablemovimientos.getColumnModel().getColumn(0).setPreferredWidth(150);
            tablemovimientos.getColumnModel().getColumn(0).setMaxWidth(150);
            tablemovimientos.getColumnModel().getColumn(0).setResizable(false);
            tablemovimientos.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Fecha</h3></html>");
            tablemovimientos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tablemovimientos.getColumnModel().getColumn(1).setMaxWidth(300);
            tablemovimientos.getColumnModel().getColumn(1).setResizable(false);
            tablemovimientos.getColumnModel().getColumn(2).setHeaderValue("<html><h3 style=font-family:Verdana;>Cod.</h3></html>");
            tablemovimientos.getColumnModel().getColumn(2).setPreferredWidth(250);
            tablemovimientos.getColumnModel().getColumn(2).setMaxWidth(250);
            tablemovimientos.getColumnModel().getColumn(2).setResizable(false);
            tablemovimientos.getColumnModel().getColumn(3).setHeaderValue("<html><h3 style=font-family:Verdana;>Material</h3></html>");
            tablemovimientos.getColumnModel().getColumn(3).setPreferredWidth(650);
            tablemovimientos.getColumnModel().getColumn(3).setMaxWidth(650);
            tablemovimientos.getColumnModel().getColumn(3).setResizable(false);
            tablemovimientos.getColumnModel().getColumn(4).setHeaderValue("<html><h3 style=font-family:Verdana;>Cant.</h3></html>");
            tablemovimientos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tablemovimientos.getColumnModel().getColumn(4).setMaxWidth(150);
            tablemovimientos.getColumnModel().getColumn(4).setResizable(false);
            tablemovimientos.getColumnModel().getColumn(5).setHeaderValue("<html><h3 style=font-family:Verdana;>Descripción</h3></html>");
            tablemovimientos.getColumnModel().getColumn(5).setPreferredWidth(650);
            tablemovimientos.getColumnModel().getColumn(5).setMaxWidth(650);
            tablemovimientos.getColumnModel().getColumn(5).setResizable(false);
        }
        tablemovimientos.getTableHeader().setReorderingAllowed(false);
        this.tablemovimientos.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotonreportes = new javax.swing.ButtonGroup();
        etchedBorder1 = (javax.swing.border.EtchedBorder)javax.swing.BorderFactory.createEtchedBorder();
        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        radiobotonconsolidado = new javax.swing.JRadioButton();
        radiobotonexistencia = new javax.swing.JRadioButton();
        radiobotonentradas = new javax.swing.JRadioButton();
        radiobotonsalidas = new javax.swing.JRadioButton();
        choicetiporpt = new java.awt.Choice();
        choicecategorias = new java.awt.Choice();
        choicedepartamentos = new java.awt.Choice();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablemovimientos = new javax.swing.JTable();
        botonbuscar = new javax.swing.JButton();
        botonxmaterial = new javax.swing.JButton();
        botongastos = new javax.swing.JButton();
        textfieldbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebuscarmaterial = new javax.swing.JTable();
        datedesde = new com.toedter.calendar.JDateChooser();
        datehasta = new com.toedter.calendar.JDateChooser();
        botonaceptar = new javax.swing.JButton();
        labelborde = new javax.swing.JLabel();
        labelborde2 = new javax.swing.JLabel();
        labeldesde = new javax.swing.JLabel();
        labelhasta = new javax.swing.JLabel();
        labelcategorias = new javax.swing.JLabel();
        labeldptos = new javax.swing.JLabel();
        labelborde1 = new javax.swing.JLabel();
        panelopciones = new javax.swing.JPanel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1349, 665));
        setMinimumSize(new java.awt.Dimension(1349, 665));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1349, 665));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("CONSULTAS");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 40));

        grupobotonreportes.add(radiobotonconsolidado);
        radiobotonconsolidado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radiobotonconsolidado.setText("Consolidado de Almacén");
        radiobotonconsolidado.setOpaque(false);
        radiobotonconsolidado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radiobotonconsolidadoMouseClicked(evt);
            }
        });
        getContentPane().add(radiobotonconsolidado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 63, -1, -1));

        grupobotonreportes.add(radiobotonexistencia);
        radiobotonexistencia.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radiobotonexistencia.setText("Existencia de Material");
        radiobotonexistencia.setOpaque(false);
        radiobotonexistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radiobotonexistenciaMouseClicked(evt);
            }
        });
        getContentPane().add(radiobotonexistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        grupobotonreportes.add(radiobotonentradas);
        radiobotonentradas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radiobotonentradas.setText("Entradas de Materiales");
        radiobotonentradas.setOpaque(false);
        radiobotonentradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radiobotonentradasMouseClicked(evt);
            }
        });
        getContentPane().add(radiobotonentradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 65, -1, -1));

        grupobotonreportes.add(radiobotonsalidas);
        radiobotonsalidas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radiobotonsalidas.setText("Salida de Materiales");
        radiobotonsalidas.setOpaque(false);
        radiobotonsalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radiobotonsalidasMouseClicked(evt);
            }
        });
        getContentPane().add(radiobotonsalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        choicetiporpt.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        choicetiporpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choicetiporptItemStateChanged(evt);
            }
        });
        getContentPane().add(choicetiporpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 260, 30));

        choicecategorias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(choicecategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 162, 260, 30));

        choicedepartamentos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(choicedepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 260, 30));

        tablemovimientos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablemovimientos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablemovimientos.setModel(modelomovimientos);
        tablemovimientos.setShowGrid(true);
        jScrollPane2.setViewportView(tablemovimientos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 670, 310));

        botonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/accept_allow_admit_okay_icon_141954.png"))); // NOI18N
        botonbuscar.setOpaque(false);
        botonbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, 60, 60));

        botonxmaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/accept_allow_admit_okay_icon_141954.png"))); // NOI18N
        botonxmaterial.setOpaque(false);
        botonxmaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonxmaterialActionPerformed(evt);
            }
        });
        getContentPane().add(botonxmaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 60, 60));

        botongastos.setBackground(new java.awt.Color(0, 0, 0));
        botongastos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botongastos.setForeground(new java.awt.Color(255, 255, 255));
        botongastos.setText("Reporte de Gastos");
        botongastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botongastosActionPerformed(evt);
            }
        });
        getContentPane().add(botongastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 180, 180, 40));

        textfieldbuscar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfieldbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfieldbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(textfieldbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 590, 30));

        tablebuscarmaterial.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablebuscarmaterial.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tablebuscarmaterial.setModel(modelobusqueda);
        tablebuscarmaterial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablebuscarmaterial.setShowGrid(true);
        jScrollPane1.setViewportView(tablebuscarmaterial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 590, 300));

        datedesde.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(datedesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 210, 30));

        datehasta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(datehasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 130, 210, 30));

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/file_pdf_icon_188248.png"))); // NOI18N
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 580, 60, 60));

        labelborde.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelborde, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 570, 60));

        labelborde2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelborde2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 470, 60));

        labeldesde.setBackground(new java.awt.Color(255, 255, 255));
        labeldesde.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labeldesde.setLabelFor(datedesde);
        labeldesde.setText("Desde:");
        getContentPane().add(labeldesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 135, -1, -1));

        labelhasta.setBackground(new java.awt.Color(255, 255, 255));
        labelhasta.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelhasta.setText("Hasta:");
        getContentPane().add(labelhasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 135, -1, -1));

        labelcategorias.setBackground(new java.awt.Color(255, 255, 255));
        labelcategorias.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelcategorias.setLabelFor(choicecategorias);
        labelcategorias.setText("Categorias:");
        getContentPane().add(labelcategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 168, -1, -1));

        labeldptos.setBackground(new java.awt.Color(255, 255, 255));
        labeldptos.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labeldptos.setLabelFor(choicecategorias);
        labeldptos.setText("Departamentos:");
        getContentPane().add(labeldptos, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 195, -1, -1));

        labelborde1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelborde1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 710, 520));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 620));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 664));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void radiobotonconsolidadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radiobotonconsolidadoMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        modelomovimientos.setRowCount(0);
        this.choicetiporpt.setEnabled(false);
        this.choicecategorias.setEnabled(false);
        this.choicedepartamentos.setEnabled(false);
        this.botonaceptar.setEnabled(true);
        modelobusqueda.setRowCount(0);
        this.textfieldbuscar.setText("");
        this.textfieldbuscar.setEnabled(false);
        this.tablebuscarmaterial.setEnabled(false);
        this.botonbuscar.setEnabled(false);
        this.botonxmaterial.setEnabled(false);
        this.choicetiporpt.select(0);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_radiobotonconsolidadoMouseClicked

    private void radiobotonentradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radiobotonentradasMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.choicetiporpt.removeAll();
        new CargarComponentes().llenarchoice(choicetiporpt, "SELECT nom_opcreporte FROM OpcionRpt");
        modelobusqueda.setRowCount(0);
        modelomovimientos.setRowCount(0);
        this.textfieldbuscar.setText("");
        this.choicetiporpt.setEnabled(true);
        if ("Por Material".equals(this.choicetiporpt.getSelectedItem())){
            this.textfieldbuscar.setEnabled(true);
            this.tablebuscarmaterial.setEnabled(true);
        } else {
            this.textfieldbuscar.setEnabled(false);
            this.tablebuscarmaterial.setEnabled(false);
        }
        this.botonxmaterial.setEnabled(false);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_radiobotonentradasMouseClicked

    private void radiobotonsalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radiobotonsalidasMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.choicetiporpt.removeAll();
        new CargarComponentes().llenarchoice(choicetiporpt, "SELECT TOP 5 nom_opcreporte FROM OpcionRpt");
        modelobusqueda.setRowCount(0);
        modelomovimientos.setRowCount(0);
        this.textfieldbuscar.setText("");
        this.choicetiporpt.setEnabled(true);
         if ("Por Material".equals(this.choicetiporpt.getSelectedItem())){
            this.textfieldbuscar.setEnabled(true);
            this.tablebuscarmaterial.setEnabled(true);
        } else {
            this.textfieldbuscar.setEnabled(false);
            this.tablebuscarmaterial.setEnabled(false);
        }
        this.botonxmaterial.setEnabled(false);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_radiobotonsalidasMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        seleccionradio = validardatos.getSelectedButtonText(grupobotonreportes);
        selecciontiporpt = this.choicetiporpt.getSelectedItem();
        fechadesde = dateformat.format(this.datedesde.getDate());
        fechahasta = dateformat.format(this.datehasta.getDate());

        switch (seleccionradio) {
            case ("Consolidado de Almacén"):
                try {
                reportesalmacen.ReporteConsolidadoAlmacen();
            } catch (JRException | IOException ex) {
                Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            break;

            case ("Entradas de Materiales"):
                switch (selecciontiporpt){
                    case ("Por Categoria"):
                        seleccion = this.choicecategorias.getSelectedItem();
                        try {
                            reportesalmacen.ReporteEntradaMaterialxCategoria(seleccion, fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                    case ("Por Material"):
                        seleccion = (String) modelo.getValueAt(tablebuscarmaterial.getSelectedRow(), 0);
                        try {
                            reportesalmacen.ReporteEntradaMaterialxMaterial(seleccion, fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                    case ("Por Fecha"):
                        try {
                            reportesalmacen.ReporteEntradaMaterialxFecha(fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                    case ("Por Departamento"):
                        selecciondpto = (String) this.choicedepartamentos.getSelectedItem();
                        try {
                            reportesalmacen.ReporteEntradaMaterialxDepartamento(selecciondpto,fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                    case ("Por Container"):
                        try {
                            reportesalmacen.ReporteEntradasxContainers();
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(SalidaManual.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                }
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
            case ("Salida de Materiales"):
                switch (selecciontiporpt){
                    case ("Por Categoria"):
                        seleccion = this.choicecategorias.getSelectedItem();
                        try {
                            reportesalmacen.ReporteSalidaMaterialxCategoria(seleccion, fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                    case ("Por Material"):
                        seleccion = (String) modelo.getValueAt(tablebuscarmaterial.getSelectedRow(), 0);
                        try {
                            reportesalmacen.ReporteSalidaMaterialxMaterial(seleccion, fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                    case ("Por Fecha"):
                         try {
                            reportesalmacen.ReporteSalidaMaterialxFecha(fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;
                     case ("Por Departamento"):
                        selecciondpto = (String) this.choicedepartamentos.getSelectedItem();
                        try {
                            reportesalmacen.ReporteSalidaMaterialxDepartamento(selecciondpto,fechadesde, fechahasta);
                        } catch (JRException | IOException ex) {
                            Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        break;    
                }
                break;
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonaceptarActionPerformed

    private void choicetiporptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choicetiporptItemStateChanged
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        selecciontiporpt = this.choicetiporpt.getSelectedItem();
        switch (selecciontiporpt) {
            case "Por Categoria":
                this.choicecategorias.setEnabled(true);
                this.choicedepartamentos.setEnabled(false);
                this.textfieldbuscar.setText("");
                this.textfieldbuscar.setEnabled(false);
                this.tablebuscarmaterial.setEnabled(false);
                this.botonbuscar.setEnabled(true);
                this.botonxmaterial.setEnabled(false);
                this.botonaceptar.setEnabled(false);
                this.botongastos.setEnabled(false);
                modelomovimientos.setRowCount(0);
                modelobusqueda.setRowCount(0);
                new CargarComponentes().llenarchoice(choicecategorias, "SELECT nom_categoria FROM Categorias");
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
            case "Por Material":
                this.textfieldbuscar.requestFocus();
                modelomovimientos.setRowCount(0);
                this.choicecategorias.setEnabled(false);
                this.choicedepartamentos.setEnabled(false);
                this.textfieldbuscar.setEnabled(true);
                this.tablebuscarmaterial.setEnabled(true);
                this.botonaceptar.setEnabled(false);
                this.botonbuscar.setEnabled(false);
                this.botongastos.setEnabled(false);
                modelobusqueda.setRowCount(0);
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
            case "Por Fecha":
                this.choicecategorias.setEnabled(false);
                this.textfieldbuscar.setText("");
                this.textfieldbuscar.setEnabled(false);
                this.tablebuscarmaterial.setEnabled(false);
                this.botonbuscar.setEnabled(true);
                this.botonaceptar.setEnabled(false);
                modelomovimientos.setRowCount(0);
                modelobusqueda.setRowCount(0);
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
            case "Por Departamento":
                this.choicedepartamentos.setEnabled(true);
                this.choicecategorias.setEnabled(false);
                this.textfieldbuscar.setText("");
                this.textfieldbuscar.setEnabled(false);
                this.tablebuscarmaterial.setEnabled(false);
                this.botonbuscar.setEnabled(true);
                this.botonaceptar.setEnabled(false);
                modelomovimientos.setRowCount(0);
                modelobusqueda.setRowCount(0);
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
        }
    }//GEN-LAST:event_choicetiporptItemStateChanged

    private void textfieldbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldbuscarKeyReleased
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        String valor = this.textfieldbuscar.getText();
        seleccionradio = validardatos.getSelectedButtonText(grupobotonreportes);
        boolean bandera = false;
        
        try {
            modelobusqueda.setRowCount(0);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultamaterial ?");
            ps.setString(1, valor);
            rs = ps.executeQuery();
            while (rs.next()) {
                bandera = true;
                if ("Existencia de Material".equals(seleccionradio)){
                    this.botonxmaterial.setEnabled(false);
                }else{
                    this.botonxmaterial.setEnabled(true);
                }
                modelobusqueda.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3), rs.getFloat(4), rs.getFloat(5)});
            }
            if (!bandera) {
                this.botonxmaterial.setEnabled(false);
            }
            ps.close();
        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_textfieldbuscarKeyReleased

    private void radiobotonexistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radiobotonexistenciaMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        modelomovimientos.setRowCount(0);
        this.textfieldbuscar.setEnabled(true);
        this.tablebuscarmaterial.setEnabled(true);
        this.choicetiporpt.setEnabled(false);
        this.choicecategorias.setEnabled(false);
        this.choicedepartamentos.setEnabled(false);
        this.botonaceptar.setEnabled(false);
        this.botonbuscar.setEnabled(false);
        this.botonxmaterial.setEnabled(false);
        this.choicetiporpt.select(0);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_radiobotonexistenciaMouseClicked

    private void botonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        boolean bandera = false;
        this.tablemovimientos.setEnabled(true);
        fechadesde = dateformat.format(this.datedesde.getDate());
        fechahasta = dateformat.format(this.datehasta.getDate());
        seleccion = this.choicecategorias.getSelectedItem();
        seleccionrpt = this.choicetiporpt.getSelectedItem();
        selecciondpto = this.choicedepartamentos.getSelectedItem();
        seleccionradio = validardatos.getSelectedButtonText(grupobotonreportes);

        switch (seleccionradio) {

            case ("Entradas de Materiales"):
                switch(seleccionrpt) {
                    case("Por Categoria"):
                        try {
                            modelomovimientos.setRowCount(0);
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxcategoriasentradas ?,?,?");
                            ps.setString(1, seleccion);
                            ps.setString(2, fechadesde);
                            ps.setString(3, fechahasta);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                bandera = true;
                                this.botonaceptar.setEnabled(true);
                                modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                            }
                            if (!bandera) {
                                this.botonaceptar.setEnabled(false);
                            }
                            ps.close();
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                        break;
                    case("Por Fecha"):
                        try{
                            modelomovimientos.setRowCount(0);
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxfechaentradas ?,?");
                            ps.setString(1, fechadesde);
                            ps.setString(2, fechahasta);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                bandera = true;
                                this.botonaceptar.setEnabled(true);
                                modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                            }
                            if (!bandera) {
                                this.botonaceptar.setEnabled(false);
                            }
                            ps.close();
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                        break;
                    case("Por Departamento"):
                        try {
                            modelomovimientos.setRowCount(0);
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxdepartamentoentradas ?,?,?");
                            ps.setString(1, selecciondpto);
                            ps.setString(2, fechadesde);
                            ps.setString(3, fechahasta);
                            rs = ps.executeQuery();
                            while(rs.next()){
                                bandera = true;
                                this.botonaceptar.setEnabled(true);
                                modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                            }
                            if (!bandera) {
                                this.botonaceptar.setEnabled(false);
                            }
                            ps.close();
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                        break;
                }
                break;
            case ("Salida de Materiales"):
                switch(seleccionrpt){
                    case("Por Categoria"):
                        this.botongastos.setEnabled(false);
                        try {
                            modelomovimientos.setRowCount(0);
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxcategoriassalidas ?,?,?");
                            ps.setString(1, seleccion);
                            ps.setString(2, fechadesde);
                            ps.setString(3, fechahasta);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                bandera = true;
                                this.botonaceptar.setEnabled(true);
                                modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                            }
                            if (!bandera) {
                                this.botonaceptar.setEnabled(false);
                            }
                            ps.close();
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                        break;
                    case("Por Fecha"):
                        try {
                            modelomovimientos.setRowCount(0);
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxfechasalidas ?,?");
                            ps.setString(1, fechadesde);
                            ps.setString(2, fechahasta);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                bandera = true;
                                this.botonaceptar.setEnabled(true);
                                this.botongastos.setEnabled(true);
                                modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                            }
                            if (!bandera) {
                                this.botonaceptar.setEnabled(false);
                            }
                            ps.close();
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                        break;
                    case("Por Departamento"):
                         try {
                            modelomovimientos.setRowCount(0);
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxdepartamentosssalidas ?,?,?");
                            ps.setString(1, selecciondpto);
                            ps.setString(2, fechadesde);
                            ps.setString(3, fechahasta);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                bandera = true;
                                this.botonaceptar.setEnabled(true);
                                modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                            }
                            if (!bandera) {
                                this.botonaceptar.setEnabled(false);
                            }
                            ps.close();
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                        break;
                }    
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonbuscarActionPerformed

    private void botonxmaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonxmaterialActionPerformed

        boolean bandera = false;
        modelo = (DefaultTableModel) tablebuscarmaterial.getModel();
        fechadesde = dateformat.format(this.datedesde.getDate());
        fechahasta = dateformat.format(this.datehasta.getDate());
        seleccionradio = validardatos.getSelectedButtonText(grupobotonreportes);
        try{
            seleccion = (String) modelo.getValueAt(tablebuscarmaterial.getSelectedRow(), 0);
        }catch(java.lang.ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Seleccionar un Registro</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        switch (seleccionradio) {
            case ("Entradas de Materiales"):
                try {
                    modelomovimientos.setRowCount(0);
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxmaterialentradas ?,?,?");
                    ps.setString(1, seleccion);
                    ps.setString(2, fechadesde);
                    ps.setString(3, fechahasta);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        this.botonaceptar.setEnabled(true);
                        bandera = true;
                        modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                    }
                    if (!bandera) {
                        this.botonaceptar.setEnabled(false);
                    }
                    ps.close();
                } catch (SQLException ex) {
                    error = ex.getMessage();
                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                }
                break;
            case ("Salida de Materiales"):
                try {
                    modelomovimientos.setRowCount(0);
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultaxmaterialsalidas ?,?,?");
                    ps.setString(1, seleccion);
                    ps.setString(2, fechadesde);
                    ps.setString(3, fechahasta);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        this.botonaceptar.setEnabled(true);
                        bandera = true;
                        modelomovimientos.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)});
                    }
                    if (!bandera) {
                        this.botonaceptar.setEnabled(false);
                    }
                    ps.close();
                } catch (SQLException ex) {
                    error = ex.getMessage();
                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                }
                break;
        }

    }//GEN-LAST:event_botonxmaterialActionPerformed

    private void botongastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botongastosActionPerformed
        
        fechadesde = dateformat.format(this.datedesde.getDate());
        fechahasta = dateformat.format(this.datehasta.getDate());
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            reportesalmacen.ReporteGastosdeSalidaxFecha(fechadesde, fechahasta);
        } catch (JRException | IOException ex) {
                Logger.getLogger(MovimientosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
       }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botongastosActionPerformed

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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonaceptar;
    private javax.swing.JButton botonbuscar;
    private javax.swing.JButton botongastos;
    private javax.swing.JButton botonxmaterial;
    private java.awt.Choice choicecategorias;
    private java.awt.Choice choicedepartamentos;
    private java.awt.Choice choicetiporpt;
    private com.toedter.calendar.JDateChooser datedesde;
    private com.toedter.calendar.JDateChooser datehasta;
    private javax.swing.border.EtchedBorder etchedBorder1;
    private javax.swing.ButtonGroup grupobotonreportes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelborde;
    private javax.swing.JLabel labelborde1;
    private javax.swing.JLabel labelborde2;
    private javax.swing.JLabel labelcategorias;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labeldesde;
    private javax.swing.JLabel labeldptos;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelhasta;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JRadioButton radiobotonconsolidado;
    private javax.swing.JRadioButton radiobotonentradas;
    private javax.swing.JRadioButton radiobotonexistencia;
    private javax.swing.JRadioButton radiobotonsalidas;
    private javax.swing.JTable tablebuscarmaterial;
    private javax.swing.JTable tablemovimientos;
    private javax.swing.JTextField textfieldbuscar;
    // End of variables declaration//GEN-END:variables
}
