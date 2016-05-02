/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

import br.com.praticas.modelobeans.BeansAgenda;


public interface IDaoAgenda {

    public void Salvar(BeansAgenda agenda);

    public void BuscarMedico(String nomeMedico);

    public void BuscarPaciente(String nomePaciente);
}
