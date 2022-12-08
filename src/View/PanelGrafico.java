/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase controller del Jugador
 **
 * *************************************************************************** */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class PanelGrafico extends javax.swing.JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private int x = 20;
    private int y = 20;
    int xa = 1;
    int ya = 1;
    private int posx = 32;
    private int posy = 32;
    private int angulo = 0;
    private static final int DIAMETER = 30;
    private ImageIcon fondo;

    public PanelGrafico() {
        initComponents();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBounds(10, 10, 350, 350);
        this.setBackground(Color.red);
        this.setSize(350, 350);
    }

    @Override
    public void paint(Graphics g) {
        //cargar el fondo del panel 
        Dimension tamaño = this.getSize();
        fondo = new ImageIcon(getClass().getResource("../img/fondo2.gif"));
        g.drawImage(fondo.getImage(), 0, 0, tamaño.width,tamaño.height,null);
        setOpaque(false);
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.yellow);
        g2d.fillOval(posx, posy, 50, 50);
        g2d.setColor(Color.BLUE);
        g2d.drawOval(posx, posy, 50, 50);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("src/img/pelota.png");
        g2d.rotate(Math.PI * angulo / 180, x, y);
        g2d.drawImage(img, x, y, this);

        Thread hilo = new Thread(this);
        hilo.start();
        try {
            Thread.sleep(1);
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
        Validadpared();
    }

    public void reversa() {
        x--;
        y--;

    }

    public void Validadpared() {
//      if(x+32<this.getHeight() && y+32<this.getWidth()&& six ){
//        x++;
//        y++;
////          System.out.println("maxima");
//        
//      }else{
//          six =  false;}
//      if (x+32>this.getHeight() && y+32>this.getWidth() && !six){
//          x--;
//          y++;
////          System.out.println("minima");
//          six=false;
//      }else{
//          six = true;
//      }
////        System.out.println("x = "+x+" y= "+y);
//  
//   
        if (x + xa < 0) {
            xa = 1;
        }
        if (x + xa > this.getWidth() - DIAMETER) {
            xa = -1;
        }
        if (y + ya < 0) {
            ya = 1;
        }
        if (y + ya > this.getHeight() - DIAMETER) {
            ya = -1;
        }

        x = x + xa;
        y = y + ya;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int codigo = ke.getKeyCode();
        if (codigo == ke.VK_UP) {

            if (angulo == 360) {
                angulo = 0;
            }
            angulo += 90;
            y = y - 10;
            System.out.println("arriba");

        }
        if (codigo == ke.VK_LEFT) {
            x = x - 10;
            System.out.println("Derecha");
        }
        if (codigo == ke.VK_RIGHT) {
            x = x + 10;
            System.out.println("izquierda");
        }
        if (codigo == ke.VK_DOWN) {

            System.out.println("abajo");
            y = y + 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
//                System.out.println("click");
        posx = me.getX();
        posy = me.getY();

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        System.out.println("moviendo");
        if ((me.getX() >= 0 && me.getY() >= 0) && me.getX() <= this.getWidth() && me.getY() <= this.getHeight()) {
            x = me.getX();
            y = me.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
