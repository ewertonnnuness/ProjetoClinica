
package br.com.praticas.modelodao;

import br.com.praticas.modeloconection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.praticas.modelobeans.BeansMedico;
import br.com.praticas.modelobeans.BeansUsuario;

/**
 *
 * @author HugoNathan
 */
public class DaoUsuario {
    ConexaoBD conex = new ConexaoBD();
    BeansUsuario mod = new BeansUsuario();
    
        public void salvar(BeansUsuario mod){
            conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuarios(usu_nome,usu_senha,usu_tipo)values (?,?,?)");
            pst.setString(1, mod.getUsuNome());
            pst.setString(2, mod.getUsuSenha());
            pst.setString(3, mod.getUsuTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário Inserido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir os Usuário!/nErro: "+ex);
        }
            conex.desconecta();
            
        }
        
              public void alterar(BeansUsuario mod){
          conex.conexao();
          
        try {
            PreparedStatement pst = conex.con.prepareStatement("update usuarios set usu_nome=?,usu_senha=?,usu_tipo=? where usu_cod=?");
            pst.setString(1, mod.getUsuNome());
            pst.setString(2, mod.getUsuSenha());
            pst.setString(3, mod.getUsuTipo());
            pst.setInt(4, (int) mod.getUsoCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteraçãp do Usuário!/nErro:"+ex );
        }
          
          conex.desconecta();
      }
        
         public BeansUsuario buscaUsuario (BeansUsuario mod){
          conex.conexao();
          conex.executarSql("select *from usuarios where usu_nome like'%"+mod.getUsuPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setUsoCod(conex.rs.getInt("usu_cod"));
            mod.setUsuNome(conex.rs.getString("usu_nome"));
            mod.setUsuSenha(conex.rs.getString("usu_senha"));
            mod.setUsuTipo(conex.rs.getString("usu_tipo"));
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "O Usuário Nao esta Cadastrado!");
        }
          
          conex.desconecta();
        return mod;
         }
         
           public void excluir(BeansUsuario mod){
      conex.conexao();
      
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where usu_cod=?");
            pst.setInt(1, (int) mod.getUsoCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Usuário!/nErro:"+ex );
        }
      
      conex.desconecta();
          
      }
}
