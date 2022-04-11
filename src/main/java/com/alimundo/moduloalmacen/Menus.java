/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alimundo.moduloalmacen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Alimundo-SRV
 */
public class Menus {
    
    String letramenus = "Verdana";
    int tamnnoletramenus = 22;
    int tamannoletrapopups = 18;
    int negritamenus = 1;
    public static int opcionpopup;
    public JMenuBar MenuPrincipal;
    Conexion con = new Conexion();
    String nombre;
    int numcargos = 0;
    public static int []vectorcargos; 
    public static String seleccionasig;
    public static String selecciondeducc;
    public static String seleccionidasistencia;
    public static String seleccionfechaasistencia;
    public static String seleccioncondiciondia;
    public int estatusasistencia = 0;
    String error;
    

    public JMenuBar CreaMenuPrincipal(){
        
        JMenu Salir,MovimientosAlmacen,Ayuda;
        //JMenuItem Cerrar,Salir;
        //JMenuItem Entrada,Salidas,Ajustes;
        //JMenuItem Acerca_de,Manual_Sistema;
      
        MenuPrincipal = new javax.swing.JMenuBar();
 
       /** Barra Menus **/
        Salir = new javax.swing.JMenu();
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/exit.png")));
        MovimientosAlmacen = new javax.swing.JMenu();
        MovimientosAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/forklift.png")));
        Ayuda = new javax.swing.JMenu();
        Ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/questions.png")));
        
       MenuPrincipal.add(Salir);
       MenuPrincipal.add(MovimientosAlmacen);
       MenuPrincipal.add(Ayuda);
       
        Salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evento) {
            System.exit(0);
        }
        });
       return MenuPrincipal;
    }
           

}    
                           
   

        
        
        
        
        
        
        
 
        
       
 
