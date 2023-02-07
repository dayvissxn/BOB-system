package screens;

import Telas.telaInicial;
import filters.*;
import java.io.IOException;
import java.util.Arrays;
import projetoboot.*;
import javax.swing.text.AbstractDocument;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditionDialog extends javax.swing.JDialog {

    private final EditAnnotation editannotation;
    private final Annotation anot;
    
    // Incicializa componentes Swing e configura os filtros
    private void setSwing(){
        initComponents();
        ((AbstractDocument) TextArea.getDocument()).
                setDocumentFilter(new TextAreaFilter(50, 50));
        ((AbstractDocument) TitleField.getDocument()).
                setDocumentFilter(new FieldFilter(50)); 
        ((AbstractDocument) TagField.getDocument()).
                setDocumentFilter(new FieldFilter(50)); 
    }
    
    // Construtor para quando deseja-se criar uma nova anotação.
    // anot é igualada a null
    public EditionDialog(java.awt.Frame parent, boolean modal, EditAnnotation editanot) {
        super(parent, modal);
        anot = null;     
        setSwing();  
        editannotation = editanot;
        ActionButton.setEnabled(false);
    }
    
    // Construtor para quando deseja-se atualizar uma anotação.
    // anot é igualada ao parâmetro editanot
    public EditionDialog(java.awt.Frame parent, boolean modal,Annotation an, EditAnnotation editanot) {        
        super(parent, modal);
        anot = an;        
        setSwing(); 
        TextArea.setText(an.getText());
        TitleField.setText(an.getTitle());
        TagField.setText(Functions.SetToString(an.getMetatag()));
        ActionButton.setText("Atualizar");
        HeaderText.setText("Editar anotação");
        ActionButton.setEnabled(true);
        editannotation = editanot;
    }
    
    // Verifica se os campos de título e conteúdo estão vazio, evitando o salvamento
    // caso estejam
    private boolean canCreate(){
        return !TextArea.getText().isEmpty()&&!TitleField.getText().isEmpty();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        HeaderText = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TitleExp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        TitleExp1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TagField = new javax.swing.JTextField();
        ActionButton = new javax.swing.JButton();
        TitleExp2 = new javax.swing.JLabel();
        btsair = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HeaderText.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        HeaderText.setForeground(new java.awt.Color(255, 255, 255));
        HeaderText.setText("Criar nova anotação:");

        TitleField.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        TitleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TitleFieldKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Título:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/screens/boob.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TitleExp.setFont(new java.awt.Font("Yu Gothic", 1, 10)); // NOI18N
        TitleExp.setForeground(new java.awt.Color(255, 255, 255));
        TitleExp.setText("Campo obrigatório. Máximo de 50 caracteres.");

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Conteúdo da anotação:");

        TextArea.setColumns(20);
        TextArea.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        TextArea.setRows(5);
        TextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextAreaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TextArea);

        TitleExp1.setFont(new java.awt.Font("Yu Gothic", 1, 10)); // NOI18N
        TitleExp1.setForeground(new java.awt.Color(255, 255, 255));
        TitleExp1.setText("Campo obrigatório. Máximo de 50 caracteres por linha. Máximo de 50 linhas");

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tags:");

        TagField.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N

        ActionButton.setBackground(new java.awt.Color(0, 102, 255));
        ActionButton.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        ActionButton.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton.setText("Salvar");
        ActionButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButtonActionPerformed(evt);
            }
        });

        TitleExp2.setFont(new java.awt.Font("Yu Gothic", 1, 10)); // NOI18N
        TitleExp2.setForeground(new java.awt.Color(255, 255, 255));
        TitleExp2.setText("Campo opcional. Máximo de 50 caracteres.");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HeaderText)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TitleExp)
                                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btsair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TitleExp2)
                                    .addComponent(TitleExp1))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HeaderText)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TitleExp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btsair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitleExp1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(TitleExp2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButtonActionPerformed
        //criar anotacao nova
        if (anot == null){
           Annotation nova = new Annotation(TitleField.getText(),TextArea.getText(),
            new Date() ,new Date(), new HashSet<>(Arrays.asList(TagField.getText().split(" "))));
            editannotation.Create(nova);
            TitleField.setText("");
            TextArea.setText("");
            TagField.setText("");
            ActionButton.setEnabled(false); 
            JOptionPane.showMessageDialog(rootPane, "Anotação criada com sucesso.");
        }
        //editar anotacao
        else{
            anot.setLastmodification(new Date());
            anot.setTitle(TitleField.getText());
            anot.setText(TextArea.getText());
            anot.setMetatag(new HashSet<String>(Arrays.asList(TagField.getText().split(" "))));
            editannotation.Edit(anot);
            JOptionPane.showMessageDialog(rootPane, "Anotação editada com sucesso.");
        }
    }//GEN-LAST:event_ActionButtonActionPerformed

    private void TitleFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TitleFieldKeyReleased
        ActionButton.setEnabled(canCreate());
    }//GEN-LAST:event_TitleFieldKeyReleased

    private void TextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextAreaKeyReleased
        ActionButton.setEnabled(canCreate());
    }//GEN-LAST:event_TextAreaKeyReleased

    private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed
        // Botão de Sair:

        MainFrame main = null;
        try {
            main = new MainFrame();
        } catch (Exception ex) {
            Logger.getLogger(telaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btsairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActionButton;
    private javax.swing.JLabel HeaderText;
    private javax.swing.JTextField TagField;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JLabel TitleExp;
    private javax.swing.JLabel TitleExp1;
    private javax.swing.JLabel TitleExp2;
    private javax.swing.JTextField TitleField;
    private javax.swing.JButton btsair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
