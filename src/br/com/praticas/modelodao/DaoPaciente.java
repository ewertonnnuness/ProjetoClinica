/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.modelodao;

import br.com.praticas.modelobeans.BeansPacientes;
import br.com.praticas.modeloconection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class DaoPaciente {
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexBairro = new ConexaoBD();
    ConexaoBD conexCidade = new ConexaoBD();
    ConexaoBD conexUF = new ConexaoBD();
    String nomeBairro;
    String nomeCidade;
    String nomeUF;
    int codBairro;
    int codCidade;
    int codUf;
    
    public void Salvar(BeansPacientes pac){
        buscaBaiCod(pac.getNomeBairro());
        buscaCidCod(pac.getNomeCidade());
        buscaUfCod(pac.getUF());
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into pacientes (paci_nome,paci_cpf,paci_rg,paci_telefone,paci_rua,paci_numero,paci_cep,paci_complemento,paci_baicodigo,paci_cidcodigo,paci_ufcodigo,paci_nasc) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,pac.getNomePaciente());
            pst.setString(2,pac.getCpf());
            pst.setString(3,pac.getRg());
            pst.setString(4,pac.getTelefone());
            pst.setString(5,pac.getRua());
            pst.setString(6,pac.getNumero());
            pst.setString(7,pac.getCep());
            pst.setString(8,pac.getComplemento());
            pst.setInt(9, codBairro);
            pst.setInt(10, codCidade);
            pst.setInt(11, codUf);
            pst.setString(12,pac.getNasc());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Paciente Salvo Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Salvar Paciente"+ex);;
        }
        
        conex.desconecta();
        
    }
    
    public void Alterar(BeansPacientes pac){
        buscaBaiCod(pac.getNomeBairro());
        buscaCidCod(pac.getNomeCidade());
        buscaUfCod(pac.getUF());
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update pacientes set paci_nome=?, paci_cpf=?,paci_rg=?,paci_telefone=?,paci_rua=?,paci_numero=?,paci_cep=?,paci_complemento=?,paci_baicodigo=?,paci_cidcodigo=?,paci_ufcodigo=?,paci_nasc=? where paci_codigo=? ");
            pst.setString(1,pac.getNomePaciente());
            pst.setString(2,pac.getCpf());
            pst.setString(3,pac.getRg());
            pst.setString(4,pac.getTelefone());
            pst.setString(5,pac.getRua());
            pst.setString(6,pac.getNumero());
            pst.setString(7,pac.getCep());
            pst.setString(8,pac.getComplemento());
            pst.setInt(9, codBairro);
            pst.setInt(10, codCidade);
            pst.setInt(11, codUf);
            pst.setString(12,pac.getNasc());
            pst.setInt(13, pac.getCodPac());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Paciente Alterado Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Alterar Paciente"+ex);;
        }
        
        conex.desconecta();
        
    }
    public void buscaBaiCod(String nome){
    conex.conexao();
    conex.executarSql("select *from bairro where bainome ='"+nome+"'");
        try {
            conex.rs.first();
            codBairro = conex.rs.getInt("baicodigo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar busca de Bairros"+ex);
        }
    
    conex.desconecta();
    }
    
    public void buscaCidCod(String nome){
    conex.conexao();
    conex.executarSql("select *from cidade where cidnome ='"+nome+"'");
        try {
            conex.rs.first();
            codCidade = conex.rs.getInt("cidcodigo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar busca de Cidades"+ex);
        }
    
    conex.desconecta();
    }
    
    public void buscaUfCod(String nome){
    conex.conexao();
    conex.executarSql("select *from uf where ufnome ='"+nome+"'");
        try {
            conex.rs.first();
            codUf = conex.rs.getInt("ufcodigo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar busca de Estados"+ex);
        }
    
    conex.desconecta();
    }
    
    public BeansPacientes buscaPaciente(BeansPacientes pac){
    
        conex.conexao();
        
        try {
            conex.executarSql("select *from pacientes where paci_nome like '%"+pac.getPesquisa()+"%'");
            conex.rs.first();
            buscaNomeBairro(conex.rs.getInt("paci_baicodigo"));
            buscaNomeCidade(conex.rs.getInt("paci_cidcodigo"));
            buscaNomeUF(conex.rs.getInt("paci_ufcodigo"));
            pac.setNomePaciente(conex.rs.getString("paci_nome"));
            pac.setCep(conex.rs.getString("paci_cep"));
            pac.setCpf(conex.rs.getString("paci_cpf"));
            pac.setCodPaciente(conex.rs.getInt("paci_codigo"));
            pac.setComplemento(conex.rs.getString("paci_complemento"));
            pac.setNasc(conex.rs.getString("paci_nasc"));
            pac.setNumero(conex.rs.getString("paci_numero"));
            pac.setRg(conex.rs.getString("paci_rg"));
            pac.setTelefone(conex.rs.getString("paci_telefone"));
            pac.setRua(conex.rs.getString("paci_rua"));
            pac.setNomeBairro(nomeBairro);
            pac.setNomeCidade(nomeCidade);
            pac.setUF(nomeUF);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar busca de Paciente"+ex);
        }
        conex.desconecta();
        
        
        return pac;
    }
    
    public void buscaNomeBairro(int cod) throws SQLException{
        conexBairro.conexao();        
        try {
            conexBairro.executarSql("select *from bairro where baicodigo="+cod);
            conexBairro.rs.first();
            nomeBairro = conexBairro.rs.getString("bainome");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar busca de nome de Bairro"+ex);
        }      
        
        conexBairro.desconecta();
    }
    
    public void buscaNomeCidade(int cod) throws SQLException{
        conexCidade.conexao();        
        try {
            conexCidade.executarSql("select *from cidade where cidcodigo="+cod);
            conexCidade.rs.first();
            nomeCidade = conexCidade.rs.getString("cidnome");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar busca de nome da Cidade"+ex);
        }      
        
        conexCidade.desconecta();
    }
    
    public void buscaNomeUF(int cod) throws SQLException{
        conexUF.conexao();        
        try {
            conexUF.executarSql("select *from uf where ufcodigo="+cod);
            conexUF.rs.first();
            nomeUF = conexUF.rs.getString("ufnome");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar busca de UF"+ex);
        }      
        
        conexUF.desconecta();
    }
    
    public void excluir(BeansPacientes pac){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from pacientes where paci_codigo=?");
            pst.setInt(1, pac.getCodPac());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Paciente Excluido com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Excluir Paciente"+ex);
        }
        conex.desconecta();
        
    }
    
    
    
}
