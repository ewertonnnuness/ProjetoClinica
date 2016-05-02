/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

import br.com.praticas.modelobeans.BeansMedico;

/**
 *
 * @author Ewerton
 */
public interface IDaoMedico {
     public void salvar(BeansMedico medicos);

    public void editar(BeansMedico medicos);

    public void excluir(BeansMedico medicos);

    public void buscaMedico(String nome);
}
