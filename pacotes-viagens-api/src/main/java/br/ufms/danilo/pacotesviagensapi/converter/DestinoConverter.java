package br.ufms.danilo.pacotesviagensapi.converter;

import br.ufms.danilo.pacotesviagensapi.dto.DestinoDto;
import br.ufms.danilo.pacotesviagensapi.entity.Destino;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DestinoConverter {

    public Destino parseDtoToDestino(DestinoDto destinoDto) {
        Destino destino = new Destino();
        BeanUtils.copyProperties(destinoDto, destino);
        return destino;
    }
}
