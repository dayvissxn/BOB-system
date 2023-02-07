package screens;

import Telas.telaInicial;
import Telas.telaLogin;
import filters.*;
import java.io.IOException;
import projetoboot.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.text.AbstractDocument;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.table.TableRowSorter;

public class MainFrame extends javax.swing.JFrame {

    private final Search search;
    private final String versioncontrolmessage;
    private final EditAnnotation editannotation;
    private final ResultsTableModel tablemodel;
    Vector<Annotation> an;

    // Cria um método de comparação para as colunas da tabela com valores de data
    private void setDateComparator() {
        TableRowSorter<ResultsTableModel> sorter
                = (TableRowSorter<ResultsTableModel>) ResultsTable.getRowSorter();
        for (int i = 2; i <= 3; i++) {
            sorter.setComparator(i, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    return Functions.convertDate(o1).compareTo(Functions.convertDate(o2));
                }
            });
        }
    }

    public MainFrame() throws Exception {
        // Cria uma instância de EditAnnotation
        editannotation = new EditAnnotation();
        tablemodel = new ResultsTableModel();
        initComponents();
        ResultsTable.setAutoCreateRowSorter(true);
        setDateComparator();
        setComboBoxes();
        ((AbstractDocument) TitleField.getDocument()).
                setDocumentFilter(new FieldFilter(100));
        ((AbstractDocument) TagsField.getDocument()).
                setDocumentFilter(new FieldFilter(100));

        // an é um vetor que contém todas as anotações criadas pelo usuário
        an = editannotation.getAnnotations();

        search = new Search(editannotation.getAnnotations());
        versioncontrolmessage = "Bloco de anotações\nV. 1.0";
    }

    // Adiciona os valores dos anos na caixa de combinções, iniciando em 2016 e
    // terminando no ano atual
    private void setComboBoxes() {
        int yearlimit = Year.now().getValue();

        for (int i = 2016; i <= yearlimit; i++) {
            CreationYearComboBox.addItem(i);
            UpdateYearComboBox.addItem(i);
        }
    }

    // Verifica se a data na caixa de combinações é válida
    private int[] ValidateComboBoxes(JComboBox year, JComboBox month, JComboBox day) {
        int[] calendar = null;
        calendar = new int[]{
            year.getSelectedIndex() == 0 ? 0 : (Integer) year.getSelectedItem(),
            month.getSelectedIndex(),
            day.getSelectedIndex()
        };
        if (Functions.CheckDateIsValid(calendar)) {
            return calendar;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btvoltar = new javax.swing.JButton();
        NewButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UpdateDayComboBox = new javax.swing.JComboBox();
        CreationMonthComboBox = new javax.swing.JComboBox();
        CreationYearComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        CreationDayComboBox = new javax.swing.JComboBox();
        UpdateYearComboBox = new javax.swing.JComboBox();
        UpdateMonthComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        TagsField = new javax.swing.JTextField();
        EditButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultsTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewMenuItem = new javax.swing.JMenuItem();
        ExitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        HelpMenu = new javax.swing.JMenu();
        AboutMenuItem = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setTitle("Pesquisar");
        setBackground(new java.awt.Color(0, 51, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(13, 699));

        btvoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/seta_resized.png"))); // NOI18N
        btvoltar.setBorderPainted(false);
        btvoltar.setContentAreaFilled(false);
        btvoltar.setDefaultCapable(false);
        btvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvoltarActionPerformed(evt);
            }
        });

        NewButton.setBackground(new java.awt.Color(0, 102, 255));
        NewButton.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        NewButton.setForeground(new java.awt.Color(255, 255, 255));
        NewButton.setText("Novo");
        NewButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(0, 102, 255));
        ResetButton.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        ResetButton.setForeground(new java.awt.Color(255, 255, 255));
        ResetButton.setText("Zerar campos");
        ResetButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(0, 102, 255));
        DeleteButton.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("Excluir");
        DeleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        DeleteButton.setEnabled(false);
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SearchButton.setBackground(new java.awt.Color(0, 102, 255));
        SearchButton.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("Pesquisar");
        SearchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Título:");

        TitleField.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        TitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data de criação:");

        UpdateDayComboBox.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        UpdateDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        CreationMonthComboBox.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        CreationMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        CreationMonthComboBox.setPreferredSize(new java.awt.Dimension(80, 20));

        CreationYearComboBox.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        CreationYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano" }));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Última modificação:");

        CreationDayComboBox.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        CreationDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        CreationDayComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreationDayComboBoxActionPerformed(evt);
            }
        });

        UpdateYearComboBox.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        UpdateYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano" }));

        UpdateMonthComboBox.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        UpdateMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tags:");

        TagsField.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N

        EditButton.setBackground(new java.awt.Color(0, 102, 255));
        EditButton.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        EditButton.setForeground(new java.awt.Color(255, 255, 255));
        EditButton.setText("Editar");
        EditButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        EditButton.setEnabled(false);
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        ResultsTable.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        ResultsTable.setModel(tablemodel);
        ResultsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResultsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(ResultsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TagsField, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CreationDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(34, 34, 34)
                                            .addComponent(UpdateDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(66, 66, 66)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(CreationMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UpdateMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(68, 68, 68)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(CreationYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UpdateYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ResetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(UpdateDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreationMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreationYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(UpdateMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreationDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TagsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(NewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(90, 30));

        FileMenu.setText("Arquivo");

        NewMenuItem.setText("Novo");
        NewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(NewMenuItem);

        ExitMenuItem.setText("Sair");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenuItem);

        jMenu1.setText("jMenu1");
        FileMenu.add(jMenu1);

        jMenuBar1.add(FileMenu);

        HelpMenu.setText("Ajuda");

        AboutMenuItem.setText("Sobre");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutMenuItem);

        jMenuBar1.add(HelpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1376, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Método chamado quando o usuário clica no botão de pesquisar
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String message;
        ArrayList<Annotation> results = null;
        int[] creationcalendar = ValidateComboBoxes(CreationYearComboBox,
                CreationMonthComboBox, CreationDayComboBox);
        int[] updatecalendar = ValidateComboBoxes(UpdateYearComboBox,
                UpdateMonthComboBox, UpdateDayComboBox);
        // Verifica se as datas são válidas
        if (creationcalendar == null) {
            message = "Data de criação inválida";
        } else if (updatecalendar == null) {
            message = "Data de última modificação inválida";
        } else {
            results = search.Search(TitleField.getText(),
                    new HashSet<>(Arrays.asList(TagsField.getText().split(" "))),
                    creationcalendar, updatecalendar, Annotation.SortCriteria.CREATION);
            int found = results.size();
            message = found + (found != 1 ? " anotações encontradas" : " anotação encontrada");
        }
        tablemodel.ResetContent();
        tablemodel.setRows(results);
        JOptionPane.showMessageDialog(rootPane, message);
        EditButton.setEnabled(false);
        DeleteButton.setEnabled(false);
    }//GEN-LAST:event_SearchButtonActionPerformed
    
    //Controle de versão
    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(rootPane, versioncontrolmessage);
    }//GEN-LAST:event_AboutMenuItemActionPerformed
    
    // Botão adicional para sair do programa
    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        telaLogin tLogin = new telaLogin();
        tLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitMenuItemActionPerformed
    
    // Abre uma caixa de diálogo permitindo o usuário editar a anotação.
    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int row = ResultsTable.convertRowIndexToModel(ResultsTable.getSelectedRow());
        new EditionDialog(this, true, tablemodel.getValueAt(row), editannotation).setVisible(true);
        tablemodel.fireTableRowsUpdated(row, row);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedrows = ResultsTable.getSelectedRowCount();
        String message = "Deseja remover " + selectedrows + (selectedrows > 1
                ? " anotações?" : " anotação");
        int ans = JOptionPane.showConfirmDialog(rootPane, message, "Realizar exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            try {
                int[] viewindexes = ResultsTable.getSelectedRows();
                int[] modelindexes = new int[viewindexes.length];

                for (int i = 0; i < viewindexes.length; i++) {
                    modelindexes[i] = ResultsTable.convertRowIndexToModel(viewindexes[i]);
                    editannotation.Delete(tablemodel.getValueAt(modelindexes[i]));
                }
                Arrays.sort(modelindexes);
                tablemodel.removeRows(modelindexes);
                JOptionPane.showMessageDialog(rootPane, selectedrows + (selectedrows > 1
                        ? " anotações removidas" : " anotação removida"));
                EditButton.setEnabled(false);
                DeleteButton.setEnabled(false);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void NewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMenuItemActionPerformed
        new EditionDialog(this, true, editannotation).setVisible(true);
    }//GEN-LAST:event_NewMenuItemActionPerformed

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        new EditionDialog(this, true, editannotation).setVisible(true);
    }//GEN-LAST:event_NewButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        TitleField.setText("");
        TagsField.setText("");
        CreationYearComboBox.setSelectedIndex(0);
        CreationMonthComboBox.setSelectedIndex(0);
        CreationDayComboBox.setSelectedIndex(0);
        UpdateYearComboBox.setSelectedIndex(0);
        UpdateMonthComboBox.setSelectedIndex(0);
        UpdateDayComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void ResultsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultsTableMousePressed
        int row = ResultsTable.convertRowIndexToModel(ResultsTable.getSelectedRow());
        if (row >= 0) {
            EditButton.setEnabled(true);
            DeleteButton.setEnabled(true);
        }
        if (evt.getClickCount() == 2 && evt.getButton() == evt.BUTTON1 && row >= 0) {
            new EditionDialog(this, true, tablemodel.getValueAt(row), editannotation).setVisible(true);
            tablemodel.fireTableRowsUpdated(row, row);
        }
    }//GEN-LAST:event_ResultsTableMousePressed

    private void CreationDayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreationDayComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreationDayComboBoxActionPerformed

    private void TitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleFieldActionPerformed

    private void btvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvoltarActionPerformed
        // TODO add your handling code here:
        telaInicial tInicial = new telaInicial();
        tInicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btvoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.ButtonGroup ButtonGroup;
    private javax.swing.JComboBox CreationDayComboBox;
    private javax.swing.JComboBox CreationMonthComboBox;
    private javax.swing.JComboBox CreationYearComboBox;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JButton NewButton;
    private javax.swing.JMenuItem NewMenuItem;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTable ResultsTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField TagsField;
    private javax.swing.JTextField TitleField;
    private javax.swing.JComboBox UpdateDayComboBox;
    private javax.swing.JComboBox UpdateMonthComboBox;
    private javax.swing.JComboBox UpdateYearComboBox;
    private javax.swing.JButton btvoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
