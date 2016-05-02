/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

import br.com.praticas.modelobeans.BeansUsuario;

/**
 *
 * @author Ewerton
 */
public interface IDaoUsuario {

    public void salvar(BeansUsuario usuarios);

    public void alterar(BeansUsuario usuarios);

    public void excluir(BeansUsuario usuarios);

    public void buscaUsuario(String nome);
}
