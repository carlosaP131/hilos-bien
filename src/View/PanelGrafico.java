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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PanelGrafico extends javax.swing.JPanel implements Runnable , KeyListener{
        private  int x=20;
        private  int y=20;
        private boolean six=true;
        
    public PanelGrafico() {
        initComponents();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setBounds(10,10,350,350);
        this.setBackground(Color.red);
        this.setSize(350,350);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(Color.yellow);
//        g2d.fillOval(x, y, 50, 50);
//        g2d.setColor(Color.BLUE);
//        g2d.drawOval(x, y, 50, 50);
        Toolkit t = Toolkit.getDefaultToolkit();
            Image img = t.getImage("src/img/corazon.png");
            g2d.drawImage(img, x,y, this);
        Thread hilo = new Thread(this);
        hilo.start();
            try {
                Thread.sleep(15);
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
      if(x+32<this.getHeight() && y+32<this.getHeight() && six ){
//       // x++;
//        y++;
          System.out.println("maxima");
      }else{
          six =  false;}
      if (x+32>32 && y+32>32 && !six){
//          x--;
//          y--;
          System.out.println("minima");
          six=false;
      }else{
          six = true;
      }
        System.out.println("x = "+x+" y= "+y);
         
        
    }

public void reversa(){
    x--;
    y--;
    
}

    @Override
    public void keyTyped(KeyEvent ke) {
        }

    @Override
    public void keyPressed(KeyEvent ke) {
        int codigo = ke.getKeyCode();
        if(codigo==ke.VK_UP)
        {
             y=y-10;
            System.out.println("arriba"); 
           
        }
        if(codigo==ke.VK_LEFT)
        {
            x=x-10;
            System.out.println("Derecha");
        }  
        if(codigo==ke.VK_RIGHT)
             
        {   
            x=x+10;
            System.out.println("izquierda");
        }
        if(codigo==ke.VK_DOWN){
           
        System.out.println("abajo");
            y=y+10;}
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
