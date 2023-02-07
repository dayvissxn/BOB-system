/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import projetoboot.Main;
import screens.MainFrame;

/**
 *
 * @author dayvi
 */
public class telaInicial extends javax.swing.JFrame {

    /**
     * Creates new form telaInicial
     */
    public telaInicial() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btjornada = new javax.swing.JButton();
        btperfil = new javax.swing.JButton();
        btsair = new javax.swing.JButton();
        btmeta1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("telaInicial");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo sem fundo.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 402, 234));

        btjornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btjdt.png"))); // NOI18N
        btjornada.setBorder(null);
        btjornada.setBorderPainted(false);
        btjornada.setContentAreaFilled(false);
        btjornada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btjornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btjornadaActionPerformed(evt);
            }
        });
        jPanel1.add(btjornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 250, 50));

        btperfil.setBackground(new java.awt.Color(255, 255, 255));
        btperfil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btpf.png"))); // NOI18N
        btperfil.setBorder(null);
        btperfil.setBorderPainted(false);
        btperfil.setContentAreaFilled(false);
        btperfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btperfilActionPerformed(evt);
            }
        });
        jPanel1.add(btperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 230, 50));

        btsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btsair.png"))); // NOI18N
        btsair.setBorder(null);
        btsair.setBorderPainted(false);
        btsair.setContentAreaFilled(false);
        btsair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsairActionPerformed(evt);
            }
        });
        jPanel1.add(btsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 50, 40));

        btmeta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btmp1.png"))); // NOI18N
        btmeta1.setBorder(null);
        btmeta1.setBorderPainted(false);
        btmeta1.setContentAreaFilled(false);
        btmeta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btmeta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmeta1ActionPerformed(evt);
            }
        });
        jPanel1.add(btmeta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 230, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bthumor.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 570, 240, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btjornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btjornadaActionPerformed
        // Botão de Jornada de Trabalho:
        
        telaJornada tJornada = new telaJornada();
        tJornada.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btjornadaActionPerformed

    private void btperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btperfilActionPerformed
        // Botão de Perfil:
        
        telaPerfil tPerfil = new telaPerfil();
        tPerfil.setVisible(true);
        this.dispose(); 
        
    }//GEN-LAST:event_btperfilActionPerformed

    private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed
        // Botão de Sair:
        
        new telaConfirmarSaida().setVisible(true); 

    }//GEN-LAST:event_btsairActionPerformed

    private void btmeta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmeta1ActionPerformed
        // TODO add your handling code here:
        MainFrame main = null;
        try {
            main = new MainFrame();
        } catch (Exception ex) {
            Logger.getLogger(telaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btmeta1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        telaHumor tHumor = new telaHumor();
        tHumor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btjornada;
    private javax.swing.JButton btmeta1;
    private javax.swing.JButton btperfil;
    private javax.swing.JButton btsair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}