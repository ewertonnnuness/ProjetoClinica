/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

import java.util.Date;


public interface IAgendaBusiness {
    
    public void salvarNaAgenda(String NomePac, String NomeMed,String Turno,String Motivo, Date Data, String Status);

    public void slavarNaAgenda(String text, String string, String string0, String text0, Date date, String aberto);
    
    
}
