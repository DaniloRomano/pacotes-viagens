package br.ufms.danilo.pacotesviagensapi.converter;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.ufms.danilo.pacotesviagensapi.dto.PacoteDto;
import br.ufms.danilo.pacotesviagensapi.models.Destino;
import br.ufms.danilo.pacotesviagensapi.models.Pacote;

@Component
public class PacoteConverter {
    
    public Pacote parseMapToPacote(Map<String, String> filter){
        Pacote pacote = new Pacote();
        pacote.setDescricao(filter.get("descricao"));
        String destinoId= filter.get("destino");
        if (Objects.nonNull(destinoId)) {
            Destino destino = new Destino();
            destino.setId(Long.parseLong(filter.get("destino")));
            pacote.setDestino(destino);
        }
        return pacote;
    }

    public Pacote parseIdToPacote(Long id){
        Pacote pacote=new Pacote();
        pacote.setId(id);
        return pacote;
    }

    public Pacote parseDtoAndIdToPacote(PacoteDto dto, Long id){
        Pacote pacote = parseDtoToPacote(dto);
        pacote.setId(id);
        return pacote;
    }

    public Pacote parseDtoToPacote(PacoteDto dto){
        Pacote pacote=new Pacote();
        BeanUtils.copyProperties(dto, pacote);
        return pacote;
    }
}
