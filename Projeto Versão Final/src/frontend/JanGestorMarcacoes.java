/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Centro_Vacinacao;
import backend.Gestor;
import backend.Serializacao;
import backend.Sistema;
import backend.Utente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marco
 */
public class JanGestorMarcacoes extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao dados;
    private AbstractTableModel modeloTabela;
    
    public JanGestorMarcacoes(Sistema sistema,Serializacao dados) {
        initComponents();
        this.sistema = sistema;
        this.dados = dados;
        this.modeloTabela = criarTabela();
        tabelaMarcacoes.setModel(modeloTabela);
    }
    
    private AbstractTableModel criarTabela(){
        String[] nomeColunas = {"Utente", "Data / Hora"};
        Gestor gestor = (Gestor) sistema.getUtilizadorLigado(); 
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return listaUtentes().size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
            /*
                Este método é invocado quando se pretende "popular" cada uma das células da tabela
                Se a tabela tem 3 linhas e 2 colunas existem 6 células (3*2), logo o método será invocado 6 vezes
                    rowIndex representa a linha da célula (0 a rowCount -1)
                    columnIndex representa a coluna da célula (0 a ColumnCount -1)
            */  Utente u = listaUtentes().get(rowIndex);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm");
                switch (columnIndex) {
                    case 0: 
                        return u.getNome();
                    case 1:
                        return sistema.getCentros_Vacinacao().procurarPorGestor(gestor).getMarcacoesV().ProxMarcação(u).format(formatter);
                    default:
                        return "";
                }                              
            }         
            
        };
    }
    
    private AbstractTableModel filtrarTabela(LocalDate data){
        String[] nomeColunas = {"Utente", "Data / Hora"};
        Gestor gestor = (Gestor) sistema.getUtilizadorLigado(); 
        Centro_Vacinacao c = sistema.getCentros_Vacinacao().procurarPorGestor(gestor);
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return c.getMarcacoesV().ListasUtentesParaDia(data).size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
            /*
                Este método é invocado quando se pretende "popular" cada uma das células da tabela
                Se a tabela tem 3 linhas e 2 colunas existem 6 células (3*2), logo o método será invocado 6 vezes
                    rowIndex representa a linha da célula (0 a rowCount -1)
                    columnIndex representa a coluna da célula (0 a ColumnCount -1)
            */  Utente u = c.getMarcacoesV().ListasUtentesParaDia(data).get(rowIndex);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm");
                switch (columnIndex) {
                    case 0: 
                        return u.getNome();
                    case 1:
                        return c.getMarcacoesV().ProxMarcação(u).format(formatter);
                    default:
                        return "";
                }                              
            }         
            
        };
    }
    
    public ArrayList<Utente> listaUtentes(){
        Centro_Vacinacao c = sistema.getCentros_Vacinacao().procurarPorGestor((Gestor) sistema.getUtilizadorLigado());
        ArrayList<LocalDateTime> datas = c.getMarcacoesV().ListasDatas();
        Collections.sort(datas); //Permite ordenar a lista de datas por ordem crescente 
        ArrayList<Utente> todos = new ArrayList<Utente>();
        for(LocalDateTime data : datas){
            ArrayList<Utente> utentes = c.getMarcacoesV().VerMarcacoes(data);
            todos.addAll(utentes);
        }
        return todos;
    }
    
    
    public void atualizar(){
        modeloTabela.fireTableDataChanged();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        BtnProcurar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMarcacoes = new javax.swing.JTable();
        BtnFaltas = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnVacinar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 38, 61));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Marcações");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Procurar por data");

        BtnProcurar.setBackground(new java.awt.Color(255, 255, 255));
        BtnProcurar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BtnProcurar.setForeground(new java.awt.Color(0, 0, 0));
        BtnProcurar.setText("Procurar");
        BtnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProcurarActionPerformed(evt);
            }
        });

        tabelaMarcacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaMarcacoes);

        BtnFaltas.setBackground(new java.awt.Color(255, 255, 255));
        BtnFaltas.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BtnFaltas.setForeground(new java.awt.Color(0, 0, 0));
        BtnFaltas.setText("Faltas");

        BtnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        BtnCancelar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BtnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnVacinar.setBackground(new java.awt.Color(255, 255, 255));
        BtnVacinar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BtnVacinar.setForeground(new java.awt.Color(0, 0, 0));
        BtnVacinar.setText("Vacinar");
        BtnVacinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVacinarActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(BtnProcurar))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(BtnFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCancelar)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnVacinar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnProcurar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFaltas)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnVacinar))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProcurarActionPerformed
         if(txtData.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Introduza uma data");
            txtData.requestFocus();
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
        LocalDate data = LocalDate.parse(txtData.getText(), formatter);
        this.modeloTabela = filtrarTabela(data);
        tabelaMarcacoes.setModel(modeloTabela);
    }//GEN-LAST:event_BtnProcurarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           dispose();
        JanGestor janela = new JanGestor(sistema, dados);
        janela.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        int rowIndex = tabelaMarcacoes.getSelectedRow();
        if(rowIndex == -1){
            JOptionPane.showMessageDialog(this, "Selecione uma marcação para cancelar");
            return;
        }
        String n = (String) modeloTabela.getValueAt(rowIndex, 0);
        String d = (String) modeloTabela.getValueAt(rowIndex, 1);
        Utente utente = (Utente) sistema.getUtilizadores().getUtilizadorNome(n);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm");
        LocalDateTime data = LocalDateTime.parse(d, formatter);
        sistema.getCentros_Vacinacao().procurarPorGestor((Gestor) sistema.getUtilizadorLigado()).getMarcacoesV().Cancelar(data, utente);
        atualizar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnVacinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVacinarActionPerformed
        int rowIndex = tabelaMarcacoes.getSelectedRow();
        if(rowIndex == -1){
            JOptionPane.showMessageDialog(this, "Selecione uma marcação para cancelar");
            return;
        }
        String n = (String) modeloTabela.getValueAt(rowIndex, 0);
        String d = (String) modeloTabela.getValueAt(rowIndex, 1);
        Utente utente = (Utente) sistema.getUtilizadores().getUtilizadorNome(n);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm");
        LocalDateTime data = LocalDateTime.parse(d, formatter);
        dispose();
        JanGestorMarcVacinar janela = new JanGestorMarcVacinar(sistema, dados, utente, data);
        janela.setVisible(true);
    }//GEN-LAST:event_BtnVacinarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnFaltas;
    private javax.swing.JButton BtnProcurar;
    private javax.swing.JButton BtnVacinar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaMarcacoes;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
