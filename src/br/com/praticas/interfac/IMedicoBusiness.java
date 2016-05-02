/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfac;

/**
 *
 * @author Ewerton
 */
public interface IMedicoBusiness {

    public void salvarMedico(long codigo, String nome, String especialidade, int crm, String pesquisa);

    public void salvarOMedico(long codigo, String nome, String especialidade, int crm, String pesquisa);
}
