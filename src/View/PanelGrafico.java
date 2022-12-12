/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-12-2022 ***
 *Fecha de actualización:11-12-2022
 *Descripción: Clase creacion de los paneles y objetos
 **
 * *************************************************************************** */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class PanelGrafico extends javax.swing.JPanel implements Runnable {

    private int x = 0;
    private int y = 0;
    int xa = 1;
    int ya = 1;
    int xb = 1;
    int yb = 1;
    private int posx = 350;
    private int posy = 350;
    private int angulo = 0;
    private static final int DIAMETER = 30;
    private ImageIcon fondo;
    private static final int WITH = 30;

    public PanelGrafico() {
        initComponents();   
        this.setFocusable(true);
        this.setBounds(10, 10, 350, 350);
        this.setBackground(Color.red);
        this.setSize(350, 350);
    }

    @Override
    public void paint(Graphics g) {
        //cargar el fondo del panel 
        Dimension tamaño = this.getSize();
        fondo = new ImageIcon(getClass().getResource("../img/fondo2.gif"));
        g.drawImage(fondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);
        setOpaque(false);
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2d2 = (Graphics2D) g;
        Toolkit t2 = Toolkit.getDefaultToolkit();
        Image img2 = t2.getImage("src/img/pelota.png");
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("src/img/pelota3.png");
        g2d.drawImage(img, x, y, this);
        g2d2.drawImage(img2, posx, posy, this);
        Thread hilo = new Thread(this);
        hilo.start();
        try {
            Thread.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanelGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

        repaint();
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

    @Override
    public void run() {
        Mover1();
        Mover2();
    }

    public void Mover1() {

        if (x + xa < 0) {
            xa = 1;
        }
        if (x + xa > this.getWidth() - WITH) {
            xa = -1;
        }
        if (y + ya < 0) {
            ya = 1;
        }
        if (y + ya > this.getHeight() - WITH) {
            ya = -1;
        }
        if (collision()) {
            ya = 1;

        }

        x = x + xa;
        y = y + ya;
    }

    public void Mover2() {

        if (posx + xb < 0) {
            xb = 1;
        }
        if (posx + xb > this.getWidth() - WITH) {
            xb = -1;
        }
        if (posy + yb < 0) {
            yb = 1;
        }
        if (posy + yb > this.getHeight() - WITH) {
            yb = -1;
        }

        posx = posx + xb;
        posy = posy + yb;
    }

    

    public Rectangle getBounds() {
        return new Rectangle(x, y, WITH, WITH);
    }

    private boolean collision() {
        return this.getBounds().intersects(getBounds2());
    }
     public Rectangle getBounds2() {
        return new Rectangle(posx, posy, DIAMETER, DIAMETER);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
