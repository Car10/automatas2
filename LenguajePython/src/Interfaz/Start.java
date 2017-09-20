/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Alexis Salazar
 */

/**
 * El fragmento de código java.awt.EventQueue.invokeLater(new Runnable()).... es el que inicia el Frame sobre el que trabajamos y originalmente 
 * se encontraba en el JForm Programa, el código antes de eso se agrego a esta parte 
 * para poderle dar ese ambiente de windows a todo el programa, se separo en una clase aparte, porque el Frame solo se hacia visible pero no se corria su metodo main, asi que no podia hacer
 * el cambio del ambiente de Windows, asi que para poder iniciar desde su main, y que lograramos ese cambio, se separo en esta clase con este metodo. 
 */
public class Start {
    public void empezar() {
        
        //Ambiente de Windows
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
         //Iniciamos el Frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Inicio().setVisible(true);
            }
        });
        
    }
}
