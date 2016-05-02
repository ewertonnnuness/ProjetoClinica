/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.business;

import br.com.praticas.fachada.Facade;
import br.com.praticas.modelobeans.BeansAgenda;

/**
 *
 * @author Ewerton
 */
public class AgendamentosBusiness {
    
    private Facade fachada  = Facade.getInstance();
    
    private BeansAgenda agendamento = new BeansAgenda();
    
    private void salvarAgendamentos(){
        
    }

    public AgendamentosBusiness() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
