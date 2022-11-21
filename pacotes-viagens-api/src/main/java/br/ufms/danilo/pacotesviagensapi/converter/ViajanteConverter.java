package br.ufms.danilo.pacotesviagensapi.converter;

import br.ufms.danilo.pacotesviagensapi.dto.ViajanteDto;
import br.ufms.danilo.pacotesviagensapi.models.Viajante;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class ViajanteConverter {

    public Viajante parseMapToViajante(Map<String, String> viajanteFiltros) {
        Viajante viajante = new Viajante();

        if (Objects.nonNull(viajanteFiltros.get("nome")))
            viajante.setNome(viajanteFiltros.get("nome"));

        if (Objects.nonNull(viajanteFiltros.get("cpf")))
            viajante.setCpf(viajanteFiltros.get("cpf"));

        return viajante;
    }

    public Viajante parseDtoToViajante(ViajanteDto viajanteDto) {
        Viajante viajante=new Viajante();
        BeanUtils.copyProperties(viajanteDto,viajante);
        return viajante;
    }

    public Viajante parseDtoAndIdToViajante(ViajanteDto viajanteDto, Long id){
        Viajante viajante= parseDtoToViajante(viajanteDto);
        viajante.setId(id);
        return viajante;
    }

    public Viajante parseIdToViajante(Long id){
        Viajante viajante=new Viajante();
        viajante.setId(id);
        return viajante;
    }
}
