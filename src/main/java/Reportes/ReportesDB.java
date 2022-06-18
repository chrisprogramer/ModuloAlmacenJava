/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import com.alimundo.moduloalmacen.Parametros;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author Alimundo-SRV
 */
public class ReportesDB {
 
    String ruta = null;
    String error;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Connection EstablecerConexion() throws SQLException {
       Connection con = null; 
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://AlimundoSRV:1433;databaseName=RegistroAlmacen","AlmacenAdmin","AlimundoStore");
        }catch (ClassNotFoundException | SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }   
        return con;
    }
    
    public String RetornaRuta(){
        try{
           ps = this.EstablecerConexion().prepareStatement("EXEC spu_devuelverutaRptsServidor"); 
           rs = ps.executeQuery();
            while (rs.next()){
                ruta = (rs.getString(1));
            }ps.close();
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror); 
        }
        return ruta;
    }

    public void ExportarPDF(JasperPrint reporte, String nombrerpt, int numnota) throws JRException{
        String rutafinal = null;
        rutafinal = this.RetornaRuta();
        File directorio = new File(rutafinal);
        
        if (directorio.isDirectory()){
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(reporte));
            try{
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(rutafinal + nombrerpt + " " + numnota + ".pdf"));    
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();
            }catch(JRRuntimeException ex){
                JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>EL ARCHIVO ESTA SIENDO USADO POR OTRO PROGRAMA..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>LA RUTA DEL DIRECTORIO NO EXISTE..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }    
    }
    public void ExportarPDF(JasperPrint reporte, String nombrerpt) throws JRException{
        String rutafinal = null;
        rutafinal = this.RetornaRuta();
        File directorio = new File(rutafinal);
        
        if (directorio.isDirectory()){
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(reporte));
            try{
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(rutafinal + nombrerpt + ".pdf"));    
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();
            }catch(JRRuntimeException ex){
                JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>EL ARCHIVO ESTA SIENDO USADO POR OTRO PROGRAMA..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>LA RUTA DEL DIRECTORIO NO EXISTE..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }
    }    

    public void AbrirPDF(String ruta) throws IOException{
        try {
        File path = new File (ruta);
        Desktop.getDesktop().open(path);
        }catch (IOException ex) {
           error = ex.getMessage();
           JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);  
        } 
    }
    
    public void ReporteNotaEntrega(int idnotaentrega, int numnota) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotaentrega", idnotaentrega);
        String nombrearch = "Nota de Entrega";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                   + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, numnota);
            rutacompleta = ruta + nombrearch + " " + numnota + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }  
    public void SubReporteNotaEntrega(int idnotaentrega) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotaentregasub", idnotaentrega);
        String nombrearch = "Sub_ReporteNotas";
        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteNotaSalida(int idnotasalida, int numnota) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotasalida", idnotasalida);
        String nombrearch = "Nota de Salida";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, numnota);
            rutacompleta = ruta + nombrearch + " " + numnota + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteNotaPrestamo(int idnotaprestamo, int numnota) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotaprestamo", idnotaprestamo);
        String nombrearch = "Nota de Prestamo";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, numnota);
            rutacompleta = ruta + nombrearch + " " + numnota + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
        public void ReporteNotaDevPrestamo(int idnotadevprestamo, int numnota) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotadevprestamo", idnotadevprestamo);
        String nombrearch = "Nota de DevPrestamo";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, numnota);
            rutacompleta = ruta + nombrearch + " " + numnota + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void SubReporteNotaSalida(int idnotasalida) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotasalida", idnotasalida);
        String nombrearch = "Sub_ReporteNotasSalidas";
        
        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void SubReporteNotaPrestamo(int idnotaprestamo) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotaprestamosub", idnotaprestamo);
        String nombrearch = "Sub_ReporteNotasPrestamos";
        
        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
     public void SubReporteDevNotaPrestamo(int idnotadevprestamo) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotadevprestamosub", idnotadevprestamo);
        String nombrearch = "Sub_ReporteNotasDevPrestamo";
        
        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    } 
    public void ReporteConsolidadoAlmacen() throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        String nombrearch = "Consolidado de Almacen";
        String rutacompleta;
        try {
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",null, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }  
    public void ReporteEntradaMaterialxCategoria(String nom_categoria, String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("nom_categoria", nom_categoria);
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Entrada por Categoria";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteSalidaMaterialxCategoria(String nom_categoria, String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("nom_categoria", nom_categoria);
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Salida por Categoria";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteEntradaMaterialxMaterial(String codigo, String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("codigo", codigo);
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Entrada por Material";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteSalidaMaterialxMaterial(String codigo, String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("codigo", codigo);
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Salida por Material";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteEntradaMaterialxFecha(String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Entrada por Fecha";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteSalidaMaterialxFecha(String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Salida por Fecha";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteEntradaMaterialxDepartamento(String nom_departamento,String fdesde, String fhasta ) throws SQLException, JRException, IOException{
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("nom_departamento",nom_departamento);
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Entrada por Departamento";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
        public void ReporteSalidaMaterialxDepartamento(String nom_departamento,String fdesde, String fhasta ) throws SQLException, JRException, IOException{
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("nom_departamento",nom_departamento);
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Salida por Departamento";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteNotaTransferencia(int idnota) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotatransferencia", idnota);
        String nombrearch = "Nota de Transferencia";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteGastosdeSalidaxFecha(String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Gastos por Fecha";
        String rutacompleta;
        try { 
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                    + nombrearch + ".jasper",parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteMaterialenPrestamo() throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        String nombrearch = "Nota de MaterialenPrestamo";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", null, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteAlertaMaterial() throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        String nombrearch = "Nota de AlertaMateriales";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", null, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
        public void ReporteEntradasxContainers(String fdesde, String fhasta) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("fdesde", fdesde);
        parametro.put("fhasta", fhasta);
        String nombrearch = "Nota de EntradasxContainers";
        String rutacompleta;
        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch);
            rutacompleta = ruta + nombrearch + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
}
