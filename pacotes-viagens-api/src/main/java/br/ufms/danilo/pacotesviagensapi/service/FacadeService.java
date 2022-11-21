package br.ufms.danilo.pacotesviagensapi.service;

import br.ufms.danilo.pacotesviagensapi.models.Viajante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacadeService {

    @Autowired
    private ViajanteService viajanteService;

    public List<Viajante> buscarViajantesPorViagemId(Long viagemId){
        return viajanteService.findByViagemId(viagemId);
    }
}
