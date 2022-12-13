/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-12-2022 
 *Fecha de actualización:12-12-2022
 *Descripción: Clase principal
 *
 * ****************************************************************************/
package View;

/**
 * 
 * @author Carlos Aurelio Alcántara Pérez
 */
public class PrincipalFrame extends javax.swing.JFrame {
       private final PanelGrafico pg;// Instancia del Panel Grafico
   
    public PrincipalFrame() {
        initComponents();
         pg = new PanelGrafico(); //Inicialisacion del panel grafico 
        this.add(this.pg);//Agregamos el panel Grafico 
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Play = new javax.swing.JButton();
        Pausa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Play.setBackground(new java.awt.Color(0, 0, 0));
        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iPlay.png"))); // NOI18N
        Play.setBorderPainted(false);
        Play.setContentAreaFilled(false);
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayMouseClicked(evt);
            }
        });
        jPanel1.add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        Pausa.setBackground(new java.awt.Color(255, 51, 51));
        Pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iPausa.png"))); // NOI18N
        Pausa.setBorderPainted(false);
        Pausa.setContentAreaFilled(false);
        Pausa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PausaMouseClicked(evt);
            }
        });
        jPanel1.add(Pausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel1.setText("PLAY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel2.setText("PAUSE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iFondoDerecha.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 410));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iFondoAbajo.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseClicked
      pg.play();
    }//GEN-LAST:event_PlayMouseClicked

    private void PausaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PausaMouseClicked
        pg.pausa();
    }//GEN-LAST:event_PausaMouseClicked

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pausa;
    private javax.swing.JButton Play;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
