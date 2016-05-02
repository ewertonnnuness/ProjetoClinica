
package br.com.praticas.modelodao;

import br.com.praticas.modeloconection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.praticas.modelobeans.BeansMedico;

public class DaoMedico {
    
    ConexaoBD conex = new ConexaoBD();
    BeansMedico mod = new BeansMedico();
    
        public void salvar(BeansMedico mod){
            conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos(nome_medico,especialidade_medico,crm_medico)values (?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCrm());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir os dados!/nErro: "+ex);
        }
            conex.desconecta();
            
        }
        
      public void editar(BeansMedico mod){
          conex.conexao();
          
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set nome_medico=?,especialidade_medico=?,crm_medico=? where cod_medico=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCrm());
            pst.setInt(4, (int) mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteraçãp dos dados!/nErro:"+ex );
        }
          
          conex.desconecta();
      }
      
      public void excluir(BeansMedico mod){
      conex.conexao();
      
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where cod_medico=?");
            pst.setInt(1, (int) mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Dados!/nErro:"+ex );
        }
      
      conex.desconecta();
          
      }
      
      public BeansMedico buscaMedico (BeansMedico mod){
          conex.conexao();
          conex.executarSql("select *from medicos where nome_medico like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_medico"));
            mod.setNome(conex.rs.getString("nome_medico"));
            mod.setEspecialidade(conex.rs.getString("especialidade_medico"));
            mod.setCrm(conex.rs.getInt("crm_medico"));
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "O medico Nao esta Cadastrado!");
        }
          
          conex.desconecta();
        return mod;

      }
}