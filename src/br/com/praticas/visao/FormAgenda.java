/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.visao;

import br.com.praticas.business.AgendaBusiness;
import br.com.praticas.fachada.Facade;
import br.com.praticas.interfac.IAgendaBusiness;
import br.com.praticas.modelobeans.BeansAgenda;
import br.com.praticas.modelobeans.ModeloTabela;
import br.com.praticas.modeloconection.ConexaoBD;
import br.com.praticas.modelodao.DaoAgenda;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class FormAgenda extends javax.swing.JFrame {

    //----------------------------------------------------
    // AK VC VAI ACESSAR TODOS OS METODOS ATRAVEZ DA FACHADA. 
    // O METODO GETINSTANCE() FAZ COM QUE TODA VEZ QUE FOR MEXER ALGO NO BANCO
    // O BANCO É ESTARTADO SOMENTE UMA VEZ
    private Facade fachada = Facade.getInstance();
    private IAgendaBusiness business = new AgendaBusiness();
    //----------------------------------------------------

    ConexaoBD conex = new ConexaoBD();
    BeansAgenda agenda = new BeansAgenda();

    public FormAgenda() {
        initComponents();
        preencherMedicos();
    }

    public void preencherMedicos() {

        conex.conexao();
        conex.executarSql("select *from medicos order by nome_medico");
        try {
            conex.rs.first();
            jComboBoxMedico.removeAllItems();
            do {
                jComboBoxMedico.addItem(conex.rs.getString("nome_medico"));
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao Preencher os Medicos" + ex);
        }

        conex.desconecta();

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPaciente = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        jComboBoxMedico = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButtonFinalizarAgendamento = new javax.swing.JButton();
        jButtonCancelarAgendamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMotivo = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Paciente:");

        jLabel3.setText("Médico:");

        jLabel4.setText("Data:");

        jLabel5.setText("Motivo:");

        jLabel6.setText("Turno:");

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matutino", "Vespertino", "Noturno" }));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacientes);

        jComboBoxMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Encaminhamento:");

        jButtonFinalizarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/praticas/imagens/V5.png"))); // NOI18N
        jButtonFinalizarAgendamento.setText("Gerar Agendamento");
        jButtonFinalizarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarAgendamentoActionPerformed(evt);
            }
        });

        jButtonCancelarAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/praticas/imagens/2000px-Red_x.svg.png"))); // NOI18N
        jButtonCancelarAgendamento.setText("Cancelar Agendamento");
        jButtonCancelarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarAgendamentoActionPerformed(evt);
            }
        });

        jTextAreaMotivo.setColumns(20);
        jTextAreaMotivo.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMotivo);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/praticas/imagens/agenda.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButtonFinalizarAgendamento)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonCancelarAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonFinalizarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("AGENDAMENTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(857, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFinalizarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarAgendamentoActionPerformed

        /*  SEU 
        agenda.setNomePac(jTextFieldPaciente.getText());
        agenda.setNomeMed((String) jComboBoxMedico.getSelectedItem());
        agenda.setTurno((String) jComboBoxTurno.getSelectedItem());
        agenda.setMotivo(jTextAreaMotivo.getText());
        agenda.setData(jDateChooserData.getDate());
        agenda.setStatus("Aberto");
        
   
        DaoAgenda dao = new DaoAgenda();
        dao.Salvar(agenda);*/
        // MEU  
        // EM VEZ DE VC CHANMAR OS PARAMETROS DIRETAMENTE COMO TAVA VC CHAMA O BUSSINESS E PASSA OS PARAMETROS ASSIM A TELA FICA MAIS LIMPA
        business.slavarNaAgenda(jTextFieldPaciente.getText(), (String) jComboBoxMedico.getSelectedItem(),
                (String) jComboBoxTurno.getSelectedItem(), jTextAreaMotivo.getText(),
                jDateChooserData.getDate(), "Aberto");


    }//GEN-LAST:event_jButtonFinalizarAgendamentoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        preencherTabela("select paci_codigo,paci_nome,paci_telefone,paci_cpf,cidnome from pacientes inner join cidade on paci_cidcodigo = cidcodigo  where paci_nome like '%" + jTextFieldPaciente.getText() + "%'");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacientesMouseClicked

        String nome_paciente = "" + jTablePacientes.getValueAt(jTablePacientes.getSelectedRow(), 1);
        conex.conexao();
        conex.executarSql("select *from pacientes where paci_nome='" + nome_paciente + "'");

        try {
            conex.rs.first();
            jTextFieldPaciente.setText(conex.rs.getString("paci_nome"));
        } catch (SQLException ex) {
        }
        conex.desconecta();
    }//GEN-LAST:event_jTablePacientesMouseClicked

    private void jButtonCancelarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarAgendamentoActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarAgendamentoActionPerformed

    public void preencherTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Contato", "CPF", "Cidade"};
        conex.conexao();
        conex.executarSql(Sql);

        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("paci_codigo"), conex.rs.getString("paci_nome"), conex.rs.getString("paci_telefone"), conex.rs.getString("paci_cpf"), conex.rs.getString("cidnome")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Busque por outro médico!");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTablePacientes.setModel(modelo);
        jTablePacientes.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTablePacientes.getColumnModel().getColumn(0).setResizable(false);
        jTablePacientes.getColumnModel().getColumn(1).setPreferredWidth(310);
        jTablePacientes.getColumnModel().getColumn(1).setResizable(false);
        jTablePacientes.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTablePacientes.getColumnModel().getColumn(2).setResizable(false);
        jTablePacientes.getColumnModel().getColumn(3).setPreferredWidth(130);
        jTablePacientes.getColumnModel().getColumn(3).setResizable(false);
        jTablePacientes.getColumnModel().getColumn(4).setPreferredWidth(130);
        jTablePacientes.getColumnModel().getColumn(4).setResizable(false);
        jTablePacientes.getTableHeader().setReorderingAllowed(false);
        jTablePacientes.setAutoResizeMode(jTablePacientes.AUTO_RESIZE_OFF);
        jTablePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
    }

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
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelarAgendamento;
    private javax.swing.JButton jButtonFinalizarAgendamento;
    private javax.swing.JComboBox jComboBoxMedico;
    private javax.swing.JComboBox jComboBoxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePacientes;
    private javax.swing.JTextArea jTextAreaMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables
}
