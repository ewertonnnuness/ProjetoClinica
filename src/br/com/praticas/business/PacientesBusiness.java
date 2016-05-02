/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.business;

import br.com.praticas.fachada.Facade;
import br.com.praticas.modelobeans.BeansPacientes;

/**
 *
 * @author Ewerton
 */
public class PacientesBusiness {

    private Facade fachada = Facade.getInstance();

    private BeansPacientes pacientes = new BeansPacientes();

    private void salvarPacientes(int codigoPaciente, String nomePaciente, String nascimento, String cpf, String rg, String telefone, String rua, String numero, String complemento, String UF, String nomeCidade, String cep, String nomeBairro, String pesquisa) {

        pacientes.setCodPaciente(codigoPaciente);
        pacientes.setNomePaciente(nomePaciente);
        pacientes.setNascimento(nascimento);
        pacientes.setCpf(cpf);
        pacientes.setRg(rg);
        pacientes.setTelefone(telefone);
        pacientes.setRua(rua);
        pacientes.setNumero(numero);
        pacientes.setComplemento(complemento);
        pacientes.setUF(UF);
        pacientes.setNomeCidade(nomeCidade);
        pacientes.setCep(cep);
        pacientes.setNomeBairro(nomeBairro);
        pacientes.setPesquisa(pesquisa);
        
       fachada.salvarOsPacientes(pacientes); 
    }
public void salvarOsPacientes(int codigoPaciente, String nomePaciente, String nascimento, String cpf, String rg, String telefone, String rua, String numero, String complemento, String UF, String nomeCidade, String cep, String nomeBairro, String pesquisa){
    throw new UnsupportedOperationException("Not supported yet.");
}
}
