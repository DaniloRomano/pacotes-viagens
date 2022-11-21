package br.ufms.danilo.pacotesviagensapi.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class PacoteDto {    
    private Long destinoId;
    private String descricao;
    private BigDecimal valorDiario;
    private Long quantidadeDias;
}
