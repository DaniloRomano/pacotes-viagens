package br.ufms.danilo.pacotesviagensapi.converter;

import br.ufms.danilo.pacotesviagensapi.enumerations.EnumSituacoesViagem;
import br.ufms.danilo.pacotesviagensapi.models.Destino;
import br.ufms.danilo.pacotesviagensapi.models.Pacote;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.ufms.danilo.pacotesviagensapi.dto.ViagemDto;
import br.ufms.danilo.pacotesviagensapi.models.Viagem;

import java.util.Map;
import java.util.Objects;

@Component
public class ViagemConverter {
    
    public Viagem parseDtoToViagem(ViagemDto dto){
        Viagem viagem = new Viagem();
        BeanUtils.copyProperties(dto,viagem);
        return viagem;
    }

    public Viagem parseMapToViagem(Map<String,String> viagemFiltros) {
        Viagem viagem=new Viagem();

        if (Objects.nonNull(viagemFiltros.get("situacao")))
            viagem.setSituacao(EnumSituacoesViagem.valueOf(viagemFiltros.get("situacao")));

        if (Objects.nonNull(viagemFiltros.get("pacoteId"))) {
            Pacote pacote = new Pacote();
            pacote.setId(Long.parseLong(viagemFiltros.get("pacoteId")));
            viagem.setPacote(pacote);
        }
        return viagem;
    }
}
