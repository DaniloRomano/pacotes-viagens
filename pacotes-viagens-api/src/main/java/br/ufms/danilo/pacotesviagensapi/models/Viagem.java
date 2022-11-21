package br.ufms.danilo.pacotesviagensapi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.ufms.danilo.pacotesviagensapi.enumerations.EnumSituacoesViagem;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Table(name = "TB_VIAGEM")
@Data
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_viagem")
    private Long id;

    @Column(nullable = false)
    private Date dataSaida;

    @Column(nullable = false)
    private Date dataChegada;

    @ManyToOne
    @JoinColumn(name = "PACOTE_ID", foreignKey = @ForeignKey(name = "FK_VIAGEM_PACOTE"))
    private Pacote pacote;

    @Column(nullable = false)
    @Enumerated
    private EnumSituacoesViagem situacao;

    @ManyToMany
    @JsonIgnoreProperties(value = "viagens")
    @JoinTable(name = "tb_viajante_viagem",
            joinColumns = {@JoinColumn(name = "viajante_id")},
            inverseJoinColumns = {@JoinColumn(name = "viagem_id")},
            foreignKey = @ForeignKey(name = "fk_viajante_viagem"),
            inverseForeignKey = @ForeignKey(name = "fk_viagem_viajante"))
    private List<Viajante> viajantes;
}
