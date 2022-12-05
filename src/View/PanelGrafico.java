/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase controller del Jugador
 **
 * ****************************************************************************/
package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class PanelGrafico extends javax.swing.JPanel {
        private final int x= 20;
        private final int y= 20;
    public PanelGrafico() {
        initComponents();
        this.setBounds(10,10,350,350);
        this.setBackground(Color.red);
        this.setSize(350,350);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.yellow);
        g2d.fillOval(x, y, 50, 50);
        g2d.setColor(Color.BLUE);
        g2d.drawOval(x, y, 50, 50);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
