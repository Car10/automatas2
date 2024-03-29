/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author anthony
 */
public class splash extends javax.swing.JPanel {
    ImageIcon imagen; // imagen para mostrar 
    BorderLayout esquema;
    /**
     * Creates new form splash
     */
    public splash() {
        initComponents();
        
        estados.setForeground(Color.white);        
        imagen = new ImageIcon(getClass().getResource("/Imagenes/Python.png")); // se obtiene la imagen 
        this.setSize(imagen.getIconWidth(), imagen.getIconHeight()); // se establece el tamaño del panel 
        // mediante la dimencion de la imagen ancho y alto 
    }
    
    @Override
    public void paintComponent(Graphics g){ // metodo paintComponent para dibujar la imagen 
        super.paintComponent(g); // para que el panel se despligue sin errores 
        g.drawImage(imagen.getImage(), 0, 0, imagen.getIconWidth(), imagen.getIconHeight(), this); // se dibuja la imagen 
        this.setOpaque(false); // se establece el panel transparente para que se pueda ver la imagen 
    } 

    public void velocidadDeCarga() throws InterruptedException{ // motodo para controlar la barra 
        for(int i = 0; i<=100; i++){ // establece el recorrido de la barra de progreso 
            Thread.sleep(8); // pausas para dar el efecto de carga 
            progreso.setForeground(Color.green); // color de la barra de progreso 
            progreso.setValue(i); // se asigna el valor de la barra 
            
        } 
    } 
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progreso = new javax.swing.JProgressBar();
        estados = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 199, 182));

        estados.setBackground(new java.awt.Color(0, 0, 0));
        estados.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        estados.setLabelFor(this);
        estados.setText("Cargando modulos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estados)
                    .addComponent(progreso, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(estados)
                .addGap(5, 5, 5)
                .addComponent(progreso, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estados;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables
}
