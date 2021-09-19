/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.atividade.repository;

import br.edu.ifpb.dac.atividade.entidades.Integrante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name = "if")
public class Buscar {

    @PersistenceContext(unitName = "dac-Pu")
    private EntityManager em;

    public Buscar() {
    }

    public Integrante bus(long id) {
        return em.find(Integrante.class, id);
    }

}
