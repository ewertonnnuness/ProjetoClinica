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
public interface IFuncionarioBusiness {

    public void salvarFuncionario(long matricula, String nome, String funcao, int cpf, String pesquisa);

    public void salvarOFuncionario(long matricula, String nome, String funcao, int cpf, String pesquisa);
}
