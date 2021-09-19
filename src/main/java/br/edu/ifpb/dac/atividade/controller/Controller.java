package br.edu.ifpb.dac.atividade.controller;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.ifpb.dac.atividade.entidades.Banda;
import br.edu.ifpb.dac.atividade.entidades.Integrante;
import br.edu.ifpb.dac.atividade.servico.BandaServico;
import br.edu.ifpb.dac.atividade.servico.IntegranteServico;
import javax.inject.Inject;

@Named
@SessionScoped
public class Controller implements Serializable {

    private static final long serialVersionUID = 1L;

    private Banda banda;
    private Integrante integrante;
    @Inject
    private BandaServico bandaServico;
      @Inject
    private IntegranteServico is;
      private List<Integrante> integrantes;
    private String origem;
    private List<Banda> bandaSession = new ArrayList<>();

    public Controller() {
        banda = new Banda();
        integrante = new Integrante();

    }

    public String SalvarBanda() {
        bandaServico.Add(banda);
        this.banda = new Banda();
        return "list";
    }

    public List<Integrante> getIntegrantes() {
        integrantes = is.todas();
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
    public String addIntegrante(Integrante i){
        banda.add(i);
        integrantes.remove(i);
        
        return "edit";
    }
    public String removeBanda(long id) {
        bandaServico.removeBanda(id);
        return "list";
    }

    public String redirect() {

        return "banda/edit";
    }

    public String editar(Banda banda) {
        this.banda = banda;
        return "edit";
    }

    public List<Banda> getBandas() {
        //return Collections.EMPTY_LIST;
        bandaSession = bandaServico.lista();
        if (bandaSession.isEmpty()) {
            return Collections.EMPTY_LIST;
        } else {
            return bandaSession;
        }
    }

    public String rediretOrigem() {
        bandaSession = Collections.EMPTY_LIST;
        return "banda/buscaOrigem";
    }

    public List<Banda> buscarOrigem() {
        System.err.println("l origem " + origem);
        bandaSession = bandaServico.localizarLocalDeOrigem(origem);
        if (bandaSession.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        System.err.println("ejdi" + bandaSession.get(0));
        return bandaSession;
    }
    public String buscarPorNome(Banda banda) {
       this.banda =banda;
        origem="";
         return "buscanome";
    }

    public Integrante getIntegrante() {
        integrantes = is.todas();
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public List<Banda> getBandaSession() {
        return bandaSession;
    }

    public void setBandaSession(List<Banda> bandaSession) {
        this.bandaSession = bandaSession;
    }

    public BandaServico getBandaServico() {
        return bandaServico;
    }

    public void setBandaServico(BandaServico bandaServico) {
        this.bandaServico = bandaServico;
    }

}
