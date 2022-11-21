package br.ufms.danilo.pacotesviagensapi.enumerations;

public enum EnumSituacoesViagem {
    PENDENTE("Realizada"),CONFIRMADA("Confirmada"),CANCELADA("Cancelada"),REALIZADA("Realizada");

    private String nome;

    EnumSituacoesViagem(String nome){
        this.nome=nome;
    }
}
