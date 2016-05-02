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
public interface IPacientesBusiness {

    public void salvarPacientes(long codPac, String nomePaciente, String nascimento, String cpf, String rg, String telefone, String rua, String numero, String complemento, String UF, String nomeCidade, String cep, String nomeBairro, String pesquisa);

    public void salvarOsPacientes(long codPac, String nomePaciente, String nascimento, String cpf, String rg, String telefone, String rua, String numero, String complemento, String UF, String nomeCidade, String cep, String nomeBairro, String pesquisa);
}
