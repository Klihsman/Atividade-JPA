package br.edu.ifpb.dac.atividade.servico;

import java.util.List;

import br.edu.ifpb.dac.atividade.entidades.Banda;
import br.edu.ifpb.dac.atividade.repository.BandaPercistencia;
import javax.ejb.Stateless;
import javax.inject.Inject;
@Stateless
public class BandaServico {

    @Inject
    private BandaPercistencia bandas;

    public BandaServico() {
 
    }

    public void Add(Banda b) {
            bandas.salvar(b);
    }

    public List<Banda> lista() {
        return bandas.list();
    }

    public void removeBanda(long id) {
        bandas.remover(id);
    }

    public List<Banda> localizarLocalDeOrigem(String origem) {
        return bandas.localizarLocalDeOrigem(origem);
    }
    public Banda localizarLocarPorNome(String nome) {
        return bandas.localizarLocarPorNome(nome);
    }
}
