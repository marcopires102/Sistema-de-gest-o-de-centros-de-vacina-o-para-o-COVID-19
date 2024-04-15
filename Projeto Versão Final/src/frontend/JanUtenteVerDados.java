/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Serializacao;
import backend.Sistema;
import backend.Utente;
/**
 *
 * @author Marco
 */
public class JanUtenteVerDados extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao dados; 
    /**
     * Creates new form JanUtenteVerDados
     */
    public JanUtenteVerDados(Sistema sistema,Serializacao dados ) {
        initComponents();
        this.sistema = sistema;
        this.dados = dados;
        Utente utente = (Utente) sistema.getUtilizadorLigado();
        txtNSNS.setText(utente.getUsername());
        txtNome.setText(utente.getNome());
        txtMorada.setText(utente.getMorada());
        txtLocalidade.setText(utente.getLocalidade());
       // txtData.setText(Integer.toString(utente.getData_nasc()));
       //txtContacto.setText(Integer.toString(utente.getContacto_tel()));
       txtEmail.setText(utente.getEmail());
       //txtCentro.setText(utente.getCentro_vacinacao().getLocalidade());   
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNSNS = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtMorada = new javax.swing.JTextField();
        txtLocalidade = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtContacto = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCentro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dados Utentes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 12, 325, 49));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Nº SNS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 79, 125, 25));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Nome");
        jLabel3.setPreferredSize(new java.awt.Dimension(125, 25));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 122, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Morada");
        jLabel4.setPreferredSize(new java.awt.Dimension(125, 25));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 165, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Localidade");
        jLabel5.setPreferredSize(new java.awt.Dimension(125, 25));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 208, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Data de nascimento");
        jLabel6.setPreferredSize(new java.awt.Dimension(125, 25));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 251, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Contacto telefónico");
        jLabel7.setPreferredSize(new java.awt.Dimension(125, 25));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 294, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Email");
        jLabel8.setPreferredSize(new java.awt.Dimension(37, 25));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 337, 125, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Centro de vacinação");
        jLabel10.setPreferredSize(new java.awt.Dimension(43, 25));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 380, 130, -1));
        getContentPane().add(txtNSNS, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 82, 235, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 125, 235, -1));
        getContentPane().add(txtMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 168, 235, -1));
        getContentPane().add(txtLocalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 211, 235, -1));
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 254, 235, -1));
        getContentPane().add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 297, 235, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 340, 235, -1));
        getContentPane().add(txtCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 383, 235, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Editar dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 467, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 467, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 38, 61));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        JanUtenteEditDados janela = new JanUtenteEditDados(sistema, dados);
        janela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        JanUtente janela = new JanUtente(sistema, dados);
        janela.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCentro;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtNSNS;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
