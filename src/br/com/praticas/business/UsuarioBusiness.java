/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.business;

import br.com.praticas.fachada.Facade;
import br.com.praticas.modelobeans.BeansUsuario;

/**
 *
 * @author Ewerton
 */
public class UsuarioBusiness {
    
    private Facade fachada = Facade.getInstance();
    
    private BeansUsuario usuarios = new BeansUsuario();
    
     private void salvarUsuarios (int usuarioCod, String usuNome, String usuTipo, String usuSenha, String usuPesquisa){
         
         usuarios.setUsoCod(usuarioCod);
         usuarios.setUsuNome(usuNome);
         usuarios.setUsuTipo(usuTipo);
         usuarios.setUsuSenha(usuSenha);
         usuarios.setUsuPesquisa(usuPesquisa);
         
         fachada.salvarOsUsuarios(usuarios);
         
     }
     public void salvarOsUsuarios(int usuarioCod, String usuNome, String usuTipo, String usuSenha, String usuPesquisa){
         throw new UnsupportedOperationException("Not supported yet.");
     }
}
