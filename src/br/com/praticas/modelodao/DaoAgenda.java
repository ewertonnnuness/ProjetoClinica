/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.modelodao;

import br.com.praticas.interfac.IDaoAgenda;
import br.com.praticas.modelobeans.BeansAgenda;
import br.com.praticas.modeloconection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HugoNathan
 */

//    COLOCAR IMPLEMENTS E O NOME DA INTERFACE
public class DaoAgenda implements IDaoAgenda{
    
    BeansAgenda agenda = new BeansAgenda();
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexPaciente = new ConexaoBD();
    ConexaoBD conexMedico = new ConexaoBD();
    
    int codMed;
    int codPac;
    
    @Override
    public void Salvar(BeansAgenda agenda){
    
        BuscarMedico(agenda.getNomeMed());
        BuscarPaciente(agenda.getNomePac());
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into agenda (agenda_codpac,agenda_codmedico,agenda_motivo,agenda_turno,agenda_data,agenda_status) values(?,?,?,?,?,?)");
            pst.setInt(1, codPac);
            pst.setInt(2, codMed);
            pst.setString(3,agenda.getMotivo());
            pst.setString(4,agenda.getTurno());
            pst.setDate(5,new java.sql.Date(agenda.getData().getTime()));
            pst.setString(6,agenda.getStatus());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Agendamento Realizado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Inserir novo Agendamento!"+ex);
        }
        
        conex.desconecta();
        
    }
     
    @Override
    public void BuscarMedico(String nomeMedico){
    
        conexMedico.conexao();
        conexMedico.executarSql("select *from medicos where nome_medico='"+nomeMedico+"'");
        try {
            conexMedico.rs.first();
            codMed= conexMedico.rs.getInt("cod_medico");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico Não Encontrado!"+ex);
        }
        conexMedico.desconecta();
    }
    
    @Override
    public void BuscarPaciente(String nomePaciente){
    
        conexPaciente.conexao();
        conexPaciente.executarSql("select *from pacientes where paci_nome='"+nomePaciente+"'");
        try {
            conexPaciente.rs.first();
            codPac= conexPaciente.rs.getInt("paci_codigo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Paciente Não Encontrado!"+ex);
        }
        conexPaciente.desconecta();
    }
}
