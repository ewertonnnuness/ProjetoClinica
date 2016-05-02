/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.business;

import br.com.praticas.fachada.Facade;
import br.com.praticas.modelobeans.BeansMedico;

/**
 *
 * @author Ewerton
 */
public class MedicoBusiness {
    
    private Facade fachada = Facade.getInstance();
    
    private BeansMedico medico = new BeansMedico();
    
    private void salvarMedico(int codigo, String nome, String especialidade,int crm, String pesquisa  ){
        medico.setCodigo(codigo);
        medico.setNome(nome);
        medico.setEspecialidade(especialidade);
        medico.setCrm(crm);
        medico.setPesquisa(pesquisa);
        
        fachada.salvarOMedico(medico);
               
        
    }
    public void salvarOMedico(int codigo, String nome, String especialidade,int crm, String pesquisa ){
         throw new UnsupportedOperationException("Not supported yet.");
    }
}
