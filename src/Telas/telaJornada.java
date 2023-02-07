
package Telas;


import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class telaJornada extends javax.swing.JFrame {

   
    //Variaveis do tempo
    private Timer tempo;
    private int centesimos_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    
    int clicou;
    
    
  private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           centesimos_segundos ++;
           if(centesimos_segundos == 100){
               segundos++;
               centesimos_segundos = 0;
           }
           if(segundos == 60){
               minutos ++;
               segundos = 0;
           }
           if(minutos == 60){
               horas ++;
               minutos = 0;
           }
           if(horas == 24){
               horas = 0;
           }
           
           
           atualizarTempo();
        }
    };
    
       
    private void atualizarTempo() {
        String texto = (horas <=9?"0":"")+horas+":"+(minutos <=9?"0":"")+minutos+":"+(segundos <=9?"0":"")+segundos+":"+(centesimos_segundos <=9?"0":"")+centesimos_segundos;
        jltempo.setText(texto);
    }
    
        
    public telaJornada() {
        initComponents();
       
        this.setLocationRelativeTo(null);
        this.setTitle("Cronometro");
        tempo = new Timer (10, acciones);
        
        clicou = 0;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btiniciar = new javax.swing.JButton();
        btpausar = new javax.swing.JButton();
        btfinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jltempo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btvoltar = new javax.swing.JButton();
        cronometro = new javax.swing.JLabel();
        btcontatos = new javax.swing.JButton();
        btdicas = new javax.swing.JButton();
        btsair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btiniciar.png"))); // NOI18N
        btiniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btiniciar.setBorderPainted(false);
        btiniciar.setContentAreaFilled(false);
        btiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 100, 50));

        btpausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btpausar.png"))); // NOI18N
        btpausar.setBorder(null);
        btpausar.setBorderPainted(false);
        btpausar.setContentAreaFilled(false);
        btpausar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btpausar.setEnabled(false);
        btpausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpausarActionPerformed(evt);
            }
        });
        jPanel1.add(btpausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 100, 30));

        btfinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btfinalizar.png"))); // NOI18N
        btfinalizar.setBorder(null);
        btfinalizar.setBorderPainted(false);
        btfinalizar.setContentAreaFilled(false);
        btfinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btfinalizar.setEnabled(false);
        btfinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btfinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 100, 50));

        jTable1.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tempo Logado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 440, 100));

        jltempo.setFont(new java.awt.Font("Yu Gothic", 1, 55)); // NOI18N
        jltempo.setForeground(new java.awt.Color(255, 255, 255));
        jltempo.setText("00:00:00:00");
        jPanel1.add(jltempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 320, 50));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total de horas logado na semana: 00:00:00");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, 620, 40));

        btvoltar.setBackground(new java.awt.Color(0, 153, 255));
        btvoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/seta_resized.png"))); // NOI18N
        btvoltar.setBorder(null);
        btvoltar.setBorderPainted(false);
        btvoltar.setContentAreaFilled(false);
        btvoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btvoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        cronometro.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 48)); // NOI18N
        cronometro.setForeground(new java.awt.Color(255, 255, 255));
        cronometro.setText("JORNADA DE TRABALHO");
        jPanel1.add(cronometro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 590, 90));

        btcontatos.setBackground(new java.awt.Color(51, 153, 255));
        btcontatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btcontatos.png"))); // NOI18N
        btcontatos.setBorder(null);
        btcontatos.setBorderPainted(false);
        btcontatos.setContentAreaFilled(false);
        btcontatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btcontatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 70, 40));

        btdicas.setBackground(new java.awt.Color(51, 153, 255));
        btdicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btdicas.png"))); // NOI18N
        btdicas.setBorder(null);
        btdicas.setBorderPainted(false);
        btdicas.setContentAreaFilled(false);
        btdicas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdicasActionPerformed(evt);
            }
        });
        jPanel1.add(btdicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 60, 40));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvoltarActionPerformed
        // Botão de Voltar:
        
        telaInicial tInicial = new telaInicial();
        tInicial.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btvoltarActionPerformed

    private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed
        // Botão de Sair:
        
        new telaConfirmarSaida().setVisible(true);

    }//GEN-LAST:event_btsairActionPerformed

    private void btdicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btdicasActionPerformed

    private void btiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btiniciarActionPerformed
        // Botão iniciar:
        tempo.start();
        btiniciar.setEnabled(false);
        btiniciar.setText("");
        btfinalizar.setEnabled(true);
        btpausar.setEnabled(true);
    }//GEN-LAST:event_btiniciarActionPerformed

    private void btpausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpausarActionPerformed
        // Botão pausar:
        tempo.stop();
        btiniciar.setEnabled(true);
    }//GEN-LAST:event_btpausarActionPerformed

    private void btfinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfinalizarActionPerformed
        // Botão finalizar:
        if(tempo.isRunning()){
           tempo.stop();          
        }
                           
        centesimos_segundos = 0;
        segundos = 0;
        minutos = 0;
        horas = 0;
        
        
        atualizarTempo();
        btiniciar.setText("");
        btiniciar.setEnabled(true);
        btpausar.setEnabled(false);
        btfinalizar.setEnabled(false);
        
        /* if  (clicou==0);{
            
        
            Object[] col;
            col = new Object[1];
            col[0]="Tempo Logado";
            Object[][] lin;
            lin=new Object[1][1];
            lin[0][0]=jltempo.getText();
            DefaultTableModel tm;
            tm = new DefaultTableModel (lin, col);
            jTable1.setModel(tm);
            clicou=1;
        */
        
            
    }//GEN-LAST:event_btfinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(telaJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new telaJornada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcontatos;
    private javax.swing.JButton btdicas;
    private javax.swing.JButton btfinalizar;
    private javax.swing.JButton btiniciar;
    private javax.swing.JButton btpausar;
    private javax.swing.JButton btsair;
    private javax.swing.JButton btvoltar;
    private javax.swing.JLabel cronometro;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jltempo;
    // End of variables declaration//GEN-END:variables
}
