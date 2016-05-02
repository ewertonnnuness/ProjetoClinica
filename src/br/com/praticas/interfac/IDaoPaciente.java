/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

import br.com.praticas.modelobeans.BeansPacientes;

/**
 *
 * @author Ewerton
 */
public interface IDaoPaciente {
   public void salvar(BeansPacientes pacientes);

    public void editar(BeansPacientes pacientes);

    public void excluir(BeansPacientes pacientes);

    public void buscaPaciente(String nome); 
}
