/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.fachada;

import br.com.praticas.interfac.IDaoAgenda;
import br.com.praticas.modelobeans.BeansAgenda;
import br.com.praticas.modelobeans.BeansFuncionario;
import br.com.praticas.modelobeans.BeansMedico;
import br.com.praticas.modelobeans.BeansPacientes;
import br.com.praticas.modelobeans.BeansUsuario;
import br.com.praticas.modelodao.DaoAgenda;


// ak vai perdir para implementar os metodos abstratos so implementar e fazer o mesmo que o exemplo de baixo
public class Facade implements IFacade {
    
    private static IDaoAgenda agend;
    private final static Facade instance = new Facade();

    private Facade() {
       this.agend = new DaoAgenda();
       
    }
  
     public static Facade getInstance() {
        
        return instance;
    }

//--------------------------AGENDA---------------------------------------------------------------    
    @Override
    public void SalvarNaAgenda(BeansAgenda agenda) {
       agend.Salvar(agenda);
    }

    @Override
    public void BuscarMedicoNaAgenda(String nomeMedico) {
       agend.BuscarMedico(nomeMedico);
    }

    @Override
    public void BuscarPacienteNaAgenda(String nomePaciente) {
       agend.BuscarPaciente(nomePaciente);
    }

//-------------------------------------------------------------------------------------------------   

    public void salvarOFuncionario(BeansFuncionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvarOMedico(BeansMedico medico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvarOsPacientes(BeansPacientes pacientes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvarOsUsuarios(BeansUsuario usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    

   
}  
    

