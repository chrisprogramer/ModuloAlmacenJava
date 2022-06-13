/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.alimundo.moduloalmacen;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author AdminSrv
 */
public class NuevoMaterial extends javax.swing.JDialog {

    Conexion con = new Conexion();
    ValidarDatos validar = new ValidarDatos();
    String error;
    int errorsql;
    int LongitudBytes;
    FileInputStream foto = null;

    public NuevoMaterial() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        new CargarComponentes().llenarchoice(choicecategorias, "EXEC spu_retornacategorias");
        new CargarComponentes().llenarchoice(choicemedidas, "EXEC spu_retornamedidas");
        new CargarComponentes().llenarchoice(choicealmacenes, "EXEC spu_retornaalmacenes");
        this.textfieldcodigo.requestFocus();
        setModal(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelcerrar = new javax.swing.JLabel();
        labelcodigo = new javax.swing.JLabel();
        textfieldcodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelnommat = new javax.swing.JLabel();
        texfieldnombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        labelcategoria = new javax.swing.JLabel();
        choicecategorias = new java.awt.Choice();
        labelmedida = new javax.swing.JLabel();
        choicemedidas = new java.awt.Choice();
        labelalmacen = new javax.swing.JLabel();
        choicealmacenes = new java.awt.Choice();
        labeldescripcion = new javax.swing.JLabel();
        textfielddescripcion = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        labeltotemin = new javax.swing.JLabel();
        textfieldtopemin = new javax.swing.JTextField();
        botonaceptar = new javax.swing.JButton();
        botonbuscar = new javax.swing.JButton();
        labelbuscar = new javax.swing.JLabel();
        labelaceptar = new javax.swing.JLabel();
        botonmodificar = new javax.swing.JButton();
        labelmodificar = new javax.swing.JLabel();
        panelopciones = new javax.swing.JPanel();
        labeltitulo = new javax.swing.JLabel();
        labelfoto = new javax.swing.JLabel();
        labelfotografia = new javax.swing.JLabel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(582, 539));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        getContentPane().setLayout(null);

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar);
        labelcerrar.setBounds(540, 0, 32, 40);

        labelcodigo.setBackground(new java.awt.Color(255, 255, 255));
        labelcodigo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelcodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcodigo.setText("Codigo:");
        labelcodigo.setOpaque(true);
        getContentPane().add(labelcodigo);
        labelcodigo.setBounds(70, 50, 90, 30);

        textfieldcodigo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        textfieldcodigo.setForeground(new java.awt.Color(255, 0, 0));
        textfieldcodigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textfieldcodigo.setOpaque(false);
        getContentPane().add(textfieldcodigo);
        textfieldcodigo.setBounds(170, 50, 300, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(170, 80, 300, 10);

        labelnommat.setBackground(new java.awt.Color(255, 255, 255));
        labelnommat.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnommat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnommat.setText("Nombre:");
        labelnommat.setOpaque(true);
        getContentPane().add(labelnommat);
        labelnommat.setBounds(70, 90, 90, 30);

        texfieldnombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        texfieldnombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        texfieldnombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        texfieldnombre.setOpaque(false);
        getContentPane().add(texfieldnombre);
        texfieldnombre.setBounds(170, 90, 300, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(170, 120, 300, 10);

        labelcategoria.setBackground(new java.awt.Color(255, 255, 255));
        labelcategoria.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelcategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcategoria.setText("Categoria:");
        labelcategoria.setOpaque(true);
        getContentPane().add(labelcategoria);
        labelcategoria.setBounds(70, 130, 90, 30);

        choicecategorias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(choicecategorias);
        choicecategorias.setBounds(170, 130, 280, 40);

        labelmedida.setBackground(new java.awt.Color(255, 255, 255));
        labelmedida.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelmedida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelmedida.setText("Medida:");
        labelmedida.setOpaque(true);
        getContentPane().add(labelmedida);
        labelmedida.setBounds(90, 170, 70, 30);

        choicemedidas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(choicemedidas);
        choicemedidas.setBounds(170, 170, 280, 40);

        labelalmacen.setBackground(new java.awt.Color(255, 255, 255));
        labelalmacen.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelalmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelalmacen.setText("Asignar Almacén:");
        labelalmacen.setOpaque(true);
        getContentPane().add(labelalmacen);
        labelalmacen.setBounds(10, 210, 150, 30);

        choicealmacenes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(choicealmacenes);
        choicealmacenes.setBounds(170, 210, 280, 40);

        labeldescripcion.setBackground(new java.awt.Color(255, 255, 255));
        labeldescripcion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeldescripcion.setText("Descripción:");
        labeldescripcion.setOpaque(true);
        getContentPane().add(labeldescripcion);
        labeldescripcion.setBounds(50, 250, 110, 30);

        textfielddescripcion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfielddescripcion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textfielddescripcion.setOpaque(false);
        textfielddescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfielddescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(textfielddescripcion);
        textfielddescripcion.setBounds(170, 250, 300, 30);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(170, 279, 300, 10);

        labeltotemin.setBackground(new java.awt.Color(255, 255, 255));
        labeltotemin.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeltotemin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltotemin.setText("Tope Minimo:");
        labeltotemin.setOpaque(true);
        getContentPane().add(labeltotemin);
        labeltotemin.setBounds(50, 290, 110, 30);

        textfieldtopemin.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        textfieldtopemin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textfieldtopemin.setText("0");
        textfieldtopemin.setToolTipText("");
        getContentPane().add(textfieldtopemin);
        textfieldtopemin.setBounds(170, 290, 80, 30);

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/add_paper_plus_insert_append_incorporate_icon_141955.png"))); // NOI18N
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar);
        botonaceptar.setBounds(500, 450, 60, 60);

        botonbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/search_look_for_seek_magnifying_glass_lens_icon_141967.png"))); // NOI18N
        botonbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botonbuscar);
        botonbuscar.setBounds(440, 450, 60, 60);

        labelbuscar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelbuscar.setText("Buscar");
        getContentPane().add(labelbuscar);
        labelbuscar.setBounds(450, 510, 50, 16);

        labelaceptar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelaceptar.setText("Aceptar");
        getContentPane().add(labelaceptar);
        labelaceptar.setBounds(510, 510, 60, 16);

        botonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/edit_pencil_paper_modify_write_icon_141958.png"))); // NOI18N
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonmodificar);
        botonmodificar.setBounds(380, 450, 60, 60);

        labelmodificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelmodificar.setText("Modificar");
        getContentPane().add(labelmodificar);
        labelmodificar.setBounds(380, 510, 70, 16);

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones);
        panelopciones.setBounds(0, 40, 30, 500);

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("MATERIALES");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo);
        labeltitulo.setBounds(0, 0, 581, 40);

        labelfoto.setBackground(new java.awt.Color(255, 255, 255));
        labelfoto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfoto.setText("Foto:");
        labelfoto.setOpaque(true);
        getContentPane().add(labelfoto);
        labelfoto.setBounds(110, 330, 41, 18);

        labelfotografia.setBackground(new java.awt.Color(255, 255, 255));
        labelfotografia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelfotografia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelfotografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs96X96/foto.png"))); // NOI18N
        labelfotografia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelfotografia.setOpaque(true);
        labelfotografia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelfotografiaMouseClicked(evt);
            }
        });
        getContentPane().add(labelfotografia);
        labelfotografia.setBounds(170, 330, 160, 140);

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo);
        labelfondo.setBounds(0, 0, 581, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] textoOpciones = {"Si", "No"};
        int cantidad;
        int LongitudBytesSilueta;
        FileInputStream FotoSilueta = null;
        
        int opc = JOptionPane.showOptionDialog(null, "<html><h3 style=font-family:Verdana New;>¿Esta Seguro que Desea Guardar la Entrada?</h3></html>",
                null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0) {
            if (validar.vacio(this.textfieldcodigo.getText(), this.texfieldnombre.getText())) {
                    if (ValidarDatos.isNumeric(this.textfieldtopemin.getText()) || this.textfieldtopemin.getText().equals('0')) {
                        try {
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardanvomaterial1 ?,?,?,?,?,?,?,?");
                            ps.setString(1, this.textfieldcodigo.getText());
                            ps.setString(2, this.texfieldnombre.getText());
                            ps.setString(3, this.choicecategorias.getSelectedItem());
                            ps.setString(4, this.choicemedidas.getSelectedItem());
                            ps.setString(5, this.choicealmacenes.getSelectedItem());
                            ps.setString(6, this.textfielddescripcion.getText());
                            ps.setInt(7,Integer.parseInt(this.textfieldtopemin.getText()));
                            if (foto != null) {
                                ps.setBlob(8, foto, LongitudBytes);
                            } else {
                                try {
                                    foto = new FileInputStream("C:\\Users\\AdminSrv\\Documents\\NetBeansProjects\\ModuloAlmacen\\src\\main\\resources\\pngs96X96\\foto.png");
                                    ps.setBlob(8, foto);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(NuevoMaterial.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Material Guardado con Exito </h3></html>",
                                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                this.textfieldcodigo.setText(" ");
                                this.texfieldnombre.setText(" ");
                                this.textfielddescripcion.setText(" ");
                                this.labelfotografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs96X96/manssilhouette_83703.png")));
                            }
                            ps.close();
                        } catch (SQLException ex) {
                            errorsql = ex.getErrorCode();
                            if (errorsql == 2627) {
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Material ya existe en el Sistema</h3></html>",
                                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                            } else {
                                error = ex.getMessage();
                                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Ingresar un Tope Minimo Valido</h3></html>",
                            "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                    }   
            } else {
                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Codigo y Nombre no pueden estar vacios</h3></html>",
                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            }
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonaceptarActionPerformed

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        new Busqueda().setVisible(true);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonbuscarActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        if(validar.vacio(this.textfieldcodigo.getText(),this.texfieldnombre.getText())){
            if(ValidarDatos.isNumeric(this.textfieldtopemin.getText())){
                try {
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    ps = con.EstablecerConexion().prepareStatement("EXEC spu_modificarmaterial ?,?,?,?,?,?,?,?");
                    ps.setString(1, this.textfieldcodigo.getText());
                    ps.setString(2, this.texfieldnombre.getText());
                    ps.setString(3, this.choicecategorias.getSelectedItem());
                    ps.setString(4, this.choicemedidas.getSelectedItem());
                    ps.setString(5, this.choicealmacenes.getSelectedItem());
                    ps.setString(6, this.textfielddescripcion.getText());
                    ps.setInt(7, Integer.parseInt(this.textfieldtopemin.getText()));
                     if (foto != null) {
                        ps.setBlob(8, foto, LongitudBytes);
                        }else {
                               try {
                                   foto = new FileInputStream("C:\\Users\\AdminSrv\\Documents\\NetBeansProjects\\ModuloAlmacen\\src\\main\\resources\\pngs96X96\\foto.png");
                                   ps.setBlob(8, foto);
                               } catch (FileNotFoundException ex) {
                                    Logger.getLogger(NuevoMaterial.class.getName()).log(Level.SEVERE, null, ex);
                               }
                        }
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Material Modificado con Exito </h3></html>",
                                null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                        this.textfieldcodigo.setText(" ");
                        this.texfieldnombre.setText(" ");
                        this.textfielddescripcion.setText(" ");
                    }
                    ps.close();
                } catch (SQLException ex) {
                    errorsql = ex.getErrorCode();
                    if (errorsql == 0){
                        JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Codigo ingresado no existe en el Sistema</h3></html>",
                                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                    }else{
                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Ingresar un Tope Minimo Valido</h3></html>",
                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                }   
        }else {JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Codigo y Nombre no pueden estar vacios</h3></html>",
                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            
        }
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void textfielddescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfielddescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfielddescripcionActionPerformed

    private void labelfotografiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelfotografiaMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException ex) {
            Logger.getLogger(NuevoMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFileChooser PanelFoto = new JFileChooser();
        PanelFoto.setDialogTitle("Seleccione la Foto del Material");
        PanelFoto.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int n = PanelFoto.showOpenDialog(null);
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (n == JFileChooser.APPROVE_OPTION){
            try{
                foto = new FileInputStream(PanelFoto.getSelectedFile());
                this.LongitudBytes = (int) PanelFoto.getSelectedFile().length();
                Image icono = ImageIO.read(PanelFoto.getSelectedFile()).getScaledInstance(this.labelfotografia.getWidth(), this.labelfotografia.getHeight(), Image.SCALE_DEFAULT);
                this.labelfotografia.setIcon(new ImageIcon(icono));
                this.labelfotografia.updateUI();
            }catch(IOException | java.lang.NullPointerException ex){
                JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>El Achivo no es una Imagen</h3></html> " ,
                    null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
            }
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelfotografiaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonaceptar;
    private javax.swing.JButton botonbuscar;
    private javax.swing.JButton botonmodificar;
    public java.awt.Choice choicealmacenes;
    public java.awt.Choice choicecategorias;
    public java.awt.Choice choicemedidas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelaceptar;
    private javax.swing.JLabel labelalmacen;
    private javax.swing.JLabel labelbuscar;
    private javax.swing.JLabel labelcategoria;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelcodigo;
    private javax.swing.JLabel labeldescripcion;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelfoto;
    public javax.swing.JLabel labelfotografia;
    private javax.swing.JLabel labelmedida;
    private javax.swing.JLabel labelmodificar;
    private javax.swing.JLabel labelnommat;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JLabel labeltotemin;
    private javax.swing.JPanel panelopciones;
    public javax.swing.JTextField texfieldnombre;
    public javax.swing.JTextField textfieldcodigo;
    public javax.swing.JTextField textfielddescripcion;
    public javax.swing.JTextField textfieldtopemin;
    // End of variables declaration//GEN-END:variables

}
