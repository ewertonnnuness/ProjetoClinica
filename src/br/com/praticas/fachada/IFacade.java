/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.fachada;

import br.com.praticas.modelobeans.BeansAgenda;




/**
 *
 * @author Onismar
 */
public interface IFacade {

// AK VC VAI COLOCAR TODOS OS METODOS QUE VC CRIO NAS INTERFACES TUDO QUE TIVER NA INTERFACE VEM 
// PRA CA MAIS VC COLOCA NOMES MAIS OBJETIVOS PARA PODER DIFERENCIAR.
// DEPOIS SO IMPLEMENTAR NA (FACADE)  
    
//--------------------------AGENDA------------------------------------------------------------    
    public void SalvarNaAgenda(BeansAgenda agenda);

    public void BuscarMedicoNaAgenda(String nomeMedico);

    public void BuscarPacienteNaAgenda(String nomePaciente);

//----------------------------------------------------------------------------------------------    
}
