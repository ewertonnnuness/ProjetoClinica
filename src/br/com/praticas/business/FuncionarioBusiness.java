/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.business;

import br.com.praticas.fachada.Facade;
import br.com.praticas.modelobeans.BeansFuncionario;

/**
 *
 * @author Ewerton
 */
public class FuncionarioBusiness {
    
    private Facade fachada = Facade.getInstance();
       
    private BeansFuncionario funcionario = new BeansFuncionario();
    
    private void salvarFuncionario(long matricula, String nome, String funcao, int cpf, String pesquisa ){
     
        funcionario.setMatricula(matricula);
        funcionario.setNome(nome);
        funcionario.setFuncao(funcao);
        funcionario.setCpf(cpf);
        funcionario.setPesquisa(pesquisa);
   
        fachada.salvarOFuncionario(funcionario);
              
    
    }
    public void salvarOFuncionario(long matricula, String nome, String funcao, int cpf, String pesquisa){
         throw new UnsupportedOperationException("Not supported yet.");
    }
    
    }

