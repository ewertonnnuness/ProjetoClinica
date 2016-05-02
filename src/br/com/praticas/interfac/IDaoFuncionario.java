/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

import br.com.praticas.modelobeans.BeansFuncionario;

/**
 *
 * @author Ewerton
 */
public interface IDaoFuncionario {

    public void salvar(BeansFuncionario funcionarios);

    public void editar(BeansFuncionario funcionarios);

    public void excluir(BeansFuncionario funcionarios);

    public void buscaFuncionario(String nomeFunc);
}
