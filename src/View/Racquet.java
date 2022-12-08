/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {

    private static final int Y = 30;
    private static final int WITH = 30;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 30;
    int y = 0;
    int ya = 30;
    private Game game;

    public Racquet(Game game) {
        this.game = game;
    }

    public void move() {
        if (x + xa < 0) {
            xa = 1;
        }
        if (x + xa > game.getWidth() - WITH) {
            xa = -1;
        }
        if (y + ya < 0) {
            ya = 1;
        }
        if (y + ya > game.getHeight() - WITH) {
            ya = -1;
        }
        
        
       
        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, WITH, WITH);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 1;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WITH, HEIGHT);
    }
   
}
