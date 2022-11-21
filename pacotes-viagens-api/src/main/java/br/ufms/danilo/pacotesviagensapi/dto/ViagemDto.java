package br.ufms.danilo.pacotesviagensapi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViagemDto {
    private Date dataSaida;
    private Date dataChegada;
    
}
