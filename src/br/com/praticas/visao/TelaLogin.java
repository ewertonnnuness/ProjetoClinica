/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.visao;

import br.com.praticas.modeloconection.ConexaoBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TelaLogin extends javax.swing.JFrame {

   ConexaoBD con = new ConexaoBD();
    
    public TelaLogin() {
        initComponents();
        con.conexao();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSenha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsuário = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jButtonEntrar1 = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelLogo = new javax.swing.JLabel();
        jLabelBemVindo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(330, 190, 70, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Usuário:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 160, 80, 20);

        jTextFieldUsuário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuárioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuário);
        jTextFieldUsuário.setBounds(400, 150, 160, 30);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(490, 240, 60, 23);

        jButtonEntrar1.setText("Entrar");
        jButtonEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar1);
        jButtonEntrar1.setBounds(410, 240, 63, 23);
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(400, 190, 160, 30);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/praticas/imagens/logo_clinica.png"))); // NOI18N
        getContentPane().add(jLabelLogo);
        jLabelLogo.setBounds(40, 50, 300, 260);

        jLabelBemVindo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelBemVindo.setText("Clínica Médica");
        getContentPane().add(jLabelBemVindo);
        jLabelBemVindo.setBounds(180, 20, 280, 50);

        jLabel1.setText("Projeto Práticas - Prof Alyson");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 290, 180, 30);

        jLabel2.setText("Hugo Nathan  /   Ewerton Nunes");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 314, 180, 20);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/praticas/imagens/123_wallpaper_blue.jpg"))); // NOI18N
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(-4, 0, 650, 360);

        setSize(new java.awt.Dimension(622, 383));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsuárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuárioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuárioActionPerformed

    private void jButtonEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrar1ActionPerformed

       try {
           con.executarSql("select *from usuarios where usu_nome='"+jTextFieldUsuário.getText()+"'");
           con.rs.first();
           if (con.rs.getString("usu_senha").equals(jPasswordFieldSenha.getText())){
               TelaPrincipal tela = new TelaPrincipal(jTextFieldUsuário.getText());
               tela.setVisible(true);
               dispose();
           }else {
           JOptionPane.showMessageDialog(rootPane, "Usuário ou Senha Inválidos!");
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "Usuário ou Senha Inválidos!");
       }
        
        
    }//GEN-LAST:event_jButtonEntrar1ActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar1;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBemVindo;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuário;
    // End of variables declaration//GEN-END:variables
}
