package br.ufms.danilo.pacotesviagensapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ViajanteDto {
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataNascimento;
}
