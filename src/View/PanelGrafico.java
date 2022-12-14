/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-12-2022 ***
 *Fecha de actualización:12-12-2022
 *Descripción: Clase creacion de los paneles y objetos tambien
 *
 * *************************************************************************** */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class PanelGrafico extends javax.swing.JPanel implements Runnable {

    private int x = 0;// Variable x para la posicion de la pelota 1
    private int y = 0;// Variable y para la posicion de la pelota 1
    private int posx = 350;
    private int posy = 350;
    private int xa = 1;// Variable xa para el aumento de la posicion de la pelota 1
    private int ya = 1;// Variable xa para el aumento de la posicion de la pelota 1
    private int xb = 1;// Variable xb para el aumento de la posicion de la pelota 2
    private int yb = 1;// Variable xb para el aumento de la posicion de la pelota 2
    private static final int Diametro = 32;//Diametro del contorno de las imagenes
    private ImageIcon Fondo;//Fondo 
    private boolean srtStp = true;
    public Thread hilo;

    public PanelGrafico() {

        initComponents();
        this.setFocusable(true);
        this.setBounds(10, 10, 350, 350);
        this.setBackground(Color.red);
        this.setSize(350, 350);
    }

    @Override
    public void paint(Graphics g) {
        /**
         * Cargar el fondo del panel
         */
        Dimension tamaño = this.getSize();
        Fondo = new ImageIcon(getClass().getResource("../img/iFondo.gif"));
        g.drawImage(Fondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);
        setOpaque(false);
        super.paint(g);
        /**
         * Crear el primer grafico para la pelota 1
         */
        Graphics2D g2d = (Graphics2D) g;
        /**
         * Crear el primer grafico para la pelota 2
         */
        Graphics2D g2d2 = (Graphics2D) g;
        Toolkit t2 = Toolkit.getDefaultToolkit();
        Image img2 = t2.getImage("src/img/iHongo.png");//Cargar imagen pelota1
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("src/img/iHongo.png");//Cargar imagen pelota2
        g2d.drawImage(img, x, y, this);
        g2d2.drawImage(img2, posx, posy, this);
        hilo = new Thread(this);
        if (srtStp) {
            hilo.start();

        } else {
            hilo.interrupt();
        }
        try {

            Thread.sleep(jSlider1.getValue());
        } catch (InterruptedException ex) {
            Logger.getLogger(PanelGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();

        setMinimumSize(new java.awt.Dimension(350, 350));

        jSlider1.setMaximum(20);
        jSlider1.setMinimum(1);
        jSlider1.setValue(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo run para la ejecucion de
     */
    @Override
    public void run() {

        Mover1();
        Mover2();
    }

    /**
     * Evento de la pelota 1
     */
    public void Mover1() {

        if (x + xa < 0) {
            xa = 1;
        }
        if (x + xa > this.getWidth() - Diametro) {
            xa = -1;
        }
        if (y + ya < 0) {
            ya = 1;
        }
        if (y + ya > this.getHeight() - Diametro) {
            ya = -1;
        }
        if (collision()) {
            ya = 1;

        }

        x = x + xa;
        y = y + ya;
    }

    /**
     * Evento de la pelota 2
     */
    public void Mover2() {

        if (posx + xb < 0) {
            xb = 1;
        }
        if (posx + xb > this.getWidth() - Diametro) {
            xb = -1;
        }
        if (posy + yb < 0) {
            yb = 1;
        }
        if (posy + yb > this.getHeight() - Diametro) {
            yb = -1;
        }
        if (collision()) {
            yb = 1;

        }

        posx = posx + xb;
        posy = posy + yb;
    }

    /**
     * Método para calcular el contorno de la pelota 1
     *
     * @return regresa el contorno
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, Diametro, Diametro);
    }

    /**
     * Validar la colision
     *
     * @return Regresa true si si chocan y false si no
     */
    private boolean collision() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("src/sonido/PelotaReboteAud.mp3"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
        return this.getBounds().intersects(getBounds2());
    }

    /**
     * Método para calcular el contorno de la pelota 1
     *
     * @return
     */
    public Rectangle getBounds2() {
        return new Rectangle(posx, posy, Diametro, Diametro);
    }

    public void setSrtStp(boolean srtStp) {
        this.srtStp = srtStp;
    }

    public boolean isSrtStp() {
        return srtStp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
