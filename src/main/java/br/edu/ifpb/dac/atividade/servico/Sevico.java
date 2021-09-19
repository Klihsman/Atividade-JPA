/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.atividade.servico;


import br.edu.ifpb.dac.atividade.entidades.Usuario;
import br.edu.ifpb.dac.atividade.repository.Teste;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jose
 */
@Stateless
public class Sevico {
    @Inject
    private Teste teste;

    public Sevico() {
    }

    public void save(Usuario u) {
       teste.salvar(u);
    }
    
    
}
