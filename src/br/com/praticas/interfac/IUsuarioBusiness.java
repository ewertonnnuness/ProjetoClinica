/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

/**
 *
 * @author Ewerton
 */
public interface IUsuarioBusiness {

    public void salvarUsuarios(long usoCod, String usuNome, String usuTipo, String usuSenha, String usuPesquisa);

    public void salvarOsUsuarios(long usoCod, String usuNome, String usuTipo, String usuSenha, String usuPesquisa);
}
