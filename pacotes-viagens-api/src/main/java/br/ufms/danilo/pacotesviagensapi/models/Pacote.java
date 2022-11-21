package br.ufms.danilo.pacotesviagensapi.models;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_PACOTE")
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DESTINO_ID", foreignKey = @ForeignKey(name = "fk_pacote_destino"))
    private Destino destino;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal precoDiario;

    @Column(nullable = false)
    private Long quantidadeDias;
}
