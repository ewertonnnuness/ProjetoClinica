
package br.com.praticas.modelodao;

import br.com.praticas.modelobeans.BeansFuncionario;
import br.com.praticas.modeloconection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.praticas.modelobeans.BeansMedico;

public class DaoFuncionario {
    
    ConexaoBD conex = new ConexaoBD();
    BeansFuncionario mod = new BeansFuncionario();
    
        public void salvar(BeansFuncionario mod){
            conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into funcionarios(nome_funcionario,funcao_funcionario,cpf_funcionario)values (?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getFuncao());
            pst.setInt(3, mod.getCpf());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir os dados!/nErro: "+ex);
        }
            conex.desconecta();
            
        }
        
      public void editar(BeansFuncionario mod){
          conex.conexao();
          
        try {
            PreparedStatement pst = conex.con.prepareStatement("update funcionarios set nome_funcionario=?,funcao_funcionario=?,cpf_funcionario=? where cod_funcionario=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getFuncao());
            pst.setInt(3, mod.getCpf());
            pst.setInt(4, (int) mod.getMatricula());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteraçãp dos dados!/nErro:"+ex );
        }
          
          conex.desconecta();
      }
      
      public void excluir(BeansFuncionario mod){
      conex.conexao();
      
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from funcionarios where cod_funcionario=?");
            pst.setInt(1, (int) mod.getMatricula());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Dados!/nErro:"+ex );
        }
      
      conex.desconecta();
          
      }
      
      public BeansFuncionario buscaFuncionario (BeansFuncionario mod){
          conex.conexao();
          conex.executarSql("select *from funcionarios where nome_funcionario like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_funcionario"));
            mod.setNome(conex.rs.getString("nome_funcionario"));
            mod.setFuncao(conex.rs.getString("funcao_funcionario"));
            mod.setCpf(conex.rs.getInt("cpf_funcionario"));
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "O Funcionario não esta Cadastrado!");
        }
          
          conex.desconecta();
        return mod;

      }
}